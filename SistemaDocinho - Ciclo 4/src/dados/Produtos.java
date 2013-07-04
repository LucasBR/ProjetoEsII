/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

/**
 *
 * @author Lucas
 */
public class Produtos {

    public Integer codigo;
    public double valor;
    public Integer pacote_quantidade;
    public String nome;
    public String descricao;

    public Produtos(Integer nCod, double nValor, Integer nQuantidade, String nNome, String nDescricao) {
        super();
        this.codigo = nCod;
        this.valor = nValor;
        this.pacote_quantidade = nQuantidade;
        this.nome = nNome;
        this.descricao = nDescricao;
    }

    public Produtos(double valor, Integer pacote_quantidade, String nome, String descricao) {
        this.valor = valor;
        this.pacote_quantidade = pacote_quantidade;
        this.nome = nome;
        this.descricao = descricao;
    }
    

    /**
     * @return the codigo
     */
    public Integer getCodigo() {
        return codigo;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @return the quantidade
     */
    public Integer getQuantidade() {
        return pacote_quantidade;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }
}
