package br.edu.poo.gui;

import br.edu.poo.backend.*;
import br.edu.poo.backend.Exceptions.*;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ControladorEstoque {
    private Estoque metodoEstoque = new Estoque();

    @FXML
    private TextField codigo_id;
    @FXML
    private TextField nome_id;
    @FXML
    private TextField descricao_id;
    @FXML
    private TextField preco_id;
    @FXML
    private TextField quantidade_id;

    void cadastrarProduto() throws Exception {
        String parseCodigo = codigo_id.getText();
        String nome = nome_id.getText();
        String descricao= descricao_id.getText();
        String parsePreco = preco_id.getText();
        String parseQuantidade = quantidade_id.getText();

        int codigo = Integer.parseInt(parseCodigo);
        double preco = Double.parseDouble(parsePreco);
        double quantidade = Double.parseDouble(parseQuantidade);

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
        String parseCodigo = codigo_id.getText();
        int codigo = Integer.parseInt(parseCodigo);

        try {
            metodoEstoque.removeProduto(codigo);
        } catch (CodigoInvalidoException e) {
            e.printStackTrace();
        }
    }

    void obterProduto() throws Exception {
        String parseCodigo = codigo_id.getText();
        int codigo = Integer.parseInt(parseCodigo);

        try {
            metodoEstoque.getProduto(codigo);
        } catch (CodigoInvalidoException e) {
            e.printStackTrace();
        }
    }

    void atualizarQuantidade() throws Exception {
        String parseCodigo = codigo_id.getText();
        String parseQuantidade = quantidade_id.getText();

        int codigo = Integer.parseInt(parseCodigo);
        double quantidade = Double.parseDouble(parseQuantidade);

        try {
            metodoEstoque.updateQuantidade(codigo, quantidade);
        } catch (CodigoInvalidoException e) {
            e.printStackTrace();
        }
    }

    void atualizarPreco() throws Exception {
        String parseCodigo = codigo_id.getText();
        String parsePreco = preco_id.getText();

        int codigo = Integer.parseInt(parseCodigo);
        double preco = Double.parseDouble(parsePreco);

        try {
            metodoEstoque.updatePreco(codigo, preco);
        } catch (CodigoInvalidoException e) {
            e.printStackTrace();
        }
    }
}
