package br.edu.poo.backend;

public class ProdutoPorKg extends Produto {
    private double peso;

    public ProdutoPorKg(int codigo, String nome, String descricao, double preco, double quantidade,
            double peso) {
        super(codigo, nome, descricao, preco, quantidade);
        this.peso = peso;
    }
    

    /**
     * Método que retorna o peso do produto.
     * 
     * @return Retorna o peso do produto.
     */
    public double getPeso() {
        return peso;
    }

    /**
     * Método que altera o peso do produto.
     * 
     * @param peso Define novo peso do produto.
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

}

