package Modelos.DTOS;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Carlos
 */
public class responseDTO {

    private String message;
    private TokenDTO value;

    public responseDTO() {
    }

    public responseDTO(String message, TokenDTO value) {
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
}
