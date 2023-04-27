package Modelos.DTOS.peliculas.DTO;

/**
 *
 * Clase que formata los datos de respuesta del servidor a la peticion de la lista de peliculas .
 *
 * @author Carlos
 */
public class ResponsePeliculaListDTO {

    // Atributos.
    private String message;
    private ValuePelicula value;

    //Getters-Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ValuePelicula getValue() {
        return value;
    }

    public void setValue(ValuePelicula value) {
        this.value = value;
    }

}
