package Pantallas;

import Modelos.DTOS.CambioDePasswordDTO;
import Modelos.DTOS.ResponseLogoutDTO;
import Modelos.DTOS.peliculas.DTO.ResponseAlquilerPeliculaDTO;
import Modelos.DTOS.peliculas.DTO.ResponsePeliculaListDTO;
import Modelos.DTOS.usuarios.DTO.ResponseUserInfoDTO;
import Pantallas.usuarios.VentanaModificarUsuario;
import com.google.gson.Gson;
import java.awt.Color;
import utils.Constants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import utils.TablePeliculas;

/**
 * Ventana del usuario USUARIO .
 *
 * @author Carlos
 */
public class VentanaUsuario extends javax.swing.JFrame {

    //Variable de Clase.
    TablePeliculas modelPeliculas;
    JSONArray jsonArrayPeliculas;
    int posicionPelicula;
<<<<<<< HEAD
<<<<<<< HEAD:src/main/java/Pantallas/usuarios/VentanaUsuario.java
    UUID idUsuario, idPelicula ;
=======
    UUID idUsuario, idPelicula;
>>>>>>> 194339f (Continuacion alquileres):src/main/java/Pantallas/VentanaUsuario.java
=======
    UUID idUsuario, idPelicula;
>>>>>>> master

    /**
     * Constructor de un nuevo formulario Ventana USUARIO.
     *
     * Se crea una peticion al servidor para mostrar el nombre del usuario.
     *
     */
    public VentanaUsuario() {
        initComponents();
        setLocationRelativeTo(null);
        panelContraseña.setVisible(false);
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
<<<<<<< HEAD
<<<<<<< HEAD:src/main/java/Pantallas/usuarios/VentanaUsuario.java
        
        //Obtenemos el idUsuario del usuario.
        idUsuario = responseJson.getValue().getId();
        
=======
=======
>>>>>>> master

        //Obtenemos el idUsuario del usuario.
        idUsuario = responseJson.getValue().getId();

<<<<<<< HEAD
>>>>>>> 194339f (Continuacion alquileres):src/main/java/Pantallas/VentanaUsuario.java
=======
>>>>>>> master
        //***********************************************
    }

