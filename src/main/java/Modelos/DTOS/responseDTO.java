package Modelos.DTOS;

/**
 * 
 * Clase que formata los datos 
 * de respuesta del servidor a
 * la peticion de login.
 * 
 * @author Carlos
 */
public class responseDTO {

    private String message;
    private TokenDTO value;

    public responseDTO() {
    }

    /**
     * Constructor con los parametros.
     *
     * @param message
     * @param value
     */
    public responseDTO(String message, TokenDTO value) {
        this.message = message;
        this.value = value;
    }

    //Getters-Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public TokenDTO getValue() {
        return value;
    }

    public void setValue(TokenDTO value) {
        this.value = value;
    }
}
