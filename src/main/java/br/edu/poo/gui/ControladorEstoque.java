package br.edu.poo.gui;


import br.edu.poo.backend.*;
import br.edu.poo.backend.Exceptions.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControladorEstoque {
    private Estoque metodoEstoque = new Estoque();

    //Tela de Pesquisa
    @FXML
    private TextField PesquisaProduto_txt;
    @FXML
    private Button PesquisaProduto_btn;
    @FXML
    private Button addProduto_btn;
    //Tela de Cadastro
    @FXML
    private TextField addCodigo_txt;
    @FXML
    private TextField addNome_txt;
    @FXML
    private TextField addDescricao_txt;
    @FXML
    private TextField addPreco_txt;
    @FXML
    private TextField addQuantidade_txt;
    @FXML
    private Button confirmaCadastro_btn;
    //Fim da Tela de Cadastro
    
    //Tela de Remoção
    //Fim da Tela de Remoção

    //Tela de Atualização
    @FXML
    private TextField attPesquisaProduto_txt;
    @FXML
    private TextField attNome_txt;
    @FXML
    private TextField attPreco_txt;
    @FXML
    private TextField attQuantidade_txt;

    private TextInputControl removerProduto_btn;
    //Fim da Tela de Atualização
    @FXML
    void cadastrarProduto(ActionEvent event) {
        String nome = addNome_txt.getText();
        String descricao= addDescricao_txt.getText();

        int codigo = Integer.parseInt(addCodigo_txt.getText());
        double preco = Double.parseDouble(addPreco_txt.getText());
        double quantidade = Double.parseDouble(addQuantidade_txt.getText());

        Produto produto = new Produto(codigo, nome, descricao, preco, quantidade);

        try {
            metodoEstoque.addProduto(produto);
        } catch (CodigoInvalidoException e) {
            e.printStackTrace();
        } catch (ProdutoInvalidoException e) {
            e.printStackTrace();
        }
    }

    void removerProduto() throws Exception {
        String parseCodigo = removerProduto_btn.getText();
        int codigo = Integer.parseInt(parseCodigo);

        try {
            metodoEstoque.removeProduto(codigo);
        } catch (CodigoInvalidoException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void obterProduto() throws Exception {
        String parseCodigo = PesquisaProduto_txt.getText();
        int codigo = Integer.parseInt(parseCodigo);

        try {
            metodoEstoque.getProduto(codigo);
        } catch (CodigoInvalidoException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void atualizarQuantidade() throws Exception {
        String parseCodigo = attPesquisaProduto_id.getText();
        String parseQuantidade = attQuantidade_id.getText();

        int codigo = Integer.parseInt(parseCodigo);
        double quantidade = Double.parseDouble(parseQuantidade);

        try {
            metodoEstoque.updateQuantidade(codigo, quantidade);
        } catch (CodigoInvalidoException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void atualizarPreco() throws Exception {
        String parseCodigo = PesquisaProduto_txt.getText();
        String parsePreco = attPreco_txt.getText();

        int codigo = Integer.parseInt(parseCodigo);
        double preco = Double.parseDouble(parsePreco);

        try {
            metodoEstoque.updatePreco(codigo, preco);
        } catch (CodigoInvalidoException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void addProduto(ActionEvent event) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TelaDeCadastro.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }
    @FXML
    private void attProduto(ActionEvent event) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("TelaDeAtualizarProduto.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }
}
