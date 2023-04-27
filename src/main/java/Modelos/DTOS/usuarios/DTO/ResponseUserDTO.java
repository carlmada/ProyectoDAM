package Modelos.DTOS.usuarios.DTO;

/**
 * Clase que formata los datos de respuesta del servidor a la peticion de informacion de un usuario.
 *
 * @author Carlos
 */
public class ResponseUserDTO {

    // Atributos.
    private String message;
    private UserDTO value;

    //Getters-Setters.
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserDTO getValue() {
        return value;
    }

    public void setValue(UserDTO value) {
        this.value = value;
    }

}
