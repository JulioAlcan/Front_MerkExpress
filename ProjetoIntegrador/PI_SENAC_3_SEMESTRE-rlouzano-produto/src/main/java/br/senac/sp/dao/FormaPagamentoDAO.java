package br.senac.sp.dao;

import br.senac.sp.jdbc.ConexaoDB;
import br.senac.sp.model.FormaPagamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FormaPagamentoDAO {

    public List<FormaPagamento> pegaTodos() {
        String sql = "select * from formapagamento";
        List<FormaPagamento> lista = new ArrayList<>();
        try {
            ConexaoDB connection = new ConexaoDB();
            Connection con = connection.recuperarConexao();
            try (PreparedStatement preparador = con.prepareStatement(sql)) {
                ResultSet resultado = preparador.executeQuery();
                
                while (resultado.next()) {
                    FormaPagamento fp = new FormaPagamento();
                    fp.setIdpagamento(resultado.getInt("idpagamento"));
                    fp.setCredito(resultado.getString("credito"));
                    fp.setDebito(resultado.getString("debito"));
                    fp.setDinheiro(resultado.getString("dinheiro"));
                    fp.setAlimentacao(resultado.getString("alimentacao"));
                    lista.add(fp);
                }
            }
        } catch (SQLException e) {
            System.out.println("ERRO AO BUSCAR AS INFORMAÇÔES DO BANCO DE DADOS" + e.getMessage());
        }
        return lista;
    }

    
}
