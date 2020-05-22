package br.senac.sp.dao;

import br.senac.sp.jdbc.ConexaoDB;
import br.senac.sp.model.Filial;
import br.senac.sp.model.produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rafae
 */
public class produtoDAO extends produto {

    public List<produto> pegaTodos() {
        String sql = "SELECT p.idproduto, p.nome, p.codigoproduto, p.categoria, p.qtd, p.preco, f.nome FROM produto AS p inner join filial AS f on p.idfilial = f.idfilial";
        List<produto> lista = new ArrayList<>();
        try {
            ConexaoDB connection = new ConexaoDB();
            Connection con = connection.recuperarConexao();
            try (PreparedStatement preparador = con.prepareStatement(sql)) {
                ResultSet resultado = preparador.executeQuery();
                while (resultado.next()) {
                    produto prod = new produto();
                    prod.setIdproduto(resultado.getInt("p.idproduto"));
                    prod.setNome(resultado.getString("p.nome"));
                    prod.setCodigo(resultado.getString("p.codigoproduto"));
                    prod.setCategoria(resultado.getString("p.categoria"));
                    prod.setQtd(resultado.getInt("p.qtd"));
                    prod.setPreco(resultado.getDouble("p.preco"));
                    Filial f = new Filial();
                    f.setNome(resultado.getString("f.nome"));
                    prod.setFilial(f);
                    lista.add(prod);
                }
            }
        } catch (SQLException e) {
            System.out.println("ERRO AO PEGAR TODOS: " + e.getMessage());
        }
        return lista;
    }

    public List<produto> pegaTudo() {
        String sql = "SELECT * FROM produto";
        List<produto> lista = new ArrayList<>();
        try {
            ConexaoDB connection = new ConexaoDB();
            Connection con = connection.recuperarConexao();
            try (PreparedStatement preparador = con.prepareStatement(sql)) {
                ResultSet resultado = preparador.executeQuery();
                while (resultado.next()) {
                    produto prod = new produto();
                    prod.setIdproduto(resultado.getInt("idproduto"));
                    prod.setNome(resultado.getString("nome"));
                    prod.setCodigo(resultado.getString("codigoproduto"));
                    prod.setCategoria(resultado.getString("categoria"));
                    prod.setQtd(resultado.getInt("qtd"));
                    prod.setPreco(resultado.getDouble("preco"));
                    lista.add(prod);
                }
            }
        } catch (SQLException e) {
            System.out.println("ERRO AO PEGAR TUDO: " + e.getMessage());
        }
        return lista;
    }

    public List<produto> pegaQtd() {
        String sql = "SELECT qtd FROM produto";
        List<produto> lista = new ArrayList<>();
        try {
            ConexaoDB connection = new ConexaoDB();
            Connection con = connection.recuperarConexao();
            try (PreparedStatement preparador = con.prepareStatement(sql)) {
                ResultSet resultado = preparador.executeQuery();
                if (resultado.next()) {
                    produto prod = new produto();
                    prod.setQtd(resultado.getInt("qtd"));
                    lista.add(prod);
                }
            }
        } catch (SQLException e) {
            System.out.println("ERRO AO PEGAR QTD: " + e.getMessage());
        }
        return lista;
    }

