package Modelos.DTOS;

/**
 * 
 * Clase que formata los datos del
 * token que seran recibidos del servidor
 * 
 * @author Carlos
 */
public class TokenDTO {

    //Atributos.
    private String token;
    private boolean isAdmin;

    //Constructor.
    public TokenDTO() {
    }

    /**
     * Constructor con los parametros.
     *
     * @param token
     * @param isAdmin
     */
    public TokenDTO(String token, boolean isAdmin) {
        this.token = token;
        this.isAdmin = isAdmin;
    }

    //Getters-Setters.
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
