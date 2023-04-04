package Pantallas.peliculas;

import Modelos.DTOS.peliculas.DTO.RegisterPeliculaDTO;
import com.google.gson.Gson;
import java.time.LocalDate;
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
 * Ventana de registro de 
 * una nueva pelicula.
 *
 * @author Carlos
 */
public class VentanaNuevaPelicula extends javax.swing.JFrame {

    /**
     * Constructor de un nuevo formulario 
     * Ventana NUEVA PELICULA.
     */
    public VentanaNuevaPelicula() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * Metodo que llama el constructor para inicializar el formulario. 
     * Este metodo se regenera automaticamente por el Editor de formularios.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelNuevaPelicula = new javax.swing.JPanel();
        textLogo = new javax.swing.JLabel();
        jLabelNuevoPelicula = new javax.swing.JLabel();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelDirector = new javax.swing.JLabel();
        jLabelGenero = new javax.swing.JLabel();
        jLabelDuracion = new javax.swing.JLabel();
        jLabelAño = new javax.swing.JLabel();
        jLabelPrecio = new javax.swing.JLabel();
        buttonRegistroPelicula = new javax.swing.JButton();
        textTitulo = new javax.swing.JTextField();
        textDirector = new javax.swing.JTextField();
        textGenero = new javax.swing.JTextField();
        textDuracion = new javax.swing.JTextField();
        textAño = new javax.swing.JTextField();
        textPrecio = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("NUEVA PELICULA");
        setResizable(false);

        jPanelNuevaPelicula.setBackground(new java.awt.Color(255, 255, 255));
        jPanelNuevaPelicula.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jPanelNuevaPelicula.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanelNuevaPelicula.setPreferredSize(new java.awt.Dimension(800, 600));

