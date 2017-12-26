/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.polisys.axurews.model;

import java.sql.SQLException;

/**
 *
 * @author POLISYS
 */
public interface IConexao {
 
    public abstract void abrirConexao() throws SQLException;
    public abstract void fecharConexao() throws SQLException;
    
}
