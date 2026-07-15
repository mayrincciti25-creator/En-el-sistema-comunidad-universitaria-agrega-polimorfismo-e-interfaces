package org.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {


    private static final String URL = "jdbc:mysql://localhost:3306/universidad";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "";


    public static Connection conectar(){

        Connection con = null;

        try{

            con = DriverManager.getConnection(URL, USUARIO, PASSWORD);

            System.out.println("Conexión exitosa a MySQL");


        }catch(Exception e){

            System.out.println("Error al conectar a MySQL: " + e.getMessage());

        }


        return con;

    }

}