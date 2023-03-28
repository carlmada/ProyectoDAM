package Pantallas;

import Modelos.DTOS.ResponseUpdateUserDTO;
import Modelos.DTOS.ResponseUserInfoDTO;
import Modelos.DTOS.UpdateUserDTO;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import utils.Constants;
import javax.swing.JOptionPane;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.json.JSONObject;

/**
 *
 * Ventana de modificacion de los datos del usuario.
 *
 * @author Carlos
 */
public class VentanaModificarUsuario extends javax.swing.JFrame {

    /**
     * Constructor de un nuevo formulario Ventana MODIFICAR USUARIO.
     */
    public VentanaModificarUsuario() {
        initComponents();
        setLocationRelativeTo(null);
        //***********************************************
        //Obtenemos el nombre del usuario
        StringBuilder resultado = new StringBuilder();
        try {
            // Creamos la URL con el token del usuario.
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

        jPanelNuevoUsuario = new javax.swing.JPanel();
        textLogo = new javax.swing.JLabel();
        jLabelNuevoUsuario = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelApellidos = new javax.swing.JLabel();
        jLabelTelefono = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jLabelDireccion = new javax.swing.JLabel();
        buttonModificarUsuario = new javax.swing.JButton();
        textNombre = new javax.swing.JTextField();
        textApellidos = new javax.swing.JTextField();
        textTelefono = new javax.swing.JTextField();
        textEmail = new javax.swing.JTextField();
        textDireccion = new javax.swing.JTextField();
        jTextFieldNombre = new javax.swing.JTextField();
        buttonInicio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MODIFICAR USUARIO");
        setResizable(false);

        jPanelNuevoUsuario.setBackground(new java.awt.Color(255, 255, 255));
        jPanelNuevoUsuario.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jPanelNuevoUsuario.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanelNuevoUsuario.setPreferredSize(new java.awt.Dimension(800, 600));

        textLogo.setBackground(new java.awt.Color(255, 255, 255));
        textLogo.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        textLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textLogo.setText("MOVIES4RENT");
        textLogo.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.black));
        textLogo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabelNuevoUsuario.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        jLabelNuevoUsuario.setText("MODIFICAR PERFIL");

        jLabelNombre.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabelNombre.setText("Nombre : ");

        jLabelApellidos.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabelApellidos.setText("Apellidos :");

        jLabelTelefono.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabelTelefono.setText("Teléfono :");

        jLabelEmail.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabelEmail.setText("e-mail :");

        jLabelDireccion.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabelDireccion.setText("Dirección :");

