/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.polisys.axurews.model;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author POLISYS
 */
public class Database {

    public static final String USERNAME;
    public static final String PASSWORD;
    public static final String HOST;
    public static final String DATABASE;
    public static final String DRIVER;
    public static final String SGBD;

    static {
        Properties properties = new Properties();
        try {
            properties.load(Database.class.getResourceAsStream("/database.properties"));
        } catch (IOException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        USERNAME = properties.getProperty("username");
        PASSWORD = properties.getProperty("password");
        HOST = properties.getProperty("host");
        DATABASE = properties.getProperty("database");
        DRIVER=properties.getProperty("driver");
        SGBD=properties.getProperty("sgbd");
    }
    
    public static String getUrlConexao(){
        return "jdbc:"+SGBD+"://"+HOST+"/"+DATABASE+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    }
}
