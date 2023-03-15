package Modelos;

import java.util.UUID;
/**
 *
 * @author Carlos
 */
public class Usuarios {
    
    //Atributos.
    UUID id;
    String address;
    String apellidos;
    String email;
    boolean isAdmin = false;
    String nombre;
    String password;
    String telefono;
    String username;

    //Constructor.
    public Usuarios(UUID id, String address, String apellidos,
                    String email, boolean isAdmin, String nombre, 
                    String password, String telefono, String username) { 
        this.id = id;
        this.address = address;
        this.apellidos = apellidos;
        this.email = email;
        this.isAdmin = isAdmin;
        this.nombre = nombre;
        this.password = password;
        this.telefono = telefono;
        this.username = username;
    }

    public Usuarios() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //Getters-Setters.

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
