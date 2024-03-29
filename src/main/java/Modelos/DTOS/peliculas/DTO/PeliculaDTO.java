package Modelos.DTOS.peliculas.DTO;

import java.util.UUID;

/**
 * Clase que formata los datos de pelicula.
 * 
 * @author Carlos
 */
public class PeliculaDTO {
    
    public PeliculaDTO() {
    }

    //Variables.
    private UUID id;
    private String titulo;
    private String director;
    private String genero;
    private int duracion;
    private int año;
    private int precio;
    

    //Getters-Setters.
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

}
