package movies4rent;

/**
 *
 * @author Carlos
 */
public class VentanaNuevoUsuario extends javax.swing.JFrame {

    /**
     * Creates new form VentanaNuevoUsuario
     */
    public VentanaNuevoUsuario() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
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
        textPasswordNuevoUsuario = new javax.swing.JPasswordField();
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

        buttonRegistroUsuario.setBackground(new java.awt.Color(153, 204, 255));
        buttonRegistroUsuario.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        buttonRegistroUsuario.setText("REGISTRAR");
        buttonRegistroUsuario.setBorderPainted(false);
        buttonRegistroUsuario.setFocusable(false);

        textNombre.setBackground(java.awt.SystemColor.control);
        textNombre.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        textNombre.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textNombre.setToolTipText("");
        textNombre.setAutoscrolls(false);
        textNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textNombre.setMinimumSize(new java.awt.Dimension(30, 20));
        textNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNombreActionPerformed(evt);
            }
        });

        textApellidos.setBackground(java.awt.SystemColor.control);
        textApellidos.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        textApellidos.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textApellidos.setToolTipText("");
        textApellidos.setAutoscrolls(false);
        textApellidos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textApellidos.setMinimumSize(new java.awt.Dimension(30, 20));
        textApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textApellidosActionPerformed(evt);
            }
        });

        textTelefono.setBackground(java.awt.SystemColor.control);
        textTelefono.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        textTelefono.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textTelefono.setToolTipText("");
        textTelefono.setAutoscrolls(false);
        textTelefono.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textTelefono.setMinimumSize(new java.awt.Dimension(30, 20));
        textTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textTelefonoActionPerformed(evt);
            }
        });

        textEmail.setBackground(java.awt.SystemColor.control);
        textEmail.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        textEmail.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textEmail.setToolTipText("");
        textEmail.setAutoscrolls(false);
        textEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textEmail.setMinimumSize(new java.awt.Dimension(30, 20));
        textEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textEmailActionPerformed(evt);
            }
        });

        textDireccion.setBackground(java.awt.SystemColor.control);
        textDireccion.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        textDireccion.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textDireccion.setToolTipText("");
        textDireccion.setAutoscrolls(false);
        textDireccion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textDireccion.setMinimumSize(new java.awt.Dimension(30, 20));
        textDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDireccionActionPerformed(evt);
            }
        });

        textUsername.setBackground(java.awt.SystemColor.control);
        textUsername.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        textUsername.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textUsername.setToolTipText("");
        textUsername.setAutoscrolls(false);
        textUsername.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textUsername.setMinimumSize(new java.awt.Dimension(30, 20));
        textUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textUsernameActionPerformed(evt);
            }
        });

        textPasswordNuevoUsuario.setBackground(java.awt.SystemColor.control);
        textPasswordNuevoUsuario.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        textPasswordNuevoUsuario.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textPasswordNuevoUsuario.setAutoscrolls(false);
        textPasswordNuevoUsuario.setMinimumSize(new java.awt.Dimension(30, 20));

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
                            .addComponent(textPasswordNuevoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(textPasswordNuevoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void textNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNombreActionPerformed

    private void textApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textApellidosActionPerformed

    private void textTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textTelefonoActionPerformed

    private void textEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textEmailActionPerformed

    private void textDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textDireccionActionPerformed

    private void textUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textUsernameActionPerformed

   
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
    private javax.swing.JPasswordField textPasswordNuevoUsuario;
    private javax.swing.JTextField textTelefono;
    private javax.swing.JTextField textUsername;
    // End of variables declaration//GEN-END:variables
}