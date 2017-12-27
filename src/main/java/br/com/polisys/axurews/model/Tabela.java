/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.polisys.axurews.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author POLISYS
 * Tabela para facilitar acesso a tabelas do banco de dados
 * 
 */
public class Tabela {
    
    private String tabelaNome;
    private List<String> campos;

    public Tabela(String tabelaNome) {
        this.tabelaNome = tabelaNome;
        campos=new ArrayList<>();
    }

    
    public Tabela(String tabelaNome, List<String> campos) {
        this.tabelaNome = tabelaNome;
        this.campos = campos;
    }
     public Tabela(String nome,String... campos) {
        this.tabelaNome = nome;
        this.campos = Arrays.asList(campos);
    }

    public String getTabelaNome() {
        return tabelaNome;
    }

    public void setTabelaNome(String tabelaNome) {
        this.tabelaNome = tabelaNome;
    }

  

    public List<String> getCampos() {
        return campos;
    }

    public void setCampos(List<String> campos) {
        this.campos = campos;
    }
    
}
