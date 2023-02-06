package br.edu.poo.gui;

import br.edu.poo.backend.*;
import br.edu.poo.backend.Exceptions.*;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControladorEstoque {
    private Estoque metodoEstoque = new Estoque();

    // Tela de Pesquisa
    @FXML
    private TextField pesquisaProduto_txt;
    @FXML
    private Button pesquisaProduto_btn;
    @FXML
    private Button addProduto_btn;
    @FXML
    private TableView<Produto> tabelaEstoque;
    @FXML
    private TableColumn<Produto, Integer> colunaCodigo;
    @FXML
    private TableColumn<Produto, String> colunaNome;
    @FXML
    private TableColumn<Produto, String> colunaDescricao;
    @FXML
    private TableColumn<Produto, Double> colunaPreco;
    @FXML
    private TableColumn<Produto, Double> colunaQuantidade;
    @FXML
    private ObservableList<Produto> pesquisaProduto = FXCollections.observableArrayList();
    // Tela de Cadastro
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
    @FXML
    private Button cancelar_btn;
    // Fim da Tela de Cadastro

    // Tela de Remoção
    // Fim da Tela de Remoção

    // Tela de Atualização
    @FXML
    private TextField attPesquisaProduto_txt;
    @FXML
    private TextField attNome_txt;
    @FXML
    private TextField attPreco_txt;
    @FXML
    private TextField attQuantidade_txt;

    private TextInputControl removerProduto_btn;

    // Fim da Tela de Atualização
    // @FXML
    // void cadastrarProduto(ActionEvent event) {
    // String nome = addNome_txt.getText();
    // String descricao = addDescricao_txt.getText();

    // int codigo = Integer.parseInt(addCodigo_txt.getText());
    // double preco = Double.parseDouble(addPreco_txt.getText());
    // double quantidade = Double.parseDouble(addQuantidade_txt.getText());

    // Produto produto = new Produto(codigo, nome, descricao, preco, quantidade);

    // try {
    // metodoEstoque.addProduto(produto);
    //
    // Alert alert = new Alert(AlertType.INFORMATION);
    // alert.setTitle("Produto Cadastrado");
    // alert.setHeaderText(null);
    // alert.setContentText(produto.toString());
    // alert.showAndWait();

    // } catch (CodigoInvalidoException e) {
    // Alert alert = new Alert(AlertType.ERROR);
    // alert.setTitle("Erro");
    // alert.setHeaderText(e.getMessage());
    // alert.setContentText("Verifique o código do produto e tente novamente.");
    // alert.showAndWait();
    // } catch (ProdutoInvalidoException e) {
    // Alert alert = new Alert(AlertType.ERROR);
    // alert.setTitle("Erro");
    // alert.setHeaderText(e.getMessage());
    // alert.setContentText("Verifique o código do produto e tente novamente.");
    // alert.showAndWait();
    // }

    // limparCampos(event);
    // }

    // crie um metodo para cadastrar produto
    @FXML
    private void cadastrarProduto() throws Exception {
        String nome = addNome_txt.getText();
        String descricao = addDescricao_txt.getText();

        int codigo = Integer.parseInt(addCodigo_txt.getText());
        double preco = Double.parseDouble(addPreco_txt.getText());
        double quantidade = Double.parseDouble(addQuantidade_txt.getText());

        Produto produto = new Produto(codigo, nome, descricao, preco, quantidade);

        try {
            metodoEstoque.addProduto(produto);

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Produto Cadastrado");
            alert.setHeaderText(null);
            alert.setContentText(produto.toString());
            alert.showAndWait();

        } catch (CodigoInvalidoException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(e.getMessage());
            alert.setContentText("Verifique o código do produto e tente novamente.");
            alert.showAndWait();
        } catch (ProdutoInvalidoException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(e.getMessage());
            alert.setContentText("Verifique o código do produto e tente novamente.");
            alert.showAndWait();
        }

        limparCampos(null);
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
    private void initialize() throws Exception {
        try {
            colunaCodigo.setCellValueFactory(
                    cellData -> new SimpleIntegerProperty(cellData.getValue().getCodigo()).asObject());
            colunaNome
                    .setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNome()));
            colunaDescricao.setCellValueFactory(
                    cellData -> new SimpleStringProperty(cellData.getValue().getDescricao()));
            colunaPreco.setCellValueFactory(
                    cellData -> new SimpleDoubleProperty(cellData.getValue().getPreco()).asObject());
            colunaQuantidade.setCellValueFactory(
                    cellData -> new SimpleDoubleProperty(cellData.getValue().getQuantidade()).asObject());
            if (pesquisaProduto != null && !pesquisaProduto.isEmpty()) {
                tabelaEstoque.setItems(pesquisaProduto);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void obterProduto(ActionEvent event) throws Exception {
        int codigo = Integer.parseInt(pesquisaProduto_txt.getText());
        Produto produto = null;

        try {
            produto = metodoEstoque.getProduto(codigo);
            pesquisaProduto.add(produto);
        } catch (CodigoInvalidoException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(e.getMessage());
            alert.setContentText("Verifique o código do produto e tente novamente.");
            alert.showAndWait();
        }
    }

    //metodo que chama o atualizar quantidade e atualizar preço
    @FXML
    void atualizarProduto() throws Exception {
        
    }

    @FXML
    void atualizarQuantidade() throws Exception {
        String parseCodigo = attPesquisaProduto_txt.getText();
        String parseQuantidade = attQuantidade_txt.getText();

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
        String parseCodigo = pesquisaProduto_txt.getText();
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
    private void addProdutos(ActionEvent event) throws Exception {
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

    @FXML
    public void fecharJanela(ActionEvent event) {
        Stage stage = (Stage) cancelar_btn.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void limparCampos(ActionEvent event) {
        addCodigo_txt.setText("");
        addNome_txt.setText("");
        addDescricao_txt.setText("");
        addPreco_txt.setText("");
        addQuantidade_txt.setText("");
    }
}
