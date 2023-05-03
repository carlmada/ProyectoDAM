package Modelos.DTOS.peliculas.DTO;

import java.util.List;

/**
 *
 * Clase que formata los datos de respuesta del servidor a la peticion de la lista de alquileres.
 *
 * @author Carlos
 */
public class ResponseAlquilerListDTO {

    // Atributos.
    private String message;
    private ValueAlquiler value;

    //Getters-Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ValueAlquiler getValue() {
        return value;
    }

    public void setValue(ValueAlquiler value) {
        this.value = value;
    }

}
