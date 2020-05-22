package br.senac.sp.dao;

import br.senac.sp.jdbc.ConexaoDB;
import br.senac.sp.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class usuarioDAO extends Usuario {

    public boolean cadastrar(String nome, String cpf, String perfil, String login, String senha, String adminSenha, String filial, int idfilial) {
        String sql = "insert into usuario(nome, cpf, perfil, login, senha, senha_adm, filial, idfilial) values (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            ConexaoDB connection = new ConexaoDB();
            Connection con = connection.recuperarConexao();
            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setString(1, nome);
            preparador.setString(2, cpf);
            preparador.setString(3, perfil);
            preparador.setString(4, login);
            preparador.setString(5, senha);
            preparador.setString(6, adminSenha);
            preparador.setString(7, filial);
            preparador.setInt(8, idfilial);
            preparador.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("ERRO AO CADASTRAR USUARIO: " + e.getMessage());
        }
        return false;
    }

    public boolean alterar(String nome, String cpf, String perfil, String login, String senha, String senha_adm, String filial, int idfilial, int id) {
        String sql = "update usuario set nome=?, cpf=?, perfil=?, login=?, senha=? ,senha_adm=? ,filial=? ,idfilial=? where id=?";
        try {
            ConexaoDB connection = new ConexaoDB();
            Connection con = connection.recuperarConexao();
            try (PreparedStatement preparador = con.prepareStatement(sql)) {
                preparador.setString(1, nome);
                preparador.setString(2, cpf);
                preparador.setString(3, perfil);
                preparador.setString(4, login);
                preparador.setString(5, senha);
                preparador.setString(6, senha_adm);
                preparador.setString(7, filial);
                preparador.setInt(8, idfilial);
                preparador.setInt(9, id);
                preparador.execute();
                return true;
            }
        } catch (SQLException e) {
            System.out.println("ERRO AO EDITAR: " + e.getMessage());
        }
        return false;
    }

    public boolean excluir(int id) {
        try {
            String sql = "delete from usuario where id=?";
            ConexaoDB connection = new ConexaoDB();
            Connection con = connection.recuperarConexao();
            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setInt(1, id);
            preparador.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Erro de sql" + e.getMessage());
            return false;
        }
    }

    /**
     * Exclui um usuario do banco de dados
     *
     * @param user representa a classe MODEL com os dados do banco de dados
     */
    /* public void excluir(Usuario user) {
        String sql = "delete from usuario where id=?";
        try {
            ConexaoDB connection = new ConexaoDB();
            Connection con = connection.recuperarConexao();
            try (PreparedStatement preparador = con.prepareStatement(sql)) {
                preparador.setInt(1, user.getId());
                preparador.execute();
            }
        } catch (SQLException e) {
            System.out.println("ERRO AO EXCLUIR USUARIOS" + e.getMessage());
        }
    }

    public void salvar(Usuario usuario) {
        if (usuario.getId() != 0) {
            alterar(usuario);
        } else {
            cadastrar(usuario);
        }
    }*/
    /**
     * Busca de um registro no banco de dados pelo numero do id do usuario
     *
     * @param id inteiro que representa o numero do id do usuario a ser buscado
     * @return Um objeto usuario quando econtra ou null quando não encontra
     * registro
     */
    public Usuario buscaPoId(int id) {
        Usuario user = new Usuario();
        String sql = "SELECT * FROM usuario WHERE id=?";
        try {
            ConexaoDB connection = new ConexaoDB();
            Connection con = connection.recuperarConexao();
            PreparedStatement preparador = con.prepareStatement(sql);
            preparador.setInt(1, id);
            ResultSet resultado = preparador.executeQuery();
            if (resultado.next()) {
                user.setId(resultado.getInt("id"));
                user.setNome(resultado.getString("nome"));
                user.setCpf(resultado.getString("cpf"));
                user.setPerfil(resultado.getString("perfil"));
                user.setLogin(resultado.getString("login"));
                user.setSenha(resultado.getString("senha"));
                user.setSenhaAdmin(resultado.getString("senha_adm"));
                user.setFilial(resultado.getString("filial"));
                user.setIdfilial(resultado.getInt("idfilial"));

            }
            preparador.execute();
        } catch (SQLException e) {
            System.out.println("ERRO AO BUSCAR USUARIOS POR ID " + e.getMessage());
        }
        return user;
    }

    /**
     * Realiza a busca de todos egistros da tabela de usuarios
     *
     * @return Uma lista de objetos usuario contendo 0 elementos quando tiver
     * registro ou n elementos quando tiver resultado
     */
    public List<Usuario> buscaTodos() {
        String sql = "Select * from usuario";
        List<Usuario> lista = new ArrayList<>();
        try {
            ConexaoDB connection = new ConexaoDB();
            Connection con = connection.recuperarConexao();
            try (PreparedStatement preparador = con.prepareStatement(sql)) {
                ResultSet resultado = preparador.executeQuery();
                while (resultado.next()) {
                    Usuario user = new Usuario();
                    user.setId(resultado.getInt("id"));
                    user.setNome(resultado.getString("nome"));
                    user.setCpf(resultado.getString("cpf"));
                    user.setPerfil(resultado.getString("perfil"));
                    user.setLogin(resultado.getString("login"));
                    user.setSenha(resultado.getString("senha"));
                    user.setSenhaAdmin(resultado.getString("senha_adm"));
                    user.setFilial(resultado.getString("filial"));
                    user.setIdfilial(resultado.getInt("idfilial"));
                    lista.add(user);
                }
            }
        } catch (SQLException e) {
            System.out.println("ERRO AO BUSCAR TODOS USUARIOS " + e.getMessage());
        }
        return lista;
    }

    public Usuario autenticar(Usuario usuConsulta) {
        String sql = "Select * from usuario where login=? and senha=?";

        try {
            ConexaoDB connection = new ConexaoDB();
            Connection con = connection.recuperarConexao();
            try (PreparedStatement preparador = con.prepareStatement(sql)) {
                preparador.setString(1, usuConsulta.getLogin());
                preparador.setString(2, usuConsulta.getSenha());
                ResultSet resultado = preparador.executeQuery();
                if (resultado.next()) {
                    Usuario user = new Usuario();
                    user.setId(resultado.getInt("id"));
                    user.setNome(resultado.getString("nome"));
                    user.setFilial(resultado.getString("filial"));
                    user.setPerfil(resultado.getString("perfil"));
                    user.setLogin(resultado.getString("login"));
                    user.setSenha(resultado.getString("senha"));
                    return user;
                }
            }
        } catch (SQLException e) {
            System.out.println("ERRO AO AUTENTICAR USUARIO " + e.getMessage());
        }
        return null;

    }
}
