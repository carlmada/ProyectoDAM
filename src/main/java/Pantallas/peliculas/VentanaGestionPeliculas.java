package Pantallas.peliculas;

import Modelos.DTOS.ResponseLogoutDTO;
import Modelos.DTOS.peliculas.DTO.ResponsePeliculaListDTO;
import Modelos.DTOS.peliculas.DTO.UpdatePeliculaDTO;
import Modelos.DTOS.usuarios.DTO.ResponseUserInfoDTO;
import Modelos.DTOS.usuarios.DTO.ResponseUserListDTO;
import Pantallas.VentanaAdmin;
import Pantallas.VentanaLogin;
import com.google.gson.Gson;
import java.awt.Color;
import static java.awt.Label.RIGHT;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import utils.Constants;
import utils.TablePeliculas;

/**
 *
 * Ventana para realizar la gestión de las peliculas.
 *
 * @author Carlos
 */
public class VentanaGestionPeliculas extends javax.swing.JFrame {

    //Variable de Clase.
    TablePeliculas model;
    JSONArray jsonArray;
    int posicion;
    JSONObject objModificarPelicula;
    UUID idModificarPelicula;

    /**
     * Constructor de un nuevo formulario Ventana de gestion de peliculas.
     */
    public VentanaGestionPeliculas() {
        initComponents();
        panelModificarPelicula.setVisible(false);
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

        jPanelGestionPeliculas = new javax.swing.JPanel();
        textLogo = new javax.swing.JLabel();
        mensajeGestionPeliculas = new javax.swing.JTextArea();
        jButtonCerrarSesion = new javax.swing.JButton();
        jLabelUsuario = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        listaPeliculas = new javax.swing.JButton();
        modificarPelicula = new javax.swing.JButton();
        eliminarPelicula = new javax.swing.JButton();
        jButtonVolver = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        panelModificarPelicula = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelModificarPelicula = new javax.swing.JLabel();
        textTitulo = new javax.swing.JTextField();
        textDirector = new javax.swing.JTextField();
        textGenero = new javax.swing.JTextField();
        textDuracion = new javax.swing.JTextField();
        textAño = new javax.swing.JTextField();
        textPrecio = new javax.swing.JTextField();
        jLabelDirector = new javax.swing.JLabel();
        jLabelGenero = new javax.swing.JLabel();
        jLabelDuracion = new javax.swing.JLabel();
        jLabelAño = new javax.swing.JLabel();
        jLabelPrecio = new javax.swing.JLabel();
        buttonModificarPeliculaConfirmacion = new javax.swing.JButton();
        añadirPelicula = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GESTION DE PELICULAS");
        setResizable(false);

        jPanelGestionPeliculas.setBackground(new java.awt.Color(255, 255, 255));
        jPanelGestionPeliculas.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jPanelGestionPeliculas.setPreferredSize(new java.awt.Dimension(800, 400));

        textLogo.setBackground(new java.awt.Color(255, 255, 255));
        textLogo.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        textLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textLogo.setText("MOVIES4RENT");
        textLogo.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.black));
        textLogo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        mensajeGestionPeliculas.setEditable(false);
        mensajeGestionPeliculas.setColumns(20);
        mensajeGestionPeliculas.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        mensajeGestionPeliculas.setRows(2);
        mensajeGestionPeliculas.setText("    GESTION DE PELICULAS");
        mensajeGestionPeliculas.setBorder(null);
        mensajeGestionPeliculas.setSelectionColor(new java.awt.Color(255, 255, 255));

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

        listaPeliculas.setBackground(new java.awt.Color(0, 204, 255));
        listaPeliculas.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        listaPeliculas.setText("Lista de Peliculas");
        listaPeliculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaPeliculasActionPerformed(evt);
            }
        });

        modificarPelicula.setBackground(new java.awt.Color(255, 153, 51));
        modificarPelicula.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        modificarPelicula.setText("Modificar Pelicula");
        modificarPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarPeliculaActionPerformed(evt);
            }
        });

        eliminarPelicula.setBackground(new java.awt.Color(255, 51, 51));
        eliminarPelicula.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        eliminarPelicula.setText("Eliminar Pelicula");
        eliminarPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarPeliculaActionPerformed(evt);
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

        panelModificarPelicula.setBackground(new java.awt.Color(204, 255, 255));

        jLabelTitulo.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabelTitulo.setText("Titulo : ");

        jLabelModificarPelicula.setBackground(new java.awt.Color(255, 255, 255));
        jLabelModificarPelicula.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        jLabelModificarPelicula.setText("MODIFICAR PELICULA");

        textTitulo.setBackground(java.awt.SystemColor.control);
        textTitulo.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        textTitulo.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textTitulo.setAutoscrolls(false);
        textTitulo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textTitulo.setMinimumSize(new java.awt.Dimension(30, 20));

        textDirector.setBackground(java.awt.SystemColor.control);
        textDirector.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        textDirector.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textDirector.setAutoscrolls(false);
        textDirector.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textDirector.setMinimumSize(new java.awt.Dimension(30, 20));

        textGenero.setBackground(java.awt.SystemColor.control);
        textGenero.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        textGenero.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textGenero.setAutoscrolls(false);
        textGenero.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textGenero.setMinimumSize(new java.awt.Dimension(30, 20));

        textDuracion.setBackground(java.awt.SystemColor.control);
        textDuracion.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        textDuracion.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textDuracion.setAutoscrolls(false);
        textDuracion.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textDuracion.setMinimumSize(new java.awt.Dimension(30, 20));

        textAño.setBackground(java.awt.SystemColor.control);
        textAño.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        textAño.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textAño.setAutoscrolls(false);
        textAño.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textAño.setMinimumSize(new java.awt.Dimension(30, 20));

        textPrecio.setBackground(java.awt.SystemColor.control);
        textPrecio.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        textPrecio.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        textPrecio.setAutoscrolls(false);
        textPrecio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textPrecio.setMinimumSize(new java.awt.Dimension(30, 20));

        jLabelDirector.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabelDirector.setText("Director : ");

        jLabelGenero.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabelGenero.setText("Genero :");

        jLabelDuracion.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabelDuracion.setText("Duracion :");

        jLabelAño.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabelAño.setText("Año :");

        jLabelPrecio.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabelPrecio.setText("Precio :");

        buttonModificarPeliculaConfirmacion.setBackground(new java.awt.Color(255, 153, 51));
        buttonModificarPeliculaConfirmacion.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        buttonModificarPeliculaConfirmacion.setText("MODIFICAR");
        buttonModificarPeliculaConfirmacion.setBorderPainted(false);
        buttonModificarPeliculaConfirmacion.setFocusable(false);
        buttonModificarPeliculaConfirmacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonModificarPeliculaConfirmacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelModificarPeliculaLayout = new javax.swing.GroupLayout(panelModificarPelicula);
        panelModificarPelicula.setLayout(panelModificarPeliculaLayout);
        panelModificarPeliculaLayout.setHorizontalGroup(
            panelModificarPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelModificarPeliculaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelModificarPelicula)
                .addContainerGap(158, Short.MAX_VALUE))
            .addGroup(panelModificarPeliculaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelModificarPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelModificarPeliculaLayout.createSequentialGroup()
                        .addComponent(jLabelPrecio)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelModificarPeliculaLayout.createSequentialGroup()
                        .addGroup(panelModificarPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelModificarPeliculaLayout.createSequentialGroup()
                                .addComponent(jLabelTitulo)
                                .addGap(47, 47, 47)
                                .addComponent(textTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(panelModificarPeliculaLayout.createSequentialGroup()
                                .addGroup(panelModificarPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelDirector)
                                    .addComponent(jLabelGenero)
                                    .addComponent(jLabelDuracion)
                                    .addComponent(jLabelAño))
                                .addGap(28, 28, 28)
                                .addGroup(panelModificarPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textAño, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(textGenero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(textDirector, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(textDuracion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(textPrecio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(34, 34, 34))))
            .addGroup(panelModificarPeliculaLayout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(buttonModificarPeliculaConfirmacion)
                .addContainerGap(157, Short.MAX_VALUE))
        );
        panelModificarPeliculaLayout.setVerticalGroup(
            panelModificarPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelModificarPeliculaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelModificarPelicula)
                .addGap(18, 18, 18)
                .addGroup(panelModificarPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTitulo)
                    .addComponent(textTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelModificarPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDirector)
                    .addComponent(textDirector, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelModificarPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelGenero)
                    .addComponent(textGenero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelModificarPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDuracion)
                    .addComponent(textDuracion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelModificarPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAño)
                    .addComponent(textAño, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelModificarPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPrecio)
                    .addComponent(textPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(buttonModificarPeliculaConfirmacion)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        añadirPelicula.setBackground(new java.awt.Color(0, 204, 102));
        añadirPelicula.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        añadirPelicula.setText("Añadir Pelicula");
        añadirPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirPeliculaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelGestionPeliculasLayout = new javax.swing.GroupLayout(jPanelGestionPeliculas);
        jPanelGestionPeliculas.setLayout(jPanelGestionPeliculasLayout);
        jPanelGestionPeliculasLayout.setHorizontalGroup(
            jPanelGestionPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGestionPeliculasLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanelGestionPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(eliminarPelicula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(modificarPelicula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(listaPeliculas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(añadirPelicula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanelGestionPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanelGestionPeliculasLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonVolver)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonCerrarSesion))
                    .addGroup(jPanelGestionPeliculasLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanelGestionPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGestionPeliculasLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(mensajeGestionPeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(jLabelUsuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(197, 197, 197)))))
                .addGap(63, 63, 63))
            .addGroup(jPanelGestionPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGestionPeliculasLayout.createSequentialGroup()
                    .addContainerGap(245, Short.MAX_VALUE)
                    .addComponent(panelModificarPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(298, 298, 298)))
        );
        jPanelGestionPeliculasLayout.setVerticalGroup(
            jPanelGestionPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGestionPeliculasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelGestionPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelGestionPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelUsuario)
                        .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelGestionPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textLogo)
                        .addComponent(mensajeGestionPeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addGroup(jPanelGestionPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelGestionPeliculasLayout.createSequentialGroup()
                        .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 146, Short.MAX_VALUE)
                        .addGroup(jPanelGestionPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonCerrarSesion)
                            .addComponent(jButtonVolver)))
                    .addGroup(jPanelGestionPeliculasLayout.createSequentialGroup()
                        .addComponent(listaPeliculas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(añadirPelicula)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(eliminarPelicula)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(modificarPelicula)
                        .addGap(0, 224, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanelGestionPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGestionPeliculasLayout.createSequentialGroup()
                    .addContainerGap(68, Short.MAX_VALUE)
                    .addComponent(panelModificarPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelGestionPeliculas, 965, 965, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelGestionPeliculas, 451, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void listaPeliculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaPeliculasActionPerformed

        /**
         *
         * Método para crear una tabla que muestre la lista de las peliculas de la aplicacion.
         */
        //***********************************************
        jScrollPane.setVisible(true);
        jTable.setVisible(true);
        
        StringBuilder resultado = new StringBuilder();
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
        ResponsePeliculaListDTO responseJson = gson.fromJson(responseJsonString, ResponsePeliculaListDTO.class);
        //*************************************************

        //Creamos una lista de objetos JSON
        jsonArray = new JSONArray();
        for (int i = 0; i < responseJson.getValue().size(); i++) {
            JSONObject obj = new JSONObject();
            obj.put("id", responseJson.getValue().get(i).getId());
            obj.put("TITULO", responseJson.getValue().get(i).getTitulo());
            obj.put("DIRECTOR", responseJson.getValue().get(i).getDirector());
            obj.put("GENERO", responseJson.getValue().get(i).getGenero());
            obj.put("DURACION", responseJson.getValue().get(i).getDuracion());
            obj.put("AÑO", responseJson.getValue().get(i).getAño());
            obj.put("PRECIO", responseJson.getValue().get(i).getPrecio());
            jsonArray.put(obj);
        }

        //Creamos un String[] de columnas
        String[] columnNames = {"TITULO", "DIRECTOR", "GENERO","AÑO", "DURACION", "PRECIO" };

        //Creamos el modelo de tabla
        model = new TablePeliculas(jsonArray, columnNames);
        //Asignamos el modelo a la tabla
        jTable.setModel(model);
        //Mostramos la tabla
        //Añadimos color a la cabecera.
        JTableHeader header = jTable.getTableHeader();
        header.setBackground(Color.LIGHT_GRAY);
        //Ponemos los datos numericos en el centro de la celda.
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
        jTable.getColumnModel().getColumn(3).setCellRenderer(renderer);
        jTable.getColumnModel().getColumn(4).setCellRenderer(renderer);
        jTable.getColumnModel().getColumn(5).setCellRenderer(renderer);
        //Asignamos el ancho de las columnas.
        jTable.getColumnModel().getColumn(3).setPreferredWidth(15);
        jTable.getColumnModel().getColumn(4).setPreferredWidth(20);
        jTable.getColumnModel().getColumn(5).setPreferredWidth(15);
    }//GEN-LAST:event_listaPeliculasActionPerformed

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

    private void eliminarPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarPeliculaActionPerformed
        /**
         * metodo para eliminar una pelicula de la aplicacion.
         *
         */

        //Obtenemos la fila seleccionada.
        posicion = jTable.getSelectedRow();

        if (posicion == -1) {
            // No se ha seleccionado ninguna pelicula de la tabla
            // Mostramos mensaje emergente de informacion.
            JOptionPane.showMessageDialog(this,
                    "Primero debes seleccionar una\n"
                    + "película de la lista.",
                    "ELIMINAR PELICULA", JOptionPane.INFORMATION_MESSAGE);

        } else {
            // Se ha seleccionado una película
            // Creamos un objeto JSON temporal de la fila seleccionada.
            JSONObject obj = new JSONObject();
            obj = jsonArray.getJSONObject(posicion);

            // Mostramos mensaje emergente de confirmacion.
            int opcion = JOptionPane.showConfirmDialog(this,
                    "Deseas eliminar la película\n"
                    + obj.get("TITULO") + " ?",
                    "CONFIRMACION",
                    JOptionPane.YES_NO_OPTION);

            if (opcion == JOptionPane.YES_OPTION) {
                //Eliminamos película.
                //1º obtenemos su id .
                UUID id = (UUID) obj.get("id");
                //****************************************************************
                // Creamos el cliente de acceso
                Client client = ClientBuilder.newClient();

                // Creamos el target (URL)
                WebTarget target = client.target(Constants.urlpeliculaDeleteId
                        + id + "?token=" + Constants.token);

                // Creamos la solicitud
                Invocation.Builder solicitud = target.request();

                // Enviamos nuestro peticion DELETE a la API
                Response deletePelicula = solicitud.delete();

                // Recibimos la respuesta del servidor.
                String responseJsonString = deletePelicula.readEntity(String.class);

                //Covertimos el JsonString en un objeto JSON.
                JSONObject json = new JSONObject(responseJsonString);
                System.out.println(json.getString("message"));

                // Si todo ha salido correcto.
                if (deletePelicula.getStatus() == 200) {
                    // Mostramos mensaje emergente de informacion.
                    JOptionPane.showMessageDialog(this,
                            "Película eliminada correctamente.",
                            "ELIMINAR PELICULA", JOptionPane.INFORMATION_MESSAGE);

                    //****************************************************************
                } else {
                    // Si ha habido error en la operacion.
                    // Mostramos mensaje emergente de informacion.
                    JOptionPane.showMessageDialog(this,
                            "Ha ocurrido un error inesperado.",
                            "ELIMINAR PELICULA", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_eliminarPeliculaActionPerformed

    private void modificarPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarPeliculaActionPerformed
        /**
         *
         * Metodo que se ejecuta al clicar en el boton MODIFICAR PELICULA.
         *
         * Operacion de modificación de los datos de la pelicula. *
         *
         */

        //Obtenemos la fila seleccionada.
        posicion = jTable.getSelectedRow();

        if (posicion == -1) {
            // No se ha seleccionado ninguna pelicula de la tabla
            // Mostramos mensaje emergente de informacion.
            JOptionPane.showMessageDialog(this,
                    "Primero debes seleccionar una\n"
                    + "película de la lista.",
                    "MODIFICAR PELICULA", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Se ha seleccionado una pelicula.
            //Abrimos Panel de modificacion de pelicula.
            jScrollPane.setVisible(false);
            panelModificarPelicula.setVisible(true);
            // Creamos un objeto JSON temporal de la fila seleccionada.
            objModificarPelicula = new JSONObject();
            objModificarPelicula = jsonArray.getJSONObject(posicion);
            //Rellenamos los campos con los datos actuales...
            textTitulo.setText(objModificarPelicula.get("TITULO").toString());
            textDirector.setText(objModificarPelicula.get("DIRECTOR").toString());
            textGenero.setText(objModificarPelicula.get("GENERO").toString());
            textDuracion.setText(objModificarPelicula.get("DURACION").toString());
            textAño.setText(objModificarPelicula.get("AÑO").toString());
            textPrecio.setText(objModificarPelicula.get("PRECIO").toString());
        }
    }//GEN-LAST:event_modificarPeliculaActionPerformed

    private void añadirPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirPeliculaActionPerformed
        VentanaNuevaPelicula nuevaPelicula = new VentanaNuevaPelicula();
        nuevaPelicula.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_añadirPeliculaActionPerformed

    private void buttonModificarPeliculaConfirmacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModificarPeliculaConfirmacionActionPerformed

        /**
         *
         * Metodo que se ejecuta al clicar en el boton MODIFICAR 
         * del formulario de datos de la pelicula.
         *
         * Operacion de modificación de los datos de la pelicula. *
         *
         */ 

        //Obtenemos su id.
        idModificarPelicula = (UUID) objModificarPelicula.get("id");
        
        // Leemos los campos de datos de la pelicula.
        String titulo = textTitulo.getText();
        String director = textDirector.getText();
        String genero = textGenero.getText();
        int duracion = Integer.parseInt(textDuracion.getText());
        int año = Integer.parseInt(textAño.getText());
        int precio = Integer.parseInt(textPrecio.getText());
      
        // Mostramos mensaje emergente de confirmacion.
        int opcion = JOptionPane.showConfirmDialog(null, "Has introducido:\n\n"
                + " Titulo: " + titulo + "\n"
                + " Director: " + director + "\n"
                + " Genero: " + genero + "\n"
                + " Duracion: " + duracion + "\n"
                + " Año: " + año + "\n"
                + "Precio: " + precio
                + "\n\n            Es correcto?",
                "CONFIRMACION", 0);
        
        //Si todo está correcto...
        if(opcion ==0){
            
            // Creamos el cliente
            Client client = ClientBuilder.newClient();

            // Creamos el target (URL)
            WebTarget target = client.target(Constants.urlUpdatePelicula + idModificarPelicula + "?token=" + Constants.token);

            // Creamos la solicitud
            Invocation.Builder solicitud = target.request();

            // Creamos el objeto DTO que espera el servidor
            UpdatePeliculaDTO updatePelicula = new UpdatePeliculaDTO();

            // Asignamos los valores
            updatePelicula.setTitulo(titulo);
            updatePelicula.setDirector(director);
            updatePelicula.setGenero(genero);
            updatePelicula.setDuracion(duracion);
            updatePelicula.setAño(año);
            updatePelicula.setPrecio(precio);
            
            // Creamos una instancia de Gson para convertir nuestro String a JSON
            Gson gson = new Gson();
            // lo pasamos a objeto Json
            String jsonString = gson.toJson(updatePelicula);
            
            // Enviamos nuestro json via PUT a la API
            Response put = solicitud.put(Entity.json(jsonString));
            
            // Recibimos la respuesta y la leemos en una clase String
            String responseJsonString = put.readEntity(String.class);
            
            //Covertimos el JsonString en un objeto JSON.
            JSONObject json = new JSONObject(responseJsonString);
            
            System.out.println(put.getStatus());
            System.out.println(json);
            
            
            // Si todo ha salido correcto.
            if (put.getStatus() == 200) {
                // Mostramos mensaje emergente de informacion.
                JOptionPane.showMessageDialog(this,""+
                        json.getString("message")
                        + "\nVolverás a Gestión de películas.",
                        "MODIFICAR PELICULA", JOptionPane.INFORMATION_MESSAGE);
                // Cerramos la ventana de registro. 
                panelModificarPelicula.setVisible(false);
                VentanaGestionPeliculas gestionPeliculas = new VentanaGestionPeliculas();
                gestionPeliculas.setVisible(true);
                this.dispose();
                                
            } else {
                // Mostramos mensaje emergente de aviso.
                JOptionPane.showMessageDialog(this,
                        json.getString("message") + "\n"
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
        } 
    }//GEN-LAST:event_buttonModificarPeliculaConfirmacionActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton añadirPelicula;
    private javax.swing.JButton buttonModificarPeliculaConfirmacion;
    private javax.swing.JButton eliminarPelicula;
    private javax.swing.JButton jButtonCerrarSesion;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JLabel jLabelAño;
    private javax.swing.JLabel jLabelDirector;
    private javax.swing.JLabel jLabelDuracion;
    private javax.swing.JLabel jLabelGenero;
    private javax.swing.JLabel jLabelModificarPelicula;
    private javax.swing.JLabel jLabelPrecio;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPanel jPanelGestionPeliculas;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JTable jTable;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JButton listaPeliculas;
    private javax.swing.JTextArea mensajeGestionPeliculas;
    private javax.swing.JButton modificarPelicula;
    private javax.swing.JPanel panelModificarPelicula;
    private javax.swing.JTextField textAño;
    private javax.swing.JTextField textDirector;
    private javax.swing.JTextField textDuracion;
    private javax.swing.JTextField textGenero;
    private javax.swing.JLabel textLogo;
    private javax.swing.JTextField textPrecio;
    private javax.swing.JTextField textTitulo;
    // End of variables declaration//GEN-END:variables

}
