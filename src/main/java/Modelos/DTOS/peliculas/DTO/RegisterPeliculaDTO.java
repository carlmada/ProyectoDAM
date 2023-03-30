package Modelos.DTOS.peliculas.DTO;

import java.time.LocalDate;

/**
 *
 * Clase que formata los datos de registro 
 * de una nueva pelicula que se enviara al servidor.
 *
 * @author Carlos
 */
public class RegisterPeliculaDTO {

    //Constructor vacio.
    public RegisterPeliculaDTO() {
    }
    
    //Atributos
    private String titulo;
    private String director;
    private String genero;
    private Double duracion;
    private String año;
    private Double precio;
    
    //Getters-Setters.

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

    public Double getDuracion() {
        return duracion;
    }

    public void setDuracion(Double duracion) {
        this.duracion = duracion;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
     
}
