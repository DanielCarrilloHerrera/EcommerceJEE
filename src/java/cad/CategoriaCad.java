/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cad;

import JavaBeans.Categoria;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Daniel
 */
public class CategoriaCad {
    public static ArrayList<Categoria> listarCategoriaSuperior(){
        try {
            String sql = "{call sp_listarCategoriaSuperior()}";
            Connection c = Conexion.conectar();
            CallableStatement sentencia;
            sentencia = c.prepareCall(sql);
            ResultSet resultado = sentencia.executeQuery(sql);
            ArrayList<Categoria> lista = new ArrayList<>();
            while(resultado.next()){
                Categoria cat = new Categoria();
                cat.setCodigo(resultado.getInt("codigo"));
                cat.setNombre(resultado.getString("nombre"));
                cat.setCategoria_superior(resultado.getInt("codigo"));
                lista.add(cat);
            }
            return lista;
        } catch (SQLException ex) {
            return null;
        }
        
    }
    public static ArrayList<Categoria> listarSubCategoria(){
        try {
            String sql = "{call sp_listarSubCategoria()}";
            Connection c = Conexion.conectar();
            CallableStatement sentencia;
            sentencia = c.prepareCall(sql);
            ResultSet resultado = sentencia.executeQuery(sql);
            ArrayList<Categoria> lista = new ArrayList<>();
            while(resultado.next()){
                Categoria cat = new Categoria();
                cat.setCodigo(resultado.getInt("codigo"));
                cat.setNombre(resultado.getString("nombre"));
                cat.setCategoria_superior(resultado.getInt("categoria_superior"));
                lista.add(cat);
            }
            return lista;
        } catch (SQLException ex) {
            return null;
        }
        
    }
    
    public static boolean esSuperior(int cat){
        try {
            String sql = "{call sp_contarSubCategorias(?)}";
            Connection c = Conexion.conectar();
            CallableStatement sentencia;
            sentencia = (CallableStatement) c.prepareCall(sql);
            sentencia.setInt(1, cat);
            ResultSet resultado = sentencia.executeQuery();
            
            resultado.next();
            
            return resultado.getInt("cantidad") > 0;
            }
         catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}