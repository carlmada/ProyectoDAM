package Modelos.DTOS.peliculas.DTO;

/**
 *
 * Clase que formata los datos de respuesta del servidor a la peticion de un nuevo alquiler de pelicula.
 *
 * @author Carlos
 */
public class ResponseAlquilerPeliculaDTO {

    //Variables.
    private String message;
    private AlquilerPeliculaDTO value;

    //Getters-Setters.
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AlquilerPeliculaDTO getValue() {
        return value;
    }

    public void setValue(AlquilerPeliculaDTO value) {
        this.value = value;
    }

}
