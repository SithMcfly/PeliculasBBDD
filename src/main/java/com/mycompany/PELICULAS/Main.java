/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.PELICULAS;


import com.mycompany.PELICULAS.igu.Principal;
import java.sql.SQLException;







/**
 *
 * @author Sith_Mcfly
 */
public class Main {

    
    public static void main(String[] args) throws SQLException {
        
        ControladoraPersistencia crud =new ControladoraPersistencia();
        
        crud.listarPeliculas();
    }
}
