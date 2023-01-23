package br.edu.poo.backend;

import java.util.ArrayList;

public class Estoque implements IProdutos {

    private static ArrayList<Produto> listaProdutos = new ArrayList<Produto>();

    @Override
    public void addProduto(Produto p) throws Exception {
        if (p != null && p instanceof Produto && !existe(p.getCodigo())) {
            listaProdutos.add(p);
        } else {
            throw new Exception("Produto inválido");
        }
    }

    @Override
    public void removeProduto(int codigo) throws Exception {
        if (existe(codigo)) {
            for (Produto produto : listaProdutos) {
                if (produto.getCodigo() == codigo) {
                    listaProdutos.remove(produto);
                    break;
                }
            }
        } else {
            throw new Exception("Código inválido");
        }

    }

    @Override
    public Produto getProduto(int codigo) throws Exception {
        if (existe(codigo)) {
            for (Produto produto : listaProdutos) {
                if (produto.getCodigo() == codigo) {
                    return produto;
                }
            }
        } else {
            throw new Exception("Código inválido");
        }
        return null;
    }

    @Override
    public void updateQuantidade(int codigo, double nova) throws Exception {
        if (existe(codigo)) {
            for (Produto produto : listaProdutos) {
                if (produto.getCodigo() == codigo) {
                    produto.setQuantidade(nova);
                    break;
                }
            }
        } else {
            throw new Exception("Código inválido");
        }

    }

    @Override
    public void updatePreco(int codigo, double novo) throws Exception {
        if (existe(codigo)) {
            for (Produto produto : listaProdutos) {
                if (produto.getCodigo() == codigo) {
                    produto.setPreco(novo);
                    break;
                }
            }
        } else {
            throw new Exception("Código inválido");
        }


    }

    @Override
    public void addQuantidade(int codigo, double quantidade) throws Exception {
        if (existe(codigo)) {
            for (Produto produto : listaProdutos) {
                if (produto.getCodigo() == codigo) {
                    produto.setQuantidade(produto.getQuantidade() + quantidade);
                    break;
                }
            }
        } else {
            throw new Exception("Código inválido");
        }


    }

    @Override
    public void subQuantidade(int codigo, double quantidade) throws Exception {
        if (existe(codigo)) {
            for (Produto produto : listaProdutos) {
                if (produto.getCodigo() == codigo) {
                    produto.setQuantidade(produto.getQuantidade() - quantidade);
                    break;
                }
            }
        } else {
            throw new Exception("Código inválido");
        }


    }

    public boolean existe(int codigo) throws Exception {
        if (codigo >= 0) {
            for (Produto produto : listaProdutos) {
                if (produto.getCodigo() == codigo) {
                    return true;
                }
            }
        } else {
            throw new Exception("Código inválido");
        }
        return false;
    }

}
