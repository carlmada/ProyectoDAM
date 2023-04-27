package Modelos.DTOS;

/**
 * Clase que formatea los datos 
 * que serviran para hacer el logout al servidor.
 *
 * @author Carlos
 */
public class LogoutUserDTO {

    //Atributos
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}
