package Modelos;

import java.util.UUID;

/**
 * Clase que define los atributos de un usuario de la aplicacion.
 *
 * @author Carlos
 */
public class Usuarios {

    //Atributos.
    UUID id;
    String direccion;
    String apellidos;
    String email;
    boolean isAdmin = false;
    String nombre;
    String password;
    String telefono;
    String username;

    /**
     * Constructor con sus parametros.
     *
     * @param id
     * @param address
     * @param apellidos
     * @param email
     * @param isAdmin
     * @param nombre
     * @param password
     * @param telefono
     * @param username
     */
    public Usuarios(UUID id, String address, String apellidos,
            String email, boolean isAdmin, String nombre,
            String password, String telefono, String username) {
        this.id = id;
        this.direccion = address;
        this.apellidos = apellidos;
        this.email = email;
        this.isAdmin = isAdmin;
        this.nombre = nombre;
        this.password = password;
        this.telefono = telefono;
        this.username = username;
    }

    public Usuarios(){};
    
    //Getters-Setters.
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
