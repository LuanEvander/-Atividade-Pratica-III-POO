package br.edu.poo.backend;

public class ProdutoPorUnd extends Produto {
    private int quantidade;
    
    public ProdutoPorUnd(int codigo, String nome, String descricao, double preco, int quantidade) {
        super(codigo, nome, descricao, preco);
        this.quantidade = quantidade;
    }
    
    public int getQuantidade() {
        return quantidade;
    }
    
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}

