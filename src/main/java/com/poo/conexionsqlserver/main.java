package com.poo.conexionsqlserver;

/**
 *
 * @author Nathy
 */
public class main {
    public static void main(String[] args){
        ConexionSQLServer conexion = new ConexionSQLServer();
        conexion.getConnection();
    }
}