        textLogo.setBackground(new java.awt.Color(255, 255, 255));
        textLogo.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        textLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textLogo.setText("MOVIES4RENT");
        textLogo.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.black));
        textLogo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabelNuevoPelicula.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        jLabelNuevoPelicula.setText("NUEVA PELICULA");

        jLabelTitulo.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabelTitulo.setText("Titulo:");

        jLabelDirector.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabelDirector.setText("Director:");

        jLabelGenero.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabelGenero.setText("Género:");

        jLabelDuracion.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabelDuracion.setText("Duración:");

        jLabelAño.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabelAño.setText("Año:");

        jLabelPrecio.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabelPrecio.setText("Precio:");

        buttonRegistroPelicula.setBackground(new java.awt.Color(255, 153, 102));
        buttonRegistroPelicula.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        buttonRegistroPelicula.setText("REGISTRAR PELICULA");
        buttonRegistroPelicula.setBorderPainted(false);
        buttonRegistroPelicula.setFocusable(false);
        buttonRegistroPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRegistroPeliculaActionPerformed(evt);
            }
        });

        textTitulo.setBackground(java.awt.SystemColor.control);
        textTitulo.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        textTitulo.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textTitulo.setToolTipText("");
        textTitulo.setAutoscrolls(false);
        textTitulo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textTitulo.setMinimumSize(new java.awt.Dimension(30, 20));

        textDirector.setBackground(java.awt.SystemColor.control);
        textDirector.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        textDirector.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textDirector.setToolTipText("");
        textDirector.setAutoscrolls(false);
        textDirector.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textDirector.setMinimumSize(new java.awt.Dimension(30, 20));

        textGenero.setBackground(java.awt.SystemColor.control);
        textGenero.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        textGenero.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textGenero.setToolTipText("");
        textGenero.setAutoscrolls(false);
        textGenero.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textGenero.setMinimumSize(new java.awt.Dimension(30, 20));

        textDuracion.setBackground(java.awt.SystemColor.control);
        textDuracion.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        textDuracion.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textDuracion.setToolTipText("");
        textDuracion.setAutoscrolls(false);
        textDuracion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textDuracion.setMinimumSize(new java.awt.Dimension(30, 20));

        textAño.setBackground(java.awt.SystemColor.control);
        textAño.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        textAño.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textAño.setToolTipText("");
        textAño.setAutoscrolls(false);
        textAño.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textAño.setMinimumSize(new java.awt.Dimension(30, 20));

        textPrecio.setBackground(java.awt.SystemColor.control);
        textPrecio.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        textPrecio.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textPrecio.setToolTipText("");
        textPrecio.setAutoscrolls(false);
        textPrecio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textPrecio.setMinimumSize(new java.awt.Dimension(30, 20));

        javax.swing.GroupLayout jPanelNuevaPeliculaLayout = new javax.swing.GroupLayout(jPanelNuevaPelicula);
        jPanelNuevaPelicula.setLayout(jPanelNuevaPeliculaLayout);
        jPanelNuevaPeliculaLayout.setHorizontalGroup(
            jPanelNuevaPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNuevaPeliculaLayout.createSequentialGroup()
                .addGroup(jPanelNuevaPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelNuevaPeliculaLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(textLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
                        .addComponent(jLabelNuevoPelicula))
                    .addGroup(jPanelNuevaPeliculaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelAño)))
                .addGap(290, 290, Short.MAX_VALUE))
            .addGroup(jPanelNuevaPeliculaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelNuevaPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDuracion)
                    .addComponent(jLabelGenero)
                    .addComponent(jLabelDirector)
                    .addComponent(jLabelTitulo)
                    .addComponent(jLabelPrecio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelNuevaPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(textTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textDirector, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textAño, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonRegistroPelicula))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelNuevaPeliculaLayout.setVerticalGroup(
            jPanelNuevaPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelNuevaPeliculaLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanelNuevaPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelNuevoPelicula)
                    .addComponent(textLogo))
                .addGap(42, 42, 42)
                .addGroup(jPanelNuevaPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTitulo))
                .addGap(18, 18, 18)
                .addGroup(jPanelNuevaPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textDirector, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDirector))
                .addGap(18, 18, 18)
                .addGroup(jPanelNuevaPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textGenero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelGenero))
                .addGap(12, 12, 12)
                .addGroup(jPanelNuevaPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textDuracion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDuracion))
                .addGap(18, 18, 18)
                .addGroup(jPanelNuevaPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAño)
                    .addComponent(textAño, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanelNuevaPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPrecio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                .addComponent(buttonRegistroPelicula)
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelNuevaPelicula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelNuevaPelicula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo que se ejecuta al clicar en el boton REGISTRAR PELICULA del formulario.
     *
     * Operacion de registro de una nueva pelicula en la aplicacion.
     *
     */
    private void buttonRegistroPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRegistroPeliculaActionPerformed
            // Leemos los campos de datos de la pelicula.
       
            String titulo = textTitulo.getText();
            String director = textDirector.getText();
            String genero = textGenero.getText();
            int duracion = Integer.parseInt(textDuracion.getText());
            int año = Integer.parseInt(textAño.getText());
            int precio = Integer.parseInt(textPrecio.getText());

            // Creamos el cliente de login
            Client client = ClientBuilder.newClient();

            // Creamos el target (URL)
            WebTarget target = client.target(Constants.urlAddPelicula + "?token=" + Constants.token);

            // Creamos la solicitud
            Invocation.Builder solicitud = target.request();

            // Creamos el objeto DTO que espera el servidor
            RegisterPeliculaDTO registerPelicula = new RegisterPeliculaDTO();

            // Asignamos los valores
            registerPelicula.setTitulo(titulo);
            registerPelicula.setDirector(director);
            registerPelicula.setGenero(genero);
            registerPelicula.setDuracion(duracion);
            registerPelicula.setAño(año);
            registerPelicula.setPrecio(precio);
            
            // Creamos una instancia de Gson para convertir nuestro String a JSON
            Gson gson = new Gson();
            // lo pasamos a objeto Json
            String jsonString = gson.toJson(registerPelicula);
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
                        "Pelicula registrada correctamente.",
                        "NUEVA PELICULA", JOptionPane.INFORMATION_MESSAGE);
                // Cerramos la ventana de registro. 
                // y volvemos a inicio.
                this.dispose();
                VentanaGestionPeliculas gestionPeliculas = new VentanaGestionPeliculas();
                gestionPeliculas.setVisible(true);
            }else{
                // Mostramos mensaje emergente de aviso.
                JOptionPane.showMessageDialog(this,
                    "Error en entrada de datos.\n"
                    + "Vuelve a introducir los datos.",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
            // Limpiamos todos los campos.
            textTitulo.setText("");
            textDirector.setText("");
            textGenero.setText("");
            textDuracion.setText("");
            textAño.setText("");
            textPrecio.setText("");
            }
    }//GEN-LAST:event_buttonRegistroPeliculaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonRegistroPelicula;
    private javax.swing.JLabel jLabelAño;
    private javax.swing.JLabel jLabelDirector;
    private javax.swing.JLabel jLabelDuracion;
    private javax.swing.JLabel jLabelGenero;
    private javax.swing.JLabel jLabelNuevoPelicula;
    private javax.swing.JLabel jLabelPrecio;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanelNuevaPelicula;
    private javax.swing.JTextField textAño;
    private javax.swing.JTextField textDirector;
    private javax.swing.JTextField textDuracion;
    private javax.swing.JTextField textGenero;
    private javax.swing.JLabel textLogo;
    private javax.swing.JTextField textPrecio;
    private javax.swing.JTextField textTitulo;
    // End of variables declaration//GEN-END:variables
}
