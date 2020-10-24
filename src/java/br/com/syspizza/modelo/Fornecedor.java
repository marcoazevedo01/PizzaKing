package br.com.syspizza.modelo;

// SUBCLASSE OU CLASSE FILHA
public class Fornecedor extends Pessoa{
    
    private Integer idFornecedor;
    private String cnpj;

    public Fornecedor() {
    }

    public Fornecedor(Integer idFornecedor, String cnpj, Integer idPessoa, String nome, String email, String telefone) {
        super(idPessoa, nome, email, telefone);
        this.idFornecedor = idFornecedor;
        this.cnpj = cnpj;
    }

    public Integer getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Integer idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    
    
    
    
    
    
    
}
