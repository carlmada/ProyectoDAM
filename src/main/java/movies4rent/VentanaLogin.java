package movies4rent;

import Modelos.DTOS.LoginUserDTO;
import Modelos.DTOS.ResponseLoginDTO;
import com.google.gson.Gson;
import utils.Constants;
import javax.swing.JOptionPane;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * Ventana para hacer el login
 * a la aplicacion.
 * 
 * @author Carlos
 */
public class VentanaLogin extends javax.swing.JFrame {

    public static String user;
    public static String pass;

    /**
     * Constructor de un nuevo formulario Inicio
     */
    public VentanaLogin() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * Metodo que llama el constructor para inicializar el formulario.
     * Este metodo se regenera automaticamente por el Editor de formularios.
     * 
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panelinicio = new javax.swing.JPanel();
        textLogo = new javax.swing.JLabel();
        mensajeBienvenida = new javax.swing.JTextArea();
        labelUsuario = new javax.swing.JLabel();
        textUsuario = new javax.swing.JTextField();
        labelContraseña = new javax.swing.JLabel();
        textPassword = new javax.swing.JPasswordField();
        buttonEntrar = new javax.swing.JButton();
        buttonNuevoUsuario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MOVIES4RENT");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(0, 0));
        setResizable(false);

        Panelinicio.setBackground(new java.awt.Color(255, 255, 255));
        Panelinicio.setPreferredSize(new java.awt.Dimension(800, 400));

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
        mensajeBienvenida.setText("       Bienvenido a MOVIES4RENT\nDebes iniciar sesion para poder acceder");
        mensajeBienvenida.setBorder(null);
        mensajeBienvenida.setSelectionColor(new java.awt.Color(255, 255, 255));

        labelUsuario.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        labelUsuario.setText("Usuario");

        textUsuario.setBackground(java.awt.SystemColor.control);
        textUsuario.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        textUsuario.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textUsuario.setToolTipText("");
        textUsuario.setAutoscrolls(false);
        textUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textUsuario.setMinimumSize(new java.awt.Dimension(30, 20));

        labelContraseña.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        labelContraseña.setText("Contraseña");

        textPassword.setBackground(java.awt.SystemColor.control);
        textPassword.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        textPassword.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        buttonEntrar.setBackground(new java.awt.Color(153, 204, 255));
        buttonEntrar.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        buttonEntrar.setText("ENTRAR");
        buttonEntrar.setBorderPainted(false);
        buttonEntrar.setFocusable(false);
        buttonEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEntrarActionPerformed(evt);
            }
        });

        buttonNuevoUsuario.setBackground(new java.awt.Color(153, 204, 255));
        buttonNuevoUsuario.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        buttonNuevoUsuario.setText("NUEVO USUARIO");
        buttonNuevoUsuario.setBorderPainted(false);
        buttonNuevoUsuario.setFocusable(false);
        buttonNuevoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNuevoUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelinicioLayout = new javax.swing.GroupLayout(Panelinicio);
        Panelinicio.setLayout(PanelinicioLayout);
        PanelinicioLayout.setHorizontalGroup(
            PanelinicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelinicioLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(textLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(PanelinicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(textPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelContraseña)
                    .addComponent(textUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelUsuario)
                    .addComponent(mensajeBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonNuevoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(268, 268, 268))
        );
        PanelinicioLayout.setVerticalGroup(
            PanelinicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelinicioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelinicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mensajeBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textLogo))
                .addGap(36, 36, 36)
                .addComponent(labelUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelContraseña)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(buttonEntrar)
                .addGap(34, 34, 34)
                .addComponent(buttonNuevoUsuario)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panelinicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panelinicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo que se ejecuta al clicar
     * en el boton ENTRAR del formulario.
     * 
     * Operacion de login al servidor.
     * 
     */
    private void buttonEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEntrarActionPerformed
        // TODO add your handling code here:
        user = textUsuario.getText();
        char[] password = textPassword.getPassword();
        pass = new String(password);

        //Creamos el cliente de login
        Client client = ClientBuilder.newClient();
        //Creamos el target (URL)
        WebTarget target = client.target(Constants.urlLogin);
        //Creamos la solicitud
        Invocation.Builder solicitud = target.request();
        //Creamos el objeto que espera el servidor
        LoginUserDTO loginUser = new LoginUserDTO();
        //Asignamos los valores
        loginUser.setPassword(pass);
        loginUser.setUsername(user);
        //Creamos una instancia de Gson para convertir nuestro String a JSON
        Gson gson = new Gson();
        String jsonString = gson.toJson(loginUser);

        //Enviamos nuestro json via POST a la API
        Response post = solicitud.post(Entity.json(jsonString));

        //Recibimos la respuesta y la leemos en una clase String
        String responseJsonString = post.readEntity(String.class);
        //El string es un json que lo convertimos en un objeto de java
        ResponseLoginDTO responseJson = gson.fromJson(responseJsonString, ResponseLoginDTO.class);
        switch (post.getStatus()) {
            case 200:
                //Si conexion es correcta
                System.out.println(responseJson.getMessage());
                System.out.println("token: " + responseJson.getValue().getToken());
                System.out.println("is admin: " + responseJson.getValue().isAdmin());

                //Asignamos el token a la variable global.
                Constants.token = responseJson.getValue().getToken();
                // Comprobamos si es administrador o usuario
                // y lo dirigimos a su ventana correspondiente.
                if (responseJson.getValue().isAdmin()) {
                    //Ventana administrador.
                    System.out.println("entras admin");
                    VentanaAdmin ventanaAdmin = new VentanaAdmin();
                    ventanaAdmin.setVisible(true);
                    this.dispose();
                } else {
                    //Ventana usuario.
                    System.out.println("entras user");
                    VentanaUsuario ventanaUsuario = new VentanaUsuario();
                    ventanaUsuario.setVisible(true);
                    this.dispose();
                }
                break;
            default:
                System.out.println("Error de Login");
                // Mostramos mensaje emergente de informacion.
                JOptionPane.showMessageDialog(this,
                        "     Error de Login.\nVuelve a iniciar sesion.",
                        "INFORMACION", JOptionPane.ERROR_MESSAGE);
                break;

        }
    }//GEN-LAST:event_buttonEntrarActionPerformed

    /**
     * Metodo que se ejecuta al clicar
     * en el boton NUEVO USUARIO del formulario.
     * 
     * Conduce a la ventana de registro de nuevo usuario.
     * 
     */
    private void buttonNuevoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNuevoUsuarioActionPerformed
        VentanaNuevoUsuario ventanaNuevoUsuario = new VentanaNuevoUsuario();
        ventanaNuevoUsuario.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonNuevoUsuarioActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panelinicio;
    private javax.swing.JButton buttonEntrar;
    private javax.swing.JButton buttonNuevoUsuario;
    private javax.swing.JLabel labelContraseña;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JTextArea mensajeBienvenida;
    private javax.swing.JLabel textLogo;
    private javax.swing.JPasswordField textPassword;
    private javax.swing.JTextField textUsuario;
    // End of variables declaration//GEN-END:variables
}
