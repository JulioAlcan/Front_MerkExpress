package br.senac.sp.dao;

import br.senac.sp.jdbc.ConexaoDB;
import br.senac.sp.model.Relatorio;
import br.senac.sp.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RelatorioDAO {

    public boolean cadastrarVendas(String nomeproduto, String codigoproduto, String categoria, int qtd_vendido, double preco_unitario, double preco_total, String usuario, String nomeCliente, String cpfCliente, String nomeFilial, String formapagamento) {
        Relatorio re = new Relatorio();
        String sql = "insert into relatorio(nomeproduto, codigoproduto, categoria, qtd_vendido, preco_unitario, preco_total, data_venda, usuario, nomeCLiente, cpfCliente, nomeFilial, forma_pagamento) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            ConexaoDB connection = new ConexaoDB();
            Connection con = connection.recuperarConexao();
            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setString(1, nomeproduto);
            preparador.setString(2, codigoproduto);
            preparador.setString(3, categoria);
            preparador.setInt(4, qtd_vendido);
            preparador.setDouble(5, preco_unitario);
            preparador.setDouble(6, preco_total);
            preparador.setObject(7, re.getLocalDateTime());
            preparador.setString(8, usuario);
            preparador.setString(9, nomeCliente);
            preparador.setString(10, cpfCliente);
            preparador.setString(11, nomeFilial);
            preparador.setString(12, formapagamento);
            preparador.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("ERRO AO FINALIZAR A VENDA: " + e.getMessage());
        }
        return false;
    }

    public Relatorio cadastrarVenda(String nomeproduto, String codigo, String categoria, int qtdvendido, double precounitario, double precototal, String login, String nomecliente, String cpfCliente, String nomeFilial, String forma_pagamento) {
        Usuario u = new Usuario();
        Relatorio re = new Relatorio();
        String sql = "insert into relatorio(nomeproduto, codigoproduto, categoria, qtd_vendido, preco_unitario, preco_total, data_venda, usuario, nomeCliente, cpfCliente, nomeFilial, forma_pagamento) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            ConexaoDB connection = new ConexaoDB();
            Connection con = connection.recuperarConexao();
            try (PreparedStatement preparador = con.prepareStatement(sql)) {
                preparador.setString(1, nomeproduto);
                preparador.setString(2, codigo);
                preparador.setString(3, categoria);
                preparador.setInt(4, qtdvendido);
                preparador.setDouble(5, precounitario);
                preparador.setDouble(6, precototal);
                preparador.setObject(7, re.getLocalDateTime());
                preparador.setString(8, login);
                preparador.setString(9, nomecliente);
                preparador.setString(10, cpfCliente);
                preparador.setString(11, nomeFilial);
                preparador.setString(12, forma_pagamento);
                preparador.execute();
            }
        } catch (SQLException e) {
            System.out.println("ERRO AO FINALIZAR A VENDA: " + e.getMessage());
        }
        return null;
    }

    public List<Relatorio> pegaTodos(String datainicio, String datafim) {
        String sql = "select * from relatorio where data_venda >= ? and data_venda < ?";
        List<Relatorio> lista = new ArrayList<>();
        try {
            ConexaoDB connection = new ConexaoDB();
            Connection con = connection.recuperarConexao();
            try (PreparedStatement preparador = con.prepareStatement(sql)) {
                preparador.setString(1, "%" + datainicio + "%");
                preparador.setString(2, datafim + "%");
                ResultSet resultado = preparador.executeQuery();
                while (resultado.next()) {
                    Relatorio re = new Relatorio();
                    re.setIdrelatorio(resultado.getInt("idrelatorio"));
                    re.setNomeproduto(resultado.getString("nomeproduto"));
                    re.setCodigoproduto(resultado.getString("codigoproduto"));
                    re.setCategoria(resultado.getString("categoria"));
                    re.setQtd_vendido(resultado.getInt("qtd_vendido"));
                    re.setPreco_unitario(resultado.getDouble("preco_unitario"));
                    re.setPreco_total(resultado.getDouble("preco_total"));
                    re.setData(resultado.getString("data_venda"));
                    re.setUsuario(resultado.getString("usuario"));
                    re.setNomeCliente(resultado.getString("nomeCLiente"));
                    re.setCpfCliente(resultado.getString("cpfCliente"));
                    re.setNomefilial(resultado.getString("nomeFilial"));
                    re.setFormPagto(resultado.getString("forma_pagamento"));
                    lista.add(re);
                }
            }
        } catch (SQLException e) {
            System.out.println("ERRO AO BUSCAR AS INFORMAÇÔES DO BANCO DE DADOS" + e.getMessage());
        }
        return lista;
    }

    public List<Relatorio> pegaTodosAnalitico(String datainicio, String datafim) {
        String sql = "select idrelatorio, nomeproduto, codigoproduto, categoria, qtd_vendido, sum(qtd_vendido) as Soma_Qtd, avg(qtd_vendido) as Media_Qtd, preco_unitario,  preco_total, sum(preco_total) as Soma_Total, avg(preco_total) as Media_Preco, data_venda, usuario, nomeCLiente, cpfCliente, nomeFilial, forma_pagamento from relatorio where data_venda >= ? and data_venda < ? group by nomeproduto, forma_pagamento";
        List<Relatorio> lista = new ArrayList<>();
        try {
            ConexaoDB connection = new ConexaoDB();
            Connection con = connection.recuperarConexao();
            try (PreparedStatement preparador = con.prepareStatement(sql)) {
                preparador.setString(1, "%" + datainicio + "%");
                preparador.setString(2, datafim + "%");
                ResultSet resultado = preparador.executeQuery();
                while (resultado.next()) {
                    Relatorio re = new Relatorio();
                    re.setIdrelatorio(resultado.getInt("idrelatorio"));
                    re.setNomeproduto(resultado.getString("nomeproduto"));
                    re.setCodigoproduto(resultado.getString("codigoproduto"));
                    re.setCategoria(resultado.getString("categoria"));
                    re.setQtd_vendido(resultado.getInt("qtd_vendido"));
                    re.setMedia_Qtd(resultado.getInt("Media_Qtd"));
                    re.setSoma_Qtd(resultado.getInt("Soma_Qtd"));
                    re.setPreco_unitario(resultado.getDouble("preco_unitario"));
                    re.setPreco_total(resultado.getDouble("preco_total"));
                    re.setSoma_Total(resultado.getDouble("Soma_Total"));
                    re.setMedia_preco(resultado.getDouble("Media_Preco"));
                    re.setData(resultado.getString("data_venda"));
                    re.setUsuario(resultado.getString("usuario"));
                    re.setNomeCliente(resultado.getString("nomeCLiente"));
                    re.setCpfCliente(resultado.getString("cpfCliente"));
                    re.setNomefilial(resultado.getString("nomeFilial"));
                    re.setFormPagto(resultado.getString("forma_pagamento"));
                    lista.add(re);
                }
            }
        } catch (SQLException e) {
            System.out.println("ERRO AO BUSCAR AS INFORMAÇÔES DO BANCO DE DADOS" + e.getMessage());
        }
        return lista;
    }

}
