package br.senac.sp.model;

import br.senac.sp.dao.vendaDAO;
import java.time.LocalDateTime;

public class Venda extends vendaDAO{

    private int id;
    private String nomeproduto;
    private String codigoproduto;
    private String categoria;
    private int qtd;
    private double preco_unitario;
    private double preco_total;
    private String usuario;
    private LocalDateTime localDateTime = LocalDateTime.now();
    private String nomecliente;
    private String cpfcliente;
    private String nome_filial;
    private String formpagto;

    public String getFormpagto() {
        return formpagto;
    }

    public void setFormpagto(String formpagto) {
        this.formpagto = formpagto;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigoproduto() {
        return codigoproduto;
    }

    public void setCodigoproduto(String codigoproduto) {
        this.codigoproduto = codigoproduto;
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

    public String getNomeproduto() {
        return nomeproduto;
    }

    public void setNomeproduto(String nomeproduto) {
        this.nomeproduto = nomeproduto;
    }

    public double getPreco_unitario() {
        return preco_unitario;
    }

    public void setPreco_unitario(double preco_unitario) {
        this.preco_unitario = preco_unitario;
    }

    public double getPreco_total() {
        return preco_total;
    }

    public void setPreco_total(double preco_total) {
        this.preco_total = preco_total;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNomecliente() {
        return nomecliente;
    }

    public void setNomecliente(String nomecliente) {
        this.nomecliente = nomecliente;
    }

    public String getCpfcliente() {
        return cpfcliente;
    }

    public void setCpfcliente(String cpfcliente) {
        this.cpfcliente = cpfcliente;
    }

    public String getNome_filial() {
        return nome_filial;
    }

    public void setNome_filial(String nome_filial) {
        this.nome_filial = nome_filial;
    }

    @Override
    public String toString() {
        return "[" + this.id + " " + this.nomeproduto + " " + this.codigoproduto + " " + this.categoria + " " + this.qtd + " " + this.preco_unitario + this.preco_total + this.usuario + this.nomecliente + this.cpfcliente + this.nome_filial + this.formpagto +"]";
    }

}
