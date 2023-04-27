package Modelos.DTOS.peliculas.DTO;

/**
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
