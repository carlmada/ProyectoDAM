package Modelos.DTOS.peliculas.DTO;

import java.util.UUID;

/**
 *Clase que formata los datos que recibiremos del servidor 
 *cuando pidamos la lista de peliculas.
 *
 * @author Carlos
 */
public class PeliculaListDTO {
    //Constructor.
    public PeliculaListDTO() {
    }
        
    //Atributos
    private UUID id;
    private String titulo;
    private String director;
    private String genero;
    private Double duracion;
    private String año;
    private Double precio;
    
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
