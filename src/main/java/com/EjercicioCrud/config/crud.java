package com.EjercicioCrud.config;

//Importamos la libreria de Sql


import java.sql.*;

public class crud {
    public void instertarDato(int id , String nombre ,double precio , String fechaVencimiento,int stock){
        String query = "insert into producto (id,nombre,precio,fechaVencimiento,stock) value(?,?,?,?,?)";

        try {
            Connection cn = Conexion.getConnection();
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setInt(1,id);
            ps.setString(2,nombre);
            ps.setDouble(3,precio);
            ps.setString(4,fechaVencimiento);
            ps.setInt(5,stock);

            ps.executeUpdate();
            System.out.println("Se inserto con exito");

        }catch (Exception ex){
            System.out.println("Error al registrar los datos");
            ex.printStackTrace();
        }


    }

    public void leerDatos(){
        String query = "select * from producto";

        try {
            Connection cn = Conexion.getConnection();
            PreparedStatement ps = cn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                double precio = rs.getDouble("precio");
                String fechaVencimiento = rs.getString("fechaVencimiento");
                int stock = rs.getInt("stock");

                System.out.println("ID:"+id+" "+"Nombre:"+nombre+" "+"Precio:"+precio+" "+"Fecha de vencimiento:"+fechaVencimiento+" "+"Stock:"+stock);

            }


        }catch (Exception ex){
            System.out.println("Error al leer los productos");
            ex.printStackTrace();
        }
    }

    public void actualizarProducto(int id , String nombre ,double precio , String fechaVencimiento,int stock){
        String query = "update producto set nombre=?,precio=?,fechaVencimiento=?,stock=? where id=?";

        try {
            Connection cn = Conexion.getConnection();
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setInt(5,id);
            ps.setString(1,nombre);
            ps.setDouble(2,precio);
            ps.setString(3,fechaVencimiento);
            ps.setInt(4,stock);

            ps.executeUpdate();
            System.out.println("Se actualizo el producto con exito");

        }catch (Exception ex){
            System.out.println("Error al actualizar el producto");
            ex.printStackTrace();
        }
    }

    public void eliminarProducto(int id){
        String query = "delete from producto where id=?";

        try {
            Connection cn = Conexion.getConnection();
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setInt(1,id);

            ps.executeUpdate();
            System.out.println("Se elimino el producto con exito");
        }catch (Exception ex){
            ex.printStackTrace();
            System.out.println("Error al eliminar el producto");
        }
    }

    public void BuscarProductoNombre(String nombre){
        String query = "select * from producto where nombre=?";

        try {
            Connection cn = Conexion.getConnection();
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setString(1,nombre);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String nombreProducto = rs.getString("nombre");
                double precio = rs.getDouble("precio");
                String fechaVencimiento = rs.getString("fechaVencimiento");
                int stock = rs.getInt("stock");

                System.out.println("ID:"+id+" "+"Nombre:"+nombreProducto+" "+"Precio:"+precio+" "+"Fecha de vencimiento:"+fechaVencimiento+" "+"Stock:"+stock);
            }

        }catch (Exception ex){
            ex.printStackTrace();
            System.out.println("Error al buscar el producto");
        }
    }

    public void ListarProductosStock(int stock){
        String query ="select * from producto where stock < ?";

        try {
            Connection cn = Conexion.getConnection();
            PreparedStatement ps = cn.prepareStatement(query);
            ps.setInt(1,stock);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String nombreProducto = rs.getString("nombre");
                double precio = rs.getDouble("precio");
                String fechaVencimiento = rs.getString("fechaVencimiento");
                int stockProducto = rs.getInt("stock");

                System.out.println("ID:"+id+" "+"Nombre:"+nombreProducto+" "+"Precio:"+precio+" "+"Fecha de vencimiento:"+fechaVencimiento+" "+"Stock:"+stockProducto);
            }
        }catch (Exception ex){
            ex.printStackTrace();
            System.out.println("Error al realizar la busqueda");
        }

    }
}
