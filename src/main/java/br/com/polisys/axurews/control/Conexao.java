/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.polisys.axurews.control;

import br.com.polisys.axurews.model.Database;
import br.com.polisys.axurews.model.IConexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author POLISYS
 */
public class Conexao implements IConexao {

    private Connection connection;

    public Conexao() {
        try {
            Class.forName(Database.DRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void abrirConexao() throws SQLException {
        if(connection!=null){
            if (!connection.isClosed()) {
                connection.close();
            }
        }
        connection = DriverManager.getConnection(Database.getUrlConexao(), Database.USERNAME, Database.PASSWORD);
    }

    @Override
    public void fecharConexao() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}
