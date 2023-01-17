package br.edu.poo.backend;

public class Produto {

    // Atributos da classe Produto.
    private int codigo;
    private String nome;
    private String descricao;
    private double preco;
    private double quantidade;

    /**
     * @param codigo Código do produto.
     * @param nome Nome do produto.
     * @param preco Preço do produto.
     * @param quantidade Quantidade do produto.
     */
    public Produto(int codigo, String nome, String descricao, double preco, double quantidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    /**
     * Método que retorna o código do produto.
     * 
     * @return Retorna valor do código do produto.
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Método que altera o código do produto.
     * 
     * @param codigo Define novo código do produto.
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Método que retorna o nome do produto.
     * 
     * @return Retorna o nome do produto.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Método que altera o nome do produto.
     * 
     * @param nome Define novo nome do produto.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Método que retorna o preço do produto.
     * 
     * @return Retorna o preço do produto.
     */
    public double getPreco() {
        return preco;
    }

    /**
     * Método que altera o preço do produto.
     * 
     * @param preco Define novo preço do produto.
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * Método que retorna a quantidade do produto.
     * 
     * @return Retorna valor da quantidade do produto.
     */
    public double getQuantidade() {
        return quantidade;
    }

    /**
     * Método que altera a quantidade do produto.
     * 
     * @param quantidade Define quantidade do produto.
     */
    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * Método que retorna a descrição do produto.
     * 
     * @return Retorna a descrição do produto.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Método que altera a descrição do produto.
     * 
     * @param descricao Define nova descrição do produto.
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
