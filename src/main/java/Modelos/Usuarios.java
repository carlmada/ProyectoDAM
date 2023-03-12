
package Modelos;

/**
 *
 * @author Carlos
 */
public class Usuarios {
    
    //Atributos.
    int id;
    String address;
    String apellidos;
    String email;
    int id_rol;
    String nombre;
    String password;
    String telefono;
    String username;

    //Constructor.
    public Usuarios(int id, String address, String apellidos,
                    String email, int id_rol, String nombre, 
                    String password, String telefono, String username) {
        
        this.id = id;
        this.address = address;
        this.apellidos = apellidos;
        this.email = email;
        this.id_rol = id_rol;
        this.nombre = nombre;
        this.password = password;
        this.telefono = telefono;
        this.username = username;
    }
    
    //Getters-Setters.

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
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
