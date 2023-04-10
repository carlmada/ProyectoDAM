package utils;

/**
 *
 * Clase con variables static que seran utilizadas en la aplicacion.
 *
 * @author Carlos
 */
public class Constants {

    //Variables con las url del servidor donde realizaremos las peticiones.
    //URL General.
    public static String url = "http://localhost:8080";

    //url de login - logout - registro.
    public static String urlLogin = url + "/login";
    public static String urlLogout = url + "/logout";
    public static String urlRegister = url + "/register";

    //url de usuarios.
    public static String urlUsuarios = url + "/users";
    public static String urlUsuariosPorId = url + "/users/{id}";
    public static String urlUsuariosInfo = url + "/users/info";
    public static String urlUpdateUsuarios = url + "/users/update";
    public static String urlUsersDeleteId = url + "/users/delete/";
    public static String urlUpdateUsuarioAdmin = url + "/users/update/";
    public static String urlUpdatePasswordUsuario = url + "/users/changepassword";

    //url de Peliculas.
    public static String urlPeliculas = url + "/peliculas";
    public static String urlAddPelicula = url + "/peliculas/add";
    public static String urlPeliculaPorId = url + "/peliculas/{id}";
    public static String urlpeliculaDeleteId = url + "/peliculas/delete/";
    public static String urlUpdatePelicula = url + "/peliculas/update/";

    //url de Alquileres.
    public static String urlPeliculasAlquileres = url + "/peliculas/alquileres";
    public static String urlPeliculasAddAlquiler = url + "/peliculas/alquileres/nuevo";
    public static String urlPeliculasAlquileresByUser = url + "/peliculas/alquileres/alquilerByUser/";
    public static String urlPeliculasDeleteAlquilerId = url + "/peliculas/alquileres/delete/";
    public static String urlPeliculasUpdateStatusAlquiler = url + "/peliculas/alquileres/updateStatus";

    //Variables globales que se usaran en la aplicacion.
    public static String token;

}
