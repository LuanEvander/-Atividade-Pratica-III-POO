package br.edu.poo.backend;

public class Item {
    private Produto produto;
    private double quantidade;

    public Item(Produto produto, double qtdProduto) {
        this.produto = produto;
        this.quantidade = qtdProduto;
    }

    /**
     * Método que retorna o produto.
     * 
     * @return Retorna o produto.
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * Método que altera o produto.
     * 
     * @param produto Define novo produto.
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    /**
     * Método que retorna a quantidade.
     * 
     * @return Retorna a quantidade.
     */
    public double getQuantidade() {
        return quantidade;
    }

    /**
     * Método que altera a quantidade.
     * 
     * @param quantidade Define nova quantidade.
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorTotal() {
        return produto.getPreco() * quantidade;
    }
}
