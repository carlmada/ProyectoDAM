package Pantallas.usuarios;

import Modelos.DTOS.usuarios.DTO.RegisterUserDTO;
import Pantallas.VentanaLogin;
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
 *
 * Ventana de registro de nuevo usuario.
 *
 * @author Carlos
 */
public class VentanaNuevoUsuario extends javax.swing.JFrame {

    /**
     * Constructor de un nuevo formulario Ventana NUEVO USUARIO.
     */
    public VentanaNuevoUsuario() {
        initComponents();
        setLocationRelativeTo(null);
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
        jLabelUsername = new javax.swing.JLabel();
        jLabelPassword = new javax.swing.JLabel();
        jLabelConfirmPassword = new javax.swing.JLabel();
        buttonRegistroUsuario = new javax.swing.JButton();
        textNombre = new javax.swing.JTextField();
        textApellidos = new javax.swing.JTextField();
        textTelefono = new javax.swing.JTextField();
        textEmail = new javax.swing.JTextField();
        textDireccion = new javax.swing.JTextField();
        textUsername = new javax.swing.JTextField();
        textPassword = new javax.swing.JPasswordField();
        textConfirmPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("NUEVO USUARIO");
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
        jLabelNuevoUsuario.setText("NUEVO USUARIO");

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

        jLabelUsername.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabelUsername.setText("UserName : ");

        jLabelPassword.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabelPassword.setText("Password :");

        jLabelConfirmPassword.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabelConfirmPassword.setText("Confirm Password :");

        buttonRegistroUsuario.setBackground(new java.awt.Color(255, 153, 102));
        buttonRegistroUsuario.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        buttonRegistroUsuario.setText("REGISTRAR");
        buttonRegistroUsuario.setBorderPainted(false);
        buttonRegistroUsuario.setFocusable(false);
        buttonRegistroUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegistroUsuarioActionPerformed(evt);
            }
        });

        textNombre.setBackground(java.awt.SystemColor.control);
        textNombre.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        textNombre.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textNombre.setToolTipText("");
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

        textUsername.setBackground(java.awt.SystemColor.control);
        textUsername.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        textUsername.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textUsername.setToolTipText("");
        textUsername.setAutoscrolls(false);
        textUsername.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textUsername.setMinimumSize(new java.awt.Dimension(30, 20));

        textPassword.setBackground(java.awt.SystemColor.control);
        textPassword.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        textPassword.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textPassword.setAutoscrolls(false);
        textPassword.setMinimumSize(new java.awt.Dimension(30, 20));

        textConfirmPassword.setBackground(java.awt.SystemColor.control);
        textConfirmPassword.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        textConfirmPassword.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textConfirmPassword.setAutoscrolls(false);
        textConfirmPassword.setMinimumSize(new java.awt.Dimension(30, 20));

        javax.swing.GroupLayout jPanelNuevoUsuarioLayout = new javax.swing.GroupLayout(jPanelNuevoUsuario);
        jPanelNuevoUsuario.setLayout(jPanelNuevoUsuarioLayout);
        jPanelNuevoUsuarioLayout.setHorizontalGroup(
            jPanelNuevoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNuevoUsuarioLayout.createSequentialGroup()
                .addGroup(jPanelNuevoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelNuevoUsuarioLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(textLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
                        .addComponent(jLabelNuevoUsuario))
                    .addGroup(jPanelNuevoUsuarioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelDireccion)))
                .addGap(295, 304, Short.MAX_VALUE))
            .addGroup(jPanelNuevoUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelNuevoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelNuevoUsuarioLayout.createSequentialGroup()
                        .addGroup(jPanelNuevoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelEmail)
                            .addComponent(jLabelTelefono)
                            .addComponent(jLabelApellidos)
                            .addComponent(jLabelNombre)
                            .addComponent(jLabelUsername))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelNuevoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonRegistroUsuario))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelNuevoUsuarioLayout.createSequentialGroup()
                        .addGroup(jPanelNuevoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelPassword)
                            .addComponent(jLabelConfirmPassword))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanelNuevoUsuarioLayout.setVerticalGroup(
            jPanelNuevoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNuevoUsuarioLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanelNuevoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelNuevoUsuario)
                    .addComponent(textLogo))
                .addGap(42, 42, 42)
                .addGroup(jPanelNuevoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNombre))
                .addGap(18, 18, 18)
                .addGroup(jPanelNuevoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textApellidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelApellidos))
                .addGap(18, 18, 18)
                .addGroup(jPanelNuevoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textTelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTelefono))
                .addGap(12, 12, 12)
                .addGroup(jPanelNuevoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEmail))
                .addGap(18, 18, 18)
                .addGroup(jPanelNuevoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDireccion)
                    .addComponent(textDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanelNuevoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelUsername))
                .addGap(18, 18, 18)
                .addGroup(jPanelNuevoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPassword))
                .addGap(18, 18, 18)
                .addGroup(jPanelNuevoUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelConfirmPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(buttonRegistroUsuario)
                .addGap(41, 41, 41))
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
     * Metodo que se ejecuta al clicar en el boton REGISTRAR del formulario.
     *
     * Operacion de registro de un nuevo usuario de la aplicacion.
     *
     */
    private void buttonRegistroUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegistroUsuarioActionPerformed
        // Leemos los campos de datos del usuario.

        // 1º Comprobamos que los password sean iguales...
        // Leemos los passwords...
        char[] password = textPassword.getPassword();
        String pass = new String(password);

        char[] passwordConfirmacion = textConfirmPassword.getPassword();
        String passConfirm = new String(passwordConfirmacion);
        // Comparamos...
        if (pass.equals(passConfirm)) {
            // Leemos el resto de campos
            String nombre = textNombre.getText();
            String apellidos = textApellidos.getText();
            String telefono = textTelefono.getText();
            String email = textEmail.getText();
            String direccion = textDireccion.getText();
            String userName = textUsername.getText();

            // Creamos el cliente de login
            Client client = ClientBuilder.newClient();

            // Creamos el target (URL)
            WebTarget target = client.target(Constants.urlRegister);

            // Creamos la solicitud
            Invocation.Builder solicitud = target.request();

            // Creamos el objeto DTO que espera el servidor
            RegisterUserDTO registerUser = new RegisterUserDTO();

            // Asignamos los valores
            registerUser.setNombre(nombre);
            registerUser.setApellidos(apellidos);
            registerUser.setTelefono(telefono);
            registerUser.setEmail(email);
            registerUser.setDireccion(direccion);
            registerUser.setUsername(userName);
            registerUser.setPassword(pass);

            // Creamos una instancia de Gson para convertir nuestro String a JSON
            Gson gson = new Gson();
            // lo pasamos a objeto Json
            String jsonString = gson.toJson(registerUser);
            // System.out.println(jsonString);

            // Enviamos nuestro json via POST a la API
            Response post = solicitud.post(Entity.json(jsonString));

            // Recibimos la respuesta y la leemos en una clase String
            String responseJsonString = post.readEntity(String.class);

            // Si todo ha salido correcto.
            if (post.getStatus() == 200) {
                // Comprobacion por consola.
                System.out.println(responseJsonString);

                // Mostramos mensaje emergente de informacion.
                JOptionPane.showMessageDialog(this,
                        "Usuario registrado correctamente."
                        + "\nVolverás a la pantalla de login.",
                        "NUEVO USUARIO", JOptionPane.INFORMATION_MESSAGE);
                // Cerramos la ventana de registro. 
                // y volvemos a inicio.
                this.dispose();
                VentanaLogin inicio = new VentanaLogin();
                inicio.setVisible(true);
            }else{
                // Mostramos mensaje emergente de aviso.
                JOptionPane.showMessageDialog(this,
                    "Error en entrada de datos.\n"
                    + "Vuelve a introducir los datos.",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
            // Limpiamos todos los campos.
            textPassword.setText("");
            textConfirmPassword.setText("");
            textNombre.setText("");
            textApellidos.setText("");
            textTelefono.setText("");
            textEmail.setText("");
            textDireccion.setText("");
            textUsername.setText("");
            // Continuamos en ventana de nuevo registro.
            }
        } else {
            // Mostramos mensaje emergente de aviso.
            JOptionPane.showMessageDialog(this,
                    "Las contraseñas no coinciden.\n"
                    + "Vuelve a introducir los datos.",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
            // Limpiamos todos los campos.
            textPassword.setText("");
            textConfirmPassword.setText("");
            textNombre.setText("");
            textApellidos.setText("");
            textTelefono.setText("");
            textEmail.setText("");
            textDireccion.setText("");
            textUsername.setText("");
            // Continuamos en ventana de nuevo registro.
        }
    }//GEN-LAST:event_buttonRegistroUsuarioActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonRegistroUsuario;
    private javax.swing.JLabel jLabelApellidos;
    private javax.swing.JLabel jLabelConfirmPassword;
    private javax.swing.JLabel jLabelDireccion;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelNuevoUsuario;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelTelefono;
    private javax.swing.JLabel jLabelUsername;
    private javax.swing.JPanel jPanelNuevoUsuario;
    private javax.swing.JTextField textApellidos;
    private javax.swing.JPasswordField textConfirmPassword;
    private javax.swing.JTextField textDireccion;
    private javax.swing.JTextField textEmail;
    private javax.swing.JLabel textLogo;
    private javax.swing.JTextField textNombre;
    private javax.swing.JPasswordField textPassword;
    private javax.swing.JTextField textTelefono;
    private javax.swing.JTextField textUsername;
    // End of variables declaration//GEN-END:variables
}
