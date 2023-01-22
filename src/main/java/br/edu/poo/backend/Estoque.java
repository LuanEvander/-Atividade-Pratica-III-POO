package br.edu.poo.backend;

import br.edu.poo.backend.Exceptions.*;
import br.edu.poo.backend.Interfaces.IProdutos;
import java.util.ArrayList;

/**
 * Classe que implementa a interface IProdutos e contém os métodos para manipular o estoque de
 * produtos.
 * 
 * @author Kaua Henrico
 * @author Luan Evander
 */

public class Estoque implements IProdutos {

    /*
     * Lista de produtos que será utilizada para armazenar os produtos cadastrados.
     */
    private static ArrayList<Produto> listaProdutos = new ArrayList<Produto>();

    /*
     * Método que adiciona um produto ao estoque.
     * @param p Produto a ser adicionado.
     * @throws ProdutoInvalidoException caso o produto seja nulo ou não seja do tipo Produto.
     * @throws CodigoInvalidoException caso o código do produto seja inválido.
     */
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

    /*
     * Método que remove um produto do estoque.
     * @param codigo Código do produto a ser removido.
     * @throws CodigoInvalidoException caso o código do produto seja inválido.
     */
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

    /*
     * Método que retorna um produto do estoque.
     * @param codigo Código do produto a ser retornado.
     * @return Produto com o código passado como parâmetro.
     * @throws CodigoInvalidoException caso o código do produto seja inválido.
     */
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

    /*
     * Método que atualiza a quantidade de um produto.
     * @param codigo Código do produto a ser atualizado.
     * @param nova Nova quantidade do produto.
     * @throws CodigoInvalidoException caso o código do produto seja inválido.
     */
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

    /*
     * Método que atualiza o preço de um produto.
     * @param codigo Código do produto a ser atualizado.
     * @param novo Novo preço do produto.
     * @throws CodigoInvalidoException caso o código do produto seja inválido.
     */
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

    /*
     * Método que adiciona a quantidade de um produto.
     * @param codigo Código do produto a ser atualizado.
     * @param quantidade Quantidade a ser adicionada ao produto.
     * @throws CodigoInvalidoException caso o código do produto seja inválido.
     */
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

    /*
     * Método que subtrai a quantidade de um produto.
     * @param codigo Código do produto a ser atualizado.
     * @param quantidade Quantidade a ser subtraída do produto.
     * @throws CodigoInvalidoException caso o código do produto seja inválido.
     */
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

    /*
     * Método que verifica se um produto existe no estoque.
     * @param codigo Código do produto a ser verificado.
     * @return true caso o produto exista, false caso contrário.
     * @throws CodigoInvalidoException caso o código do produto seja inválido.
     */
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
