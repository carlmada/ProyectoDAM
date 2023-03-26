package Modelos;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Clase que define el objeto Token con sus atributos.
 *
 * @author Carlos
 */
//Atributos.
public class token {

    private UUID id;
    String username;
    String token;
    LocalDateTime creationDate;
    LocalDateTime lastUsed;

    //Constructor.
    public token() {
    }

    /**
     * Constructor con todos sus parametros.
     *
     * @param id
     * @param username
     * @param token
     * @param creationDate
     * @param lastUsed
     */
    public token(UUID id, String username, String token, LocalDateTime creationDate, LocalDateTime lastUsed) {
        this.id = id;
        this.username = username;
        this.token = token;
        this.creationDate = creationDate;
        this.lastUsed = lastUsed;
    }

    //Getters-Setters.
    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getToken() {
        return token;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public LocalDateTime getLastUsed() {
        return lastUsed;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setLastUsed(LocalDateTime lastUsed) {
        this.lastUsed = lastUsed;
    }

}
