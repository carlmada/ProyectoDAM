package Modelos;

/**
 *
 * @author Carlos
 */
public class Roles {

    //Atributos
    int id;
    String descripcion;
    String nom_rol;
    
    //Constructor.
    public Roles(int id, String descripcion, String nom_rol) {
        this.id = id;
        this.descripcion = descripcion;
        this.nom_rol = nom_rol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNom_rol() {
        return nom_rol;
    }

    public void setNom_rol(String nom_rol) {
        this.nom_rol = nom_rol;
    }
    
}