    /**
     * Metodo que llama el constructor para inicializar el formulario. Este metodo se regenera automaticamente por el Editor de formularios.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelUsuario = new javax.swing.JPanel();
        jScrollPanePeliculas = new javax.swing.JScrollPane();
        jTablePeliculas = new javax.swing.JTable();
        panelContraseña = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelPassword = new javax.swing.JLabel();
        jLabelConfirmPassword = new javax.swing.JLabel();
        jPassword = new javax.swing.JPasswordField();
        jPassword2 = new javax.swing.JPasswordField();
        buttonModificarContraseña = new javax.swing.JButton();
        buttonInicio = new javax.swing.JButton();
        textLogo = new javax.swing.JLabel();
        mensajeBienvenida = new javax.swing.JTextArea();
        jButtonCerrarSesion = new javax.swing.JButton();
        jLabelUsuario = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        listaPeliculas = new javax.swing.JButton();
        modificarPerfil = new javax.swing.JButton();
        cambioDeContraseña = new javax.swing.JButton();
        alquilarPelicula = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("USUARIO");
        setResizable(false);

        jPanelUsuario.setBackground(new java.awt.Color(255, 255, 255));
        jPanelUsuario.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jPanelUsuario.setPreferredSize(new java.awt.Dimension(800, 400));

        jScrollPanePeliculas.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPanePeliculas.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPanePeliculas.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPanePeliculas.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N

        jTablePeliculas.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jTablePeliculas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTablePeliculas.setFillsViewportHeight(true);
        jTablePeliculas.setFocusable(false);
        jTablePeliculas.setGridColor(new java.awt.Color(153, 153, 153));
        jTablePeliculas.setSelectionBackground(new java.awt.Color(102, 204, 255));
        jScrollPanePeliculas.setViewportView(jTablePeliculas);

        panelContraseña.setBackground(new java.awt.Color(204, 255, 255));
        panelContraseña.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cambio de Contraseña");

        jLabelPassword.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabelPassword.setText("Password :");

        jLabelConfirmPassword.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabelConfirmPassword.setText("Confirm Password :");

        jPassword.setBackground(java.awt.SystemColor.control);
        jPassword.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N

        jPassword2.setBackground(java.awt.SystemColor.control);
        jPassword2.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N

        buttonModificarContraseña.setBackground(new java.awt.Color(255, 153, 51));
        buttonModificarContraseña.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        buttonModificarContraseña.setText("MODIFICAR");
        buttonModificarContraseña.setBorderPainted(false);
        buttonModificarContraseña.setFocusable(false);
        buttonModificarContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonModificarContraseñaActionPerformed(evt);
            }
        });

        buttonInicio.setBackground(new java.awt.Color(153, 204, 0));
        buttonInicio.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        buttonInicio.setText("VOLVER");
        buttonInicio.setBorderPainted(false);
        buttonInicio.setFocusable(false);
        buttonInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInicioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelContraseñaLayout = new javax.swing.GroupLayout(panelContraseña);
        panelContraseña.setLayout(panelContraseñaLayout);
        panelContraseñaLayout.setHorizontalGroup(
            panelContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContraseñaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelContraseñaLayout.createSequentialGroup()
                        .addComponent(jLabelConfirmPassword)
                        .addGap(14, 14, 14)
                        .addComponent(jPassword2, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
                    .addGroup(panelContraseñaLayout.createSequentialGroup()
                        .addComponent(jLabelPassword)
                        .addGap(82, 82, 82)
                        .addComponent(jPassword)))
                .addContainerGap())
            .addGroup(panelContraseñaLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(buttonModificarContraseña)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonInicio)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelContraseñaLayout.setVerticalGroup(
            panelContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContraseñaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(panelContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPassword)
                    .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(panelContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelConfirmPassword)
                    .addComponent(jPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(panelContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonModificarContraseña)
                    .addComponent(buttonInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31))
        );

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

        jButtonCerrarSesion.setBackground(new java.awt.Color(255, 102, 102));
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

        listaPeliculas.setBackground(new java.awt.Color(0, 204, 255));
        listaPeliculas.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        listaPeliculas.setText("Lista de Peliculas");
        listaPeliculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaPeliculasActionPerformed(evt);
            }
        });

        modificarPerfil.setBackground(new java.awt.Color(255, 153, 51));
        modificarPerfil.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        modificarPerfil.setText("Modificar Perfil");
        modificarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarPerfilActionPerformed(evt);
            }
        });

        cambioDeContraseña.setBackground(new java.awt.Color(255, 153, 51));
        cambioDeContraseña.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        cambioDeContraseña.setText("Cambiar Contraseña");
        cambioDeContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambioDeContraseñaActionPerformed(evt);
            }
        });

        alquilarPelicula.setBackground(new java.awt.Color(0, 204, 102));
        alquilarPelicula.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        alquilarPelicula.setText("Alquilar Pelicula");
        alquilarPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alquilarPeliculaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelUsuarioLayout = new javax.swing.GroupLayout(jPanelUsuario);
        jPanelUsuario.setLayout(jPanelUsuarioLayout);
        jPanelUsuarioLayout.setHorizontalGroup(
            jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(textLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(mensajeBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jLabelUsuario))
                    .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(modificarPerfil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(alquilarPelicula, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(cambioDeContraseña, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(listaPeliculas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panelContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jButtonCerrarSesion))
                    .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                    .addGap(216, 216, 216)
                    .addComponent(jScrollPanePeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(84, Short.MAX_VALUE)))
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
                .addGap(51, 51, 51)
                .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                        .addComponent(panelContraseña, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                        .addComponent(listaPeliculas)
                        .addGap(12, 12, 12)
                        .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                                .addComponent(alquilarPelicula)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(modificarPerfil)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cambioDeContraseña)
                                .addGap(0, 150, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelUsuarioLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButtonCerrarSesion)
                                .addGap(18, 18, 18))))))
            .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                    .addGap(113, 113, 113)
                    .addComponent(jScrollPanePeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(97, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo que se ejecuta al clicar en el boton CERRAR SESION del formulario.
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

    /**
     * Metodo que llama a la ventana de modificacion del perfil del usuario.
     *
     */
    private void modificarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarPerfilActionPerformed
        VentanaModificarUsuario ventanaModificarUsuario = new VentanaModificarUsuario();
        ventanaModificarUsuario.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_modificarPerfilActionPerformed

