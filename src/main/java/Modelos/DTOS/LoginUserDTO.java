package Modelos.DTOS;

/**
 * Clase que formatea los datos que serviran para hacer el login al servidor.
 *
 * @author Carlos
 */
public class LoginUserDTO {

    //Atributos.
    private String username;
    private String password;

    //Getters-Setters.
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
