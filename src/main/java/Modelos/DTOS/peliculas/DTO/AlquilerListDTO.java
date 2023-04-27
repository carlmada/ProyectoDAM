package Modelos.DTOS.peliculas.DTO;

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
    private UUID peliculaId;
    private UUID usuariId;
    private String fechaInicio;
    private String fechaFin;
    private double precio;
    private String estado;

    //Getters-Setters.
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getPeliculaId() {
        return peliculaId;
    }

    public void setPeliculaId(UUID peliculaId) {
        this.peliculaId = peliculaId;
    }

    public UUID getUsuariId() {
        return usuariId;
    }

    public void setUsuariId(UUID usuariId) {
        this.usuariId = usuariId;
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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
