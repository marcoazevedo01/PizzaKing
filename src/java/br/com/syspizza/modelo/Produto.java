package br.com.syspizza.modelo;

// SUPER CLASSE OU CLASSE PAI

import java.util.Date;

public class Produto {
    
    private Integer idProduto;
    private String descricao;
    private Date dataValidade;
    private Double medida;
    private Double valor;

    public Produto() {
    }

    public Produto(Integer idProduto, String descricao, Date dataValidade, Double medida, Double valor) {
        this.idProduto = idProduto;
        this.descricao = descricao;
        this.dataValidade = dataValidade;
        this.medida = medida;
        this.valor = valor;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
            this.descricao = descricao;   
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public Double getMedida() {
        return medida;
    }

    public void setMedida(Double medida) {
        this.medida = medida;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    
    
    
    
}
