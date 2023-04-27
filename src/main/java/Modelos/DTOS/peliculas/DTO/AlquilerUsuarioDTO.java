package Modelos.DTOS.peliculas.DTO;

import java.util.UUID;

/**
 * Clase que formata los datos de respuesta del servidor
 * a la peticion de la lista de los alquileres de un usuario.
 * 
 * @author Carlos
 */
public class AlquilerUsuarioDTO {
    
    //Variables
    private UUID id;
    private String titulo;
    private String director;
    private String genero;
    private int duracion;
    private int año;
    private int precio;

    public AlquilerUsuarioDTO(UUID id, String titulo, String director, String genero, int duracion, int año, int precio) {
        this.id = id;
        this.titulo = titulo;
        this.director = director;
        this.genero = genero;
        this.duracion = duracion;
        this.año = año;
        this.precio = precio;
    }

    
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
