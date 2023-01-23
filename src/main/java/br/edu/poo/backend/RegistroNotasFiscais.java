package br.edu.poo.backend;

import br.edu.poo.backend.Exceptions.*;
import java.util.ArrayList;
import br.edu.poo.backend.Interfaces.INotasFiscais;

/**
 * Classe que representa uma nota fiscal.
 * 
 * @author Luan Evander
 */
public class RegistroNotasFiscais implements INotasFiscais {
    private static ArrayList<NotaFiscal> listaNotasFiscais = new ArrayList<NotaFiscal>();

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
