package Pantallas.peliculas;

import Modelos.DTOS.ResponseLogoutDTO;
import Modelos.DTOS.peliculas.DTO.ResponsePeliculaListDTO;
import Modelos.DTOS.peliculas.DTO.UpdatePeliculaDTO;
import Modelos.DTOS.usuarios.DTO.ResponseUserInfoDTO;
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
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import utils.Constants;
import Tablas.TablePeliculas;

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
    int pagina = 0, paginaSize = 10, paginasTotales;
    int paginaFiltro = 0, paginaSizeFiltro = 10, paginasTotalesFiltro;
    String parametros = null;

    /**
     * Constructor de un nuevo formulario Ventana de gestion de peliculas.
     *
     * @Author Carlos.
     */
    public VentanaGestionPeliculas() {
        initComponents();
        //cerramos los paneles que hubieran estado abiertos.
        panelModificarPelicula.setVisible(false);
        jLabelPagina.setVisible(false);
        jButtonAnterior.setVisible(false);
        jButtonSiguiente.setVisible(false);
        jButtonFiltros.setVisible(false);
        jPanelFiltros.setVisible(false);
        jPanelPeliculasFiltradas.setVisible(false);
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
     *
     * @Author Carlos.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelGestionPeliculas = new javax.swing.JPanel();
        jButtonAnterior = new javax.swing.JButton();
        jLabelPagina = new javax.swing.JLabel();
        jButtonSiguiente = new javax.swing.JButton();
        jButtonFiltros = new javax.swing.JButton();
        textLogo = new javax.swing.JLabel();
        mensajeGestionPeliculas = new javax.swing.JTextArea();
        jButtonCerrarSesion = new javax.swing.JButton();
        jLabelUsuario = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        listaPeliculas = new javax.swing.JButton();
        modificarPelicula = new javax.swing.JButton();
        eliminarPelicula = new javax.swing.JButton();
        jButtonVolver = new javax.swing.JButton();
        añadirPelicula = new javax.swing.JButton();
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
        jButtonVolver2 = new javax.swing.JButton();
        jPanelFiltros = new javax.swing.JPanel();
        jLabelFiltrosDeBusqueda = new javax.swing.JLabel();
        jLabelDescripcion = new javax.swing.JLabel();
        jLabelDirector1 = new javax.swing.JLabel();
        jLabelGenero1 = new javax.swing.JLabel();
        jLabelAño1 = new javax.swing.JLabel();
        jLabelOrden = new javax.swing.JLabel();
        jTextFieldDirector = new javax.swing.JTextField();
        jTextFieldGenero = new javax.swing.JTextField();
        jTextFieldAño = new javax.swing.JTextField();
        jComboBoxFiltros = new javax.swing.JComboBox<>();
        jButtonFiltrar = new javax.swing.JButton();
        jLabelDescripcion2 = new javax.swing.JLabel();
        buttonInicio1 = new javax.swing.JButton();
        jPanelPeliculasFiltradas = new javax.swing.JPanel();
        jScrollPanePeliculasFiltradas = new javax.swing.JScrollPane();
        jTablePeliculasFiltradas = new javax.swing.JTable();
        jButtonAnteriorPeliculasFiltradas = new javax.swing.JButton();
        jLabelPaginaPeliculasFiltradas = new javax.swing.JLabel();
        jButtonSiguientePeliculasFiltradas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GESTION DE PELICULAS");
        setResizable(false);

        jPanelGestionPeliculas.setBackground(new java.awt.Color(255, 255, 255));
        jPanelGestionPeliculas.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jPanelGestionPeliculas.setPreferredSize(new java.awt.Dimension(800, 400));

        jButtonAnterior.setBackground(new java.awt.Color(242, 242, 242));
        jButtonAnterior.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jButtonAnterior.setText("Anterior");
        jButtonAnterior.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnteriorActionPerformed(evt);
            }
        });

        jLabelPagina.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabelPagina.setText("1");

        jButtonSiguiente.setBackground(new java.awt.Color(242, 242, 242));
        jButtonSiguiente.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jButtonSiguiente.setText("Siguiente");
        jButtonSiguiente.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSiguienteActionPerformed(evt);
            }
        });

        jButtonFiltros.setBackground(new java.awt.Color(242, 242, 242));
        jButtonFiltros.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jButtonFiltros.setText("Filtros de búsqueda");
        jButtonFiltros.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonFiltros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFiltrosActionPerformed(evt);
            }
        });

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

        añadirPelicula.setBackground(new java.awt.Color(0, 204, 102));
        añadirPelicula.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        añadirPelicula.setText("Añadir Pelicula");
        añadirPelicula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirPeliculaActionPerformed(evt);
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

        jButtonVolver2.setBackground(new java.awt.Color(153, 204, 0));
        jButtonVolver2.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jButtonVolver2.setText("VOLVER");
        jButtonVolver2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolver2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelModificarPeliculaLayout = new javax.swing.GroupLayout(panelModificarPelicula);
        panelModificarPelicula.setLayout(panelModificarPeliculaLayout);
        panelModificarPeliculaLayout.setHorizontalGroup(
            panelModificarPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelModificarPeliculaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelModificarPelicula)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelModificarPeliculaLayout.createSequentialGroup()
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
                                    .addComponent(textPrecio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelModificarPeliculaLayout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(buttonModificarPeliculaConfirmacion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonVolver2)
                                .addGap(0, 10, Short.MAX_VALUE)))
                        .addGap(34, 34, 34))))
        );
        panelModificarPeliculaLayout.setVerticalGroup(
            panelModificarPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelModificarPeliculaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelModificarPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelModificarPeliculaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonVolver2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(buttonModificarPeliculaConfirmacion))
                    .addGroup(panelModificarPeliculaLayout.createSequentialGroup()
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
                        .addGap(49, 49, 49)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanelFiltros.setBackground(new java.awt.Color(204, 255, 255));

        jLabelFiltrosDeBusqueda.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        jLabelFiltrosDeBusqueda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFiltrosDeBusqueda.setText("FILTROS DE BUSQUEDA");

        jLabelDescripcion.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        jLabelDescripcion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDescripcion.setText("Puedes filtrar la búsqueda rellenando uno de los campos.");

        jLabelDirector1.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabelDirector1.setText("Director :");

        jLabelGenero1.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabelGenero1.setText("Genero :");

        jLabelAño1.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabelAño1.setText("Año :");

        jLabelOrden.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabelOrden.setText("Orden :");

        jTextFieldDirector.setBackground(java.awt.SystemColor.control);
        jTextFieldDirector.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jTextFieldDirector.setToolTipText("");
        jTextFieldDirector.setBorder(null);

        jTextFieldGenero.setBackground(java.awt.SystemColor.control);
        jTextFieldGenero.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jTextFieldGenero.setToolTipText("");
        jTextFieldGenero.setBorder(null);

        jTextFieldAño.setBackground(javax.swing.UIManager.getDefaults().getColor("control"));
        jTextFieldAño.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jTextFieldAño.setToolTipText("");
        jTextFieldAño.setBorder(null);

        jComboBoxFiltros.setBackground(javax.swing.UIManager.getDefaults().getColor("control"));
        jComboBoxFiltros.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jComboBoxFiltros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sin orden", "vecesAlquiladaAsc", "vecesAlquiladaDesc", "duracionAsc", "duracionDesc", "añoAsc", "añoDesc", " " }));
        jComboBoxFiltros.setBorder(null);

        jButtonFiltrar.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jButtonFiltrar.setText("FILTRAR");
        jButtonFiltrar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonFiltrar.setBorderPainted(false);
        jButtonFiltrar.setFocusable(false);
        jButtonFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFiltrarActionPerformed(evt);
            }
        });

        jLabelDescripcion2.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        jLabelDescripcion2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDescripcion2.setText("Y seleccionar el orden deseado.");

        buttonInicio1.setBackground(new java.awt.Color(153, 204, 0));
        buttonInicio1.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        buttonInicio1.setText("VOLVER");
        buttonInicio1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonInicio1.setBorderPainted(false);
        buttonInicio1.setFocusable(false);
        buttonInicio1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInicio1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelFiltrosLayout = new javax.swing.GroupLayout(jPanelFiltros);
        jPanelFiltros.setLayout(jPanelFiltrosLayout);
        jPanelFiltrosLayout.setHorizontalGroup(
            jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFiltrosLayout.createSequentialGroup()
                .addGroup(jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFiltrosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelFiltrosDeBusqueda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                            .addGroup(jPanelFiltrosLayout.createSequentialGroup()
                                .addGroup(jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanelFiltrosLayout.createSequentialGroup()
                                        .addComponent(jButtonFiltrar)
                                        .addGap(25, 25, 25)
                                        .addComponent(buttonInicio1))
                                    .addGroup(jPanelFiltrosLayout.createSequentialGroup()
                                        .addGroup(jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jLabelGenero1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabelDirector1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                                                .addComponent(jLabelAño1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextFieldAño)
                                            .addComponent(jComboBoxFiltros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldGenero)
                                            .addComponent(jTextFieldDirector))))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(jLabelDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelDescripcion2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelFiltrosLayout.setVerticalGroup(
            jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFiltrosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelFiltrosDeBusqueda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelDescripcion)
                .addGap(4, 4, 4)
                .addComponent(jLabelDescripcion2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDirector1)
                    .addComponent(jTextFieldDirector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelGenero1)
                    .addComponent(jTextFieldGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAño1)
                    .addComponent(jTextFieldAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelOrden)
                    .addComponent(jComboBoxFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonFiltrar)
                    .addComponent(buttonInicio1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanelPeliculasFiltradas.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPanePeliculasFiltradas.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPanePeliculasFiltradas.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPanePeliculasFiltradas.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPanePeliculasFiltradas.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N

        jTablePeliculasFiltradas.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jTablePeliculasFiltradas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTablePeliculasFiltradas.setFillsViewportHeight(true);
        jTablePeliculasFiltradas.setFocusable(false);
        jTablePeliculasFiltradas.setGridColor(new java.awt.Color(153, 153, 153));
        jTablePeliculasFiltradas.setSelectionBackground(new java.awt.Color(102, 204, 255));
        jScrollPanePeliculasFiltradas.setViewportView(jTablePeliculasFiltradas);

        jButtonAnteriorPeliculasFiltradas.setBackground(new java.awt.Color(242, 242, 242));
        jButtonAnteriorPeliculasFiltradas.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jButtonAnteriorPeliculasFiltradas.setText("Anterior");
        jButtonAnteriorPeliculasFiltradas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonAnteriorPeliculasFiltradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnteriorPeliculasFiltradasActionPerformed(evt);
            }
        });

        jLabelPaginaPeliculasFiltradas.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N

        jButtonSiguientePeliculasFiltradas.setBackground(new java.awt.Color(242, 242, 242));
        jButtonSiguientePeliculasFiltradas.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jButtonSiguientePeliculasFiltradas.setText("Siguiente");
        jButtonSiguientePeliculasFiltradas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonSiguientePeliculasFiltradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSiguientePeliculasFiltradasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelPeliculasFiltradasLayout = new javax.swing.GroupLayout(jPanelPeliculasFiltradas);
        jPanelPeliculasFiltradas.setLayout(jPanelPeliculasFiltradasLayout);
        jPanelPeliculasFiltradasLayout.setHorizontalGroup(
            jPanelPeliculasFiltradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPeliculasFiltradasLayout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(jButtonAnteriorPeliculasFiltradas)
                .addGap(18, 18, 18)
                .addComponent(jLabelPaginaPeliculasFiltradas, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSiguientePeliculasFiltradas)
                .addContainerGap(320, Short.MAX_VALUE))
            .addGroup(jPanelPeliculasFiltradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPanePeliculasFiltradas, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE))
        );
        jPanelPeliculasFiltradasLayout.setVerticalGroup(
            jPanelPeliculasFiltradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPeliculasFiltradasLayout.createSequentialGroup()
                .addContainerGap(208, Short.MAX_VALUE)
                .addGroup(jPanelPeliculasFiltradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonSiguientePeliculasFiltradas)
                    .addComponent(jLabelPaginaPeliculasFiltradas, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAnteriorPeliculasFiltradas))
                .addContainerGap())
            .addGroup(jPanelPeliculasFiltradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelPeliculasFiltradasLayout.createSequentialGroup()
                    .addComponent(jScrollPanePeliculasFiltradas, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 44, Short.MAX_VALUE)))
        );

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
                .addGroup(jPanelGestionPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelGestionPeliculasLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane))
                    .addGroup(jPanelGestionPeliculasLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelGestionPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGestionPeliculasLayout.createSequentialGroup()
                                .addComponent(mensajeGestionPeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(jLabelUsuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(197, 197, 197))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGestionPeliculasLayout.createSequentialGroup()
                                .addComponent(jButtonAnterior)
                                .addGap(35, 35, 35)
                                .addComponent(jLabelPagina, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jButtonSiguiente)
                                .addGap(31, 31, 31)
                                .addComponent(jButtonFiltros)
                                .addGap(108, 108, 108)))))
                .addGap(63, 63, 63))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGestionPeliculasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonVolver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonCerrarSesion)
                .addGap(78, 78, 78))
            .addGroup(jPanelGestionPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGestionPeliculasLayout.createSequentialGroup()
                    .addContainerGap(271, Short.MAX_VALUE)
                    .addComponent(panelModificarPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(298, 298, 298)))
            .addGroup(jPanelGestionPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelGestionPeliculasLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanelFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jPanelGestionPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGestionPeliculasLayout.createSequentialGroup()
                    .addContainerGap(257, Short.MAX_VALUE)
                    .addComponent(jPanelPeliculasFiltradas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(67, Short.MAX_VALUE)))
        );
        jPanelGestionPeliculasLayout.setVerticalGroup(
            jPanelGestionPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGestionPeliculasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelGestionPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textLogo)
                    .addComponent(mensajeGestionPeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelUsuario)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanelGestionPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelGestionPeliculasLayout.createSequentialGroup()
                        .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanelGestionPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAnterior)
                            .addComponent(jButtonSiguiente)
                            .addComponent(jLabelPagina)
                            .addComponent(jButtonFiltros)))
                    .addGroup(jPanelGestionPeliculasLayout.createSequentialGroup()
                        .addComponent(listaPeliculas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(añadirPelicula)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(eliminarPelicula)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(modificarPelicula)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addGroup(jPanelGestionPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCerrarSesion)
                    .addComponent(jButtonVolver))
                .addGap(19, 19, 19))
            .addGroup(jPanelGestionPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGestionPeliculasLayout.createSequentialGroup()
                    .addContainerGap(75, Short.MAX_VALUE)
                    .addComponent(panelModificarPelicula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(14, 14, 14)))
            .addGroup(jPanelGestionPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelGestionPeliculasLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanelFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jPanelGestionPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGestionPeliculasLayout.createSequentialGroup()
                    .addContainerGap(106, Short.MAX_VALUE)
                    .addComponent(jPanelPeliculasFiltradas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(106, Short.MAX_VALUE)))
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
         *
         * @Author Carlos.
         */

        VentanaAdmin ventanaAdmin = new VentanaAdmin();
        ventanaAdmin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonVolverActionPerformed

    private void listaPeliculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaPeliculasActionPerformed

        /**
         *
         * Método para crear una tabla que muestre la lista de las peliculas de la aplicacion.
         *
         * @Author Carlos.
         */
        //***********************************************
        //cerramos los paneles que hubieran estado abiertos.
        jPanelFiltros.setVisible(false);
        jPanelPeliculasFiltradas.setVisible(false);
        
        //Mostramos la tabla de peliculas.
        jScrollPane.setVisible(true);
        jTable.setVisible(true);
        jLabelPagina.setVisible(true);
        jButtonAnterior.setVisible(true);
        jButtonSiguiente.setVisible(true);
        jButtonFiltros.setVisible(true);
        /**
         * Esta es la primera tabla de peliculas que se muestra. pagina 0 ( 1 en pantalla.)
         *
         * @Author Carlos.
         */

        // Creamos la URL
        // Es una url con tres parametros en modo query.
        StringBuilder resultado = new StringBuilder();
        try {
            // Creamos la URL
            /*
            URL url = new URL(Constants.urlPeliculas + "?token=" + Constants.token);
             */

            URL url = new URL(Constants.urlPeliculasPaginadas
                    + "?page=" + pagina
                    + "&pageSize=" + paginaSize
                    + "&token=" + Constants.token);

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

        //*************************************************
        // El array de objetos JSON lo convertimos en un array de objetos DTO.
        // Lo transformamos gracias al objeto DTO creado para ello.
        ResponsePeliculaListDTO responseJson = gson.fromJson(responseJsonString, ResponsePeliculaListDTO.class);
        //*************************************************

        paginasTotales = responseJson.getValue().getTotalPages();
        jLabelPagina.setText(String.valueOf(pagina + 1) + " de " + paginasTotales);

        //Creamos una lista de objetos JSON
        jsonArray = new JSONArray();
        for (int i = 0; i < responseJson.getValue().getContent().size(); i++) {
            JSONObject obj = new JSONObject();
            obj.put("id", responseJson.getValue().getContent().get(i).getId());
            obj.put("TITULO", responseJson.getValue().getContent().get(i).getTitulo());
            obj.put("DIRECTOR", responseJson.getValue().getContent().get(i).getDirector());
            obj.put("GENERO", responseJson.getValue().getContent().get(i).getGenero());
            obj.put("DURACION", responseJson.getValue().getContent().get(i).getDuracion());
            obj.put("AÑO", responseJson.getValue().getContent().get(i).getAño());
            obj.put("PRECIO", responseJson.getValue().getContent().get(i).getPrecio());
            obj.put("ALQUILERES", responseJson.getValue().getContent().get(i).getVecesAlquilada());
            jsonArray.put(obj);
        }

        //Creamos un String[] de columnas
        String[] columnNames = {"TITULO", "DIRECTOR", "GENERO", "AÑO", "DURACION", "PRECIO", "ALQUILERES"};

        //Creamos el modelo de tabla
        model = new TablePeliculas(jsonArray, columnNames);
        //Asignamos el modelo a la tabla
        jTable.setModel(model);
        //Mostramos la tabla
        //Añadimos color a la cabecera.
        //Añadimos color a la cabecera.
        JTableHeader header = jTable.getTableHeader();
        header.setBackground(Color.CYAN);
        //Ponemos los datos numericos en el centro de la celda.
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
        jTable.getColumnModel().getColumn(3).setCellRenderer(renderer);
        jTable.getColumnModel().getColumn(4).setCellRenderer(renderer);
        jTable.getColumnModel().getColumn(5).setCellRenderer(renderer);
        jTable.getColumnModel().getColumn(6).setCellRenderer(renderer);
        //Asignamos el ancho de las columnas.
        jTable.getColumnModel().getColumn(0).setPreferredWidth(110);
        jTable.getColumnModel().getColumn(1).setPreferredWidth(60);
        jTable.getColumnModel().getColumn(2).setPreferredWidth(70);
        jTable.getColumnModel().getColumn(3).setPreferredWidth(10);
        jTable.getColumnModel().getColumn(4).setPreferredWidth(25);
        jTable.getColumnModel().getColumn(5).setPreferredWidth(15);
        jTable.getColumnModel().getColumn(6).setPreferredWidth(40);
    }//GEN-LAST:event_listaPeliculasActionPerformed

    private void jButtonCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarSesionActionPerformed
        /**
         * Metodo para cerrar la sesion y volver a inicio.
         *
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

    private void eliminarPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarPeliculaActionPerformed
        /**
         * metodo para eliminar una pelicula de la aplicacion.
         *
         * @Author Carlos.
         *
         */

        //Cerramos panel de filtros si estaba abierto.
        jPanelFiltros.setVisible(false);
        jPanelPeliculasFiltradas.setVisible(false);
        
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
            } else {
                jTable.clearSelection();
                jTablePeliculasFiltradas.clearSelection();
            }
        }
    }//GEN-LAST:event_eliminarPeliculaActionPerformed

    private void modificarPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarPeliculaActionPerformed
        /**
         *
         * Metodo que se ejecuta al clicar en el boton MODIFICAR PELICULA. Operacion de modificación de los datos de la pelicula.
         *
         * @Author Carlos.
         *
         */

        //Cerramos panel de filtros si estaba abierto.
        jPanelFiltros.setVisible(false);
        jPanelPeliculasFiltradas.setVisible(false);
        
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
            jLabelPagina.setVisible(false);
            jButtonAnterior.setVisible(false);
            jButtonSiguiente.setVisible(false);
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
        /**
         * Metodo para abrir la ventana de añadir pelicula nueva.
         *
         * @Author Carlos.
         *
         */
        VentanaNuevaPelicula nuevaPelicula = new VentanaNuevaPelicula();
        nuevaPelicula.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_añadirPeliculaActionPerformed

    private void buttonModificarPeliculaConfirmacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModificarPeliculaConfirmacionActionPerformed

        /**
         *
         * Metodo que se ejecuta al clicar en el boton MODIFICAR del formulario de datos de la pelicula.
         *
         * Operacion de modificación de los datos de la pelicula. *
         *
         * @Author Carlos.
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

        // Creamos un objeto JSON temporal de la fila seleccionada.
        JSONObject obj = new JSONObject();
        obj = jsonArray.getJSONObject(posicion);

        //Obtenemos su id.
        UUID id = (UUID) obj.get("id");

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
        if (opcion == 0) {

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
                JOptionPane.showMessageDialog(this, ""
                        + json.getString("message")
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

    private void jButtonVolver2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolver2ActionPerformed

        /**
         * Metodo para volver a la pantalla anterior.
         *
         * @Author Carlos.
         */
        //cerramos todo lo que se muestra en pantalla.
        jScrollPane.setVisible(false);
        panelModificarPelicula.setVisible(false);
        jLabelPagina.setVisible(false);
        jButtonAnterior.setVisible(false);
        jButtonSiguiente.setVisible(false);
        pagina = 0;
        jTable.clearSelection();
    }//GEN-LAST:event_jButtonVolver2ActionPerformed

    private void jButtonAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnteriorActionPerformed
        /**
         * Hago la consulta de tabla. Con la pagina anterior. Leo los datos en el DTO para ello. Paso los datos a la tabla.
         *
         */
        if (pagina > 0) {
            pagina--;

            StringBuilder resultado = new StringBuilder();
            try {
                // Creamos la URL
                /*
            URL url = new URL(Constants.urlPeliculas + "?token=" + Constants.token);
                 */

                URL url = new URL(Constants.urlPeliculasPaginadas
                        + "?page=" + pagina
                        + "&pageSize=" + paginaSize
                        + "&token=" + Constants.token);

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

            //*************************************************
            // El array de objetos JSON lo convertimos en un array de objetos DTO.
            // Lo transformamos gracias al objeto DTO creado para ello.
            ResponsePeliculaListDTO responseJson = gson.fromJson(responseJsonString, ResponsePeliculaListDTO.class);
            //*************************************************

            //Actualizo el label del contador de paginas.
            jLabelPagina.setText(String.valueOf(pagina + 1) + " de " + paginasTotales);

            //Creamos una lista de objetos JSON
            jsonArray = new JSONArray();
            for (int i = 0; i < responseJson.getValue().getContent().size(); i++) {
                JSONObject obj = new JSONObject();
                obj.put("id", responseJson.getValue().getContent().get(i).getId());
                obj.put("TITULO", responseJson.getValue().getContent().get(i).getTitulo());
                obj.put("DIRECTOR", responseJson.getValue().getContent().get(i).getDirector());
                obj.put("GENERO", responseJson.getValue().getContent().get(i).getGenero());
                obj.put("DURACION", responseJson.getValue().getContent().get(i).getDuracion());
                obj.put("AÑO", responseJson.getValue().getContent().get(i).getAño());
                obj.put("PRECIO", responseJson.getValue().getContent().get(i).getPrecio());
                obj.put("ALQUILERES", responseJson.getValue().getContent().get(i).getVecesAlquilada());
                jsonArray.put(obj);
            }

            //Creamos un String[] de columnas
            String[] columnNames = {"TITULO", "DIRECTOR", "GENERO", "AÑO", "DURACION", "PRECIO", "ALQUILERES"};

            //Creamos el modelo de tabla
            model = new TablePeliculas(jsonArray, columnNames);
            //Asignamos el modelo a la tabla
            jTable.setModel(model);
            //Mostramos la tabla
            //Añadimos color a la cabecera.
            JTableHeader header = jTable.getTableHeader();
            header.setBackground(Color.CYAN);
            //Ponemos los datos numericos en el centro de la celda.
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            renderer.setHorizontalAlignment(JLabel.CENTER);
            jTable.getColumnModel().getColumn(3).setCellRenderer(renderer);
            jTable.getColumnModel().getColumn(4).setCellRenderer(renderer);
            jTable.getColumnModel().getColumn(5).setCellRenderer(renderer);
            jTable.getColumnModel().getColumn(6).setCellRenderer(renderer);
            //Asignamos el ancho de las columnas.
            jTable.getColumnModel().getColumn(0).setPreferredWidth(110);
            jTable.getColumnModel().getColumn(1).setPreferredWidth(60);
            jTable.getColumnModel().getColumn(2).setPreferredWidth(70);
            jTable.getColumnModel().getColumn(3).setPreferredWidth(10);
            jTable.getColumnModel().getColumn(4).setPreferredWidth(25);
            jTable.getColumnModel().getColumn(5).setPreferredWidth(15);
            jTable.getColumnModel().getColumn(6).setPreferredWidth(40);

        }

    }//GEN-LAST:event_jButtonAnteriorActionPerformed

    private void jButtonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSiguienteActionPerformed
        /**
         * Hago la consulta de tabla. Con la pagina siguiente. Leo los datos en el DTO para ello. Paso los datos a la tabla.
         *
         */
        if (pagina < paginasTotales - 1) {
            pagina++;

            StringBuilder resultado = new StringBuilder();
            try {
                // Creamos la URL
                /*
            URL url = new URL(Constants.urlPeliculas + "?token=" + Constants.token);
                 */

                URL url = new URL(Constants.urlPeliculasPaginadas
                        + "?page=" + pagina
                        + "&pageSize=" + paginaSize
                        + "&token=" + Constants.token);

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

            //*************************************************
            // El array de objetos JSON lo convertimos en un array de objetos DTO.
            // Lo transformamos gracias al objeto DTO creado para ello.
            ResponsePeliculaListDTO responseJson = gson.fromJson(responseJsonString, ResponsePeliculaListDTO.class);
            //*************************************************

            //Actualizo el label del contador de paginas.
            jLabelPagina.setText(String.valueOf(pagina + 1) + " de " + paginasTotales);

            //Creamos una lista de objetos JSON
            jsonArray = new JSONArray();
            for (int i = 0; i < responseJson.getValue().getContent().size(); i++) {
                JSONObject obj = new JSONObject();
                obj.put("id", responseJson.getValue().getContent().get(i).getId());
                obj.put("TITULO", responseJson.getValue().getContent().get(i).getTitulo());
                obj.put("DIRECTOR", responseJson.getValue().getContent().get(i).getDirector());
                obj.put("GENERO", responseJson.getValue().getContent().get(i).getGenero());
                obj.put("DURACION", responseJson.getValue().getContent().get(i).getDuracion());
                obj.put("AÑO", responseJson.getValue().getContent().get(i).getAño());
                obj.put("PRECIO", responseJson.getValue().getContent().get(i).getPrecio());
                obj.put("ALQUILERES", responseJson.getValue().getContent().get(i).getVecesAlquilada());
                jsonArray.put(obj);
            }

            //Creamos un String[] de columnas
            String[] columnNames = {"TITULO", "DIRECTOR", "GENERO", "AÑO", "DURACION", "PRECIO", "ALQUILERES"};

            //Creamos el modelo de tabla
            model = new TablePeliculas(jsonArray, columnNames);
            //Asignamos el modelo a la tabla
            jTable.setModel(model);
            //Mostramos la tabla
            //Añadimos color a la cabecera.
            JTableHeader header = jTable.getTableHeader();
            header.setBackground(Color.CYAN);
            //Ponemos los datos numericos en el centro de la celda.
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            renderer.setHorizontalAlignment(JLabel.CENTER);
            jTable.getColumnModel().getColumn(3).setCellRenderer(renderer);
            jTable.getColumnModel().getColumn(4).setCellRenderer(renderer);
            jTable.getColumnModel().getColumn(5).setCellRenderer(renderer);
            jTable.getColumnModel().getColumn(6).setCellRenderer(renderer);
            //Asignamos el ancho de las columnas.
            jTable.getColumnModel().getColumn(0).setPreferredWidth(110);
            jTable.getColumnModel().getColumn(1).setPreferredWidth(60);
            jTable.getColumnModel().getColumn(2).setPreferredWidth(70);
            jTable.getColumnModel().getColumn(3).setPreferredWidth(10);
            jTable.getColumnModel().getColumn(4).setPreferredWidth(25);
            jTable.getColumnModel().getColumn(5).setPreferredWidth(15);
            jTable.getColumnModel().getColumn(6).setPreferredWidth(40);
        }
    }//GEN-LAST:event_jButtonSiguienteActionPerformed

    private void jButtonFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFiltrarActionPerformed

        /**
         * Metodo para mostrar la lista de peliculas filtrada por los parametros de búsqueda.
         *
         * Esta es la primera tabla de peliculas filtradas que se muestra. pagina 0 ( 1 en pantalla.)
         *
         * @Author Carlos.
         */
        //cerramos los paneles que hubieran estado abiertos.
        panelModificarPelicula.setVisible(false);
        jLabelPagina.setVisible(false);
        jButtonAnterior.setVisible(false);
        jButtonSiguiente.setVisible(false);
        jButtonFiltros.setVisible(false);
        jPanelFiltros.setVisible(false);
        
        //Limpiamos la tabla de peliculas filtradas.
        jTablePeliculasFiltradas.clearSelection();

        //Variables de la url.
        String director;
        String genero;
        String año;

        // Leemos los campos seleccionados
        // y creamos la cadena de parametros.
        if (!jTextFieldDirector.getText().isEmpty()) {
            director = jTextFieldDirector.getText().replace(" ", "%20");
            parametros = "&director=" + director;

        } else if (!jTextFieldGenero.getText().isEmpty()) {
            genero = jTextFieldGenero.getText().replace(" ", "%20");
            parametros = "&genero=" + genero;

        } else if (!jTextFieldAño.getText().isEmpty()) {
            año = jTextFieldAño.getText();
            parametros = "&año=" + año;

        } else {
            // Mostramos mensaje emergente de informacion.
            JOptionPane.showMessageDialog(this,
                    "No has introducido datos para realizar la búsqueda.",
                    "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
            VentanaGestionPeliculas ventanaGestionPeliculas = new VentanaGestionPeliculas();
            ventanaGestionPeliculas.setVisible(true);
            this.dispose();
        }

        //Leemos el orden que hemos seleccionado...
        String orden = (String) jComboBoxFiltros.getSelectedItem();

        //Asignamos el string parametro del orden.
        orden = switch (orden) {
            case "vecesAlquiladaAsc" ->
                "&orden=vecesAlquiladaAsc";
            case "vecesAlquiladaDesc" ->
                "&orden=vecesAlquiladaDesc";
            case "duracionAsc" ->
                "&orden=duracionAsc";
            case "duracionDesc" ->
                "&orden=duracionDesc";
            case "añoAsc" ->
                "&orden=anoAsc";
            case "añoDesc" ->
                "&orden=anoDesc";
            default ->
                "";
        };

        //Terminamos de crear el string parametros de la url.
        parametros = parametros + orden;

        //Tabla peliculas filtradas.
        jPanelPeliculasFiltradas.setVisible(true);

        // Creamos la URL
        // Es una url con cuatro parametros en modo PATH.
        StringBuilder resultado = new StringBuilder();
        try {

            URL url = new URL(Constants.urlPeliculasPaginadas
                    + "?page=" + paginaFiltro
                    + "&pageSize=" + paginaSizeFiltro
                    + "&token=" + Constants.token
                    + parametros);

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

        //*************************************************
        // El array de objetos JSON lo convertimos en un array de objetos DTO.
        // Lo transformamos gracias al objeto DTO creado para ello.
        ResponsePeliculaListDTO responseJson = gson.fromJson(responseJsonString, ResponsePeliculaListDTO.class);
        //*************************************************

        paginasTotalesFiltro = responseJson.getValue().getTotalPages();
        jLabelPaginaPeliculasFiltradas.setText(String.valueOf(paginaFiltro + 1) + " de " + paginasTotalesFiltro);

        //Creamos una lista de objetos JSON
        jsonArray = new JSONArray();
        for (int i = 0; i < responseJson.getValue().getContent().size(); i++) {
            JSONObject obj = new JSONObject();
            obj.put("id", responseJson.getValue().getContent().get(i).getId());
            obj.put("TITULO", responseJson.getValue().getContent().get(i).getTitulo());
            obj.put("DIRECTOR", responseJson.getValue().getContent().get(i).getDirector());
            obj.put("GENERO", responseJson.getValue().getContent().get(i).getGenero());
            obj.put("DURACION", responseJson.getValue().getContent().get(i).getDuracion());
            obj.put("AÑO", responseJson.getValue().getContent().get(i).getAño());
            obj.put("PRECIO", responseJson.getValue().getContent().get(i).getPrecio());
            obj.put("ALQUILERES", responseJson.getValue().getContent().get(i).getVecesAlquilada());
            jsonArray.put(obj);
        }

        //Creamos un String[] de columnas
        String[] columnNames = {"TITULO", "DIRECTOR", "GENERO", "AÑO", "DURACION", "PRECIO", "ALQUILERES"};

        //Creamos el modelo de tabla
        model = new TablePeliculas(jsonArray, columnNames);
        //Asignamos el modelo a la tabla
        jTablePeliculasFiltradas.setModel(model);
        //Mostramos la tabla
        //Añadimos color a la cabecera.
        JTableHeader header = jTablePeliculasFiltradas.getTableHeader();
        header.setBackground(Color.CYAN);
        //Ponemos los datos numericos en el centro de la celda.
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
        jTablePeliculasFiltradas.getColumnModel().getColumn(3).setCellRenderer(renderer);
        jTablePeliculasFiltradas.getColumnModel().getColumn(4).setCellRenderer(renderer);
        jTablePeliculasFiltradas.getColumnModel().getColumn(5).setCellRenderer(renderer);
        jTablePeliculasFiltradas.getColumnModel().getColumn(6).setCellRenderer(renderer);
        //Asignamos el ancho de las columnas.
        jTablePeliculasFiltradas.getColumnModel().getColumn(0).setPreferredWidth(110);
        jTablePeliculasFiltradas.getColumnModel().getColumn(1).setPreferredWidth(55);
        jTablePeliculasFiltradas.getColumnModel().getColumn(2).setPreferredWidth(55);
        jTablePeliculasFiltradas.getColumnModel().getColumn(3).setPreferredWidth(10);
        jTablePeliculasFiltradas.getColumnModel().getColumn(4).setPreferredWidth(30);
        jTablePeliculasFiltradas.getColumnModel().getColumn(5).setPreferredWidth(15);
        jTablePeliculasFiltradas.getColumnModel().getColumn(6).setPreferredWidth(50);
    }//GEN-LAST:event_jButtonFiltrarActionPerformed

    private void buttonInicio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInicio1ActionPerformed
        // Cerramos el panel de filtros.
        // y volvemos a inicio.
        VentanaGestionPeliculas gestionPeliculas = new VentanaGestionPeliculas();
        gestionPeliculas.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonInicio1ActionPerformed

    private void jButtonAnteriorPeliculasFiltradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnteriorPeliculasFiltradasActionPerformed
        /**
         * Hago la consulta de tabla. Con la pagina anterior. Leo los datos en el DTO para ello. Paso los datos a la tabla.
         *
         */
        if (paginaFiltro > 0) {
            paginaFiltro--;

            // Creamos la URL
            // Es una url con cuatro parametros en modo PATH.
            StringBuilder resultado = new StringBuilder();
            try {

                URL url = new URL(Constants.urlPeliculasPaginadas
                        + "?page=" + paginaFiltro
                        + "&pageSize=" + paginaSizeFiltro
                        + "&token=" + Constants.token
                        + parametros);

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

            //*************************************************
            // El array de objetos JSON lo convertimos en un array de objetos DTO.
            // Lo transformamos gracias al objeto DTO creado para ello.
            ResponsePeliculaListDTO responseJson = gson.fromJson(responseJsonString, ResponsePeliculaListDTO.class);
            //*************************************************

            paginasTotalesFiltro = responseJson.getValue().getTotalPages();
            jLabelPaginaPeliculasFiltradas.setText(String.valueOf(paginaFiltro + 1) + " de " + paginasTotalesFiltro);

            //Creamos una lista de objetos JSON
            jsonArray = new JSONArray();
            for (int i = 0; i < responseJson.getValue().getContent().size(); i++) {
                JSONObject obj = new JSONObject();
                obj.put("id", responseJson.getValue().getContent().get(i).getId());
                obj.put("TITULO", responseJson.getValue().getContent().get(i).getTitulo());
                obj.put("DIRECTOR", responseJson.getValue().getContent().get(i).getDirector());
                obj.put("GENERO", responseJson.getValue().getContent().get(i).getGenero());
                obj.put("DURACION", responseJson.getValue().getContent().get(i).getDuracion());
                obj.put("AÑO", responseJson.getValue().getContent().get(i).getAño());
                obj.put("PRECIO", responseJson.getValue().getContent().get(i).getPrecio());
                obj.put("ALQUILERES", responseJson.getValue().getContent().get(i).getVecesAlquilada());
                jsonArray.put(obj);
            }

            //Creamos un String[] de columnas
            String[] columnNames = {"TITULO", "DIRECTOR", "GENERO", "AÑO", "DURACION", "PRECIO", "ALQUILERES"};

            //Creamos el modelo de tabla
            model = new TablePeliculas(jsonArray, columnNames);
            //Asignamos el modelo a la tabla
            jTablePeliculasFiltradas.setModel(model);
            //Mostramos la tabla
            //Añadimos color a la cabecera.
            JTableHeader header = jTablePeliculasFiltradas.getTableHeader();
            header.setBackground(Color.CYAN);
            //Ponemos los datos numericos en el centro de la celda.
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            renderer.setHorizontalAlignment(JLabel.CENTER);
            jTablePeliculasFiltradas.getColumnModel().getColumn(3).setCellRenderer(renderer);
            jTablePeliculasFiltradas.getColumnModel().getColumn(4).setCellRenderer(renderer);
            jTablePeliculasFiltradas.getColumnModel().getColumn(5).setCellRenderer(renderer);
            jTablePeliculasFiltradas.getColumnModel().getColumn(6).setCellRenderer(renderer);
            //Asignamos el ancho de las columnas.
            jTablePeliculasFiltradas.getColumnModel().getColumn(0).setPreferredWidth(110);
            jTablePeliculasFiltradas.getColumnModel().getColumn(1).setPreferredWidth(55);
            jTablePeliculasFiltradas.getColumnModel().getColumn(2).setPreferredWidth(55);
            jTablePeliculasFiltradas.getColumnModel().getColumn(3).setPreferredWidth(10);
            jTablePeliculasFiltradas.getColumnModel().getColumn(4).setPreferredWidth(30);
            jTablePeliculasFiltradas.getColumnModel().getColumn(5).setPreferredWidth(15);
            jTablePeliculasFiltradas.getColumnModel().getColumn(6).setPreferredWidth(50);
        }
    }//GEN-LAST:event_jButtonAnteriorPeliculasFiltradasActionPerformed

    private void jButtonSiguientePeliculasFiltradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSiguientePeliculasFiltradasActionPerformed
        /**
         * Hago la consulta de tabla. Con la pagina siguiente. Leo los datos en el DTO para ello. Paso los datos a la tabla.
         *
         */

        if (paginaFiltro < paginasTotalesFiltro - 1) {
            paginaFiltro++;

            // Creamos la URL
            // Es una url con cuatro parametros en modo PATH.
            StringBuilder resultado = new StringBuilder();
            try {

                URL url = new URL(Constants.urlPeliculasPaginadas
                        + "?page=" + paginaFiltro
                        + "&pageSize=" + paginaSizeFiltro
                        + "&token=" + Constants.token
                        + parametros);

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

            //*************************************************
            // El array de objetos JSON lo convertimos en un array de objetos DTO.
            // Lo transformamos gracias al objeto DTO creado para ello.
            ResponsePeliculaListDTO responseJson = gson.fromJson(responseJsonString, ResponsePeliculaListDTO.class);
            //*************************************************

            paginasTotalesFiltro = responseJson.getValue().getTotalPages();
            jLabelPaginaPeliculasFiltradas.setText(String.valueOf(paginaFiltro + 1) + " de " + paginasTotalesFiltro);

            //Creamos una lista de objetos JSON
            jsonArray = new JSONArray();
            for (int i = 0; i < responseJson.getValue().getContent().size(); i++) {
                JSONObject obj = new JSONObject();
                obj.put("id", responseJson.getValue().getContent().get(i).getId());
                obj.put("TITULO", responseJson.getValue().getContent().get(i).getTitulo());
                obj.put("DIRECTOR", responseJson.getValue().getContent().get(i).getDirector());
                obj.put("GENERO", responseJson.getValue().getContent().get(i).getGenero());
                obj.put("DURACION", responseJson.getValue().getContent().get(i).getDuracion());
                obj.put("AÑO", responseJson.getValue().getContent().get(i).getAño());
                obj.put("PRECIO", responseJson.getValue().getContent().get(i).getPrecio());
                obj.put("ALQUILERES", responseJson.getValue().getContent().get(i).getVecesAlquilada());
                jsonArray.put(obj);
            }

            //Creamos un String[] de columnas
            String[] columnNames = {"TITULO", "DIRECTOR", "GENERO", "AÑO", "DURACION", "PRECIO", "ALQUILERES"};

            //Creamos el modelo de tabla
            model = new TablePeliculas(jsonArray, columnNames);
            //Asignamos el modelo a la tabla
            jTablePeliculasFiltradas.setModel(model);
            //Mostramos la tabla
            //Añadimos color a la cabecera.
            JTableHeader header = jTablePeliculasFiltradas.getTableHeader();
            header.setBackground(Color.CYAN);
            //Ponemos los datos numericos en el centro de la celda.
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            renderer.setHorizontalAlignment(JLabel.CENTER);
            jTablePeliculasFiltradas.getColumnModel().getColumn(3).setCellRenderer(renderer);
            jTablePeliculasFiltradas.getColumnModel().getColumn(4).setCellRenderer(renderer);
            jTablePeliculasFiltradas.getColumnModel().getColumn(5).setCellRenderer(renderer);
            jTablePeliculasFiltradas.getColumnModel().getColumn(6).setCellRenderer(renderer);
            //Asignamos el ancho de las columnas.
            jTablePeliculasFiltradas.getColumnModel().getColumn(0).setPreferredWidth(110);
            jTablePeliculasFiltradas.getColumnModel().getColumn(1).setPreferredWidth(55);
            jTablePeliculasFiltradas.getColumnModel().getColumn(2).setPreferredWidth(55);
            jTablePeliculasFiltradas.getColumnModel().getColumn(3).setPreferredWidth(10);
            jTablePeliculasFiltradas.getColumnModel().getColumn(4).setPreferredWidth(30);
            jTablePeliculasFiltradas.getColumnModel().getColumn(5).setPreferredWidth(15);
            jTablePeliculasFiltradas.getColumnModel().getColumn(6).setPreferredWidth(50);

        }
    }//GEN-LAST:event_jButtonSiguientePeliculasFiltradasActionPerformed

    private void jButtonFiltrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFiltrosActionPerformed
        /**
         * Metodo para mostrar el panel de entrada de parametros para realizar la búsqueda de peliculas.
         *
         * @Author Carlos.
         */
        //cerramos los paneles que hubieran estado abiertos.
        panelModificarPelicula.setVisible(false);
        jLabelPagina.setVisible(false);
        jButtonAnterior.setVisible(false);
        jButtonSiguiente.setVisible(false);
        jButtonFiltros.setVisible(false);
        jScrollPane.setVisible(false);
        jTable.clearSelection();
        
        //Mostramos panel de seleccion de filtros.
        jPanelFiltros.setVisible(true);

        //Ponemos los campos en blanco.
        jTextFieldDirector.setText("");
        jTextFieldGenero.setText("");
        jTextFieldAño.setText("");
    }//GEN-LAST:event_jButtonFiltrosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton añadirPelicula;
    private javax.swing.JButton buttonInicio1;
    private javax.swing.JButton buttonModificarPeliculaConfirmacion;
    private javax.swing.JButton eliminarPelicula;
    private javax.swing.JButton jButtonAnterior;
    private javax.swing.JButton jButtonAnteriorPeliculasFiltradas;
    private javax.swing.JButton jButtonCerrarSesion;
    private javax.swing.JButton jButtonFiltrar;
    private javax.swing.JButton jButtonFiltros;
    private javax.swing.JButton jButtonSiguiente;
    private javax.swing.JButton jButtonSiguientePeliculasFiltradas;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JButton jButtonVolver2;
    private javax.swing.JComboBox<String> jComboBoxFiltros;
    private javax.swing.JLabel jLabelAño;
    private javax.swing.JLabel jLabelAño1;
    private javax.swing.JLabel jLabelDescripcion;
    private javax.swing.JLabel jLabelDescripcion2;
    private javax.swing.JLabel jLabelDirector;
    private javax.swing.JLabel jLabelDirector1;
    private javax.swing.JLabel jLabelDuracion;
    private javax.swing.JLabel jLabelFiltrosDeBusqueda;
    private javax.swing.JLabel jLabelGenero;
    private javax.swing.JLabel jLabelGenero1;
    private javax.swing.JLabel jLabelModificarPelicula;
    private javax.swing.JLabel jLabelOrden;
    private javax.swing.JLabel jLabelPagina;
    private javax.swing.JLabel jLabelPaginaPeliculasFiltradas;
    private javax.swing.JLabel jLabelPrecio;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPanel jPanelFiltros;
    private javax.swing.JPanel jPanelGestionPeliculas;
    private javax.swing.JPanel jPanelPeliculasFiltradas;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JScrollPane jScrollPanePeliculasFiltradas;
    private javax.swing.JTable jTable;
    private javax.swing.JTable jTablePeliculasFiltradas;
    private javax.swing.JTextField jTextFieldAño;
    private javax.swing.JTextField jTextFieldDirector;
    private javax.swing.JTextField jTextFieldGenero;
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
