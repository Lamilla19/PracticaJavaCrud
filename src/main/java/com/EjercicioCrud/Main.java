package com.EjercicioCrud;

import com.EjercicioCrud.config.Conexion;
import com.EjercicioCrud.config.crud;


public class Main {
    public static void main(String[] args) {

        //Conexion.getConnection();
        crud operacion = new crud();
        //operacion.instertarDato(4,"PEZCADO",5.50,"2025-08-24",3);
        //operacion.leerDatos();
        //operacion.actualizarProducto(2,"LECHE DESCREMADA",5.50,"2030-06-15",100);
        //operacion.eliminarProducto(3);
        operacion.BuscarProductoNombre("COCA COLA");

    }
}