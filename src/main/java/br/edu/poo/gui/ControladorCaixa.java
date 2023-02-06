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
import javafx.scene.control.Alert.AlertType;
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
        int codProduto = 0;
        Produto produto = null;
        double qtdProduto = 0;
        try {
            codProduto = Integer.parseInt(txtPesquisarProduto.getText());
        } catch (NumberFormatException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Código inválido");
            alert.setContentText("Verifique o código do produto e tente novamente.");
            alert.showAndWait();
        }
        try {
            qtdProduto = Double.parseDouble(txtQtdProduto.getText());
        } catch (NumberFormatException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Quantidade inválida");
            alert.setContentText("Preencha a caixa de texro com uma quantidade válida.");
            alert.showAndWait();

            txtPesquisarProduto.setText("");
            codProduto = 0;
        }
        try {
            produto = metodoEstoque.getProduto(codProduto);
            Item produtoItem = new Item(produto, qtdProduto);
            listaDeProdutos.add(produtoItem);

            double total = 0;
            for (Item item : listaDeProdutos) {
                total += item.getValorTotal();
            }
            txtPesquisarProduto.setText("");
            txtQtdProduto.setText("");
            labelTotal.setText(String.valueOf(total));
            tabelaProdutos.refresh();
        } catch (CodigoInvalidoException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(e.getMessage());
            alert.setContentText("Preencha a caixa de texto com uma quantidade válida.");
            alert.showAndWait();
        } catch (NumberFormatException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Quantidade inválida");
            alert.setContentText("Preencha a caixa de texto com uma quantidade válida.");
            alert.showAndWait();
        }
    }

    // metodo pra limpar a planilha apertnado um botão de cancelar
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

    @FXML
    private void confirmarCompra(ActionEvent event) throws Exception {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("MarkÈd - Caixa");
        alert.setHeaderText("Confirmar compra");
        alert.setContentText("Verifique se a compra foi realizada corretamente.");
        alert.showAndWait(); 
    }

    // metodo de compra concluida
    @FXML
    private void compraConcluida(ActionEvent event) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PagamentoConcluído.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    // metodo para entrar no estoque
    @FXML
    private void estoque(ActionEvent event) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("estoque.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    // metodo para entrar no registro de notas fiscais
    @FXML
    private void registroNotasFiscais(ActionEvent event) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("registroNotasFiscais.fxml"));
        Parent root = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();
    }

    @FXML
    private void carregarProdutos() throws ProdutoInvalidoException, CodigoInvalidoException {
        Produto produto1 = new Produto(1, "Arroz", "Arroz branco", 5.00, 10);
        Produto produto2 = new Produto(2, "Feijão", "Feijão preto", 4.00, 10);
        Produto produto3 = new Produto(3, "Macarrão", "Macarrão de espaguete", 3.00, 10);

        try {
            metodoEstoque.addProduto(produto3);
            metodoEstoque.addProduto(produto2);
            metodoEstoque.addProduto(produto1);

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Produto Cadastrado");
            alert.setHeaderText(null);
            alert.setContentText("Produtos cadastrados com sucesso!");
            alert.showAndWait();
        } catch (ProdutoInvalidoException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(e.getMessage());
            alert.setContentText("Produtos já foram cadastrados.");
            alert.showAndWait();
        } catch (CodigoInvalidoException e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(e.getMessage());
            alert.setContentText("Produtos já foram cadastrados.");
            alert.showAndWait();
        }
    }

}