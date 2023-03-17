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
    public static String urlLogin = url + "/login"; //post
    public static String urlLogout = url + "/logout"; //get
    public static String urlRegister = url + "/register"; //post
    public static String urlUsuarios = url + "/users"; //get
    public static String urlUsuariosPorId = url + "/users/{id}"; //get
    public static String urlUsuariosInfo = url + "/users/info"; //get
    public static String urlUpdateUsuarios = url + "/users/update"; //put
    
    
    //Variables globales que se usaran en la aplicacion.
    public static String token;

}
