package Modelos.DTOS.usuarios.DTO;

/**
 * Clase que formata los datos de respuesta del servidor a la peticion de Modificacion de usuario.
 *
 * @author Carlos
 */
public class ResponseUpdateUserDTO {

    // Atributos.
    private String message;
    private String value;

    //Getters-Setters.
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
