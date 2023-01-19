package br.edu.poo.backend;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * Classe que representa uma nota fiscal.
 * 
 * @author Luan Evander
 */
public class NotaFiscal {

    // Atributos da classe NotaFiscal.
    private static int numCodigo = 1000000000;
    private int codigo;
    private Date dataEmissao;
    private ArrayList<Item> relacaoItens = new ArrayList<Item>();

    SimpleDateFormat formatoData =
            new SimpleDateFormat("dd/MM/yyyy hh:mm:ss", new Locale("pt", "BR"));

    /**
     * @param item Relação de itens da nota fiscal.
     */
    public NotaFiscal(ArrayList<Item> item) {
        this.codigo = numCodigo++;
        this.dataEmissao = new Date();
        this.relacaoItens = item;
    }

    /**
     * Método que retorna o código da nota fiscal.
     * 
     * @return Retorna valor do código da nota fiscal.
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Método que retorna a data de emissão da nota fiscal.
     * 
     * @return Retorna valor da data de emissão da nota fiscal.
     */
    public Date getDataEmissao() {
        return dataEmissao;
    }

    /**
     * Método que retorna a relação de itens da nota fiscal.
     * 
     * @return Retorna valor da relação de itens da nota fiscal.
     */
    public ArrayList<Item> getRelacaoItens() {
        return relacaoItens;
    }

    /**
     * Método que altera a relação de itens da nota fiscal.
     * 
     * @param relacaoItens Define nova relação de itens da nota fiscal.
     */
    public void setRelacaoItens(ArrayList<Item> relacaoItens) {
        this.relacaoItens = relacaoItens;
    }

    public String toString() {
        return "Código: " + this.codigo + "\nData de emissão: "
                + formatoData.format(this.dataEmissao) + "\nRelação de itens: "
                + this.relacaoItens.toString()
                + "\n";
    }
}
