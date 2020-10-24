package br.com.syspizza.modelo;

// SUPER CLASSE OU CLASSE PAI
public class Pessoa {
    
    private Integer idPessoa;
    private String nome;
    private String email;
    private String telefone;

    public Pessoa() {
    }

    public Pessoa(Integer idPessoa, String nome, String email, String telefone) {
        this.idPessoa = idPessoa;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public Integer getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Integer idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    
    
}
