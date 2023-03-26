package Modelos.DTOS;

import java.util.UUID;

/**
 *
 * Clase que formata los datos que recibiremos del servidor cuando pidamos la lista de usuarios.
 *
 * @author Carlos
 */
public class UserListDTO {

    //Constructor.
    public UserListDTO() {
    }

    //Atributos
    private UUID id;
    private String nombre;
    private String apellidos;
    private String telefono;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
