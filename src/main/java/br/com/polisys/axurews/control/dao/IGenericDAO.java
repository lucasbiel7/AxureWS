/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.polisys.axurews.control.dao;

import br.com.polisys.axurews.model.Tabela;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author POLISYS
 * @param <Entity>
 * Parametro generico para representar tabela que será usada
 * 
 */
public interface IGenericDAO<Entity extends Tabela> {
    
    List<Entity> pegarTodos() throws SQLException;
    boolean salvar(Entity entity);
    boolean editar(Entity entity);
    boolean excluir(Entity entity);
    
}
