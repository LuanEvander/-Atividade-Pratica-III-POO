package br.edu.poo.backend;

public class Produto implements IProdutos{

    // Atributos da classe Produto.
    private int codigo;
    private String nome;
    private double preco;
    private double quantidade;

    /**
     * @param codigo O código do produto.
     * @param nome O nome do produto.
     * @param preco O preço do produto.
     * @param quantidade A quantidade do produto.
     */
    public Produto(int codigo, String nome, double preco, double quantidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    /**
     * Essa função retorna o código do produto.
     * 
     * @return O valor do código do produto.
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Essa função altera o código do produto.
     * 
     * @param codigo O novo código do produto.
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Essa função retorna o nome do produto.
     * 
     * @return O metodo retorna o nome do produto.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Essa função altera o nome do produto.
     * 
     * @param nome O novo nome do produto.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Essa função retorna o preço do produto.
     * 
     * @return Essa função retorna o preço do produto.
     */
    public double getPreco() {
        return preco;
    }

    /**
     * Essa função altera o preço do produto.
     * 
     * @param preco O novo preço do produto.
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * A função retorna a quantidade do produto.
     * 
     * @return O valor da quantidade do produto.
     */
    public double getQuantidade() {
        return quantidade;
    }

    /**
     * Essa função altera a quantidade do produto.
     * 
     * @param quantidade A nova quantidade do produto.
     */
    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public void addProduto(Produto p) throws Exception {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void removeProduto(int codigo) throws Exception {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Produto getProduto(int codigo) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updateQuantidade(int codigo, double nova) throws Exception {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void updatePreco(int codigo, double novo) throws Exception {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void addQuantidade(int codigo, double quantidade) throws Exception {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void subQuantidade(int codigo, double quantidade) throws Exception {
        // TODO Auto-generated method stub
        
    }

}
