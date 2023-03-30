package Modelos.DTOS.usuarios.DTO;

import java.util.UUID;

/**
 *
 * Clase que formata los datos que recibiremos del servidor con la informacion del usuario.
 *
 * @author Carlos
 */
public class UserInfoDTO {

    public UserInfoDTO() {
    }

    //Atributos
    private UUID id;
    private String nombre;
    private String apellidos;
    private String email;
    private String direccion;

    //Getters-Setters.
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
