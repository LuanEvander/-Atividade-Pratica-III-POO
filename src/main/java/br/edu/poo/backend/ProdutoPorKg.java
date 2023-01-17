package br.edu.poo.backend;

public class ProdutoPorKg extends Produto {
    private double quantidade;
    
    public ProdutoPorKg(int codigo, String nome, String descricao, double preco, double quantidade) {
        super(codigo, nome, descricao, preco);
        this.quantidade = quantidade;
    }
    
    public double getQuantidade() {
        return quantidade;
    }
    
    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }
}

