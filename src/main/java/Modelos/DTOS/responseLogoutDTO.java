package Modelos.DTOS;

/**
 *
 * Clase que formata los datos de respuesta del servidor a la peticion de logout.
 *
 * @author Carlos
 */
public class ResponseLogoutDTO {

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
