package br.senac.sp.model;


public class produto {

    private int idproduto;
    private String nome;
    private String codigo;
    private String categoria;
    private int qtd;
    private double preco;
    private String pesquisa;
    private int id;
    private Filial filial;

    public produto(int idproduto, String nome, String codigo, String categoria, int qtd, double preco, String pesquisa, Filial filial) {
        this.idproduto = idproduto;
        this.nome = nome;
        this.codigo = codigo;
        this.categoria = categoria;
        this.qtd = qtd;
        this.preco = preco;
        this.pesquisa = pesquisa;
        this.filial = filial;
    }
    

    public produto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }

    public int getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(int idproduto) {
        this.idproduto = idproduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Filial getFilial() {
        return filial;
    }

    public void setFilial(Filial filial) {
        this.filial = filial;
    }



    @Override
    public String toString() {
        return "[" + this.idproduto + " | " + this.getNome() + " | " + this.codigo + " | " + this.categoria + " | " + this.qtd + " | " + this.preco + " | " + this.id + " " +  this.filial + "]";
    }

}
