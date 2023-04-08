package Pantalla.alquiler;

import Modelos.DTOS.ResponseLogoutDTO;
import Modelos.DTOS.peliculas.DTO.ResponseAlquilerListDTO;
import Modelos.DTOS.peliculas.DTO.ResponseAlquilerPeliculaDTO;
import Modelos.DTOS.peliculas.DTO.ResponsePeliculaListDTO;
import Modelos.DTOS.usuarios.DTO.ResponseUserInfoDTO;
import Modelos.DTOS.usuarios.DTO.ResponseUserListDTO;
import Pantallas.VentanaAdmin;
import Pantallas.VentanaLogin;
import com.google.gson.Gson;
import java.awt.Color;
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
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import utils.Constants;
import utils.TableAlquileres;
import utils.TablePeliculas;
import utils.TableUsuarios;

/**
 *
 * Ventana para realizar la gestión de los alquileres de las peliculas desde la parte de usuario administrador.
 *
 * @author Carlos
 *
 */
public class VentanaGestionAlquilerPeliculas extends javax.swing.JFrame {

    //Variable de Clase.
    TablePeliculas modelPeliculas;
    TableUsuarios modelUsuarios;
    TableAlquileres modelAlquileres;
    JSONArray jsonArrayPeliculas, jsonArrayUsuarios, jsonArrayAlquileres;
    int posicionPelicula, posicionUsuario, posicionAlquiler;
    UUID idPelicula, idUsuario, alquilerId;