    /**
     * Metodo que muestra el panel de cambio de contraseña del usuario.
     *
     */
    private void cambioDeContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambioDeContraseñaActionPerformed
        //cerramos la tabla peliculas si estaba abierta.        
        jScrollPanePeliculas.setVisible(false);

        panelContraseña.setVisible(true);

    }//GEN-LAST:event_cambioDeContraseñaActionPerformed

    /**
     * Metodo que muestra el formulario de cambio de contraseña del usuario.
     *
     */
    private void buttonModificarContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModificarContraseñaActionPerformed

        // Leemos los campos password introducidos.
        // Comprobamos que los password sean iguales...
        char[] password = jPassword.getPassword();
        String pass = new String(password);

        char[] passwordConfirmacion = jPassword2.getPassword();
        String passConfirm = new String(passwordConfirmacion);

        // Comparamos...
        if (pass.equals(passConfirm)) {

            // Creamos el cliente
            Client client = ClientBuilder.newClient();

            // Creamos el target (URL) con el token.
            WebTarget target = client.target(Constants.urlUpdatePasswordUsuario + "?token=" + Constants.token);

            // Creamos la solicitud
            Invocation.Builder solicitud = target.request();

            // Creamos el objeto DTO que espera el servidor
            CambioDePasswordDTO cambioPassword = new CambioDePasswordDTO();

            // Asignamos los valores
            cambioPassword.setPassword(pass);

            // Creamos una instancia de Gson para convertir nuestro String a JSON
            Gson gson = new Gson();

            // lo pasamos a objeto Json
            String jsonString = gson.toJson(cambioPassword);

            // Enviamos nuestro json via PUT a la API
            Response put = solicitud.put(Entity.json(jsonString));

            // Recibimos la respuesta y la leemos en una clase String
            String responseJsonString = put.readEntity(String.class);

            // Si todo ha salido correcto.
            if (put.getStatus() == 200) {
                // Comprobacion por consola.
                System.out.println(responseJsonString);

                // Mostramos mensaje emergente de informacion.
                JOptionPane.showMessageDialog(this,
                        "Contraseña actualizada correctamente."
                        + "\nVolverás a la pantalla de login.",
                        "CAMBIO de CONTRASEÑA", JOptionPane.INFORMATION_MESSAGE);
                // Cerramos la ventana. 
                // y volvemos a inicio.
                this.dispose();
                VentanaLogin inicio = new VentanaLogin();
                inicio.setVisible(true);
            } else {
                // Mostramos mensaje emergente de aviso.
                JOptionPane.showMessageDialog(this,
                        "Error en cambio de contraseña.\n"
                        + "Vuelve a introducir los datos.",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
                // Limpiamos todos los campos.
                jPassword.setText("");
                jPassword2.setText("");
                // Continuamos en ventana de nuevo registro.
            }
        } else {
            // Mostramos mensaje emergente de aviso.
            JOptionPane.showMessageDialog(this,
                    "Las contraseñas no coinciden.\n"
                    + "Vuelve a introducir los datos.",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
            // Limpiamos todos los campos.
            jPassword.setText("");
            jPassword2.setText("");
            // Continuamos en ventana de nuevo registro.
        }

    }//GEN-LAST:event_buttonModificarContraseñaActionPerformed

    /**
     *
     * Metodo que usa el usuario para hacer el alquiler de una pelicula.
     *
     */
    private void alquilarPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alquilarPeliculaActionPerformed

        //cerramos el panel de contraseña si estaba abierto.
        panelContraseña.setVisible(false);
<<<<<<< HEAD
<<<<<<< HEAD:src/main/java/Pantallas/usuarios/VentanaUsuario.java
        
=======

>>>>>>> 194339f (Continuacion alquileres):src/main/java/Pantallas/VentanaUsuario.java
=======

>>>>>>> master
        //Obtenemos la fila seleccionada de pelicula.
        posicionPelicula = jTablePeliculas.getSelectedRow();

        if ((posicionPelicula == -1)) {
            // No se ha seleccionado pelicula.
            // Mostramos mensaje emergente de informacion.
            JOptionPane.showMessageDialog(this,
                    "Debes seleccionar una\n"
                    + "PELICULA de la tabla.",
                    "ALQUILAR PELICULA", JOptionPane.INFORMATION_MESSAGE);
<<<<<<< HEAD
<<<<<<< HEAD:src/main/java/Pantallas/usuarios/VentanaUsuario.java
        }else {
=======
        } else {
>>>>>>> 194339f (Continuacion alquileres):src/main/java/Pantallas/VentanaUsuario.java
=======
        } else {
>>>>>>> master
            // Se ha seleccionado una película.
            // Creamos objeto JSON temporales de la pelicula seleccionada.
            JSONObject objPelicula = new JSONObject();
            objPelicula = jsonArrayPeliculas.getJSONObject(posicionPelicula);
            //Asignamos el id de la pelicula a su variable UUID.
            idPelicula = (UUID) objPelicula.get("id");
<<<<<<< HEAD
<<<<<<< HEAD:src/main/java/Pantallas/usuarios/VentanaUsuario.java
            
             // Mostramos mensaje emergente de confirmacion.
            int opcion = JOptionPane.showConfirmDialog(this,
                     "Deseas alquilar la pelicula\n"
                    + objPelicula.get("TITULO")  + "  ?",
                    "CONFIRMACION",
                    JOptionPane.YES_NO_OPTION);
            
=======
=======
>>>>>>> master

            // Mostramos mensaje emergente de confirmacion.
            int opcion = JOptionPane.showConfirmDialog(this,
                    "Deseas alquilar la pelicula\n"
                    + objPelicula.get("TITULO") + "  ?",
                    "CONFIRMACION",
                    JOptionPane.YES_NO_OPTION);

<<<<<<< HEAD
>>>>>>> 194339f (Continuacion alquileres):src/main/java/Pantallas/VentanaUsuario.java
=======
>>>>>>> master
            if (opcion == JOptionPane.YES_OPTION) {
                //****************************************************************
                // Realizamos la peticion de alquiler nuevo 
                // para el usuario.
<<<<<<< HEAD
<<<<<<< HEAD:src/main/java/Pantallas/usuarios/VentanaUsuario.java
                // Creamos el cliente de acceso
                Client client = ClientBuilder.newClient();
                // Creamos el target (URL)
                WebTarget target = client.target(Constants.urlPeliculasAddAlquiler
                        +idPelicula+ "?token=" + Constants.token);


            
            
            
            }
            
            
        }
        
        
        
        
=======
=======
>>>>>>> master
                //***********************************************
                StringBuilder resultado = new StringBuilder();
                try {
                    //Creamos la URL
                    URL url = new URL(Constants.urlPeliculasAddAlquiler
                            + "?peliculaId=" + idPelicula
                            + "&usuariId=" + idUsuario
                            + "&token=" + Constants.token);

                    //Creamos la conexion al servidor.
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    //Metodo POST
                    conn.setRequestMethod("POST");

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
                    
                    // Creamos una instancia de Gson para convertir nuestro String a JSON
                    Gson gson = new Gson();
                    // Pasamos la respuesta a un String.
                    String responseJsonString = resultado.toString();
                    // El string es un json que lo convertimos en un objeto de java
                    // Lo transformamos gracias al objeto DTO creado para ello.
                    ResponseAlquilerPeliculaDTO responseJson = gson.fromJson(responseJsonString, ResponseAlquilerPeliculaDTO.class);
                   
                    
                    //Si todo bien...
                    if (conn.getResponseCode() == 200) {
                        // Mostramos mensaje emergente de informacion.
                        JOptionPane.showMessageDialog(this,
                                "Película alquilada correctamente.\n"
                                +"Fecha de inicio:           "+responseJson.getValue().getFechaInicio()+"\n"
                                +"Fecha de finalizacion: "+responseJson.getValue().getFechaFin()+"\n"
                                +"Estado: "+responseJson.getValue().getEstado(),                                
                                "ALQUILER PELICULA", JOptionPane.INFORMATION_MESSAGE);
                        // y volvemos a inicio.
                        
                    }
                } catch (MalformedURLException ex) {
                    System.out.println(ex);
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            } else {
                //No hacemos nada...
            }
        }
