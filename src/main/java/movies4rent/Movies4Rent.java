package movies4rent;

import Pantallas.VentanaLogin;

/**
 * Clase Principal (Main) de la aplicacion.
 *
 * @author Carlos
 */
public class Movies4Rent {

    public static VentanaLogin inicio = new VentanaLogin();

    /**
     * Metodo principal de la aplicaion.
     *
     * @param args
     */
    public static void main(String[] args) {
        //Inicio de la aplicacion.
        inicio.setVisible(true);
    }
}
