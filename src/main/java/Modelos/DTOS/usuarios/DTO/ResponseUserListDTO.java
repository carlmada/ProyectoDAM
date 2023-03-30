package Modelos.DTOS.usuarios.DTO;

import java.util.List;

/**
 *
 * Clase que formata los datos de respuesta del servidor a la peticion de la lista de usuarios .
 *
 * @author Carlos
 */
public class ResponseUserListDTO {

    // Atributos.
    private String message;
    private List<UserListDTO> value;

    //Getters-Setters.
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<UserListDTO> getValue() {
        return value;
    }

    public void setValue(List<UserListDTO> value) {
        this.value = value;
    }

}
