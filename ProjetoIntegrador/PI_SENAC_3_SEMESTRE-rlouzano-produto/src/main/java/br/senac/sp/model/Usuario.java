package br.senac.sp.model;

public class Usuario {

    private int id;
    private String nome;
    private String cpf;
    private String perfil;
    private String login;
    private String senha;
    private String senhaAdmin;
    private String filial;
    private int idfilial;

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public int getIdfilial() {
        return idfilial;
    }

    public void setIdfilial(int idfilial) {
        this.idfilial = idfilial;
    }

    public Usuario() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getFilial() {
        return filial;
    }

    public void setFilial(String filial) {
        this.filial = filial;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getSenhaAdmin() {
        return senhaAdmin;
    }

    public void setSenhaAdmin(String senhaAdmin) {
        this.senhaAdmin = senhaAdmin;
    }

    @Override
    public String toString() {
        return "[" + this.id + " " + this.nome + " " + this.cpf + " " + this.perfil + " " + this.login + " " + this.senha + " " + this.senhaAdmin + " " + this.filial + this.idfilial + "]";
    }

}
