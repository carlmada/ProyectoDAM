package Modelos.DTOS;

/**
 * Clase que formata los datos que se enviaran al servidor para realizar el cambio de password.
 *
 * @author Carlos
 */
public class CambioDePasswordDTO {

    //Atributos.
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