    /**
     * Constructor de un nuevo formulario Ventana de gestion de alquileres de peliculas.
     */
    public VentanaGestionAlquilerPeliculas() {
        initComponents();
        jLabelPeliculas.setVisible(false);
        jLabelUsuarios.setVisible(false);

        //Obtenemos el nombre del usuario para mostrarlo.
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

        jPanelGestionAlquilerPeliculas = new javax.swing.JPanel();
        textLogo = new javax.swing.JLabel();
        mensajeAlquilerPeliculas = new javax.swing.JTextArea();
        jButtonCerrarSesion = new javax.swing.JButton();
        jLabelUsuario = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        listaPeliculasUsuarios = new javax.swing.JButton();
        modificarAlquiler = new javax.swing.JButton();
        eliminarAlquilerPelicula = new javax.swing.JButton();
        jButtonVolver = new javax.swing.JButton();
        alquilarPelicula = new javax.swing.JButton();
        jScrollPanePeliculas = new javax.swing.JScrollPane();
        jTablePeliculas = new javax.swing.JTable();
        jScrollPaneUsuarios = new javax.swing.JScrollPane();
        jTableUsuarios = new javax.swing.JTable();
        jLabelPeliculas = new javax.swing.JLabel();
        jLabelUsuarios = new javax.swing.JLabel();
        listaAlquileresPeliculas = new javax.swing.JButton();
        jScrollPaneAlquileres = new javax.swing.JScrollPane();
        jTableAlquileres = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GESTION DE ALQUILER DE PELICULASPELICULAS");
        setResizable(false);

        jPanelGestionAlquilerPeliculas.setBackground(new java.awt.Color(255, 255, 255));
        jPanelGestionAlquilerPeliculas.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jPanelGestionAlquilerPeliculas.setPreferredSize(new java.awt.Dimension(800, 400));

        textLogo.setBackground(new java.awt.Color(255, 255, 255));
        textLogo.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        textLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textLogo.setText("MOVIES4RENT");
        textLogo.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.black));
        textLogo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        mensajeAlquilerPeliculas.setEditable(false);
        mensajeAlquilerPeliculas.setColumns(20);
        mensajeAlquilerPeliculas.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        mensajeAlquilerPeliculas.setRows(2);
        mensajeAlquilerPeliculas.setText("    ALQUILER DE PELICULAS");
        mensajeAlquilerPeliculas.setBorder(null);
        mensajeAlquilerPeliculas.setSelectionColor(new java.awt.Color(255, 255, 255));

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

        listaPeliculasUsuarios.setBackground(new java.awt.Color(0, 204, 255));
        listaPeliculasUsuarios.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        listaPeliculasUsuarios.setText("Peliculas y Usuarios");
        listaPeliculasUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaPeliculasUsuariosActionPerformed(evt);
            }
        });

        modificarAlquiler.setBackground(new java.awt.Color(255, 153, 51));
        modificarAlquiler.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        modificarAlquiler.setText("Modificar Alquiler");

        eliminarAlquilerPelicula.setBackground(new java.awt.Color(255, 51, 51));
        eliminarAlquilerPelicula.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        eliminarAlquilerPelicula.setText("Eliminar Alquiler de Pelicula");
        eliminarAlquilerPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarAlquilerPeliculaActionPerformed(evt);
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

        alquilarPelicula.setBackground(new java.awt.Color(0, 204, 102));
        alquilarPelicula.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        alquilarPelicula.setText("Alquilar Pelicula");
        alquilarPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alquilarPeliculaActionPerformed(evt);
            }
        });

        jScrollPanePeliculas.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPanePeliculas.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPanePeliculas.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPanePeliculas.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N

        jTablePeliculas.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jTablePeliculas.setFillsViewportHeight(true);
        jTablePeliculas.setFocusable(false);
        jTablePeliculas.setGridColor(new java.awt.Color(153, 153, 153));
        jTablePeliculas.setSelectionBackground(new java.awt.Color(102, 204, 255));
        jScrollPanePeliculas.setViewportView(jTablePeliculas);

        jScrollPaneUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPaneUsuarios.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPaneUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPaneUsuarios.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N

        jTableUsuarios.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jTableUsuarios.setFillsViewportHeight(true);
        jTableUsuarios.setFocusable(false);
        jTableUsuarios.setGridColor(new java.awt.Color(153, 153, 153));
        jTableUsuarios.setSelectionBackground(new java.awt.Color(102, 204, 255));
        jScrollPaneUsuarios.setViewportView(jTableUsuarios);

        jLabelPeliculas.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabelPeliculas.setText("Peliculas");

        jLabelUsuarios.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabelUsuarios.setText("Usuarios");

        listaAlquileresPeliculas.setBackground(new java.awt.Color(0, 204, 255));
        listaAlquileresPeliculas.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        listaAlquileresPeliculas.setText("Lista de Alquileres");
        listaAlquileresPeliculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaAlquileresPeliculasActionPerformed(evt);
            }
        });

        jScrollPaneAlquileres.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPaneAlquileres.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPaneAlquileres.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPaneAlquileres.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N

        jTableAlquileres.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jTableAlquileres.setFillsViewportHeight(true);
        jTableAlquileres.setFocusable(false);
        jTableAlquileres.setGridColor(new java.awt.Color(153, 153, 153));
        jTableAlquileres.setSelectionBackground(new java.awt.Color(102, 204, 255));
        jScrollPaneAlquileres.setViewportView(jTableAlquileres);

        javax.swing.GroupLayout jPanelGestionAlquilerPeliculasLayout = new javax.swing.GroupLayout(jPanelGestionAlquilerPeliculas);
        jPanelGestionAlquilerPeliculas.setLayout(jPanelGestionAlquilerPeliculasLayout);
        jPanelGestionAlquilerPeliculasLayout.setHorizontalGroup(
            jPanelGestionAlquilerPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGestionAlquilerPeliculasLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanelGestionAlquilerPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(eliminarAlquilerPelicula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(modificarAlquiler, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(listaPeliculasUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(alquilarPelicula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(listaAlquileresPeliculas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanelGestionAlquilerPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelGestionAlquilerPeliculasLayout.createSequentialGroup()
                        .addGroup(jPanelGestionAlquilerPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelGestionAlquilerPeliculasLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(mensajeAlquilerPeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelUsuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 197, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGestionAlquilerPeliculasLayout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(jPanelGestionAlquilerPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGestionAlquilerPeliculasLayout.createSequentialGroup()
                                        .addComponent(jButtonVolver)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButtonCerrarSesion))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGestionAlquilerPeliculasLayout.createSequentialGroup()
                                        .addComponent(jScrollPanePeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPaneUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addGap(6, 6, 6)))))
                        .addGap(63, 63, 63))
                    .addGroup(jPanelGestionAlquilerPeliculasLayout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(jLabelPeliculas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelUsuarios)
                        .addGap(158, 158, 158))))
            .addGroup(jPanelGestionAlquilerPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelGestionAlquilerPeliculasLayout.createSequentialGroup()
                    .addGap(247, 247, 247)
                    .addComponent(jScrollPaneAlquileres, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(140, Short.MAX_VALUE)))
        );
        jPanelGestionAlquilerPeliculasLayout.setVerticalGroup(
            jPanelGestionAlquilerPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGestionAlquilerPeliculasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelGestionAlquilerPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textLogo)
                    .addComponent(mensajeAlquilerPeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelUsuario)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanelGestionAlquilerPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listaPeliculasUsuarios)
                    .addComponent(jLabelPeliculas)
                    .addComponent(jLabelUsuarios))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelGestionAlquilerPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelGestionAlquilerPeliculasLayout.createSequentialGroup()
                        .addGroup(jPanelGestionAlquilerPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPaneUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelGestionAlquilerPeliculasLayout.createSequentialGroup()
                                .addComponent(listaAlquileresPeliculas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(alquilarPelicula)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(eliminarAlquilerPelicula)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(modificarAlquiler)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                        .addGroup(jPanelGestionAlquilerPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonCerrarSesion)
                            .addComponent(jButtonVolver)))
                    .addGroup(jPanelGestionAlquilerPeliculasLayout.createSequentialGroup()
                        .addComponent(jScrollPanePeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanelGestionAlquilerPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelGestionAlquilerPeliculasLayout.createSequentialGroup()
                    .addGap(81, 81, 81)
                    .addComponent(jScrollPaneAlquileres, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(101, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelGestionAlquilerPeliculas, 965, 965, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelGestionAlquilerPeliculas, 451, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    /**
     *
     * Método para crear las tablas que muestren las peliculas y los usuarios para poder seleccionarlos.
     *
     */
    private void listaPeliculasUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaPeliculasUsuariosActionPerformed
        
        
        //Mostramos lo diferentes elementos.
        jLabelPeliculas.setVisible(true);
        jLabelUsuarios.setVisible(true);
        //Tabla peliculas.
        jScrollPanePeliculas.setVisible(true);
        jTablePeliculas.setVisible(true);
        //Tabla Usuarios.
        jScrollPaneUsuarios.setVisible(true);
        jTableUsuarios.setVisible(true);

        jScrollPaneAlquileres.setVisible(false);
        jTableAlquileres.setVisible(false);
        
        
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
        String[] columnNamesPeliculas = {"TITULO", "DIRECTOR", "PRECIO"};

        //Creamos el modelo de tabla
        modelPeliculas = new TablePeliculas(jsonArrayPeliculas, columnNamesPeliculas);
        //Asignamos el modelo a la tabla
        jTablePeliculas.setModel(modelPeliculas);
        //Mostramos la tabla
        //Añadimos color a la cabecera.
        JTableHeader header = jTablePeliculas.getTableHeader();
        header.setBackground(Color.LIGHT_GRAY);
        //Ponemos los datos numericos en el lado derecho de la celda.
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
        jTablePeliculas.getColumnModel().getColumn(2).setCellRenderer(renderer);
        //Asignamos el ancho de las columnas.
        jTablePeliculas.getColumnModel().getColumn(0).setPreferredWidth(150);
        jTablePeliculas.getColumnModel().getColumn(2).setPreferredWidth(30);

        //***************************************************
        //Leemos la lista de usuarios.
        StringBuilder resultadoUsuarios = new StringBuilder();
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
                resultadoUsuarios.append(linea);
            }
            // Cerramos la conexion.
            rd.close();
        } catch (MalformedURLException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        // Creamos una instancia de Gson para convertir nuestro String a JSON
        Gson gsonUsuarios = new Gson();

        // Pasamos la respuesta a un String.
        String responseJsonStringUsuarios = resultadoUsuarios.toString();
        System.out.println(responseJsonStringUsuarios);
        //*************************************************
        // El array de objetos JSON lo convertimos en un array de objetos DTO.
        // Lo transformamos gracias al objeto DTO creado para ello.
        ResponseUserListDTO responseJsonUsuarios = gsonUsuarios.fromJson(responseJsonStringUsuarios, ResponseUserListDTO.class);
        //*************************************************

        //Creamos una lista de objetos JSON
        jsonArrayUsuarios = new JSONArray();
        for (int i = 0; i < responseJsonUsuarios.getValue().size(); i++) {
            JSONObject objUsuario = new JSONObject();
            objUsuario.put("id", responseJsonUsuarios.getValue().get(i).getId());
            objUsuario.put("NOMBRE", responseJsonUsuarios.getValue().get(i).getNombre());
            objUsuario.put("APELLIDOS", responseJsonUsuarios.getValue().get(i).getApellidos());
            objUsuario.put("TELEFONO", responseJsonUsuarios.getValue().get(i).getTelefono());
            objUsuario.put("EMAIL", responseJsonUsuarios.getValue().get(i).getEmail());
            objUsuario.put("DIRECCION", responseJsonUsuarios.getValue().get(i).getDireccion());
            objUsuario.put("IsAdmin", responseJsonUsuarios.getValue().get(i).getIsAdmin());
            jsonArrayUsuarios.put(objUsuario);
        }

        //Creamos un String[] de columnas
        String[] columnNames = {"NOMBRE", "APELLIDOS"};

        //Creamos el modelo de tabla
        modelUsuarios = new TableUsuarios(jsonArrayUsuarios, columnNames);
        //Asignamos el modelo a la tabla
        jTableUsuarios.setModel(modelUsuarios);
        //Mostramos la lista
        //Añadimos color a la cabecera.
        JTableHeader headerUsuarios = jTableUsuarios.getTableHeader();
        headerUsuarios.setBackground(Color.LIGHT_GRAY);


    }//GEN-LAST:event_listaPeliculasUsuariosActionPerformed

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

    private void eliminarAlquilerPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarAlquilerPeliculaActionPerformed
        /**
         * metodo para eliminar un alquiler de pelicula de la aplicacion.
         *
         */
        
        //Obtenemos la fila seleccionada de alquileres.
        posicionAlquiler = jTableAlquileres.getSelectedRow();
        
        if (posicionAlquiler == -1) {
            // No se ha seleccionado alquiler de la lista.
            // Mostramos mensaje emergente de informacion.
            JOptionPane.showMessageDialog(this,
                    "Debes seleccionar un alquiler\n"
                    + "de la tabla de alquileres.",
                    "ELIMINAR PELICULA", JOptionPane.INFORMATION_MESSAGE);
        }else{
            // Se ha seleccionado un alquiler de la lista.
            // Creamos objeto JSON temporal de la fila seleccionada.
            JSONObject objAlquiler = new JSONObject();
            objAlquiler = jsonArrayAlquileres.getJSONObject(posicionAlquiler);
            
            //Asignamos el id del alquiler a su variable UUID.
            alquilerId = (UUID) objAlquiler.get("idAlquiler");
            
            // Mostramos mensaje emergente de confirmacion.
            int opcion = JOptionPane.showConfirmDialog(this,
                    "Deseas eliminar el alquiler\n"
                    + objAlquiler.get("idAlquiler") + " ? ",
                    "CONFIRMACION",
                    JOptionPane.YES_NO_OPTION);
            
            if (opcion == JOptionPane.YES_OPTION) {
                //Eliminamos alquiler.
                                
                // Creamos el cliente de acceso
                Client client = ClientBuilder.newClient();

                // Creamos el target (URL)
                WebTarget target = client.target(Constants.urlPeliculasDeleteAlquilerId 
                        +"?alquilerId="+alquilerId
                        +"&token=" + Constants.token);
                
                // Creamos la solicitud
                Invocation.Builder solicitud = target.request();

                // Enviamos nuestro peticion DELETE a la API
                Response deleteAlquiler = solicitud.delete();

                // Recibimos la respuesta del servidor.
                String responseJsonString = deleteAlquiler.readEntity(String.class);

                //Covertimos el JsonString en un objeto JSON.
                JSONObject json = new JSONObject(responseJsonString);
                //System.out.println(json.getString("message"));

                // Si todo ha salido correcto.
                if (deleteAlquiler.getStatus() == 200) {
                    // Mostramos mensaje emergente de informacion.
                    JOptionPane.showMessageDialog(this,
                            "Alquiler eliminado correctamente.",
                            "ELIMINAR ALQUILER", JOptionPane.INFORMATION_MESSAGE);
                    //****************************************************************
                } else {
                    // Si ha habido error en la operacion.
                    // Mostramos mensaje emergente de informacion.
                    JOptionPane.showMessageDialog(this,
                            "Ha ocurrido un error inesperado.",
                            "ELIMINAR ALQUILER", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_eliminarAlquilerPeliculaActionPerformed

    /**
     *
     * Metodo para asignar un alquiler de pelicula a un usuario.
     *
     */
    private void alquilarPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alquilarPeliculaActionPerformed

        //Obtenemos la fila seleccionada de pelicula y usuario..
        posicionPelicula = jTablePeliculas.getSelectedRow();
        posicionUsuario = jTableUsuarios.getSelectedRow();

        if ((posicionPelicula == -1) || (posicionUsuario == -1)) {
            // No se ha seleccionado pelicula y usuario.
            // Mostramos mensaje emergente de informacion.
            JOptionPane.showMessageDialog(this,
                    "Debes seleccionar\n"
                    + "PELICULA y USUARIO\n"
                    + "de las tablas.",
                    "ALQUILAR PELICULA", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Se ha seleccionado una película y un usuario.
            // Creamos dos objetos JSON temporales de las filas seleccionadas.
            JSONObject objPelicula = new JSONObject();
            objPelicula = jsonArrayPeliculas.getJSONObject(posicionPelicula);
            JSONObject objUsuario = new JSONObject();
            objUsuario = jsonArrayUsuarios.getJSONObject(posicionUsuario);

            //Asignamos el id de la pelicula a su variable UUID.
            idPelicula = (UUID) objPelicula.get("id");
            //Asignamos el id del usuario a su variable UUID.
            idUsuario = (UUID) objUsuario.get("id");

            // Mostramos mensaje emergente de confirmacion.
            int opcion = JOptionPane.showConfirmDialog(this,
                    "Deseas alquilar la pelicula\n"
                    + objPelicula.get("TITULO") + "\n"
                    + "al usuario\n"
                    + objUsuario.get("NOMBRE") + " " + objUsuario.get("APELLIDOS") + " ?",
                    "CONFIRMACION",
                    JOptionPane.YES_NO_OPTION);

            if (opcion == JOptionPane.YES_OPTION) {
                //****************************************************************
                // Realizamos la peticion de asignar 
                // la pelicula al usuario.
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
                        
                        /*
                        // Mostramos mensaje emergente de informacion.
                        JOptionPane.showMessageDialog(this,
                                "Pelicula alquilada correctamente.",
                                "ALQUILER PELICULA", JOptionPane.INFORMATION_MESSAGE);
                        // y volvemos a inicio.
                        */
                                                
                        // Mostramos mensaje emergente de informacion.
                        JOptionPane.showMessageDialog(this,
                                "Película alquilada correctamente.\n"
                                +"Titulo: " + objPelicula.get("TITULO")+"\n"
                                +"Usuario: "+ objUsuario.get("NOMBRE") + " " + objUsuario.get("APELLIDOS")+"\n"                                        
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
                //No hacemos nada.
            }
        }
    }//GEN-LAST:event_alquilarPeliculaActionPerformed

    private void listaAlquileresPeliculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaAlquileresPeliculasActionPerformed
        
        //Tabla alquileres.
        jScrollPaneAlquileres.setVisible(true);
        jTableAlquileres.setVisible(true);
        
        //cerramos las otras listas.
        jScrollPanePeliculas.setVisible(false);
        jScrollPaneUsuarios.setVisible(false);
        jLabelPeliculas.setVisible(false);
        jLabelUsuarios.setVisible(false);
        
               
        //Leemos la lista de peliculas.
        StringBuilder resultadoAlquileres = new StringBuilder();
        try {
            // Creamos la URL
            URL url = new URL(Constants.urlPeliculasAlquileres + "?token=" + Constants.token);
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
                resultadoAlquileres.append(linea);
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
        String responseJsonString = resultadoAlquileres.toString();
        System.out.println(responseJsonString);
        //*************************************************
        // El array de objetos JSON lo convertimos en un array de objetos DTO.
        // Lo transformamos gracias al objeto DTO creado para ello.
        ResponseAlquilerListDTO responseJson = gson.fromJson(responseJsonString, ResponseAlquilerListDTO.class);
        //*************************************************

        //Creamos una lista de objetos JSON
        jsonArrayAlquileres = new JSONArray();
        for (int i = 0; i < responseJson.getValue().size(); i++) {
            JSONObject objAlquiler = new JSONObject();
            objAlquiler.put("idAlquiler", responseJson.getValue().get(i).getId());
            objAlquiler.put("idPelicula", responseJson.getValue().get(i).getPeliculaId());
            objAlquiler.put("idUsuario", responseJson.getValue().get(i).getUsuariId());
            objAlquiler.put("Fecha Inicio", responseJson.getValue().get(i).getFechaInicio());
            objAlquiler.put("Fecha Fin", responseJson.getValue().get(i).getFechaFin());
            objAlquiler.put("Precio", responseJson.getValue().get(i).getPrecio());
            objAlquiler.put("Estado", responseJson.getValue().get(i).getEstado());
            jsonArrayAlquileres.put(objAlquiler);
        }

        //Creamos un String[] de columnas
        String[] columnNamesPeliculas = {"idAlquiler", "Fecha Inicio", "Fecha Fin", "Estado"};

        //Creamos el modelo de tabla
        modelAlquileres = new TableAlquileres(jsonArrayAlquileres, columnNamesPeliculas);
        //Asignamos el modelo a la tabla
        jTableAlquileres.setModel(modelAlquileres);
        //Mostramos la tabla
        //Añadimos color a la cabecera.
        JTableHeader header = jTableAlquileres.getTableHeader();
        header.setBackground(Color.LIGHT_GRAY);
        
        //Ponemos los datos numericos en el lado derecho de la celda.
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
        jTableAlquileres.getColumnModel().getColumn(1).setCellRenderer(renderer);
        jTableAlquileres.getColumnModel().getColumn(2).setCellRenderer(renderer);
        jTableAlquileres.getColumnModel().getColumn(3).setCellRenderer(renderer);
        //Asignamos el ancho de la columna id.
        jTableAlquileres.getColumnModel().getColumn(0).setPreferredWidth(250);
               
    }//GEN-LAST:event_listaAlquileresPeliculasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alquilarPelicula;
    private javax.swing.JButton eliminarAlquilerPelicula;
    private javax.swing.JButton jButtonCerrarSesion;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JLabel jLabelPeliculas;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JLabel jLabelUsuarios;
    private javax.swing.JPanel jPanelGestionAlquilerPeliculas;
    private javax.swing.JScrollPane jScrollPaneAlquileres;
    private javax.swing.JScrollPane jScrollPanePeliculas;
    private javax.swing.JScrollPane jScrollPaneUsuarios;
    private javax.swing.JTable jTableAlquileres;
    private javax.swing.JTable jTablePeliculas;
    private javax.swing.JTable jTableUsuarios;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JButton listaAlquileresPeliculas;
    private javax.swing.JButton listaPeliculasUsuarios;
    private javax.swing.JTextArea mensajeAlquilerPeliculas;
    private javax.swing.JButton modificarAlquiler;
    private javax.swing.JLabel textLogo;
    // End of variables declaration//GEN-END:variables

}
