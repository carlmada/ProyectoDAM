package Modelos.DTOS.ranking.DTO;

/**
 * DTO de ranking de respuesta del servidor.
 * 
 * @author Carlos
 */
public class ResponseRankingListDTO {
    
    // Atributos.
    private String message;
    private ValueRanking value;
    
    //Getters-Setters

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ValueRanking getValue() {
        return value;
    }

    public void setValue(ValueRanking value) {
        this.value = value;
    }
    
    
}
