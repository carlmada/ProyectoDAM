package helper;

/**
 *
 * Clase con las variables static que seran utilizadas en la aplicacion.
 *
 * @author Carlos
 */
public class Constants {

    //Variables con las url del servidor donde realizaremos las peticiones.
    public static String url = "http://localhost:8080";
    public static String urlLogin = url + "/login";
    public static String urlLogout = url + "/logout";
    public static String urlRegister = url + "/register";
    public static String urlUsuarios = url + "/users";
    public static String urlUsuariosPorId = url + "/users/{id}";
    public static String urlUsuariosInfo = url + "/users/info";
    public static String urlUpdateUsuarios = url + "/users/update";

    //Variables globales que se usaran en la aplicacion.
    public static String token;

}
