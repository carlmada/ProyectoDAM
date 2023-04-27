package Modelos.DTOS.usuarios.DTO;

/**
 *
 * Clase que formata los datos de respuesta del servidor a la peticion de la lista de usuarios .
 *
 * @author Carlos
 */
public class ResponseUserListDTO {

    // Atributos.
    private String message;
    private ValueUser value;

    //Getters-Setters.
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ValueUser getValue() {
        return value;
    }

    public void setValue(ValueUser value) {
        this.value = value;
    }

}
