package Pantallas;

import Modelos.DTOS.ResponseLogoutDTO;
import Modelos.DTOS.ResponseUserInfoDTO;
import com.google.gson.Gson;
import utils.Constants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JOptionPane;

/**
 * Ventana del usuario USUARIO
 * .
 * @author Carlos
 */
public class VentanaUsuario extends javax.swing.JFrame {

    /**
     * Constructor de un nuevo formulario
     * Ventana USUARIO.
     * 
     * Se crea una peticion al servidor 
     * para mostrar el nombre del usuario.
     * 
     */
    public VentanaUsuario() {
        initComponents();
        setLocationRelativeTo(null);       
        //***********************************************
        StringBuilder resultado = new StringBuilder();
        try {
            // Creamos la URL
            URL url = new URL(Constants.urlUsuariosInfo + "?token=" + Constants.token);
            // Creamos la conexion al servidor.
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            // Metodo GET
            conn.setRequestMethod("GET");

            // Abrimos un input Stream de datos del servidor
            // y esperamos la respuesta del servidor.
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            // Leemos la respuesta del servidor.
            // y contruimos el string 'resultado'
            String linea;
            while ((linea = rd.readLine()) != null) {
                resultado.append(linea);
            }
            // Cerramos la conexion.
            rd.close();
        } catch (MalformedURLException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }

        // Creamos una instancia de Gson para convertir nuestro String a JSON
        Gson gson = new Gson();

        // Pasamos la respuesta a un String.
        String responseJsonString = resultado.toString();

        // El string es un json que lo convertimos en un objeto de java
        // Lo transformamos gracias al objeto DTO creado para ello.
        ResponseUserInfoDTO responseJson = gson.fromJson(responseJsonString, ResponseUserInfoDTO.class);
        // System.out.println(responseJson.getValue().getNombre());
        // Ponemos el nombre en el textfield correspondiente.
        jTextFieldNombre.setText(responseJson.getValue().getNombre());       
        //***********************************************
    }
    
     /**
     * Metodo que llama el constructor para inicializar el formulario.
     * Este metodo se regenera automaticamente por el Editor de formularios.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelUsuario = new javax.swing.JPanel();
        textLogo = new javax.swing.JLabel();
        mensajeBienvenida = new javax.swing.JTextArea();
        jButtonCerrarSesion = new javax.swing.JButton();
        jLabelUsuario = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        modificarPerfil = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("USUARIO");
        setResizable(false);

        jPanelUsuario.setBackground(new java.awt.Color(255, 255, 255));
        jPanelUsuario.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N

        textLogo.setBackground(new java.awt.Color(255, 255, 255));
        textLogo.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        textLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textLogo.setText("MOVIES4RENT");
        textLogo.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.black));
        textLogo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        mensajeBienvenida.setEditable(false);
        mensajeBienvenida.setColumns(20);
        mensajeBienvenida.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        mensajeBienvenida.setRows(2);
        mensajeBienvenida.setText("       Bienvenido a MOVIES4RENT\n                Eres USUARIO\n");
        mensajeBienvenida.setBorder(null);
        mensajeBienvenida.setSelectionColor(new java.awt.Color(255, 255, 255));

        jButtonCerrarSesion.setBackground(new java.awt.Color(153, 204, 255));
        jButtonCerrarSesion.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jButtonCerrarSesion.setText("Cerrar Sesion");
        jButtonCerrarSesion.setBorderPainted(false);
        jButtonCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarSesionActionPerformed(evt);
            }
        });

        jLabelUsuario.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabelUsuario.setText("USUARIO:");

        jTextFieldNombre.setEditable(false);
        jTextFieldNombre.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldNombre.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jTextFieldNombre.setToolTipText("");
        jTextFieldNombre.setBorder(null);

        modificarPerfil.setBackground(new java.awt.Color(242, 242, 242));
        modificarPerfil.setText("Modificar Perfil");
        modificarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarPerfilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelUsuarioLayout = new javax.swing.GroupLayout(jPanelUsuario);
        jPanelUsuario.setLayout(jPanelUsuarioLayout);
        jPanelUsuarioLayout.setHorizontalGroup(
            jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(modificarPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                .addGap(35, 35, 35)
                .addComponent(mensajeBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jLabelUsuario)
                .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonCerrarSesion)
                        .addGap(59, 59, 59))
                    .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanelUsuarioLayout.setVerticalGroup(
            jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(mensajeBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelUsuario)
                        .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(textLogo))
                .addGap(56, 56, 56)
                .addComponent(modificarPerfil)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 209, Short.MAX_VALUE)
                .addComponent(jButtonCerrarSesion)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo que se ejecuta al clicar
     * en el boton CERRAR SESION del formulario.
     * 
     * Operacion de logout del servidor.
     * 
     */
    private void jButtonCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarSesionActionPerformed
        StringBuilder resultado = new StringBuilder();
        try {

            // Creamos la URL
            URL url = new URL(Constants.urlLogout + "?token=" + Constants.token);
            // Creamos la conexion al servidor.
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            // Metodo GET
            conn.setRequestMethod("GET");

            // Abrimos un InputStream de datos del servidor
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            // Leemos la respuesta del servidor.
            String linea;
            while ((linea = rd.readLine()) != null) {
                resultado.append(linea);
            }
            // Cerramos la conexion.
            rd.close();
        } catch (MalformedURLException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }

        // Creamos una instancia de Gson para convertir nuestro String a JSON
        Gson gson = new Gson();

        // Pasamos la respuesta a un String.
        String responseJsonString = resultado.toString();

        // El string es un json que lo convertimos en un objeto de java
        ResponseLogoutDTO responseJson = gson.fromJson(responseJsonString, ResponseLogoutDTO.class);

        // Mostramos mensaje emergente de informacion.
        JOptionPane.showMessageDialog(this,
                "    Has cerrado la sesion.\nVolverás a la pantalla de login.",
                "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
        // Cerramos la ventana de usuario.
        this.dispose();
        // Volvemos la ventana de inicio.
        VentanaLogin inicio = new VentanaLogin();
        inicio.setVisible(true);
    }//GEN-LAST:event_jButtonCerrarSesionActionPerformed

    private void modificarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarPerfilActionPerformed
        VentanaModificarUsuario ventanaModificarUsuario = new VentanaModificarUsuario();
        ventanaModificarUsuario.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_modificarPerfilActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCerrarSesion;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPanel jPanelUsuario;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextArea mensajeBienvenida;
    private javax.swing.JButton modificarPerfil;
    private javax.swing.JLabel textLogo;
    // End of variables declaration//GEN-END:variables

}
