/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.polisys.axurews.control.dao;

import br.com.polisys.axurews.control.Conexao;
import br.com.polisys.axurews.model.Tabela;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author POLISYS
 * @param <Entity>
 * 
 * 
 */
public class GenericDAO<Entity extends Tabela> implements IGenericDAO<Entity>{

    protected Conexao conexao;
    protected Class<Entity> superClass;
    private Entity entity;
   
    public GenericDAO() {
        conexao=new Conexao();
        Type[] types=((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments();
        if(types.length>0){
            superClass=(Class<Entity>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
            entity=novaInstancia();
        }
    }
    
    
    @Override
    public List<Entity> pegarTodos() throws SQLException{
        conexao.abrirConexao();
        ResultSet set=conexao.query().executeQuery("select * from "+entity.getTabelaNome());
        List<Entity> objetos=new ArrayList<>();
        while(set.next()){
            try {
                Entity entity=superClass.newInstance();
                for (String campo : entity.getCampos()) {
                    Field atributo=superClass.getDeclaredField(campo);
                    atributo.setAccessible(true);
                    atributo.set(entity, set.getObject(campo, atributo.getType()));
                }
                objetos.add(entity);
            } catch (InstantiationException | IllegalAccessException | NoSuchFieldException | SecurityException ex) {
                Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        conexao.fecharConexao();
        return objetos;
    }

    @Override
    public boolean salvar(Entity entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editar(Entity entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(Entity entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private Entity novaInstancia(){
        if(superClass!=null){
            try {
                return superClass.newInstance();
            } catch (InstantiationException | IllegalAccessException ex) {
                Logger.getLogger(GenericDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
}
