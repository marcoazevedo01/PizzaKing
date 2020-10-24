package br.com.syspizza.modelo;

// SUBCLASSE OU CLASSE FILHA
public class Bebida extends Produto{
    
    private Integer idBebida;
    private String tipo;

    public Bebida() {
    }

    public Bebida(Integer idBebida, String tipo, Integer idProduto, String descricao, String dataValidade, Double medida, Double valor) {
        super(idProduto, descricao, dataValidade, medida, valor);
        this.idBebida = idBebida;
        this.tipo = tipo;
    }

    public Integer getIdBebida() {
        return idBebida;
    }

    public void setIdBebida(Integer idBebida) {
        this.idBebida = idBebida;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
    
    
    
    
    
}
