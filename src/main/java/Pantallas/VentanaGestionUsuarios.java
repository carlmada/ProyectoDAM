package Pantallas;

import Modelos.DTOS.ResponseLogoutDTO;
import Modelos.DTOS.ResponseUserInfoDTO;
import Modelos.DTOS.ResponseUserListDTO;
import Modelos.DTOS.UserListDTO;
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
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
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
     * Metodo que llama el constructor para inicializar el formulario. Este metodo se regenera automaticamente por el Editor de formularios.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelGestionUsuarios = new javax.swing.JPanel();
        textLogo = new javax.swing.JLabel();
        mensajeBienvenida = new javax.swing.JTextArea();
        jButtonCerrarSesion = new javax.swing.JButton();
        jLabelUsuario = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        listaUsuarios = new javax.swing.JButton();
        añadirUsuario = new javax.swing.JButton();
        modificarUsuario = new javax.swing.JButton();
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

        mensajeBienvenida.setEditable(false);
        mensajeBienvenida.setColumns(20);
        mensajeBienvenida.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        mensajeBienvenida.setRows(2);
        mensajeBienvenida.setText("    GESTION DE USUARIOS");
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

        listaUsuarios.setBackground(new java.awt.Color(242, 242, 242));
        listaUsuarios.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        listaUsuarios.setText("Listar Usuarios");
        listaUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaUsuariosActionPerformed(evt);
            }
        });

        añadirUsuario.setBackground(new java.awt.Color(242, 242, 242));
        añadirUsuario.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        añadirUsuario.setText("Añadir Usuarios");

        modificarUsuario.setBackground(new java.awt.Color(242, 242, 242));
        modificarUsuario.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        modificarUsuario.setText("Modificar ROL Usuario");

        eliminarUsuario.setBackground(new java.awt.Color(242, 242, 242));
        eliminarUsuario.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        eliminarUsuario.setText("Eliminar Usuario");
        eliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarUsuarioActionPerformed(evt);
            }
        });

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
                    .addComponent(modificarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(añadirUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                                .addComponent(mensajeBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(mensajeBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addGroup(jPanelGestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelGestionUsuariosLayout.createSequentialGroup()
                        .addComponent(listaUsuarios)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(añadirUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(modificarUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(eliminarUsuario))
                    .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
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
         */

        VentanaAdmin ventanaAdmin = new VentanaAdmin();
        ventanaAdmin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonVolverActionPerformed

    private void listaUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaUsuariosActionPerformed

        /**
         *
         * Método para crear una tabla que muestre la lista de usuarios de la aplicacion.
         */
        //***********************************************
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
                    "CONFIRMACION",
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton añadirUsuario;
    private javax.swing.JButton eliminarUsuario;
    private javax.swing.JButton jButtonCerrarSesion;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPanel jPanelGestionUsuarios;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JButton listaUsuarios;
    private javax.swing.JTextArea mensajeBienvenida;
    private javax.swing.JButton modificarUsuario;
    private javax.swing.JLabel textLogo;
    // End of variables declaration//GEN-END:variables

}
