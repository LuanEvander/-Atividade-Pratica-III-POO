package br.edu.poo.gui;

import br.edu.poo.backend.Estoque;
import br.edu.poo.backend.Produto;
import br.edu.poo.backend.RegistroNotasFiscais;
import br.edu.poo.backend.Exceptions.CodigoInvalidoException;
import br.edu.poo.backend.Exceptions.ProdutoInvalidoException;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class ControladorNotaFiscal {
private RegistroNotasFiscais metodoNotasFiscais = new RegistroNotasFiscais();
private Estoque metodoEstoque = new Estoque();

    @FXML
    private TableView<Produto> tabelaProdutos;
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
    private ObservableList<Produto> listaDeProdutos = FXCollections.observableArrayList();

    @FXML
    private TextField txtPesquisarProduto;

    @FXML
    private void initialize() throws ProdutoInvalidoException, CodigoInvalidoException {
        carregarProdutos();

        colunaCodigo.setCellValueFactory(new PropertyValueFactory<Produto, Integer>("codigo"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<Produto, String>("nome"));
        colunaDescricao.setCellValueFactory(new PropertyValueFactory<Produto, String>("descricao"));
        colunaPreco.setCellValueFactory(new PropertyValueFactory<Produto, Double>("preco"));
        colunaQuantidade.setCellValueFactory(new PropertyValueFactory<Produto, Double>("quantidade"));

        tabelaProdutos.setItems(listaDeProdutos);
    }

    @FXML
    public void adicionarProduto(ActionEvent event) throws CodigoInvalidoException {
        int codProduto = Integer.parseInt(txtPesquisarProduto.getText());
        metodoEstoque.existe(codProduto);
        metodoEstoque.getProduto(codProduto);

        listaDeProdutos.add(metodoEstoque.getProduto(codProduto));
    }

    private void carregarProdutos() throws ProdutoInvalidoException, CodigoInvalidoException {
        Produto produto1 = new Produto(1, "Arroz", "Arroz branco", 5.00, 10);
        Produto produto2 = new Produto(2, "Feijão", "Feijão preto", 4.00, 10);
        Produto produto3 = new Produto(3, "Macarrão", "Macarrão de espaguete", 3.00, 10);

        metodoEstoque.addProduto(produto3);
        metodoEstoque.addProduto(produto2);
        metodoEstoque.addProduto(produto1);
    }

}