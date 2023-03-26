package Modelos.DTOS;

/**
 * Clase que formata los datos de respuesta del servidor a la peticion de informacion del usuario.
 *
 * @author Carlos
 */
public class ResponseUserInfoDTO {

    // Atributos.
    private String message;
    private UserInfoDTO value;

    //Getters-Setters.
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserInfoDTO getValue() {
        return value;
    }

    public void setValue(UserInfoDTO value) {
        this.value = value;
    }

}
