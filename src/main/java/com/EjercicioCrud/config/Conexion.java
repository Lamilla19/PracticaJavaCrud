package com.EjercicioCrud.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    public static final String username= "root";
    public static final String password="";
    public static final String database="bdempleado";
    public static final String url = "jdbc:mysql://localhost:3306/"+database;

    public static Connection getConnection(){
        Connection cn = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection(url,username,password);
            System.out.println("La conexion fue exitosa");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return cn;
    }
}
