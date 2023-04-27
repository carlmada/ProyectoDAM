package Pantallas.usuarios;

import Modelos.DTOS.ResponseLogoutDTO;
import Modelos.DTOS.usuarios.DTO.ResponseUserInfoDTO;
import Modelos.DTOS.usuarios.DTO.ResponseUserListDTO;
import Pantallas.VentanaAdmin;
import Pantallas.VentanaLogin;
import com.google.gson.Gson;
import utils.TableUsuarios;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.JTableHeader;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import utils.Constants;

/**
 *
 * Ventana para realizar la gestión de los usuarios.
 *
 * @author Carlos
 */
public class VentanaGestionUsuarios extends javax.swing.JFrame {

    //Variable de Clase.
    TableUsuarios model;
    JSONArray jsonArray;

    /**
     * Constructor de un nuevo formulario Ventana de gestion de los usuarios.
     * @Author Carlos.
     */
    public VentanaGestionUsuarios() {
        initComponents();

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
     * @Author Carlos.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelGestionUsuarios = new javax.swing.JPanel();
        textLogo = new javax.swing.JLabel();
        mensajeGestionUsuarios = new javax.swing.JTextArea();
        jButtonCerrarSesion = new javax.swing.JButton();
        jLabelUsuario = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        listaUsuarios = new javax.swing.JButton();
        modificarRolUsuario = new javax.swing.JButton();
        eliminarUsuario = new javax.swing.JButton();
        jButtonVolver = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GESTION DE USUARIOS");
        setResizable(false);

        jPanelGestionUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        jPanelGestionUsuarios.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jPanelGestionUsuarios.setPreferredSize(new java.awt.Dimension(800, 400));

        textLogo.setBackground(new java.awt.Color(255, 255, 255));
        textLogo.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        textLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textLogo.setText("MOVIES4RENT");
        textLogo.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.black));
        textLogo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        mensajeGestionUsuarios.setEditable(false);
        mensajeGestionUsuarios.setColumns(20);
        mensajeGestionUsuarios.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        mensajeGestionUsuarios.setRows(2);
        mensajeGestionUsuarios.setText("    GESTION DE USUARIOS");
        mensajeGestionUsuarios.setBorder(null);
        mensajeGestionUsuarios.setSelectionColor(new java.awt.Color(255, 255, 255));

        jButtonCerrarSesion.setBackground(new java.awt.Color(255, 102, 102));
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

        listaUsuarios.setBackground(new java.awt.Color(0, 204, 255));
        listaUsuarios.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        listaUsuarios.setText("Listar Usuarios");
        listaUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaUsuariosActionPerformed(evt);
            }
        });

        modificarRolUsuario.setBackground(new java.awt.Color(255, 153, 51));
        modificarRolUsuario.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        modificarRolUsuario.setText("Modificar ROL Usuario");
        modificarRolUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarRolUsuarioActionPerformed(evt);
            }
        });

        eliminarUsuario.setBackground(new java.awt.Color(255, 51, 51));
        eliminarUsuario.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        eliminarUsuario.setText("Eliminar Usuario");
        eliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarUsuarioActionPerformed(evt);
            }
        });

        jButtonVolver.setBackground(new java.awt.Color(153, 204, 0));
        jButtonVolver.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jButtonVolver.setText("Volver");
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
            }
        });

        jScrollPane.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N

        jTable.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jTable.setFillsViewportHeight(true);
        jTable.setFocusable(false);
        jTable.setGridColor(new java.awt.Color(153, 153, 153));
        jTable.setSelectionBackground(new java.awt.Color(102, 204, 255));
        jScrollPane.setViewportView(jTable);

        javax.swing.GroupLayout jPanelGestionUsuariosLayout = new javax.swing.GroupLayout(jPanelGestionUsuarios);
        jPanelGestionUsuarios.setLayout(jPanelGestionUsuariosLayout);
        jPanelGestionUsuariosLayout.setHorizontalGroup(
            jPanelGestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGestionUsuariosLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanelGestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(eliminarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(modificarRolUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(listaUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                .addGroup(jPanelGestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelGestionUsuariosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 476, Short.MAX_VALUE)
                        .addComponent(jButtonVolver)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonCerrarSesion))
                    .addGroup(jPanelGestionUsuariosLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanelGestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
                            .addGroup(jPanelGestionUsuariosLayout.createSequentialGroup()
                                .addComponent(mensajeGestionUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(jLabelUsuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 262, Short.MAX_VALUE)))))
                .addGap(63, 63, 63))
        );
        jPanelGestionUsuariosLayout.setVerticalGroup(
            jPanelGestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGestionUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelGestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelGestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelUsuario)
                        .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelGestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textLogo)
                        .addComponent(mensajeGestionUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addGroup(jPanelGestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelGestionUsuariosLayout.createSequentialGroup()
                        .addComponent(listaUsuarios)
                        .addGap(18, 18, 18)
                        .addComponent(modificarRolUsuario)
                        .addGap(18, 18, 18)
                        .addComponent(eliminarUsuario))
                    .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                .addGroup(jPanelGestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCerrarSesion)
                    .addComponent(jButtonVolver))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelGestionUsuarios, 965, 965, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelGestionUsuarios, 451, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverActionPerformed
        /**
         *
         * Método para volver a la pantalla anterior.
         * @Author Carlos.
         */

        VentanaAdmin ventanaAdmin = new VentanaAdmin();
        ventanaAdmin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonVolverActionPerformed

    private void listaUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaUsuariosActionPerformed

        /**
         *
         * Método para crear una tabla que muestre la lista de usuarios de la aplicacion.
         * @Author Carlos.
         */
       
        StringBuilder resultado = new StringBuilder();
        try {
            // Creamos la URL
            URL url = new URL(Constants.urlUsuarios + "?token=" + Constants.token);
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
        System.out.println(responseJsonString);
        //*************************************************
        // El array de objetos JSON lo convertimos en un array de objetos DTO.
        // Lo transformamos gracias al objeto DTO creado para ello.
        ResponseUserListDTO responseJson = gson.fromJson(responseJsonString, ResponseUserListDTO.class);
        //*************************************************

        //Creamos una lista de objetos JSON
        jsonArray = new JSONArray();
        for (int i = 0; i < responseJson.getValue().size(); i++) {
            JSONObject obj = new JSONObject();
            obj.put("id", responseJson.getValue().get(i).getId());
            obj.put("NOMBRE", responseJson.getValue().get(i).getNombre());
            obj.put("APELLIDOS", responseJson.getValue().get(i).getApellidos());
            obj.put("TELEFONO", responseJson.getValue().get(i).getTelefono());
            obj.put("EMAIL", responseJson.getValue().get(i).getEmail());
            obj.put("DIRECCION", responseJson.getValue().get(i).getDireccion());
            obj.put("IsAdmin", responseJson.getValue().get(i).getIsAdmin());
            jsonArray.put(obj);
        }

        //Creamos un String[] de columnas
        String[] columnNames = {"NOMBRE", "APELLIDOS", "TELEFONO", "EMAIL", "DIRECCION", "IsAdmin"};

        //Creamos el modelo de tabla
        model = new TableUsuarios(jsonArray, columnNames);
        //Asignamos el modelo a la tabla
        jTable.setModel(model);
        //Mostramos la lista
        //Añadimos color a la cabecera.
        JTableHeader header = jTable.getTableHeader();
        header.setBackground(Color.cyan);

    }//GEN-LAST:event_listaUsuariosActionPerformed

    private void jButtonCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarSesionActionPerformed
        /**
         * Metodo para cerrar la sesion y volver a inicio.
         * @Author Carlos.
         */
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

    private void eliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarUsuarioActionPerformed
        /**
         * metodo para eliminar un usuario de la aplicacion.
         * @Author Carlos.
         *
         */

        //Obtenemos la fila seleccionada.
        int posicion = jTable.getSelectedRow();

        if (posicion == -1) {
            // No se ha seleccionado un usuario de la tabla
            // Mostramos mensaje emergente de informacion.
            JOptionPane.showMessageDialog(this,
                    "Primero debes seleccionar un\n"
                    + "usuario en la lista de usuarios",
                    "ELIMINAR USUARIO", JOptionPane.INFORMATION_MESSAGE);

        } else {
            // Se ha seleccionado un usuario
            // Creamos un objeto JSON temporal de la fila seleccionada.
            JSONObject obj = new JSONObject();
            obj = jsonArray.getJSONObject(posicion);

            // Mostramos mensaje emergente de confirmacion.
            int opcion = JOptionPane.showConfirmDialog(this,
                    "Deseas eliminar el usuario\n"
                    + obj.get("NOMBRE") + " "
                    + obj.getString("APELLIDOS") + " ?",
                    "ELIMINAR USUARIO",
                    JOptionPane.YES_NO_OPTION);

            if (opcion == JOptionPane.YES_OPTION) {
                //Eliminamos usuario.
                //1º obtenemos su id .
                UUID id = (UUID) obj.get("id");
                //****************************************************************
                // Creamos el cliente de acceso
                Client client = ClientBuilder.newClient();

                // Creamos el target (URL)
                WebTarget target = client.target(Constants.urlUsersDeleteId
                        + id + "?token=" + Constants.token);

                // Creamos la solicitud
                Invocation.Builder solicitud = target.request();

                // Enviamos nuestro peticion DELETE a la API
                Response deleteUser = solicitud.delete();

                // Recibimos la respuesta del servidor.
                String responseJsonString = deleteUser.readEntity(String.class);

                //Covertimos el JsonString en un objeto JSON.
                JSONObject json = new JSONObject(responseJsonString);
                System.out.println(json.getString("message"));

                // Si todo ha salido correcto.
                if (deleteUser.getStatus() == 200) {
                    // Mostramos mensaje emergente de informacion.
                    JOptionPane.showMessageDialog(this,
                            "Usuario eliminado correctamente.",
                            "ELIMINAR USUARIO", JOptionPane.INFORMATION_MESSAGE);

                    //****************************************************************
                } else {
                    // Si ha habido error en la operacion.
                    // Mostramos mensaje emergente de informacion.
                    JOptionPane.showMessageDialog(this,
                            "Ha ocurrido un error inesperado.",
                            "ELIMINAR USUARIO", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_eliminarUsuarioActionPerformed

    private void modificarRolUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarRolUsuarioActionPerformed
        /**
         * Metodo para modificar el ROL del usuario
         *
         * administrador o usuario.
         * @Author Carlos.
         */

        //Obtenemos la fila seleccionada.
        int posicion = jTable.getSelectedRow();

        if (posicion == -1) {
            // No se ha seleccionado un usuario de la tabla
            // Mostramos mensaje emergente de informacion.
            JOptionPane.showMessageDialog(this,
                    "Primero debes seleccionar un\n"
                    + "usuario en la lista de usuarios",
                    "MODIFICAR ROL USUARIO", JOptionPane.INFORMATION_MESSAGE);

        } else {

            // Se ha seleccionado un usuario
            // Creamos un objeto JSON temporal de la fila seleccionada.
            JSONObject obj = new JSONObject();
            obj = jsonArray.getJSONObject(posicion);

            //Obtenemos su id.
            UUID id = (UUID) obj.get("id");

            //Comprobamos que tipo de usuario es.
            //Si es un administrador...
            if ((obj.getBoolean("IsAdmin")) == true) {

                // Mostramos mensaje emergente de confirmacion.
                int opcion = JOptionPane.showConfirmDialog(null,
                        "  Usuario ADMINISTRADOR.\n"
                        + "Deseas cambiarlo a USUARIO?",
                        "CONFIRMACION", 0);

                //Si opcion es SI...
                if (opcion == 0) {
                    //Cambiamos su ROL a usuario.
                    Boolean admin = false;
                    try {
                        // Creamos la URL.
                        URL url = new URL(Constants.urlUpdateUsuarioAdmin + id + "/" + admin + "?token=" + Constants.token);
                        //Creamos la conexion al servidor.
                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                        //Metodo PUT
                        conn.setDoOutput(true);
                        conn.setRequestMethod("PUT");
                        // Si todo ha salido correcto.
                        if (conn.getResponseCode() == 200) {
                            // Mostramos mensaje emergente de informacion.
                            JOptionPane.showMessageDialog(this,
                                    "ROL del usuario modificado correctamente.",
                                    "MODIFICAR ROL USUARIO", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } catch (MalformedURLException ex) {
                        Logger.getLogger(VentanaGestionUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(VentanaGestionUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    //No hacemos nada.                    
                }
            } else { //Si es Usuario...
                // Mostramos mensaje emergente de confirmacion.
                int opcion = JOptionPane.showConfirmDialog(null,
                        "          Es un USUARIO.\n"
                        + "Deseas cambiarlo a ADMINISTRADOR?",
                        "CONFIRMACION", 0);

                //Si opcion es SI...
                if (opcion == 0) {
                    //Cambiamos su ROL a administrador.
                    Boolean admin = true;
                    try {
                        // Creamos la URL.
                        URL url = new URL(Constants.urlUpdateUsuarioAdmin + id + "/" + admin + "?token=" + Constants.token);
                        //Creamos la conexion al servidor.
                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                        //Metodo PUT
                        conn.setDoOutput(true);
                        conn.setRequestMethod("PUT");
                        // Si todo ha salido correcto.
                        if (conn.getResponseCode() == 200) {
                            // Mostramos mensaje emergente de informacion.
                            JOptionPane.showMessageDialog(this,
                                    "ROL del usuario modificado correctamente.",
                                    "MODIFICAR ROL USUARIO", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } catch (MalformedURLException ex) {
                        Logger.getLogger(VentanaGestionUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(VentanaGestionUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    //No hacemos nada.                    
                }
            }
        }
    }//GEN-LAST:event_modificarRolUsuarioActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton eliminarUsuario;
    private javax.swing.JButton jButtonCerrarSesion;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPanel jPanelGestionUsuarios;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JButton listaUsuarios;
    private javax.swing.JTextArea mensajeGestionUsuarios;
    private javax.swing.JButton modificarRolUsuario;
    private javax.swing.JLabel textLogo;
    // End of variables declaration//GEN-END:variables

}
