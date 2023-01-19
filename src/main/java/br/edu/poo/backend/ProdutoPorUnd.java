package br.edu.poo.backend;

public class ProdutoPorUnd extends Produto {
    private int unidades;

public ProdutoPorUnd(int codigo, String nome, String descricao, double preco, double quantidade, int unidades) {
    super(codigo, nome, descricao, preco, quantidade);
    this.unidades = unidades;
}

    // Métodos getters e setters para unidades

    /**
     * Método que retorna a quantidade de unidades do produto.
     * 
     * @return Retorna a quantidade de unidades do produto.
     */
    public int getUnidades() {
        return unidades;
    }
    
    /**
     * Método que altera a quantidade de unidades do produto.
     * 
     * @param unidades Define nova quantidade de unidades do produto.
     */
    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }
}

