/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.polisys.axurews.model.entidades;

import br.com.polisys.axurews.model.Tabela;

/**
 *
 * @author POLISYS
 */
public class Usuario extends Tabela{
    
    private Integer id;
    private String nome;

    public Usuario() {
        super("usuario","id","nome");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
