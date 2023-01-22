package br.edu.poo.backend;

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
    public void addNotaFiscal(NotaFiscal nf) throws Exception {
        if (nf != null && nf instanceof NotaFiscal && nf.getRelacaoItens() != null
                && nf.getRelacaoItens().size() > 0 && !existe(nf.getCodigo())) {
            listaNotasFiscais.add(nf);
        } else {
            throw new Exception("Nota fiscal inválida.");
        }
    }

    @Override
    public void removeNotaFiscal(int codigo) throws Exception {
        if (existe(codigo)) {
            for (NotaFiscal nf : listaNotasFiscais) {
                if (nf.getCodigo() == codigo) {
                    listaNotasFiscais.remove(nf);
                    break;
                }
            }
        } else {
            throw new Exception("Código inválido.");
        }
    }

    @Override
    public NotaFiscal getNotaFiscal(int codigo) throws Exception {
        if (existe(codigo)) {
            for (NotaFiscal nf : listaNotasFiscais) {
                if (nf.getCodigo() == codigo) {
                    return nf;
                }
            }
        } else {
            throw new Exception("Código inválido.");
        }
        return null;
    }

    @Override
    public double getTotal(int codigo) throws Exception {
        if(existe(codigo)) {
            double total = 0;
            for (NotaFiscal nf : listaNotasFiscais) {
                if (nf.getCodigo() == codigo) {
                    for (Item item : nf.getRelacaoItens()) {
                        total += item.getValorTotal();
                    }
                }
            }
            return total;
        } else {
            throw new Exception("Código inválido.");
        }
    }

    @Override
    public void addItem(int codigo, Item item) throws Exception {
        if(existe(codigo)) {
            for (NotaFiscal nf : listaNotasFiscais) {
                if (nf.getCodigo() == codigo) {
                    nf.getRelacaoItens().add(item);
                }
            }
        } else {
            throw new Exception("Código inválido.");
        }

    }

    @Override
    public void removeItem(int codigo, Item item) throws Exception {
        if(existe(codigo)) {
            for (NotaFiscal nf : listaNotasFiscais) {
                if (nf.getCodigo() == codigo) {
                    nf.getRelacaoItens().remove(item);
                }
            }
        } else {
            throw new Exception("Código inválido.");
        } 
    }

    public boolean existe (int codigo) throws Exception {
        if (codigo >= 1000000000 && codigo <= 9999999999L) {
            for (NotaFiscal nf : listaNotasFiscais) {
                if (nf.getCodigo() == codigo) {
                    return true;
                }
            }
        } else {
            throw new Exception("Código inválido.");
        }
        return false;
    }
}