<<<<<<< HEAD
>>>>>>> 194339f (Continuacion alquileres):src/main/java/Pantallas/VentanaUsuario.java
=======
>>>>>>> master
    }//GEN-LAST:event_alquilarPeliculaActionPerformed

    /**
     *
     * Metodo para mostrar la tabla de peliculas para poder seleccionarlas.
     *
     */

    private void listaPeliculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaPeliculasActionPerformed

        //cerramos el panel de contraseña si estaba abierto.
        panelContraseña.setVisible(false);

        //Tabla peliculas. 
        jScrollPanePeliculas.setVisible(true);
        jTablePeliculas.setVisible(true);

        //Leemos la lista de peliculas.
        StringBuilder resultadoPeliculas = new StringBuilder();
        try {
            // Creamos la URL
            URL url = new URL(Constants.urlPeliculas + "?token=" + Constants.token);
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
                resultadoPeliculas.append(linea);
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
        String responseJsonString = resultadoPeliculas.toString();
        System.out.println(responseJsonString);
        //*************************************************
        // El array de objetos JSON lo convertimos en un array de objetos DTO.
        // Lo transformamos gracias al objeto DTO creado para ello.
        ResponsePeliculaListDTO responseJson = gson.fromJson(responseJsonString, ResponsePeliculaListDTO.class);
        //*************************************************

        //Creamos una lista de objetos JSON
        jsonArrayPeliculas = new JSONArray();
        for (int i = 0; i < responseJson.getValue().size(); i++) {
            JSONObject objPelicula = new JSONObject();
            objPelicula.put("id", responseJson.getValue().get(i).getId());
            objPelicula.put("TITULO", responseJson.getValue().get(i).getTitulo());
            objPelicula.put("DIRECTOR", responseJson.getValue().get(i).getDirector());
            objPelicula.put("GENERO", responseJson.getValue().get(i).getGenero());
            objPelicula.put("DURACION", responseJson.getValue().get(i).getDuracion());
            objPelicula.put("AÑO", responseJson.getValue().get(i).getAño());
            objPelicula.put("PRECIO", responseJson.getValue().get(i).getPrecio());
            jsonArrayPeliculas.put(objPelicula);
        }

        //Creamos un String[] de columnas
        String[] columnNamesPeliculas = {"TITULO", "DIRECTOR", "GENERO", "DURACION", "AÑO", "PRECIO"};

        //Creamos el modelo de tabla
        modelPeliculas = new TablePeliculas(jsonArrayPeliculas, columnNamesPeliculas);
        //Asignamos el modelo a la tabla
        jTablePeliculas.setModel(modelPeliculas);
        //Mostramos la tabla
        //Añadimos color a la cabecera.
        JTableHeader header = jTablePeliculas.getTableHeader();
        header.setBackground(Color.LIGHT_GRAY);
        //Ponemos los datos numericos en el centro de la celda.
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
        jTablePeliculas.getColumnModel().getColumn(3).setCellRenderer(renderer);
        jTablePeliculas.getColumnModel().getColumn(4).setCellRenderer(renderer);
        jTablePeliculas.getColumnModel().getColumn(5).setCellRenderer(renderer);

        //Asignamos el ancho de las columnas.
        jTablePeliculas.getColumnModel().getColumn(0).setPreferredWidth(130);
        jTablePeliculas.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTablePeliculas.getColumnModel().getColumn(3).setPreferredWidth(65);
        jTablePeliculas.getColumnModel().getColumn(4).setPreferredWidth(35);
        jTablePeliculas.getColumnModel().getColumn(5).setPreferredWidth(45);

        //***************************************************

    }//GEN-LAST:event_listaPeliculasActionPerformed

    private void buttonInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInicioActionPerformed
        // Cerramos la ventana de registro.
        // y volvemos a inicio.
        this.dispose();
        VentanaUsuario usuario = new VentanaUsuario();
        usuario.setVisible(true);
    }//GEN-LAST:event_buttonInicioActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alquilarPelicula;
    private javax.swing.JButton buttonInicio;
    private javax.swing.JButton buttonModificarContraseña;
    private javax.swing.JButton cambioDeContraseña;
    private javax.swing.JButton jButtonCerrarSesion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelConfirmPassword;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPanel jPanelUsuario;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JPasswordField jPassword2;
    private javax.swing.JScrollPane jScrollPanePeliculas;
    private javax.swing.JTable jTablePeliculas;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JButton listaPeliculas;
    private javax.swing.JTextArea mensajeBienvenida;
    private javax.swing.JButton modificarPerfil;
    private javax.swing.JPanel panelContraseña;
    private javax.swing.JLabel textLogo;
    // End of variables declaration//GEN-END:variables

}
