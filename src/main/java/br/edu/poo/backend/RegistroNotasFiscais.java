package br.edu.poo.backend;

import br.edu.poo.backend.Exceptions.*;
import java.util.ArrayList;
import br.edu.poo.backend.Interfaces.INotasFiscais;

/**
 * Classe que implementa a interface INotasFiscais e contém os métodos para manipular as notas
 * 
 * @author Luan Evander
 * @author Kaua Henrico
 */
public class RegistroNotasFiscais implements INotasFiscais {
    private static ArrayList<NotaFiscal> listaNotasFiscais = new ArrayList<NotaFiscal>();

    /**
     *  Método que adiciona uma nota fiscal ao registro. 
     * @param nf Nota fiscal a ser adicionada.
     * @throws NotaFiscalInvalidaException caso a nota fiscal seja nula ou não seja do tipo NotaFiscal.
     * @throws NumeroNotaFiscalInvalidoException caso o número da nota fiscal seja inválido.
     * 
     */
    @Override
    public void addNotaFiscal(NotaFiscal nf)
            throws NotaFiscalInvalidaException, NumeroNotaFiscalInvalidoException {
        if (nf == null) {
            throw new NotaFiscalInvalidaException("Nota fiscal não pode ser nula.");
        }
        if (!(nf instanceof NotaFiscal)) {
            throw new NotaFiscalInvalidaException("Objeto não é do tipo NotaFiscal.");
        }
        if (nf.getRelacaoItens() == null || nf.getRelacaoItens().size() == 0) {
            throw new NotaFiscalInvalidaException("Nota fiscal deve conter pelo menos um item.");
        }
        if (existe(nf.getCodigo())) {
            throw new NumeroNotaFiscalInvalidoException("Nota fiscal já existe com esse código.");
        }
        listaNotasFiscais.add(nf);
    }

    /**
     *  Método que remove uma nota fiscal do registro.
     * @param codigo Código da nota fiscal a ser removida.
     * @throws NumeroNotaFiscalInvalidoException caso o número da nota fiscal seja inválido.
     */
    
    @Override
    public void removeNotaFiscal(int codigo) throws NumeroNotaFiscalInvalidoException {
        if (!existe(codigo)) {
            throw new NumeroNotaFiscalInvalidoException("Código inválido.");
        }
        for (NotaFiscal nf : listaNotasFiscais) {
            if (nf.getCodigo() == codigo) {
                listaNotasFiscais.remove(nf);
                break;
            }
        }
    }


    /**
     *  Método que retorna uma nota fiscal do registro.
     * @param codigo Código da nota fiscal a ser retornada.
     * @throws NumeroNotaFiscalInvalidoException caso o número da nota fiscal seja inválido.
     */
    @Override
    public NotaFiscal getNotaFiscal(int codigo) throws NumeroNotaFiscalInvalidoException {
        if (!existe(codigo)) {
            throw new NumeroNotaFiscalInvalidoException("Código inválido.");
        }
        for (NotaFiscal nf : listaNotasFiscais) {
            if (nf.getCodigo() == codigo) {
                return nf;
            }
        }
        return null;
    }

    /**
     *  Método que retorna o total de uma nota fiscal.
     * @param codigo Código da nota fiscal a ser retornada.
     * @throws NumeroNotaFiscalInvalidoException caso o número da nota fiscal seja inválido.
     */
    @Override
    public double getTotal(int codigo) throws NumeroNotaFiscalInvalidoException {
        if (!existe(codigo)) {
            throw new NumeroNotaFiscalInvalidoException("Código inválido.");
        }
        double total = 0;
        for (NotaFiscal nf : listaNotasFiscais) {
            if (nf.getCodigo() == codigo) {
                for (Item item : nf.getRelacaoItens()) {
                    total += item.getValorTotal();
                }
            }
        }
        return total;
    }

    /**
     *  Método que adiciona um item a uma nota fiscal.
     * @param codigo Código da nota fiscal a ser adicionado o item.
     * @param item Item a ser adicionado.
     * @throws NumeroNotaFiscalInvalidoException caso o número da nota fiscal seja inválido.
     */
    @Override
    public void addItem(int codigo, Item item) throws NumeroNotaFiscalInvalidoException {
        if (!existe(codigo)) {
            throw new NumeroNotaFiscalInvalidoException("Código inválido.");
        }
        for (NotaFiscal nf : listaNotasFiscais) {
            if (nf.getCodigo() == codigo) {
                nf.getRelacaoItens().add(item);
            }
        }
    }

    /**
     *  Método que remove um item de uma nota fiscal.
     * @param codigo Código da nota fiscal a ser removido o item.
     * @param item Item a ser removido.
     * @throws NumeroNotaFiscalInvalidoException caso o número da nota fiscal seja inválido.
     */
    @Override
    public void removeItem(int codigo, Item item) throws NumeroNotaFiscalInvalidoException {
        if (!existe(codigo)) {
            throw new NumeroNotaFiscalInvalidoException("Código inválido.");
        }
        for (NotaFiscal nf : listaNotasFiscais) {
            if (nf.getCodigo() == codigo) {
                nf.getRelacaoItens().remove(item);
            }
        }
    }

    /**
     *  Método que retorna uma lista de notas fiscais.
     * @return Lista de notas fiscais.
     */
    public boolean existe(int codigo) throws NumeroNotaFiscalInvalidoException {
        if (codigo >= 1000000000 && codigo <= 9999999999L) {
            for (NotaFiscal nf : listaNotasFiscais) {
                if (nf.getCodigo() == codigo) {
                    return true;
                }
            }
        } else {
            throw new NumeroNotaFiscalInvalidoException("Código inválido.");
        }
        return false;
    }

}
