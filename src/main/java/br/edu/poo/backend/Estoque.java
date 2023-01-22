package br.edu.poo.backend;

import br.edu.poo.backend.Exceptions.*;
import br.edu.poo.backend.Interfaces.IProdutos;
import java.util.ArrayList;

public class Estoque implements IProdutos {

    private static ArrayList<Produto> listaProdutos = new ArrayList<Produto>();

    @Override
    public void addProduto(Produto p) throws ProdutoInvalidoException, CodigoInvalidoException {
        if (p == null) {
            throw new ProdutoInvalidoException("Produto não pode ser nulo");
        }
        if (!(p instanceof Produto)) {
            throw new ProdutoInvalidoException("Objeto não é do tipo Produto");
        }
        if (existe(p.getCodigo())) {
            throw new ProdutoInvalidoException("Produto com esse código já existe");
        }
        listaProdutos.add(p);
    }

    @Override
    public void removeProduto(int codigo) throws CodigoInvalidoException {
        if (!existe(codigo)) {
            throw new CodigoInvalidoException("Código inválido");
        }
        for (Produto produto : listaProdutos) {
            if (produto.getCodigo() == codigo) {
                listaProdutos.remove(produto);
                break;
            }
        }
    }

    @Override
    public Produto getProduto(int codigo) throws CodigoInvalidoException {
        if (!existe(codigo)) {
            throw new CodigoInvalidoException("Código inválido");
        }
        for (Produto produto : listaProdutos) {
            if (produto.getCodigo() == codigo) {
                return produto;
            }
        }
        return null;
    }

    @Override
    public void updateQuantidade(int codigo, double nova) throws CodigoInvalidoException {
        if (!existe(codigo)) {
            throw new CodigoInvalidoException("Código inválido");
        }
        for (Produto produto : listaProdutos) {
            if (produto.getCodigo() == codigo) {
                produto.setQuantidade(nova);
                break;
            }
        }
    }

    @Override
    public void updatePreco(int codigo, double novo) throws CodigoInvalidoException {
        if (!existe(codigo)) {
            throw new CodigoInvalidoException("Código inválido");
        }
        for (Produto produto : listaProdutos) {
            if (produto.getCodigo() == codigo) {
                produto.setPreco(novo);
                break;
            }
        }
    }

    @Override
    public void addQuantidade(int codigo, double quantidade) throws CodigoInvalidoException {
        if (!existe(codigo)) {
            throw new CodigoInvalidoException("Código inválido");
        }
        for (Produto produto : listaProdutos) {
            if (produto.getCodigo() == codigo) {
                produto.setQuantidade(produto.getQuantidade() + quantidade);
                break;
            }
        }
    }

    @Override
    public void subQuantidade(int codigo, double quantidade) throws CodigoInvalidoException {
        if (!existe(codigo)) {
            throw new CodigoInvalidoException("Código inválido");
        }
        for (Produto produto : listaProdutos) {
            if (produto.getCodigo() == codigo) {
                produto.setQuantidade(produto.getQuantidade() - quantidade);
                break;
            }
        }
    }

    public boolean existe(int codigo) throws CodigoInvalidoException {
        if (codigo < 0) {
            throw new CodigoInvalidoException("Código inválido");
        }
        for (Produto produto : listaProdutos) {
            if (produto.getCodigo() == codigo) {
                return true;
            }
        }
        return false;
    }

}