        buttonModificarUsuario.setBackground(new java.awt.Color(153, 204, 255));
        buttonModificarUsuario.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        buttonModificarUsuario.setText("MODIFICAR");
        buttonModificarUsuario.setBorderPainted(false);
        buttonModificarUsuario.setFocusable(false);
        buttonModificarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonModificarUsuarioActionPerformed(evt);
            }
        });

        textNombre.setBackground(java.awt.SystemColor.control);
        textNombre.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        textNombre.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textNombre.setAutoscrolls(false);
        textNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textNombre.setMinimumSize(new java.awt.Dimension(30, 20));

        textApellidos.setBackground(java.awt.SystemColor.control);
        textApellidos.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        textApellidos.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textApellidos.setToolTipText("");
        textApellidos.setAutoscrolls(false);
        textApellidos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textApellidos.setMinimumSize(new java.awt.Dimension(30, 20));

        textTelefono.setBackground(java.awt.SystemColor.control);
        textTelefono.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        textTelefono.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textTelefono.setToolTipText("");
        textTelefono.setAutoscrolls(false);
        textTelefono.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textTelefono.setMinimumSize(new java.awt.Dimension(30, 20));

        textEmail.setBackground(java.awt.SystemColor.control);
        textEmail.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        textEmail.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textEmail.setToolTipText("");
        textEmail.setAutoscrolls(false);
        textEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textEmail.setMinimumSize(new java.awt.Dimension(30, 20));

        textDireccion.setBackground(java.awt.SystemColor.control);
        textDireccion.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        textDireccion.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textDireccion.setToolTipText("");
        textDireccion.setAutoscrolls(false);
        textDireccion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textDireccion.setMinimumSize(new java.awt.Dimension(30, 20));

        jTextFieldNombre.setEditable(false);
        jTextFieldNombre.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldNombre.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jTextFieldNombre.setBorder(null);

        buttonInicio.setBackground(new java.awt.Color(153, 204, 255));
        buttonInicio.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        buttonInicio.setText("INICIO");
        buttonInicio.setBorderPainted(false);
        buttonInicio.setFocusable(false);
        buttonInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInicioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelNuevoUsuarioLayout = new javax.swing.GroupLayout(jPanelNuevoUsuario);
        jPanelNuevoUsuario.setLayout(jPanelNuevoUsuarioLayout);
        jPanelNuevoUsuarioLayout.setHorizontalGroup(
            jPanelNuevoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelNuevoUsuarioLayout.createSequentialGroup()
                .addGroup(jPanelNuevoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelNuevoUsuarioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelNuevoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelEmail)
                            .addComponent(jLabelTelefono)
                            .addComponent(jLabelApellidos)
                            .addComponent(jLabelNombre)
                            .addComponent(jLabelDireccion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 183, Short.MAX_VALUE)
                        .addGroup(jPanelNuevoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNuevoUsuario)
                            .addComponent(buttonModificarUsuario)
                            .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonInicio)))
                    .addGroup(jPanelNuevoUsuarioLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(textLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(125, 125, 125))
        );
        jPanelNuevoUsuarioLayout.setVerticalGroup(
            jPanelNuevoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNuevoUsuarioLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanelNuevoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textLogo)
                    .addComponent(jLabelNuevoUsuario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(jPanelNuevoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelNuevoUsuarioLayout.createSequentialGroup()
                        .addComponent(jLabelNombre)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelApellidos)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelTelefono)
                        .addGap(20, 20, 20)
                        .addComponent(jLabelEmail)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelDireccion))
                    .addGroup(jPanelNuevoUsuarioLayout.createSequentialGroup()
                        .addComponent(textNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(textApellidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(textTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(textEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(textDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44)
                .addComponent(buttonModificarUsuario)
                .addGap(33, 33, 33)
                .addComponent(buttonInicio)
                .addContainerGap(105, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelNuevoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelNuevoUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo que se ejecuta al clicar en el boton MODIFICAR del formulario.
     *
     * Operacion de modificación de los datos del usuario.
     *
     */
    private void buttonModificarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModificarUsuarioActionPerformed
        // Leemos los campos de datos del usuario.

        String nombre = textNombre.getText();
        String apellidos = textApellidos.getText();
        String telefono = textTelefono.getText();
        String email = textEmail.getText();
        String direccion = textDireccion.getText();

        // Mostramos mensaje emergente de confirmacion.
        int opcion
                = JOptionPane.showConfirmDialog(null, "Has introducido:\n\n"
                        + " Nombre: " + nombre + "\n"
                        + " Apellidos: " + apellidos + "\n"
                        + " Telefono: " + telefono + "\n"
                        + " Email: " + email + "\n"
                        + " Direccion:  " + direccion
                        + "\n\n            Es correcto?",
                        "CONFIRMACION", 0);

        //Si es correcto, hacemos la modificacion...
        if (opcion == 0) {

            // Creamos el cliente de login
            Client client = ClientBuilder.newClient();

            // Creamos el target (URL)
            WebTarget target = client.target(Constants.urlUpdateUsuarios + "?token=" + Constants.token);

            // Creamos la solicitud
            Invocation.Builder solicitud = target.request();

            // Creamos el objeto DTO que espera el servidor
            UpdateUserDTO updateUser = new UpdateUserDTO();

            // Asignamos los valores
            updateUser.setNombre(nombre);
            updateUser.setApellidos(apellidos);
            updateUser.setTelefono(telefono);
            updateUser.setEmail(email);
            updateUser.setDireccion(direccion);

            // Creamos una instancia de Gson para convertir nuestro String a JSON
            Gson gson = new Gson();
            // lo pasamos a objeto Json
            String jsonString = gson.toJson(updateUser);

            // Enviamos nuestro json via PUT a la API
            Response post = solicitud.put(Entity.json(jsonString));

            // Recibimos la respuesta y la leemos en una clase String
            String responseJsonString = post.readEntity(String.class);
            
            //Covertimos el JsonString en un objeto JSON.
            JSONObject json = new JSONObject(responseJsonString);
                
            // Si todo ha salido correcto.
            if (post.getStatus() == 200) {
                
                // Mostramos mensaje emergente de informacion.
                JOptionPane.showMessageDialog(this,"        "+
                        json.getString("message")
                        + "\nVolverás a la pantalla de login.",
                        "PERFIL DE USUARIO", JOptionPane.INFORMATION_MESSAGE);
                // Cerramos la ventana de registro. 
                // y volvemos a inicio.
                this.dispose();
                VentanaLogin inicio = new VentanaLogin();
                inicio.setVisible(true);
            } else {
                // Mostramos mensaje emergente de aviso.
                JOptionPane.showMessageDialog(this,
                        json.getString("message") + "\n"
                        + "Vuelve a introducir los datos.",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
                // Limpiamos todos los campos.
                textNombre.setText("");
                textApellidos.setText("");
                textTelefono.setText("");
                textEmail.setText("");
                textDireccion.setText("");
                // Continuamos en ventana de modificacion de perfil.
            }
        } else {
            //Si no es correcto, volvemos atras...
            initComponents();
        }
    }//GEN-LAST:event_buttonModificarUsuarioActionPerformed

    private void buttonInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInicioActionPerformed
        // Cerramos la ventana de registro. 
        // y volvemos a inicio.
        this.dispose();
        VentanaLogin inicio = new VentanaLogin();
        inicio.setVisible(true);

    }//GEN-LAST:event_buttonInicioActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonInicio;
    private javax.swing.JButton buttonModificarUsuario;
    private javax.swing.JLabel jLabelApellidos;
    private javax.swing.JLabel jLabelDireccion;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelNuevoUsuario;
    private javax.swing.JLabel jLabelTelefono;
    private javax.swing.JPanel jPanelNuevoUsuario;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField textApellidos;
    private javax.swing.JTextField textDireccion;
    private javax.swing.JTextField textEmail;
    private javax.swing.JLabel textLogo;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textTelefono;
    // End of variables declaration//GEN-END:variables
}
