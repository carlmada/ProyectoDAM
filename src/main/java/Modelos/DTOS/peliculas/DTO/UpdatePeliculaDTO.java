package Modelos.DTOS.peliculas.DTO;

/**
 *Clase que formata los datos que se enviaran al servidor
 *para modificar una pelicula.
 * 
 * @author Carlos
 */
public class UpdatePeliculaDTO {

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Double getDuracion() {
        return duracion;
    }

    public void setDuracion(Double duracion) {
        this.duracion = duracion;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    //Constructor.
    public UpdatePeliculaDTO() {
    }
    //Atributos.
    private String titulo;
    private String director;
    private String genero;
    private Double duracion;
    private String año;
    private Double precio;
    
}
