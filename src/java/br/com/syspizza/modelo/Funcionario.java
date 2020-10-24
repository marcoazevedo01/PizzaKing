package br.com.syspizza.modelo;

public class Funcionario {
    
    private Integer id;
    private String nome;
    private Double salario;
    private String telefone;

    public Funcionario() {
    }

    public Funcionario(Integer id, String nome, Double salario, String telefone) {
        this.id = id;
        this.nome = nome;
        this.salario = salario;
        this.telefone = telefone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    
    
}
