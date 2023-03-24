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
 * Ventana del usuario ADMINISTRADOR.
 * 
 * @author Carlos
 */
public class VentanaAdmin extends javax.swing.JFrame {

    /**
     * 
     * Constructor de un nuevo formulario
     * Ventana Administrador.
     * 
     * Se crea una peticion al servidor 
     * para mostrar el nombre del usuario.
     * 
     */
    public VentanaAdmin() {
        initComponents();
        setLocationRelativeTo(null); 
        //***********************************************
        StringBuilder resultado = new StringBuilder();
        try {
            //Creamos la URL
            URL url = new URL(Constants.urlUsuariosInfo + "?token=" + Constants.token);
            //Creamos la conexion al servidor.
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //Metodo GET
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

        jPanelAdmin = new javax.swing.JPanel();
        textLogo = new javax.swing.JLabel();
        mensajeBienvenida = new javax.swing.JTextArea();
        jButtonCerrarSesion = new javax.swing.JButton();
        jLabelUsuario = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        gestionUsuarios = new javax.swing.JButton();
        gestionPeliculas = new javax.swing.JButton();
        gestionAlquiler = new javax.swing.JButton();
        correoAvisoClientes = new javax.swing.JButton();
        rankingPeliculas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ADMINISTRADOR");
        setResizable(false);

        jPanelAdmin.setBackground(new java.awt.Color(255, 255, 255));
        jPanelAdmin.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jPanelAdmin.setPreferredSize(new java.awt.Dimension(800, 400));

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
        mensajeBienvenida.setText("       Bienvenido a MOVIES4RENT\n          Eres ADMINISTRADOR");
        mensajeBienvenida.setBorder(null);
        mensajeBienvenida.setSelectionColor(new java.awt.Color(255, 255, 255));

        jButtonCerrarSesion.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jButtonCerrarSesion.setText("Cerrar Sesion");
        jButtonCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarSesionActionPerformed(evt);
            }
        });

        jLabelUsuario.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabelUsuario.setText("USUARIO:");

        jTextFieldNombre.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jTextFieldNombre.setToolTipText("");
        jTextFieldNombre.setBorder(null);

        gestionUsuarios.setBackground(new java.awt.Color(242, 242, 242));
        gestionUsuarios.setText("Gestión Usuarios");

        gestionPeliculas.setBackground(new java.awt.Color(242, 242, 242));
        gestionPeliculas.setText("Gestión Películas");

        gestionAlquiler.setBackground(new java.awt.Color(242, 242, 242));
        gestionAlquiler.setText("Gestión Alquiler Películas");
        gestionAlquiler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestionAlquilerActionPerformed(evt);
            }
        });

        correoAvisoClientes.setBackground(new java.awt.Color(242, 242, 242));
        correoAvisoClientes.setText("Correo a clientes");
        correoAvisoClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                correoAvisoClientesActionPerformed(evt);
            }
        });

        rankingPeliculas.setBackground(new java.awt.Color(242, 242, 242));
        rankingPeliculas.setText("Ranking de Películas");

        javax.swing.GroupLayout jPanelAdminLayout = new javax.swing.GroupLayout(jPanelAdmin);
        jPanelAdmin.setLayout(jPanelAdminLayout);
        jPanelAdminLayout.setHorizontalGroup(
            jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAdminLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonCerrarSesion)
                .addGap(63, 63, 63))
            .addGroup(jPanelAdminLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAdminLayout.createSequentialGroup()
                        .addGroup(jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(gestionUsuarios, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textLogo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                        .addGap(40, 40, 40)
                        .addComponent(mensajeBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jLabelUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(rankingPeliculas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(correoAvisoClientes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(gestionAlquiler, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(gestionPeliculas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        jPanelAdminLayout.setVerticalGroup(
            jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(mensajeBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelUsuario)
                        .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(textLogo))
                .addGap(36, 36, 36)
                .addComponent(gestionUsuarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(gestionPeliculas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(gestionAlquiler)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rankingPeliculas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(correoAvisoClientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(jButtonCerrarSesion)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
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

            // Abrimos un input Stream de datos del servidor
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

    private void gestionAlquilerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestionAlquilerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gestionAlquilerActionPerformed

    private void correoAvisoClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_correoAvisoClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_correoAvisoClientesActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton correoAvisoClientes;
    private javax.swing.JButton gestionAlquiler;
    private javax.swing.JButton gestionPeliculas;
    private javax.swing.JButton gestionUsuarios;
    private javax.swing.JButton jButtonCerrarSesion;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPanel jPanelAdmin;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextArea mensajeBienvenida;
    private javax.swing.JButton rankingPeliculas;
    private javax.swing.JLabel textLogo;
    // End of variables declaration//GEN-END:variables

}
