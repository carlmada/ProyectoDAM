package Modelos.DTOS;

/**
 * Clase que formata los datos que se enviaran
 * al servidor para modificar el perfil
 * del usuario.
 * 
 * @author Carlos
 */
public class UpdateUserDTO {
    
    //Constructor vacio.
    public UpdateUserDTO() {
    }
        
    //Atributos.
    private String nombre;
    private String apellidos;
    private String email;
    private String direccion;
    private String telefono;

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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
       
}
