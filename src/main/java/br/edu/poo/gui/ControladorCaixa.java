package br.edu.poo.gui;

import br.edu.poo.backend.*;
import br.edu.poo.backend.Exceptions.*;
import javafx.beans.property.*;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControladorCaixa {
    private RegistroNotasFiscais metodoNotasFiscais = new RegistroNotasFiscais();
    private Estoque metodoEstoque = new Estoque();

    @FXML
    private TableView<Item> tabelaProdutos;
    @FXML
    private TableColumn<Item, Integer> colunaCodigo;
    @FXML
    private TableColumn<Item, String> colunaNome;
    @FXML
    private TableColumn<Item, String> colunaDescricao;
    @FXML
    private TableColumn<Item, Double> colunaPreco;
    @FXML
    private TableColumn<Item, Double> colunaQuantidade;
    @FXML
    private TableColumn<Item, Double> colunaTotal;
    @FXML
    private ObservableList<Item> listaDeProdutos = FXCollections.observableArrayList();

    @FXML
    private TextField txtPesquisarProduto;
    @FXML
    private TextField txtQtdProduto;
    @FXML
    private Label labelTotal;

    @FXML
    private void initialize() throws ProdutoInvalidoException, CodigoInvalidoException {
        carregarProdutos();

        colunaCodigo.setCellValueFactory(
                cellData -> new SimpleIntegerProperty(cellData.getValue().getProduto().getCodigo()).asObject());
        colunaNome
                .setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getProduto().getNome()));
        colunaDescricao.setCellValueFactory(
                cellData -> new SimpleStringProperty(cellData.getValue().getProduto().getDescricao()));
        colunaPreco.setCellValueFactory(
                cellData -> new SimpleDoubleProperty(cellData.getValue().getProduto().getPreco()).asObject());
        colunaQuantidade.setCellValueFactory(
                cellData -> new SimpleDoubleProperty(cellData.getValue().getQuantidade()).asObject());
        colunaTotal.setCellValueFactory(
                cellData -> new SimpleDoubleProperty(cellData.getValue().getValorTotal()).asObject());

        tabelaProdutos.setItems(listaDeProdutos);
    }

    @FXML
public void adicionarProduto(ActionEvent event) {
    int codProduto = Integer.parseInt(txtPesquisarProduto.getText());
    double qtdProduto = Double.parseDouble(txtQtdProduto.getText());
    Produto produto = null;
    try {
        produto = metodoEstoque.getProduto(codProduto);
    } catch (CodigoInvalidoException e) {
        e.printStackTrace();
    }

    try {
        if (qtdProduto <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que 0");
        }
    } catch (IllegalArgumentException e) {
        // Mostre uma mensagem de erro para o usuário

    }

    Item produtoItem = new Item(produto, qtdProduto);
    listaDeProdutos.add(produtoItem);

    double total = 0;
    for (Item item : listaDeProdutos) {
        total += item.getValorTotal();
    }
    labelTotal.setText(String.valueOf(total));
    tabelaProdutos.refresh();
}
    //metodo pra limpar a planilha apertnado um botão de cancelar
    @FXML
    private void limparPlanilha(ActionEvent event) {
        listaDeProdutos.clear();
        tabelaProdutos.refresh();
    }

    @FXML
    private void pagamento(ActionEvent event) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pagamento.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    //metodo de compra concluida
    @FXML
    private void compraConcluida(ActionEvent event) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PagamentoConcluído.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    //metodo para entrar no estoque
    @FXML
    private void estoque(ActionEvent event) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("estoque.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    //metodo para entrar no registro de notas fiscais
    @FXML
    private void registroNotasFiscais(ActionEvent event) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("notafiscal.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
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