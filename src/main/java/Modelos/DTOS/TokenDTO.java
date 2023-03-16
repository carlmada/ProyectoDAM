/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos.DTOS;

/**
 *
<<<<<<< HEAD
 * @author Carlos
 */
public class TokenDTO {
    
    //Atributos.
    private String token;
    private boolean isAdmin;

    //Constructor.
    public TokenDTO() {
    }
     
    public TokenDTO(String token, boolean isAdmin) {
        this.token = token;
        this.isAdmin = isAdmin;
    }

   
    //Getters-Setters.
    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
=======
 * @author Carlos.
 */
public class TokenDTO {

    private String token;
    private boolean isAdmin;

    public TokenDTO() {
    }

    public TokenDTO(String token, boolean isAdmin) {
        this.token = token;
        this.isAdmin = isAdmin;
>>>>>>> c849ec9 (Continuo codificacion de registro nuevo usuario y RegisterUserDTO)
    }

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
