/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.movies4rent;

import java.net.HttpURLConnection;
import java.net.URL;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlos
 */
public class Inicio extends javax.swing.JFrame {

    /**
     * Creates new form Inicio
     */
    public Inicio() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
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
        buttonLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MOVIES4RENT");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(0, 0));

        Panelinicio.setBackground(new java.awt.Color(255, 255, 255));

        textLogo.setBackground(new java.awt.Color(255, 255, 255));
        textLogo.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        textLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textLogo.setText("MOVIES4RENT");
        textLogo.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.black));
        textLogo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        mensajeBienvenida.setEditable(false);
        mensajeBienvenida.setBackground(new java.awt.Color(255, 255, 255));
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

        buttonLogin.setBackground(new java.awt.Color(153, 204, 255));
        buttonLogin.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        buttonLogin.setText("ENTRAR");
        buttonLogin.setBorderPainted(false);
        buttonLogin.setFocusable(false);
        buttonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelinicioLayout = new javax.swing.GroupLayout(Panelinicio);
        Panelinicio.setLayout(PanelinicioLayout);
        PanelinicioLayout.setHorizontalGroup(
            PanelinicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelinicioLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(textLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(PanelinicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(textPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelContraseña)
                    .addComponent(textUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelUsuario)
                    .addComponent(mensajeBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(buttonLogin)
                .addContainerGap(124, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panelinicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panelinicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLoginActionPerformed
        // TODO add your handling code here:
        String user = textUsuario.getText();
        char[] password = textPassword.getPassword();
        String pass = new String(password);

        //System.out.println(user+pass);
        //JOptionPane.showMessageDialog(new JFrame(), "Usuario correcto");
        //System.exit(0);
        try {
            //Creamos la url 
            URL url;
            url = new URL("http://localhost:8080/demo");
            //Creamos la conexion con la url
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //Indicamos el mwetodo de la peticion en la conexion (GET)
            //conn.setRequestMethod("GET");
            //Hacemos la conexion
            conn.connect();

            //Comprovamos la conexion
            int codigoRespuesta = conn.getResponseCode();
            if(codigoRespuesta != 200){
                System.out.println("error de conexion");
            }else{
                System.out.println("conexion establecida");
            }

        } catch (Exception ex) {
                ex.printStackTrace();
        }


    }//GEN-LAST:event_buttonLoginActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panelinicio;
    private javax.swing.JButton buttonLogin;
    private javax.swing.JLabel labelContraseña;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JTextArea mensajeBienvenida;
    private javax.swing.JLabel textLogo;
    private javax.swing.JPasswordField textPassword;
    private javax.swing.JTextField textUsuario;
    // End of variables declaration//GEN-END:variables
}
