
package com.mycompany.PELICULAS;



/**
 *
 * @author Sith_Mcfly
 */

public class Pelicula {

    
    private int id;
    
    private String titulo;
    private String lugar;
    private String quien;
    private String fecha;
    
    public Pelicula(String titulo) {
        this.titulo = titulo;
                
    }
    public Pelicula(int id, String titulo, String lugar, String quien, String fecha) {
        this.id = id;
        this.titulo = titulo;
        this.lugar = lugar;
        this.quien = quien;
        this.fecha = fecha;  
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getQuien() {
        return quien;
    }

    public void setQuien(String quien) {
        this.quien = quien;
    }
    
       public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    @Override
    public String toString(){
        return String.format("La pelicula %s la vio %s en %s el día %s", 
                this.titulo,
                this.quien,
                this.lugar,
                this.fecha);
       
    }
}
