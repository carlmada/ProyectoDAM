/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 *
 * @author Er_jo
 */
public class token {
       private UUID id;

    String username;

    String token;

    LocalDateTime creationDate;

    LocalDateTime lastUsed;

    public token() {
        
    }

    public token(UUID id, String username, String token, LocalDateTime creationDate, LocalDateTime lastUsed) {
        this.id = id;
        this.username = username;
        this.token = token;
        this.creationDate = creationDate;
        this.lastUsed = lastUsed;
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getLastUsed() {
        return lastUsed;
    }

    public void setLastUsed(LocalDateTime lastUsed) {
        this.lastUsed = lastUsed;
    }

}

