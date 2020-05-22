package br.senac.sp.model;

import java.time.LocalDateTime;

public class Relatorio {

    private int idrelatorio;
    private String nomeproduto;
    private String codigoproduto;
    private String categoria;
    private int qtd_vendido;
    private int Soma_Qtd;
    private int Media_Qtd;
    private double preco_unitario;
    private double preco_total;
    private double Soma_Total;
    private double Media_preco;
    private LocalDateTime localDateTime = LocalDateTime.now();//LocalDate hoje = LocalDate.now();
    private String data;
    private String usuario;
    private String nomeCliente;
    private String cpfCliente;
    private String nomefilial;
    private String formPagto;

    public double getMedia_preco() {
        return Media_preco;
    }

    public void setMedia_preco(double Media_preco) {
        this.Media_preco = Media_preco;
    }

    public int getSoma_Qtd() {
        return Soma_Qtd;
    }

    public void setSoma_Qtd(int Soma_Qtd) {
        this.Soma_Qtd = Soma_Qtd;
    }

    public int getMedia_Qtd() {
        return Media_Qtd;
    }

    public void setMedia_Qtd(int Media_Qtd) {
        this.Media_Qtd = Media_Qtd;
    }

    public double getSoma_Total() {
        return Soma_Total;
    }

    public void setSoma_Total(double Soma_Total) {
        this.Soma_Total = Soma_Total;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getFormPagto() {
        return formPagto;
    }

    public void setFormPagto(String formPagto) {
        this.formPagto = formPagto;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public int getIdrelatorio() {
        return idrelatorio;
    }

    public void setIdrelatorio(int idrelatorio) {
        this.idrelatorio = idrelatorio;
    }

    public String getNomeproduto() {
        return nomeproduto;
    }

    public void setNomeproduto(String nomeproduto) {
        this.nomeproduto = nomeproduto;
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

    public int getQtd_vendido() {
        return qtd_vendido;
    }

    public void setQtd_vendido(int qtd_vendido) {
        this.qtd_vendido = qtd_vendido;
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

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getNomefilial() {
        return nomefilial;
    }

    public void setNomefilial(String nomefilial) {
        this.nomefilial = nomefilial;
    }

    @Override
    public String toString() {
        return "Nome= " + this.nomeproduto + " Codigo= " + this.codigoproduto + " Categoria= " + this.categoria + " Qtd Venda= " + this.qtd_vendido + " Soma Qtd= " + this.Soma_Qtd + " Media Qtd= " + this.Media_Qtd + " Preco Unitario= " + this.preco_unitario + " Preco total= " + this.preco_total + this.Soma_Total + " Data= " + this.localDateTime + " Id Cliente= " + this.nomeCliente + " CPF= " + this.cpfCliente + "Id Usuario= " + this.usuario + " Id Filial= " + this.nomefilial + " ";
    }
}
