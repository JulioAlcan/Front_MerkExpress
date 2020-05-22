/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rafae
 */
public class ConexaoDB {
    

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
              Logger.getLogger(ConexaoDB.class.getName()).log(Level.SEVERE, null, ex);
              System.out.println("Não Conectou");
        }
    }

    public Connection recuperarConexao() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/supermercado?useTimezone=true&serverTimezone=UTC", "root", "");

    }
}
//useTimezone=true&serverTimezone=UTC