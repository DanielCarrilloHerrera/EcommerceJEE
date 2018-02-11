/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cad;

import JavaBeans.Producto;
import JavaBeans.ProductoMoneda;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Daniel
 */
public class ProductoCad {
    
    public static boolean registrarProducto(Producto p,
                                            ProductoMoneda cop,
                                            ProductoMoneda usd,
                                            ProductoMoneda pen){
        try {
            String sql = "{call sp_registrarproducto(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
            Connection c = Conexion.conectar();
            CallableStatement sentencia;
            sentencia = c.prepareCall(sql);
            sentencia.setString(1, p.getNombre());
            sentencia.setFloat(2, p.getPrecio());
            sentencia.setFloat(3, p.getPrecionuevo());
            sentencia.setInt(4, p.getStock());
            sentencia.setBoolean(5, p.isNuevo());
            sentencia.setBoolean(6, p.isRecomendado());
            sentencia.setString(7, p.getDescripcion());
            sentencia.setBoolean(8, p.isVisible());
            sentencia.setInt(9, p.getCodigo_marca());
            sentencia.setInt(10, p.getCodigo_categoria());
            sentencia.setString(11, p.getImg());
            
            sentencia.setString(12, cop.getMoneda());
            sentencia.setFloat(13, cop.getPrecio());
            sentencia.setFloat(14, cop.getPrecionuevo());
            
            sentencia.setString(15, usd.getMoneda());
            sentencia.setFloat(16, usd.getPrecio());
            sentencia.setFloat(17, usd.getPrecionuevo());
            
            sentencia.setString(18, pen.getMoneda());
            sentencia.setFloat(19, pen.getPrecio());
            sentencia.setFloat(20, pen.getPrecionuevo());
              
            boolean resultado = sentencia.executeUpdate()>0;
            return resultado;
            
           
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        
    }
}