/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.PELICULAS;

/**
 *
 * @author Sith_Mcfly
 */
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ControladoraPersistencia {


    public void listarPeliculas() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/peliculas?serverTimezone=UTC";
        String user = "root";
        String pswd = "migato1928@";
        Connection conectar = null;

        try {
            conectar = DriverManager.getConnection(url, user, pswd);
            System.out.println("SUCCESS");
        } catch (SQLException e) {
            System.out.println("FAILED " + e.getMessage());
        }

        String sql = "Select * from pelicula";
        PreparedStatement ps = conectar.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        System.out.println("LISTADO DE PELICULAS");
        while (rs.next()) {
            int id = rs.getInt("Id");
            String titulo = rs.getString("TITULO");
            String lugar = rs.getString("LUGAR");
            String espectador = rs.getString("ESPECTADOR");
            String fecha = rs.getString("fecha");

            System.out.printf(" (%d).- La pelicula %s la vio en %s %s el dia %s\n", id, titulo, lugar, espectador, fecha);
        }

        rs.close();
        ps.close();
        conectar.close();
    }

    public void insertarPelicula(int id, String titulo) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/peliculas?serverTimezone=UTC";
        String user = "root";
        String pswd = "migato1928@";
        Connection conectar = null;

        try {
            conectar = DriverManager.getConnection(url, user, pswd);
            System.out.println("SUCCESS");
        } catch (SQLException e) {
            System.out.println("FAILED " + e.getMessage());
        }

        String sql = "Insert into pelicula(id, titulo) value(?,?)";
        PreparedStatement ps = conectar.prepareStatement(sql);
        ps.setInt(1, id);
        ps.setString(2, titulo);
        ps.executeUpdate();
        System.out.printf("La pelicula %s se agregó a la lista\n", titulo);

        ps.close();
        conectar.close();
    }

    public void actualizarPeliculas(String espectador, String lugar, String titulo) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/peliculas?serverTimezone=UTC";
        String user = "root";
        String pswd = "migato1928@";
        Connection conectar = null;

        try {
            conectar = DriverManager.getConnection(url, user, pswd);
            System.out.println("SUCCESS");
        } catch (SQLException e) {
            System.out.println("FAILED " + e.getMessage());
        }

        String sql = "update pelicula set lugar=?, espectador=?, fecha=current_date() where titulo=?";
        PreparedStatement ps = conectar.prepareStatement(sql);
        ps.setString(1, lugar);
        ps.setString(2, espectador);
        ps.setString(3, titulo);
        ps.executeUpdate();
        System.out.printf("La pelicula %s se ha ACTUALIZADO\n", titulo);

        ps.close();
        conectar.close();
    }

    public void eliminarPeliculas(String titulo) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/peliculas?serverTimezone=UTC";
        String user = "root";
        String pswd = "migato1928@";
        Connection conectar = null;

        try {
            conectar = DriverManager.getConnection(url, user, pswd);
            System.out.println("SUCCESS");
        } catch (SQLException e) {
            System.out.println("FAILED " + e.getMessage());
        }

        String sql = "Delete from pelicula where titulo=?";
        PreparedStatement ps = conectar.prepareStatement(sql);
        ps.setString(1, titulo);
        ps.executeUpdate();
        System.out.printf("La pelicula %s se ha ELIMINADO\n", titulo);

        ps.close();
        conectar.close();
    }

    public void buscarPeliculas(String titulo) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/peliculas?serverTimezone=UTC";
        String user = "root";
        String pswd = "migato1928@";
        Connection conectar = null;

        try {
            conectar = DriverManager.getConnection(url, user, pswd);
            System.out.println("SUCCESS");
        } catch (SQLException e) {
            System.out.println("FAILED " + e.getMessage());
        }

        String sql = "select id, titulo, lugar, espectador, fecha, titulo from pelicula where titulo = ?";
        PreparedStatement ps = conectar.prepareStatement(sql);
        ps.setString(1, titulo);
        ResultSet rs = ps.executeQuery();

        boolean encontrada = false;
        while (rs.next()) {
            encontrada = true;
            int id = rs.getInt("Id");
            titulo = rs.getString("TITULO");
            String lugar = rs.getString("LUGAR");
            String espectador = rs.getString("ESPECTADOR");
            String fecha = rs.getString("fecha");

            System.out.printf(" (%d).- La pelicula %s la vio en %s %s el dia %s\n", id, titulo, lugar, espectador, fecha);

        }
        if (!encontrada) {
            System.out.printf("La pelicula %s no ha sido encontrada\n", titulo);
        }
        rs.close();
        ps.close();
        conectar.close();

    }

}
