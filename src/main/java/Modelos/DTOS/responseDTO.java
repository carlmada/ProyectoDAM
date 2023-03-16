package Modelos.DTOS;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
<<<<<<< HEAD

=======
>>>>>>> c849ec9 (Continuo codificacion de registro nuevo usuario y RegisterUserDTO)
/**
 *
 * @author Carlos
 */
<<<<<<< HEAD
public class ResponseDTO {
    
    //Atributos.
    private String message;
    private TokenDTO value;
=======
public class responseDTO {

    private String message;
    private TokenDTO value;

    public responseDTO() {
    }

    public responseDTO(String message, TokenDTO value) {
        this.message = message;
        this.value = value;
    }
>>>>>>> c849ec9 (Continuo codificacion de registro nuevo usuario y RegisterUserDTO)

    //Constructor.
    public ResponseDTO() {
    }

    public ResponseDTO(String message, TokenDTO value) {
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
<<<<<<< HEAD
=======

>>>>>>> c849ec9 (Continuo codificacion de registro nuevo usuario y RegisterUserDTO)
}
