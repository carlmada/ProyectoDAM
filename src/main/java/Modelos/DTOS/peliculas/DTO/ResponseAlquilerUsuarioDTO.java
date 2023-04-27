package Modelos.DTOS.peliculas.DTO;

import java.util.List;

/**
 *
 * Clase que formata los datos de respuesta del servidor a la peticion de la lista de alquileres del usuario .
 *
 * @author Carlos
 */
public class ResponseAlquilerUsuarioDTO {

    // Atributos.
    private String message;
    private List<AlquilerUsuarioDTO> value;

    //Getters-Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<AlquilerUsuarioDTO> getValue() {
        return value;
    }

    public void setValue(List<AlquilerUsuarioDTO> value) {
        this.value = value;
    }

}
