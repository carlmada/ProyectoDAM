package Modelos.DTOS.peliculas.DTO;

/**
 * DTO de pelicula de respuesta del servidor.
 * 
 * @author Carlos
 */
public class ResponsePeliculaDTO {

    // Atributos.
    private String message;
    private PeliculaDTO value;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public PeliculaDTO getValue() {
        return value;
    }

    public void setValue(PeliculaDTO value) {
        this.value = value;
    }

}
