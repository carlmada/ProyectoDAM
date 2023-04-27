package Modelos.DTOS.peliculas.DTO;

import java.util.List;

/**
 *
 * Clase que formata los datos de respuesta del servidor a la peticion de la lista de peliculas .
 *
 * @author Carlos
 */
public class ResponsePeliculaListDTO {

    // Atributos.
    private String message;
    private List<PeliculaListDTO> value;

    //Getters-Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<PeliculaListDTO> getValue() {
        return value;
    }

    public void setValue(List<PeliculaListDTO> value) {
        this.value = value;
    }

}