    public List<produto> buscaPorPesquisa(String pesquisa) {
        String sql = "select p.idproduto, p.nome, p.codigoproduto, p.categoria, p.qtd, p.preco, f.nome, f.idfilial from produto as p inner join filial as f on p.idfilial = f.idfilial where p.nome like ? or p.codigoproduto like ?";
        List<produto> lista = new ArrayList<>();
        try {
            ConexaoDB connection = new ConexaoDB();
            Connection con = connection.recuperarConexao();
            try (PreparedStatement preparador = con.prepareStatement(sql)) {
                preparador.setString(1, "%" + pesquisa + "%");
                preparador.setString(2, "%" + pesquisa + "%");
                ResultSet resultado = preparador.executeQuery();
                while (resultado.next()) {
                    produto prod = new produto();
                    prod.setId(resultado.getInt("p.idproduto"));
                    prod.setNome(resultado.getString("p.nome"));
                    prod.setCodigo(resultado.getString("p.codigoproduto"));
                    prod.setCategoria(resultado.getString("p.categoria"));
                    prod.setQtd(resultado.getInt("p.qtd"));
                    prod.setPreco(resultado.getDouble("p.preco"));
                    Filial f = new Filial();
                    f.setIdfilial(resultado.getInt("f.idfilial"));
                    f.setNome(resultado.getString("f.nome"));
                    prod.setFilial(f);
                    lista.add(prod);
                }
            }
        } catch (SQLException e) {
            System.out.println("ERRO AO EXECUTAR A PESQUISA NO BANCO" + e.getMessage());
        }
        return lista;
    }

    public boolean cadastrar(String nome, String codigo, String Categoria, int qtd, double preco) {
        String sql = "insert into produto(nome, codigoproduto, categoria, qtd, preco) value (?, ?, ?, ?, ?)";
        try {
            ConexaoDB connection = new ConexaoDB();
            Connection con = connection.recuperarConexao();
            PreparedStatement p = con.prepareStatement(sql);
            p.setString(1, nome);
            p.setString(2, codigo);
            p.setString(3, Categoria);
            p.setInt(4, qtd);
            p.setDouble(5, preco);
            p.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("ERRO AO CADASTRAR O PRODUTO " + e.getMessage());
        }
        return false;
    }

    public boolean alterar(String nome, String codigoproduto, String categoria, int qtd, double preco, int idfilial, int idproduto) {
        String sql = "update produto set nome = ?,codigoproduto = ?,categoria = ?,qtd = ?,preco = ?, idfilial= ?  where idproduto=?";
        try {
            ConexaoDB connection = new ConexaoDB();
            Connection con = connection.recuperarConexao();
            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setString(1, nome);
            preparador.setString(2, codigoproduto);
            preparador.setString(3, categoria);
            preparador.setInt(4, qtd);
            preparador.setDouble(5, preco);
            preparador.setInt(6, idfilial);
            preparador.setInt(7, idproduto);
            preparador.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("ERRO AO EDITAR PRODUTO: " + e.getMessage());
        }
        return false;
    }

    public boolean excluir(int idproduto) {
        try {
            String sql = "delete from produto where idproduto=?";
            ConexaoDB connection = new ConexaoDB();
            Connection con = connection.recuperarConexao();
            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setInt(1, idproduto);
            preparador.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro de sql" + e.getMessage());
            return false;
        }
    }

    public produto buscaPorId(int idproduto) {

        produto prod = new produto();
        try {
            String sql = "SELECT * FROM produto WHERE idproduto=?";
            ConexaoDB connection = new ConexaoDB();
            Connection con = connection.recuperarConexao();
            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setInt(1, idproduto);
            ResultSet resultado = preparador.executeQuery();
            while (resultado.next()) {
                prod.setIdproduto(resultado.getInt("idproduto"));
                prod.setNome(resultado.getString("nome"));
                prod.setCodigo(resultado.getString("codigoproduto"));
                prod.setCategoria(resultado.getString("categoria"));
                prod.setQtd(resultado.getInt("qtd"));
                prod.setPreco(resultado.getDouble("preco"));
                prod.setId(resultado.getInt("idfilial"));
                preparador.execute();
            }
        } catch (SQLException e) {
            System.out.println("Erro de sql" + e.getMessage());
        }
        return prod;
    }

    public boolean alteraVenda(int qtd, String codigoproduto) {
        String sql = "update produto set qtd=? where codigoproduto = ?";
        try {
            ConexaoDB connection = new ConexaoDB();
            Connection con = connection.recuperarConexao();
            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setInt(1, qtd);
            preparador.setString(2, codigoproduto);
            preparador.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("ERRO AO CADASTRAR VENDA " + e.getMessage());
        }
        return false;
    }
}
