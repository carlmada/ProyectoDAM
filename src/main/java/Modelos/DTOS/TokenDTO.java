/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos.DTOS;

/**
 *
 * @author Er_jo
 */
public class TokenDTO {
    private String token;
    private boolean isAdmin;

    public TokenDTO(String token, boolean isAdmin) {
        this.token = token;
        this.isAdmin = isAdmin;
    }

    public TokenDTO() {
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
