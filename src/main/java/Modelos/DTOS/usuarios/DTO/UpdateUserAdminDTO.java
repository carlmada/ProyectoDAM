package Modelos.DTOS.usuarios.DTO;

/**
 * Clase que utilitzarem per modificar el ROL dels usuaris.
 * 
 * @author Carlos
 */
public class UpdateUserAdminDTO {

    //Contructor.
    public UpdateUserAdminDTO() {
    }

    //Atributos.
    private boolean isAdmin;

    //Getter - Setter.
    public boolean isIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

}
