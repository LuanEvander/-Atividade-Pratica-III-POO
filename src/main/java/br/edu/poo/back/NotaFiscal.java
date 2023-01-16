package br.edu.poo.back;

public class NotaFiscal implements INotasFiscais {

    // Atributos da classe NotaFiscal.
    private int codigo;
    private String nome;
    private double preco;
    private double quantidade;

    /**
     * @param codigo O código da nota fiscal.
     * @param nome O nome do produto.
     * @param preco O preço do produto.
     * @param quantidade A quantidade do produto.
     */
    public NotaFiscal(int codigo, String nome, double preco, double quantidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    // Os métodos getters e setters da classe NotaFiscal.
    // O método que retorna o código da nota fiscal.
    public int getCodigo() {
        return codigo;
    }

    // O método que calcula o total da nota fiscal.
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    // O método que retorna o nome do produto.
    public String getNome() {
        return nome;
    }

    // O método que retorna o preço do produto.
    public void setNome(String nome) {
        this.nome = nome;
    }

    // O método que retorna a quantidade do produto.
    public double getPreco() {
        return preco;
    }

    // O método que retorna o total da nota fiscal.
    public void setPreco(double preco) {
        this.preco = preco;
    }

    // O método que retorna o total da nota fiscal.
    public double getQuantidade() {
        return quantidade;
    }

    // O método que retorna o total da nota fiscal.
    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    // Os métodos da interface INotasFiscais.
    @Override
    public void addNotaFiscal(NotaFiscal nf) throws Exception {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void removeNotaFiscal(int codigo) throws Exception {
        // TODO Auto-generated method stub
        
    }

    @Override
    public NotaFiscal getNotaFiscal(int codigo) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public double getTotal(int codigo) throws Exception {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void addItem(int codigo, Item item) throws Exception {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void removeItem(int codigo, Item item) throws Exception {
        // TODO Auto-generated method stub
        
    }

}
