package Modelos.DTOS.alquiler.DTO;

import java.util.UUID;

/**
 * Clase que formata los datos que recibiremos del servidor cuando pidamos la lista de alquileres.
 *
 * @author Carlos
 */
public class AlquilerListDTO {

    //Constructor.
    public AlquilerListDTO() {
    }

    //Atributos
    private UUID id;
    private UUID pelicula;
    private UUID usuari;
    private String fechaInicio;
    private String fechaFin;
    private int precio;
    private String estado;

    //Getters-Setters.
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getPelicula() {
        return pelicula;
    }

    public void setPelicula(UUID pelicula) {
        this.pelicula = pelicula;
    }

    public UUID getUsuari() {
        return usuari;
    }

    public void setUsuari(UUID usuari) {
        this.usuari = usuari;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
