package Modelos.DTOS.alquiler.DTO;

/**
 *
 * @author Carlos
 */
public class ResponseAlquilerDTO {

    // Atributos.
    private String message;
    private AlquilerDTO value;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AlquilerDTO getValue() {
        return value;
    }

    public void setValue(AlquilerDTO value) {
        this.value = value;
    }

}
