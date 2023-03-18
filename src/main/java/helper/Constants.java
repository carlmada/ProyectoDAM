/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;

/**
 *
 * @author Carlos
 */
public class Constants {

    //Constants amb les url del servidor a on farem les peticions.
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
