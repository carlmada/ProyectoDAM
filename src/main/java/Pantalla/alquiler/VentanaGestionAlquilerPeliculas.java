package Pantalla.alquiler;

import Modelos.DTOS.ResponseLogoutDTO;
import Modelos.DTOS.peliculas.DTO.ResponsePeliculaDTO;
import Modelos.DTOS.alquiler.DTO.ResponseAlquilerListDTO;
import Modelos.DTOS.alquiler.DTO.ResponseAlquilerPeliculaDTO;
import Modelos.DTOS.peliculas.DTO.ResponsePeliculaListDTO;
import Modelos.DTOS.usuarios.DTO.ResponseUserDTO;
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
import Tablas.TableAlquileres;
import Tablas.TablePeliculas;
import Tablas.TableUsuarios;

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
    UUID idPelicula, idUsuario;
    JSONObject objAlquiler;
    int paginaPeliculas = 0, paginaUsuarios = 0, paginaAlquileres = 0, paginaFiltro = 0,
            paginaSizePeliculas = 10, paginaSizeUsuarios = 10, paginaSizeAlquileres = 10, paginaSizeFiltro = 10,
            paginasTotalesPeliculas, paginasTotalesUsuarios, paginasTotalesAlquileres, paginasTotalesFiltro;
    String tituloPelicula, nombreUser, parametros = "";

    /**
     * Constructor de un nuevo formulario Ventana de gestion de alquileres de peliculas.
     *
     * @author Carlos
     */
    public VentanaGestionAlquilerPeliculas() {
        initComponents();
        jPanelPeliculasUsuarios.setVisible(false);
        jPanelAlquileres.setVisible(false);
        jPanelCambioEstatus.setVisible(false);
        jPanelFiltros.setVisible(false);
        jPanelAlquileresFiltrados.setVisible(false);

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
     *
     * @author Carlos
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
        modificarEstatusAlquiler = new javax.swing.JButton();
        eliminarAlquilerPelicula = new javax.swing.JButton();
        jButtonVolver = new javax.swing.JButton();
        alquilarPelicula = new javax.swing.JButton();
        listaAlquileresPeliculas = new javax.swing.JButton();
        jPanelCambioEstatus = new javax.swing.JPanel();
        jLabelStatusAlquiler = new javax.swing.JLabel();
        jLabelEstatus = new javax.swing.JLabel();
        buttonModificarEstatus = new javax.swing.JButton();
        jButtonVolverAlquilerStatus = new javax.swing.JButton();
        jComboBoxEstatus = new javax.swing.JComboBox<>();
        jTextEstatusActual = new javax.swing.JLabel();
        jLabelStatusActual1 = new javax.swing.JLabel();
        jPanelPeliculasUsuarios = new javax.swing.JPanel();
        jLabelPeliculas = new javax.swing.JLabel();
        jLabelUsuarios = new javax.swing.JLabel();
        jScrollPanePeliculas = new javax.swing.JScrollPane();
        jTablePeliculas = new javax.swing.JTable();
        jScrollPaneUsuarios = new javax.swing.JScrollPane();
        jTableUsuarios = new javax.swing.JTable();
        jButtonAnteriorPeliculas = new javax.swing.JButton();
        jLabelPaginaPeliculas = new javax.swing.JLabel();
        jButtonSiguientePeliculas = new javax.swing.JButton();
        jButtonSiguienteUsuarios = new javax.swing.JButton();
        jButtonAnteriorUsuarios = new javax.swing.JButton();
        jLabelPaginaUsuario = new javax.swing.JLabel();
        jPanelAlquileres = new javax.swing.JPanel();
        jScrollPaneAlquileres = new javax.swing.JScrollPane();
        jTableAlquileres = new javax.swing.JTable();
        jLabelAlquileres = new javax.swing.JLabel();
        jButtonAnteriorAlquileres = new javax.swing.JButton();
        jLabelPaginaAlquileres = new javax.swing.JLabel();
        jButtonSiguienteAlquileres = new javax.swing.JButton();
        jButtonFiltros = new javax.swing.JButton();
        jPanelFiltros = new javax.swing.JPanel();
        jLabelFiltrosDeBusqueda = new javax.swing.JLabel();
        jLabelDescripcion = new javax.swing.JLabel();
        jLabelDescripcion2 = new javax.swing.JLabel();
        jLabelPeliculaId = new javax.swing.JLabel();
        jUsuariId = new javax.swing.JLabel();
        jLabelFechaInicio = new javax.swing.JLabel();
        jLabelFechaFin = new javax.swing.JLabel();
        jLabelPrecio = new javax.swing.JLabel();
        jLabelOrden = new javax.swing.JLabel();
        jTextFieldPeliculaId = new javax.swing.JTextField();
        jTextFieldUsuariId = new javax.swing.JTextField();
        jTextFieldFechaInicio = new javax.swing.JTextField();
        jTextFieldFechaFin = new javax.swing.JTextField();
        jTextFieldPrecio = new javax.swing.JTextField();
        jComboBoxFiltros = new javax.swing.JComboBox<>();
        jButtonFiltrar = new javax.swing.JButton();
        buttonVolver2 = new javax.swing.JButton();
        jPanelAlquileresFiltrados = new javax.swing.JPanel();
        jScrollPaneAlquileresFiltrados = new javax.swing.JScrollPane();
        jTableAlquileresFiltrados = new javax.swing.JTable();
        jLabelAlquileresFiltrados = new javax.swing.JLabel();
        jButtonAnteriorAlquileresFiltrados = new javax.swing.JButton();
        jLabelPaginaAlquileresFiltrados = new javax.swing.JLabel();
        jButtonSiguienteAlquileresFiltrados = new javax.swing.JButton();

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
        mensajeAlquilerPeliculas.setText("    GESTION DE ALQUILERES");
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

        modificarEstatusAlquiler.setBackground(new java.awt.Color(255, 153, 51));
        modificarEstatusAlquiler.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        modificarEstatusAlquiler.setText("Modificar Estatus Alquiler");
        modificarEstatusAlquiler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarEstatusAlquilerActionPerformed(evt);
            }
        });

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

        listaAlquileresPeliculas.setBackground(new java.awt.Color(0, 204, 255));
        listaAlquileresPeliculas.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        listaAlquileresPeliculas.setText("Lista de Alquileres");
        listaAlquileresPeliculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaAlquileresPeliculasActionPerformed(evt);
            }
        });

        jPanelCambioEstatus.setBackground(new java.awt.Color(204, 255, 255));
        jPanelCambioEstatus.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N

        jLabelStatusAlquiler.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        jLabelStatusAlquiler.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelStatusAlquiler.setText("Cambio Estatus Alquiler");

        jLabelEstatus.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabelEstatus.setText("Nuevo Estatus :");

        buttonModificarEstatus.setBackground(new java.awt.Color(255, 153, 51));
        buttonModificarEstatus.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        buttonModificarEstatus.setText("MODIFICAR");
        buttonModificarEstatus.setBorderPainted(false);
        buttonModificarEstatus.setFocusable(false);
        buttonModificarEstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonModificarEstatusActionPerformed(evt);
            }
        });

        jButtonVolverAlquilerStatus.setBackground(new java.awt.Color(153, 204, 0));
        jButtonVolverAlquilerStatus.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jButtonVolverAlquilerStatus.setText("VOLVER");
        jButtonVolverAlquilerStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverAlquilerStatusActionPerformed(evt);
            }
        });

        jComboBoxEstatus.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jComboBoxEstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EN_CURSO", "FINALIZADO", "CANCELADO" }));

        jTextEstatusActual.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N

        jLabelStatusActual1.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabelStatusActual1.setText("Estatus Actual:");

        javax.swing.GroupLayout jPanelCambioEstatusLayout = new javax.swing.GroupLayout(jPanelCambioEstatus);
        jPanelCambioEstatus.setLayout(jPanelCambioEstatusLayout);
        jPanelCambioEstatusLayout.setHorizontalGroup(
            jPanelCambioEstatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCambioEstatusLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCambioEstatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelStatusAlquiler, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelCambioEstatusLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanelCambioEstatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelCambioEstatusLayout.createSequentialGroup()
                                .addComponent(buttonModificarEstatus)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonVolverAlquilerStatus))
                            .addGroup(jPanelCambioEstatusLayout.createSequentialGroup()
                                .addGroup(jPanelCambioEstatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelEstatus)
                                    .addComponent(jLabelStatusActual1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelCambioEstatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextEstatusActual, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 117, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelCambioEstatusLayout.setVerticalGroup(
            jPanelCambioEstatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCambioEstatusLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelStatusAlquiler)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanelCambioEstatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelStatusActual1)
                    .addComponent(jTextEstatusActual))
                .addGap(26, 26, 26)
                .addGroup(jPanelCambioEstatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelEstatus)
                    .addComponent(jComboBoxEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanelCambioEstatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonModificarEstatus)
                    .addComponent(jButtonVolverAlquilerStatus))
                .addGap(32, 32, 32))
        );

        jPanelPeliculasUsuarios.setBackground(new java.awt.Color(255, 255, 255));

        jLabelPeliculas.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabelPeliculas.setText("Peliculas");

        jLabelUsuarios.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabelUsuarios.setText("Usuarios");

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

        jButtonAnteriorPeliculas.setBackground(new java.awt.Color(242, 242, 242));
        jButtonAnteriorPeliculas.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jButtonAnteriorPeliculas.setText("Anterior");
        jButtonAnteriorPeliculas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonAnteriorPeliculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnteriorPeliculasActionPerformed(evt);
            }
        });

        jLabelPaginaPeliculas.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabelPaginaPeliculas.setText("1");

        jButtonSiguientePeliculas.setBackground(new java.awt.Color(242, 242, 242));
        jButtonSiguientePeliculas.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jButtonSiguientePeliculas.setText("Siguiente");
        jButtonSiguientePeliculas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonSiguientePeliculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSiguientePeliculasActionPerformed(evt);
            }
        });

        jButtonSiguienteUsuarios.setBackground(new java.awt.Color(242, 242, 242));
        jButtonSiguienteUsuarios.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jButtonSiguienteUsuarios.setText("Siguiente");
        jButtonSiguienteUsuarios.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonSiguienteUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSiguienteUsuariosActionPerformed(evt);
            }
        });

        jButtonAnteriorUsuarios.setBackground(new java.awt.Color(242, 242, 242));
        jButtonAnteriorUsuarios.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jButtonAnteriorUsuarios.setText("Anterior");
        jButtonAnteriorUsuarios.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonAnteriorUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnteriorUsuariosActionPerformed(evt);
            }
        });

        jLabelPaginaUsuario.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabelPaginaUsuario.setText("1");

        javax.swing.GroupLayout jPanelPeliculasUsuariosLayout = new javax.swing.GroupLayout(jPanelPeliculasUsuarios);
        jPanelPeliculasUsuarios.setLayout(jPanelPeliculasUsuariosLayout);
        jPanelPeliculasUsuariosLayout.setHorizontalGroup(
            jPanelPeliculasUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPeliculasUsuariosLayout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(jLabelPeliculas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelUsuarios)
                .addGap(130, 130, 130))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPeliculasUsuariosLayout.createSequentialGroup()
                .addGroup(jPanelPeliculasUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPeliculasUsuariosLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jButtonAnteriorPeliculas)
                        .addGap(35, 35, 35)
                        .addComponent(jLabelPaginaPeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jButtonSiguientePeliculas))
                    .addComponent(jScrollPanePeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelPeliculasUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPeliculasUsuariosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(jButtonAnteriorUsuarios)
                        .addGap(35, 35, 35)
                        .addComponent(jLabelPaginaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jButtonSiguienteUsuarios)
                        .addGap(37, 37, 37))
                    .addGroup(jPanelPeliculasUsuariosLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPaneUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanelPeliculasUsuariosLayout.setVerticalGroup(
            jPanelPeliculasUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPeliculasUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPeliculasUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPeliculas)
                    .addComponent(jLabelUsuarios))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelPeliculasUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPanePeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPaneUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelPeliculasUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPeliculasUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonAnteriorUsuarios)
                        .addComponent(jButtonSiguienteUsuarios)
                        .addComponent(jLabelPaginaUsuario))
                    .addGroup(jPanelPeliculasUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonAnteriorPeliculas)
                        .addComponent(jButtonSiguientePeliculas)
                        .addComponent(jLabelPaginaPeliculas)))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jPanelAlquileres.setBackground(new java.awt.Color(255, 255, 255));

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

        jLabelAlquileres.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabelAlquileres.setText("ALQUILERES");

        jButtonAnteriorAlquileres.setBackground(new java.awt.Color(242, 242, 242));
        jButtonAnteriorAlquileres.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jButtonAnteriorAlquileres.setText("Anterior");
        jButtonAnteriorAlquileres.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonAnteriorAlquileres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnteriorAlquileresActionPerformed(evt);
            }
        });

        jLabelPaginaAlquileres.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabelPaginaAlquileres.setText("1");

        jButtonSiguienteAlquileres.setBackground(new java.awt.Color(242, 242, 242));
        jButtonSiguienteAlquileres.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jButtonSiguienteAlquileres.setText("Siguiente");
        jButtonSiguienteAlquileres.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonSiguienteAlquileres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSiguienteAlquileresActionPerformed(evt);
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

        javax.swing.GroupLayout jPanelAlquileresLayout = new javax.swing.GroupLayout(jPanelAlquileres);
        jPanelAlquileres.setLayout(jPanelAlquileresLayout);
        jPanelAlquileresLayout.setHorizontalGroup(
            jPanelAlquileresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAlquileresLayout.createSequentialGroup()
                .addGroup(jPanelAlquileresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAlquileresLayout.createSequentialGroup()
                        .addGroup(jPanelAlquileresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelAlquileresLayout.createSequentialGroup()
                                .addGap(258, 258, 258)
                                .addComponent(jLabelAlquileres))
                            .addGroup(jPanelAlquileresLayout.createSequentialGroup()
                                .addGap(179, 179, 179)
                                .addComponent(jButtonAnteriorAlquileres)
                                .addGap(35, 35, 35)
                                .addComponent(jLabelPaginaAlquileres, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jButtonSiguienteAlquileres)
                                .addGap(30, 30, 30)
                                .addComponent(jButtonFiltros)))
                        .addGap(0, 94, Short.MAX_VALUE))
                    .addComponent(jScrollPaneAlquileres, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelAlquileresLayout.setVerticalGroup(
            jPanelAlquileresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAlquileresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelAlquileres)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneAlquileres, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelAlquileresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAnteriorAlquileres)
                    .addComponent(jButtonSiguienteAlquileres)
                    .addComponent(jLabelPaginaAlquileres)
                    .addComponent(jButtonFiltros))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jPanelFiltros.setBackground(new java.awt.Color(204, 255, 255));

        jLabelFiltrosDeBusqueda.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        jLabelFiltrosDeBusqueda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFiltrosDeBusqueda.setText("FILTROS DE BUSQUEDA");

        jLabelDescripcion.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        jLabelDescripcion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDescripcion.setText("Puedes filtrar la búsqueda rellenando los campos.");

        jLabelDescripcion2.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        jLabelDescripcion2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDescripcion2.setText("Y seleccionar el orden deseado.");

        jLabelPeliculaId.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabelPeliculaId.setText("Pelicula Id :");

        jUsuariId.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jUsuariId.setText("Usuario Id :");

        jLabelFechaInicio.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabelFechaInicio.setText("Fecha Inicio :");

        jLabelFechaFin.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabelFechaFin.setText("Fecha Fin :");

        jLabelPrecio.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabelPrecio.setText("Precio :");

        jLabelOrden.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabelOrden.setText("Orden :");

        jTextFieldPeliculaId.setBackground(java.awt.SystemColor.control);
        jTextFieldPeliculaId.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jTextFieldPeliculaId.setToolTipText("");
        jTextFieldPeliculaId.setBorder(null);

        jTextFieldUsuariId.setBackground(java.awt.SystemColor.control);
        jTextFieldUsuariId.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jTextFieldUsuariId.setToolTipText("");
        jTextFieldUsuariId.setBorder(null);

        jTextFieldFechaInicio.setBackground(javax.swing.UIManager.getDefaults().getColor("control"));
        jTextFieldFechaInicio.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jTextFieldFechaInicio.setToolTipText("");
        jTextFieldFechaInicio.setBorder(null);

        jTextFieldFechaFin.setBackground(javax.swing.UIManager.getDefaults().getColor("control"));
        jTextFieldFechaFin.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jTextFieldFechaFin.setToolTipText("");
        jTextFieldFechaFin.setBorder(null);

        jTextFieldPrecio.setBackground(javax.swing.UIManager.getDefaults().getColor("control"));
        jTextFieldPrecio.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jTextFieldPrecio.setToolTipText("");
        jTextFieldPrecio.setBorder(null);

        jComboBoxFiltros.setBackground(javax.swing.UIManager.getDefaults().getColor("control"));
        jComboBoxFiltros.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jComboBoxFiltros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sin orden", "peliculaId Asc", "peliculaId Desc", "usuariId Asc", "usuariId Desc", "FechaInicio Asc", "FechaInicio Desc", "FechaFin Asc", "FechaFin Desc", "precio Asc", "precio Desc", " " }));
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

        buttonVolver2.setBackground(new java.awt.Color(153, 204, 0));
        buttonVolver2.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        buttonVolver2.setText("VOLVER");
        buttonVolver2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonVolver2.setBorderPainted(false);
        buttonVolver2.setFocusable(false);
        buttonVolver2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVolver2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelFiltrosLayout = new javax.swing.GroupLayout(jPanelFiltros);
        jPanelFiltros.setLayout(jPanelFiltrosLayout);
        jPanelFiltrosLayout.setHorizontalGroup(
            jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFiltrosLayout.createSequentialGroup()
                .addGroup(jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelDescripcion2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelFiltrosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelFiltrosDeBusqueda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                            .addGroup(jPanelFiltrosLayout.createSequentialGroup()
                                .addGroup(jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanelFiltrosLayout.createSequentialGroup()
                                            .addComponent(jButtonFiltrar)
                                            .addGap(25, 25, 25)
                                            .addComponent(buttonVolver2))
                                        .addGroup(jPanelFiltrosLayout.createSequentialGroup()
                                            .addGroup(jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFiltrosLayout.createSequentialGroup()
                                                    .addGroup(jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabelOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                            .addComponent(jUsuariId, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(jLabelPeliculaId, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(jLabelFechaInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                                .addGroup(jPanelFiltrosLayout.createSequentialGroup()
                                                    .addComponent(jLabelPrecio)
                                                    .addGap(54, 54, 54)))
                                            .addGroup(jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jTextFieldFechaInicio)
                                                .addComponent(jComboBoxFiltros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextFieldUsuariId)
                                                .addComponent(jTextFieldPeliculaId)
                                                .addComponent(jTextFieldFechaFin)
                                                .addComponent(jTextFieldPrecio))))
                                    .addComponent(jLabelFechaFin))
                                .addGap(0, 0, Short.MAX_VALUE)))))
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
                    .addComponent(jLabelPeliculaId)
                    .addComponent(jTextFieldPeliculaId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jUsuariId)
                    .addComponent(jTextFieldUsuariId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFechaInicio)
                    .addComponent(jTextFieldFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFechaFin)
                    .addComponent(jTextFieldFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPrecio)
                    .addComponent(jTextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelOrden)
                    .addComponent(jComboBoxFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonFiltrar)
                    .addComponent(buttonVolver2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );

        jPanelAlquileresFiltrados.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPaneAlquileresFiltrados.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPaneAlquileresFiltrados.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPaneAlquileresFiltrados.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPaneAlquileresFiltrados.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N

        jTableAlquileresFiltrados.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jTableAlquileresFiltrados.setFillsViewportHeight(true);
        jTableAlquileresFiltrados.setFocusable(false);
        jTableAlquileresFiltrados.setGridColor(new java.awt.Color(153, 153, 153));
        jTableAlquileresFiltrados.setSelectionBackground(new java.awt.Color(102, 204, 255));
        jScrollPaneAlquileresFiltrados.setViewportView(jTableAlquileresFiltrados);

        jLabelAlquileresFiltrados.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabelAlquileresFiltrados.setText("ALQUILERES");

        jButtonAnteriorAlquileresFiltrados.setBackground(new java.awt.Color(242, 242, 242));
        jButtonAnteriorAlquileresFiltrados.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jButtonAnteriorAlquileresFiltrados.setText("Anterior");
        jButtonAnteriorAlquileresFiltrados.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonAnteriorAlquileresFiltrados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnteriorAlquileresFiltradosActionPerformed(evt);
            }
        });

        jLabelPaginaAlquileresFiltrados.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabelPaginaAlquileresFiltrados.setText("1");

        jButtonSiguienteAlquileresFiltrados.setBackground(new java.awt.Color(242, 242, 242));
        jButtonSiguienteAlquileresFiltrados.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jButtonSiguienteAlquileresFiltrados.setText("Siguiente");
        jButtonSiguienteAlquileresFiltrados.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonSiguienteAlquileresFiltrados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSiguienteAlquileresFiltradosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAlquileresFiltradosLayout = new javax.swing.GroupLayout(jPanelAlquileresFiltrados);
        jPanelAlquileresFiltrados.setLayout(jPanelAlquileresFiltradosLayout);
        jPanelAlquileresFiltradosLayout.setHorizontalGroup(
            jPanelAlquileresFiltradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAlquileresFiltradosLayout.createSequentialGroup()
                .addGroup(jPanelAlquileresFiltradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAlquileresFiltradosLayout.createSequentialGroup()
                        .addGroup(jPanelAlquileresFiltradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelAlquileresFiltradosLayout.createSequentialGroup()
                                .addGap(258, 258, 258)
                                .addComponent(jLabelAlquileresFiltrados))
                            .addGroup(jPanelAlquileresFiltradosLayout.createSequentialGroup()
                                .addGap(179, 179, 179)
                                .addComponent(jButtonAnteriorAlquileresFiltrados)
                                .addGap(35, 35, 35)
                                .addComponent(jLabelPaginaAlquileresFiltrados, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jButtonSiguienteAlquileresFiltrados)))
                        .addGap(0, 242, Short.MAX_VALUE))
                    .addComponent(jScrollPaneAlquileresFiltrados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelAlquileresFiltradosLayout.setVerticalGroup(
            jPanelAlquileresFiltradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAlquileresFiltradosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelAlquileresFiltrados)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneAlquileresFiltrados, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelAlquileresFiltradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAnteriorAlquileresFiltrados)
                    .addComponent(jButtonSiguienteAlquileresFiltrados)
                    .addComponent(jLabelPaginaAlquileresFiltrados))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelGestionAlquilerPeliculasLayout = new javax.swing.GroupLayout(jPanelGestionAlquilerPeliculas);
        jPanelGestionAlquilerPeliculas.setLayout(jPanelGestionAlquilerPeliculasLayout);
        jPanelGestionAlquilerPeliculasLayout.setHorizontalGroup(
            jPanelGestionAlquilerPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGestionAlquilerPeliculasLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanelGestionAlquilerPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(eliminarAlquilerPelicula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(modificarEstatusAlquiler, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(listaPeliculasUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(alquilarPelicula, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(listaAlquileresPeliculas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanelGestionAlquilerPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelGestionAlquilerPeliculasLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(mensajeAlquilerPeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 260, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGestionAlquilerPeliculasLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonVolver)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonCerrarSesion)
                        .addGap(62, 62, 62))
                    .addGroup(jPanelGestionAlquilerPeliculasLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelPeliculasUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(41, Short.MAX_VALUE))))
            .addGroup(jPanelGestionAlquilerPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelGestionAlquilerPeliculasLayout.createSequentialGroup()
                    .addGap(247, 247, 247)
                    .addComponent(jPanelCambioEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(279, Short.MAX_VALUE)))
            .addGroup(jPanelGestionAlquilerPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGestionAlquilerPeliculasLayout.createSequentialGroup()
                    .addContainerGap(248, Short.MAX_VALUE)
                    .addComponent(jPanelAlquileres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(72, Short.MAX_VALUE)))
            .addGroup(jPanelGestionAlquilerPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelGestionAlquilerPeliculasLayout.createSequentialGroup()
                    .addGap(282, 282, 282)
                    .addComponent(jPanelFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(282, Short.MAX_VALUE)))
            .addGroup(jPanelGestionAlquilerPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGestionAlquilerPeliculasLayout.createSequentialGroup()
                    .addContainerGap(258, Short.MAX_VALUE)
                    .addComponent(jPanelAlquileresFiltrados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(62, 62, 62)))
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
                .addGroup(jPanelGestionAlquilerPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelGestionAlquilerPeliculasLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(listaPeliculasUsuarios)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(listaAlquileresPeliculas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(alquilarPelicula)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(eliminarAlquilerPelicula)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(modificarEstatusAlquiler))
                    .addGroup(jPanelGestionAlquilerPeliculasLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanelPeliculasUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(jPanelGestionAlquilerPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCerrarSesion)
                    .addComponent(jButtonVolver))
                .addContainerGap())
            .addGroup(jPanelGestionAlquilerPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGestionAlquilerPeliculasLayout.createSequentialGroup()
                    .addContainerGap(153, Short.MAX_VALUE)
                    .addComponent(jPanelCambioEstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(48, 48, 48)))
            .addGroup(jPanelGestionAlquilerPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGestionAlquilerPeliculasLayout.createSequentialGroup()
                    .addContainerGap(77, Short.MAX_VALUE)
                    .addComponent(jPanelAlquileres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(48, Short.MAX_VALUE)))
            .addGroup(jPanelGestionAlquilerPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelGestionAlquilerPeliculasLayout.createSequentialGroup()
                    .addGap(82, 82, 82)
                    .addComponent(jPanelFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(83, Short.MAX_VALUE)))
            .addGroup(jPanelGestionAlquilerPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGestionAlquilerPeliculasLayout.createSequentialGroup()
                    .addContainerGap(87, Short.MAX_VALUE)
                    .addComponent(jPanelAlquileresFiltrados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(38, 38, 38)))
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
         *
         * @author Carlos
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
        /**
         * metodo para mostrar las lista de las peliculas y los usuarios de manera paginada.
         *
         * @author Carlos
         */

        //Mostramos el panel de lista 
        //de peliculas y usuarios.
        jPanelPeliculasUsuarios.setVisible(true);
        //Cerramos otros paneles si estuvieran abiertos.
        jPanelAlquileres.setVisible(false);
        jPanelCambioEstatus.setVisible(false);
        jPanelFiltros.setVisible(false);

        paginaPeliculas = 0;
        paginaUsuarios = 0;
        /**
         * Esta es la primera tabla de peliculas que se muestra. pagina 0 ( 1 en pantalla.)
         */
        // Creamos la URL
        // Es una url con tres parametros en modo query.
        StringBuilder resultadoPeliculas = new StringBuilder();
        try {
            // Creamos la URL
            URL url = new URL(Constants.urlPeliculasPaginadas
                    + "?page=" + paginaPeliculas
                    + "&pageSize=" + paginaSizePeliculas
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

        //*************************************************
        // El array de objetos JSON lo convertimos en un array de objetos DTO.
        // Lo transformamos gracias al objeto DTO creado para ello.
        ResponsePeliculaListDTO responseJson = gson.fromJson(responseJsonString, ResponsePeliculaListDTO.class);
        //*************************************************
        paginasTotalesPeliculas = responseJson.getValue().getTotalPages();
        jLabelPaginaPeliculas.setText(String.valueOf(paginaPeliculas + 1) + " de " + paginasTotalesPeliculas);

        //Creamos una lista de objetos JSON
        jsonArrayPeliculas = new JSONArray();
        for (int i = 0; i < responseJson.getValue().getContent().size(); i++) {
            JSONObject objPelicula = new JSONObject();
            objPelicula.put("id", responseJson.getValue().getContent().get(i).getId());
            objPelicula.put("TITULO", responseJson.getValue().getContent().get(i).getTitulo());
            objPelicula.put("DIRECTOR", responseJson.getValue().getContent().get(i).getDirector());
            objPelicula.put("GENERO", responseJson.getValue().getContent().get(i).getGenero());
            objPelicula.put("DURACION", responseJson.getValue().getContent().get(i).getDuracion());
            objPelicula.put("AÑO", responseJson.getValue().getContent().get(i).getAño());
            objPelicula.put("PRECIO", responseJson.getValue().getContent().get(i).getPrecio());
            objPelicula.put("ALQUILERES", responseJson.getValue().getContent().get(i).getVecesAlquilada());
            jsonArrayPeliculas.put(objPelicula);
        }

        //Creamos un String[] de columnas
        String[] columnNamesPeliculas = {"TITULO", "DIRECTOR", "PRECIO", "ALQUILERES"};

        //Creamos el modelo de tabla
        modelPeliculas = new TablePeliculas(jsonArrayPeliculas, columnNamesPeliculas);
        //Asignamos el modelo a la tabla
        jTablePeliculas.setModel(modelPeliculas);
        //Mostramos la tabla
        //Añadimos color a la cabecera.
        JTableHeader header = jTablePeliculas.getTableHeader();
        header.setBackground(Color.CYAN);
        //Ponemos los datos numericos en el centro de la celda.
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
        jTablePeliculas.getColumnModel().getColumn(2).setCellRenderer(renderer);
        jTablePeliculas.getColumnModel().getColumn(3).setCellRenderer(renderer);
        //Asignamos el ancho de las columnas.
        jTablePeliculas.getColumnModel().getColumn(0).setPreferredWidth(140);
        jTablePeliculas.getColumnModel().getColumn(2).setPreferredWidth(25);
        jTablePeliculas.getColumnModel().getColumn(3).setPreferredWidth(50);

        /**
         * Esta es la primera tabla de usuarios que se muestra. pagina 0 ( 1 en pantalla.)
         *
         */
        //Leemos la lista de usuarios.
        StringBuilder resultadoUsuarios = new StringBuilder();
        try {
            // Creamos la URL
            // Es una url con tres parametros en modo query.
            URL url = new URL(Constants.urlUsuariosPaginados
                    + "?page=" + paginaUsuarios
                    + "&pageSize=" + paginaSizeUsuarios
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
        paginasTotalesUsuarios = responseJson.getValue().getTotalPages();
        jLabelPaginaUsuario.setText(String.valueOf(paginaUsuarios + 1) + " de " + paginasTotalesUsuarios);
        //Creamos una lista de objetos JSON
        jsonArrayUsuarios = new JSONArray();
        for (int i = 0; i < responseJsonUsuarios.getValue().getContent().size(); i++) {
            JSONObject objUsuario = new JSONObject();
            objUsuario.put("id", responseJsonUsuarios.getValue().getContent().get(i).getId());
            objUsuario.put("NOMBRE", responseJsonUsuarios.getValue().getContent().get(i).getNombre());
            objUsuario.put("APELLIDOS", responseJsonUsuarios.getValue().getContent().get(i).getApellidos());
            objUsuario.put("TELEFONO", responseJsonUsuarios.getValue().getContent().get(i).getTelefono());
            objUsuario.put("EMAIL", responseJsonUsuarios.getValue().getContent().get(i).getEmail());
            objUsuario.put("DIRECCION", responseJsonUsuarios.getValue().getContent().get(i).getDireccion());
            objUsuario.put("IsAdmin", responseJsonUsuarios.getValue().getContent().get(i).getIsAdmin());
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
        headerUsuarios.setBackground(Color.CYAN);

    }//GEN-LAST:event_listaPeliculasUsuariosActionPerformed

    private void jButtonCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarSesionActionPerformed
        /**
         * Metodo para cerrar la sesion y volver a inicio.
         *
         * @author Carlos
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

        //Cerramos otros paneles si estuvieran abiertos.
        jPanelPeliculasUsuarios.setVisible(false);
        jPanelCambioEstatus.setVisible(false);

        //Obtenemos la fila seleccionada de alquileres.
        posicionAlquiler = jTableAlquileres.getSelectedRow();

        if (posicionAlquiler == -1) {
            // No se ha seleccionado alquiler de la lista.
            // Mostramos mensaje emergente de informacion.
            JOptionPane.showMessageDialog(this,
                    "Debes seleccionar un alquiler\n"
                    + "de la tabla de alquileres.",
                    "ELIMINAR PELICULA", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Se ha seleccionado un alquiler de la lista.
            // Creamos objeto JSON temporal de la fila seleccionada.
            objAlquiler = new JSONObject();
            objAlquiler = jsonArrayAlquileres.getJSONObject(posicionAlquiler);

            //Asignamos el id del alquiler a su variable UUID.
            UUID id = (UUID) objAlquiler.get("idAlquiler");

            // Mostramos mensaje emergente de confirmacion.
            int opcion = JOptionPane.showConfirmDialog(this,
                    "Deseas eliminar el alquiler\n"
                    + id + " ? ",
                    "CONFIRMACION",
                    JOptionPane.YES_NO_OPTION);

            if (opcion == JOptionPane.YES_OPTION) {
                //Eliminamos alquiler.

                // Creamos el cliente de acceso
                Client client = ClientBuilder.newClient();

                // Creamos el target (URL)
                WebTarget target = client.target(Constants.urlPeliculasDeleteAlquilerId
                        + id
                        + "?token=" + Constants.token);

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

                    //Limpiamos la seleccion actual.
                    jTableAlquileres.clearSelection();
                    jPanelAlquileres.setVisible(false);

                } else {
                    // Si ha habido error en la operacion.
                    // Mostramos mensaje emergente de informacion.
                    JOptionPane.showMessageDialog(this,
                            "Ha ocurrido un error inesperado.",
                            "ELIMINAR ALQUILER", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                //ceramos el panel de alquileres.
                jTableAlquileres.clearSelection();
                jPanelAlquileres.setVisible(false);
            }
        }
    }//GEN-LAST:event_eliminarAlquilerPeliculaActionPerformed
    /**
     *
     * Metodo para asignar un alquiler de pelicula a un usuario.
     *
     * @author Carlos.
     *
     */
    private void alquilarPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alquilarPeliculaActionPerformed

        //Cerramos lo que este abierto.
        jPanelAlquileres.setVisible(false);
        jPanelCambioEstatus.setVisible(false);

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
                                + "Titulo: " + objPelicula.get("TITULO") + "\n"
                                + "Usuario: " + objUsuario.get("NOMBRE") + " " + objUsuario.get("APELLIDOS") + "\n"
                                + "Fecha de inicio:           " + responseJson.getValue().getFechaInicio() + "\n"
                                + "Fecha de finalizacion: " + responseJson.getValue().getFechaFin() + "\n"
                                + "Estado: " + responseJson.getValue().getEstado(),
                                "ALQUILER PELICULA", JOptionPane.INFORMATION_MESSAGE);

                        //Limpiamos la seleccion actual.
                        jTablePeliculas.clearSelection();
                        jTableUsuarios.clearSelection();

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

        /**
         * Metodo para mostrar la lista de los alquileres de peliculas paginadas de la aplicacion.
         *
         * @author Carlos
         */
        
        //Cerramos otros paneles si estuvieran abiertos.
        jPanelPeliculasUsuarios.setVisible(false);
        jPanelCambioEstatus.setVisible(false);
        jPanelFiltros.setVisible(false);
        jPanelAlquileresFiltrados.setVisible(false);
        paginaAlquileres = 0;
        /**
         * Esta es la primera tabla de alquileres que se muestra. pagina 0 ( 1 en pantalla.)
         *
         */
        //Leemos la lista de alquileres.
        StringBuilder resultadoAlquileres = new StringBuilder();
        try {
            // Creamos la URL
            // Es una url con tres parametros en modo query.
            URL url = new URL(Constants.urlPeliculasAlquileresPaginados
                    + "?page=" + paginaAlquileres
                    + "&pageSize=" + paginaSizeAlquileres
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

        // El array de objetos JSON lo convertimos en un array de objetos DTO.
        // Lo transformamos gracias al objeto DTO creado para ello.
        ResponseAlquilerListDTO responseJson = gson.fromJson(responseJsonString, ResponseAlquilerListDTO.class);
        //*************************************************

        // Si no hay alquileres...
        if (responseJson == null) {
            // Mostramos mensaje emergente de informacion.
            JOptionPane.showMessageDialog(this,
                    "No hay alquileres para mostrar.",
                    "ALQUILERES", JOptionPane.INFORMATION_MESSAGE);
        } else {
            //Mostramos el panel de lista de alquileres.       
            jPanelAlquileres.setVisible(true);
            
            paginasTotalesAlquileres = responseJson.getValue().getTotalPages();
            jLabelPaginaAlquileres.setText(String.valueOf(paginaAlquileres + 1) + " de " + paginasTotalesAlquileres);

            //Creamos una lista de objetos JSON
            jsonArrayAlquileres = new JSONArray();
            for (int i = 0; i < responseJson.getValue().getContent().size(); i++) {
                objAlquiler = new JSONObject();
                objAlquiler.put("idAlquiler", responseJson.getValue().getContent().get(i).getId());
                objAlquiler.put("idPelicula", responseJson.getValue().getContent().get(i).getPelicula());
                objAlquiler.put("idUsuario", responseJson.getValue().getContent().get(i).getUsuari());
                objAlquiler.put("Fecha Inicio", responseJson.getValue().getContent().get(i).getFechaInicio());
                objAlquiler.put("Fecha Fin", responseJson.getValue().getContent().get(i).getFechaFin());
                objAlquiler.put("Precio", responseJson.getValue().getContent().get(i).getPrecio());
                objAlquiler.put("Estado", responseJson.getValue().getContent().get(i).getEstado());
                //Obtenemos el titulo de la pelicula.
                idPelicula = responseJson.getValue().getContent().get(i).getPelicula();
                tituloPelicula = tituloPelicula(idPelicula);
                objAlquiler.put("Titulo Pelicula", tituloPelicula);
                //Obtenemos el nombre del usuario.
                idUsuario = responseJson.getValue().getContent().get(i).getUsuari();
                nombreUser = nombreUsuario(idUsuario);
                objAlquiler.put("Nombre Usuario", nombreUser);

                jsonArrayAlquileres.put(objAlquiler);
            }

            //Creamos un String[] de columnas
            String[] columnNamesPeliculas = {"Titulo Pelicula", "Nombre Usuario", "Fecha Inicio", "Fecha Fin", "Precio", "Estado"};

            //Creamos el modelo de tabla
            modelAlquileres = new TableAlquileres(jsonArrayAlquileres, columnNamesPeliculas);
            //Asignamos el modelo a la tabla
            jTableAlquileres.setModel(modelAlquileres);
            //Mostramos la tabla
            //Añadimos color a la cabecera.
            JTableHeader header = jTableAlquileres.getTableHeader();
            header.setBackground(Color.CYAN);

            //Ponemos los datos numericos centrados en la celda.
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            renderer.setHorizontalAlignment(JLabel.CENTER);
            jTableAlquileres.getColumnModel().getColumn(1).setCellRenderer(renderer);
            jTableAlquileres.getColumnModel().getColumn(2).setCellRenderer(renderer);
            jTableAlquileres.getColumnModel().getColumn(3).setCellRenderer(renderer);
            jTableAlquileres.getColumnModel().getColumn(4).setCellRenderer(renderer);
            //Asignamos el ancho de las columnas.
            jTableAlquileres.getColumnModel().getColumn(0).setPreferredWidth(190);
            jTableAlquileres.getColumnModel().getColumn(2).setPreferredWidth(60);
            jTableAlquileres.getColumnModel().getColumn(3).setPreferredWidth(60);
            jTableAlquileres.getColumnModel().getColumn(4).setPreferredWidth(25);
            jTableAlquileres.getColumnModel().getColumn(5).setPreferredWidth(70);
        }
    }//GEN-LAST:event_listaAlquileresPeliculasActionPerformed

    private void buttonModificarEstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModificarEstatusActionPerformed
        /**
         * Metodo para modificar el estado de un alquiler.
         *
         * @author Carlos
         */

        //Leemos el nuevo estado que hemos seleccionado...
        String estado = (String) jComboBoxEstatus.getSelectedItem();
        // Se ha seleccionado un alquiler de la lista.
        // Creamos objeto JSON temporal de la fila seleccionada.
        objAlquiler = jsonArrayAlquileres.getJSONObject(posicionAlquiler);

        //Asignamos el id del alquiler a su variable UUID.
        UUID id = (UUID) objAlquiler.get("idAlquiler");

        // Mostramos mensaje emergente de confirmacion.
        int opcion = JOptionPane.showConfirmDialog(this,
                "Deseas cambiar el estado del alquiler a\n"
                + estado + " ? ",
                "CONFIRMACION",
                JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {
            //Cambiamos el estado del alquiler.

            try {
                // Creamos la URL.
                URL url = new URL(Constants.urlPeliculasUpdateStatusAlquiler
                        + "?estadoAlquiler=" + estado
                        + "&alquilerId=" + id
                        + "&token=" + Constants.token);

                //Creamos la conexion al servidor.
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                //Metodo PUT
                conn.setDoOutput(true);
                conn.setRequestMethod("PUT");
                //Comprobacion de respuesta del servidor
                System.out.println(conn.getResponseCode());

                // Si todo ha salido correcto.
                if (conn.getResponseCode() == 200) {
                    // Mostramos mensaje emergente de informacion.
                    JOptionPane.showMessageDialog(this,
                            "Estado del alquiler modificado correctamente.",
                            "MODIFICAR ESTADO ALQUILER", JOptionPane.INFORMATION_MESSAGE);

                    jTableAlquileres.clearSelection();
                    jPanelCambioEstatus.setVisible(false);

                }
            } catch (MalformedURLException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            //ceramos el panel de alquileres.
            jTableAlquileres.clearSelection();
            jPanelAlquileres.setVisible(false);
            jPanelCambioEstatus.setVisible(false);

        }

    }//GEN-LAST:event_buttonModificarEstatusActionPerformed

    private void jButtonVolverAlquilerStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverAlquilerStatusActionPerformed
        /**
         *
         * Método para volver a la pantalla anterior.
         *
         * @author Carlos
         */

        jPanelCambioEstatus.setVisible(false);
    }//GEN-LAST:event_jButtonVolverAlquilerStatusActionPerformed

    private void modificarEstatusAlquilerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarEstatusAlquilerActionPerformed

        /**
         * Metodo para cambiar el estado de un alquiler
         *
         * @author Carlos.
         */
        //Cerramos otros paneles si estuvieran abiertos.
        jPanelPeliculasUsuarios.setVisible(false);
        jPanelCambioEstatus.setVisible(false);

        //Obtenemos la fila seleccionada de alquileres.
        posicionAlquiler = jTableAlquileres.getSelectedRow();

        if (posicionAlquiler == -1) {
            // No se ha seleccionado alquiler de la lista.
            // Mostramos mensaje emergente de informacion.
            JOptionPane.showMessageDialog(this,
                    "Debes seleccionar un alquiler\n"
                    + "de la tabla de alquileres.",
                    "MODIFICAR ESTATUS ALQUILER", JOptionPane.INFORMATION_MESSAGE);
        } else {
            jPanelCambioEstatus.setVisible(true);
            jPanelAlquileres.setVisible(false);
            objAlquiler = jsonArrayAlquileres.getJSONObject(posicionAlquiler);
            jTextEstatusActual.setText(objAlquiler.getString("Estado"));

        }

    }//GEN-LAST:event_modificarEstatusAlquilerActionPerformed

    private void jButtonAnteriorPeliculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnteriorPeliculasActionPerformed
        /**
         * Hago la consulta de tabla. Con la pagina anterior. Leo los datos en el DTO para ello. Paso los datos a la tabla.
         *
         */
        if (paginaPeliculas > 0) {
            paginaPeliculas--;

            StringBuilder resultado = new StringBuilder();
            try {
                // Creamos la URL
                /*
                URL url = new URL(Constants.urlPeliculas + "?token=" + Constants.token);
                 */

                URL url = new URL(Constants.urlPeliculasPaginadas
                        + "?page=" + paginaPeliculas
                        + "&pageSize=" + paginaSizePeliculas
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
            jLabelPaginaPeliculas.setText(String.valueOf(paginaPeliculas + 1) + " de " + paginasTotalesPeliculas);

            //Creamos una lista de objetos JSON
            jsonArrayPeliculas = new JSONArray();
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
                jsonArrayPeliculas.put(obj);
            }

            //Creamos un String[] de columnas
            String[] columnNames = {"TITULO", "DIRECTOR", "PRECIO", "ALQUILERES"};

            //Creamos el modelo de tabla
            modelPeliculas = new TablePeliculas(jsonArrayPeliculas, columnNames);
            //Asignamos el modelo a la tabla
            jTablePeliculas.setModel(modelPeliculas);
            //Mostramos la tabla
            //Añadimos color a la cabecera.
            JTableHeader header = jTablePeliculas.getTableHeader();
            header.setBackground(Color.CYAN);
            //Ponemos los datos numericos en el lado derecho de la celda.
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            renderer.setHorizontalAlignment(JLabel.CENTER);
            jTablePeliculas.getColumnModel().getColumn(2).setCellRenderer(renderer);
            jTablePeliculas.getColumnModel().getColumn(3).setCellRenderer(renderer);
            //Asignamos el ancho de las columnas.
            jTablePeliculas.getColumnModel().getColumn(0).setPreferredWidth(140);
            jTablePeliculas.getColumnModel().getColumn(2).setPreferredWidth(25);
            jTablePeliculas.getColumnModel().getColumn(3).setPreferredWidth(50);

        }
    }//GEN-LAST:event_jButtonAnteriorPeliculasActionPerformed

    private void jButtonSiguientePeliculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSiguientePeliculasActionPerformed
        /**
         * Hago la consulta de tabla. Con la pagina siguiente. Leo los datos en el DTO para ello. Paso los datos a la tabla.
         *
         */
        if (paginaPeliculas < paginasTotalesPeliculas - 1) {
            paginaPeliculas++;

            StringBuilder resultado = new StringBuilder();
            try {
                // Creamos la URL
                /*
                URL url = new URL(Constants.urlPeliculas + "?token=" + Constants.token);
                 */

                URL url = new URL(Constants.urlPeliculasPaginadas
                        + "?page=" + paginaPeliculas
                        + "&pageSize=" + paginaSizePeliculas
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
            jLabelPaginaPeliculas.setText(String.valueOf(paginaPeliculas + 1) + " de " + paginasTotalesPeliculas);

            //Creamos una lista de objetos JSON
            jsonArrayPeliculas = new JSONArray();
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
                jsonArrayPeliculas.put(obj);
            }

            //Creamos un String[] de columnas
            String[] columnNames = {"TITULO", "DIRECTOR", "PRECIO", "ALQUILERES"};

            //Creamos el modelo de tabla
            modelPeliculas = new TablePeliculas(jsonArrayPeliculas, columnNames);
            //Asignamos el modelo a la tabla
            jTablePeliculas.setModel(modelPeliculas);
            //Mostramos la tabla
            //Añadimos color a la cabecera.
            JTableHeader header = jTablePeliculas.getTableHeader();
            header.setBackground(Color.CYAN);
            //Ponemos los datos numericos en el lado derecho de la celda.
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            renderer.setHorizontalAlignment(JLabel.CENTER);
            jTablePeliculas.getColumnModel().getColumn(2).setCellRenderer(renderer);
            jTablePeliculas.getColumnModel().getColumn(3).setCellRenderer(renderer);
            //Asignamos el ancho de las columnas.
            jTablePeliculas.getColumnModel().getColumn(0).setPreferredWidth(140);
            jTablePeliculas.getColumnModel().getColumn(2).setPreferredWidth(25);
            jTablePeliculas.getColumnModel().getColumn(3).setPreferredWidth(50);
        }

    }//GEN-LAST:event_jButtonSiguientePeliculasActionPerformed

    private void jButtonSiguienteUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSiguienteUsuariosActionPerformed

        /**
         * Hago la consulta de tabla. Con la siguiente pagina. Leo los datos en el DTO para ello. Paso los datos a la tabla.
         *
         */
        if (paginaUsuarios < paginasTotalesUsuarios - 1) {
            paginaUsuarios++;
            StringBuilder resultado = new StringBuilder();
            try {
                // Creamos la URL
                // Es una url con tres parametros en modo query.

                URL url = new URL(Constants.urlUsuariosPaginados
                        + "?page=" + paginaUsuarios
                        + "&pageSize=" + paginaSizeUsuarios
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
            ResponseUserListDTO responseJson = gson.fromJson(responseJsonString, ResponseUserListDTO.class);
            //*************************************************

            //Actualizo el label del contador de paginas.
            jLabelPaginaUsuario.setText(String.valueOf(paginaUsuarios + 1) + " de " + paginasTotalesUsuarios);

            //Creamos una lista de objetos JSON
            jsonArrayUsuarios = new JSONArray();
            for (int i = 0; i < responseJson.getValue().getContent().size(); i++) {
                JSONObject obj = new JSONObject();
                obj.put("id", responseJson.getValue().getContent().get(i).getId());
                obj.put("NOMBRE", responseJson.getValue().getContent().get(i).getNombre());
                obj.put("APELLIDOS", responseJson.getValue().getContent().get(i).getApellidos());
                obj.put("TELEFONO", responseJson.getValue().getContent().get(i).getTelefono());
                obj.put("EMAIL", responseJson.getValue().getContent().get(i).getEmail());
                obj.put("DIRECCION", responseJson.getValue().getContent().get(i).getDireccion());
                obj.put("IsAdmin", responseJson.getValue().getContent().get(i).getIsAdmin());
                jsonArrayUsuarios.put(obj);
            }

            //Actualizo la tabla.
            //Creamos un String[] de columnas
            String[] columnNames = {"NOMBRE", "APELLIDOS"};

            //Creamos el modelo de tabla
            modelUsuarios = new TableUsuarios(jsonArrayUsuarios, columnNames);
            //Asignamos el modelo a la tabla
            jTableUsuarios.setModel(modelUsuarios);
            //Mostramos la lista
            //Añadimos color a la cabecera.
            JTableHeader headerUsuarios = jTableUsuarios.getTableHeader();
            headerUsuarios.setBackground(Color.CYAN);
        }
    }//GEN-LAST:event_jButtonSiguienteUsuariosActionPerformed

    private void jButtonAnteriorUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnteriorUsuariosActionPerformed

        /**
         * Hago la consulta de tabla. Con la pagina anterior. Leo los datos en el DTO para ello. Paso los datos a la tabla.
         *
         */
        if (paginaUsuarios > 0) {
            paginaUsuarios--;
            StringBuilder resultado = new StringBuilder();
            try {
                // Creamos la URL
                // Es una url con tres parametros en modo query.

                URL url = new URL(Constants.urlUsuariosPaginados
                        + "?page=" + paginaUsuarios
                        + "&pageSize=" + paginaSizeUsuarios
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
            ResponseUserListDTO responseJson = gson.fromJson(responseJsonString, ResponseUserListDTO.class);
            //*************************************************

            //Actualizo el label del contador de paginas.
            jLabelPaginaUsuario.setText(String.valueOf(paginaUsuarios + 1) + " de " + paginasTotalesUsuarios);

            //Creamos una lista de objetos JSON
            jsonArrayUsuarios = new JSONArray();
            for (int i = 0; i < responseJson.getValue().getContent().size(); i++) {
                JSONObject obj = new JSONObject();
                obj.put("id", responseJson.getValue().getContent().get(i).getId());
                obj.put("NOMBRE", responseJson.getValue().getContent().get(i).getNombre());
                obj.put("APELLIDOS", responseJson.getValue().getContent().get(i).getApellidos());
                obj.put("TELEFONO", responseJson.getValue().getContent().get(i).getTelefono());
                obj.put("EMAIL", responseJson.getValue().getContent().get(i).getEmail());
                obj.put("DIRECCION", responseJson.getValue().getContent().get(i).getDireccion());
                obj.put("IsAdmin", responseJson.getValue().getContent().get(i).getIsAdmin());
                jsonArrayUsuarios.put(obj);
            }

            //Actualizo la tabla.
            //Creamos un String[] de columnas
            String[] columnNames = {"NOMBRE", "APELLIDOS"};

            //Creamos el modelo de tabla
            modelUsuarios = new TableUsuarios(jsonArrayUsuarios, columnNames);
            //Asignamos el modelo a la tabla
            jTableUsuarios.setModel(modelUsuarios);
            //Mostramos la lista
            //Añadimos color a la cabecera.
            JTableHeader headerUsuarios = jTableUsuarios.getTableHeader();
            headerUsuarios.setBackground(Color.CYAN);
        }
    }//GEN-LAST:event_jButtonAnteriorUsuariosActionPerformed

    private void jButtonAnteriorAlquileresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnteriorAlquileresActionPerformed
        /**
         * Hago la consulta de tabla. Con la pagina anterior. Leo los datos en el DTO para ello. Paso los datos a la tabla.
         *
         */
        if (paginaAlquileres > 0) {
            paginaAlquileres--;
            //Leemos la lista de alquileres.
            StringBuilder resultadoAlquileres = new StringBuilder();
            try {
                // Creamos la URL
                // Es una url con tres parametros en modo query.
                URL url = new URL(Constants.urlPeliculasAlquileresPaginados
                        + "?page=" + paginaAlquileres
                        + "&pageSize=" + paginaSizeAlquileres
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

            // El array de objetos JSON lo convertimos en un array de objetos DTO.
            // Lo transformamos gracias al objeto DTO creado para ello.
            ResponseAlquilerListDTO responseJson = gson.fromJson(responseJsonString, ResponseAlquilerListDTO.class);
            //*************************************************

            jLabelPaginaAlquileres.setText(String.valueOf(paginaAlquileres + 1) + " de " + paginasTotalesAlquileres);

            //Creamos una lista de objetos JSON
            jsonArrayAlquileres = new JSONArray();
            for (int i = 0; i < responseJson.getValue().getContent().size(); i++) {
                objAlquiler = new JSONObject();
                objAlquiler.put("idAlquiler", responseJson.getValue().getContent().get(i).getId());
                objAlquiler.put("idPelicula", responseJson.getValue().getContent().get(i).getPelicula());
                objAlquiler.put("idUsuario", responseJson.getValue().getContent().get(i).getUsuari());
                objAlquiler.put("Fecha Inicio", responseJson.getValue().getContent().get(i).getFechaInicio());
                objAlquiler.put("Fecha Fin", responseJson.getValue().getContent().get(i).getFechaFin());
                objAlquiler.put("Precio", responseJson.getValue().getContent().get(i).getPrecio());
                objAlquiler.put("Estado", responseJson.getValue().getContent().get(i).getEstado());
                //Obtenemos el titulo de la pelicula.
                idPelicula = responseJson.getValue().getContent().get(i).getPelicula();
                tituloPelicula = tituloPelicula(idPelicula);
                objAlquiler.put("Titulo Pelicula", tituloPelicula);
                //Obtenemos el nombre del usuario.
                idUsuario = responseJson.getValue().getContent().get(i).getUsuari();
                nombreUser = nombreUsuario(idUsuario);
                objAlquiler.put("Nombre Usuario", nombreUser);

                jsonArrayAlquileres.put(objAlquiler);
            }

            //Creamos un String[] de columnas
            String[] columnNamesPeliculas = {"Titulo Pelicula", "Nombre Usuario", "Fecha Inicio", "Fecha Fin", "Precio", "Estado"};

            //Creamos el modelo de tabla
            modelAlquileres = new TableAlquileres(jsonArrayAlquileres, columnNamesPeliculas);
            //Asignamos el modelo a la tabla
            jTableAlquileres.setModel(modelAlquileres);
            //Mostramos la tabla
            //Añadimos color a la cabecera.
            JTableHeader header = jTableAlquileres.getTableHeader();
            header.setBackground(Color.CYAN);

            //Ponemos los datos numericos centrados en la celda.
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            renderer.setHorizontalAlignment(JLabel.CENTER);
            jTableAlquileres.getColumnModel().getColumn(1).setCellRenderer(renderer);
            jTableAlquileres.getColumnModel().getColumn(2).setCellRenderer(renderer);
            jTableAlquileres.getColumnModel().getColumn(3).setCellRenderer(renderer);
            jTableAlquileres.getColumnModel().getColumn(4).setCellRenderer(renderer);
            //Asignamos el ancho de las columnas.
            jTableAlquileres.getColumnModel().getColumn(0).setPreferredWidth(190);
            jTableAlquileres.getColumnModel().getColumn(2).setPreferredWidth(60);
            jTableAlquileres.getColumnModel().getColumn(3).setPreferredWidth(60);
            jTableAlquileres.getColumnModel().getColumn(4).setPreferredWidth(25);
            jTableAlquileres.getColumnModel().getColumn(5).setPreferredWidth(70);
        }
    }//GEN-LAST:event_jButtonAnteriorAlquileresActionPerformed

    private void jButtonSiguienteAlquileresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSiguienteAlquileresActionPerformed
        /**
         * Hago la consulta de tabla. Con la pagina siguiente. Leo los datos en el DTO para ello. Paso los datos a la tabla.
         *
         */
        if (paginaAlquileres < paginasTotalesAlquileres - 1) {
            paginaAlquileres++;
            //Leemos la lista de alquileres.
            StringBuilder resultadoAlquileres = new StringBuilder();
            try {
                // Creamos la URL
                // Es una url con tres parametros en modo query.
                URL url = new URL(Constants.urlPeliculasAlquileresPaginados
                        + "?page=" + paginaAlquileres
                        + "&pageSize=" + paginaSizeAlquileres
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

            // El array de objetos JSON lo convertimos en un array de objetos DTO.
            // Lo transformamos gracias al objeto DTO creado para ello.
            ResponseAlquilerListDTO responseJson = gson.fromJson(responseJsonString, ResponseAlquilerListDTO.class);
            //*************************************************

            jLabelPaginaAlquileres.setText(String.valueOf(paginaAlquileres + 1) + " de " + paginasTotalesAlquileres);

            //Creamos una lista de objetos JSON
            jsonArrayAlquileres = new JSONArray();
            for (int i = 0; i < responseJson.getValue().getContent().size(); i++) {
                objAlquiler = new JSONObject();
                objAlquiler.put("idAlquiler", responseJson.getValue().getContent().get(i).getId());
                objAlquiler.put("idPelicula", responseJson.getValue().getContent().get(i).getPelicula());
                objAlquiler.put("idUsuario", responseJson.getValue().getContent().get(i).getUsuari());
                objAlquiler.put("Fecha Inicio", responseJson.getValue().getContent().get(i).getFechaInicio());
                objAlquiler.put("Fecha Fin", responseJson.getValue().getContent().get(i).getFechaFin());
                objAlquiler.put("Precio", responseJson.getValue().getContent().get(i).getPrecio());
                objAlquiler.put("Estado", responseJson.getValue().getContent().get(i).getEstado());

                //Obtenemos el titulo de la pelicula.
                idPelicula = responseJson.getValue().getContent().get(i).getPelicula();
                tituloPelicula = tituloPelicula(idPelicula);
                objAlquiler.put("Titulo Pelicula", tituloPelicula);

                //Obtenemos el nombre del usuario.
                idUsuario = responseJson.getValue().getContent().get(i).getUsuari();
                nombreUser = nombreUsuario(idUsuario);
                objAlquiler.put("Nombre Usuario", nombreUser);

                jsonArrayAlquileres.put(objAlquiler);
            }

            //Creamos un String[] de columnas
            String[] columnNamesPeliculas = {"Titulo Pelicula", "Nombre Usuario", "Fecha Inicio", "Fecha Fin", "Precio", "Estado"};

            //Creamos el modelo de tabla
            modelAlquileres = new TableAlquileres(jsonArrayAlquileres, columnNamesPeliculas);
            //Asignamos el modelo a la tabla
            jTableAlquileres.setModel(modelAlquileres);
            //Mostramos la tabla
            //Añadimos color a la cabecera.
            JTableHeader header = jTableAlquileres.getTableHeader();
            header.setBackground(Color.CYAN);

            //Ponemos los datos numericos centrados en la celda.
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            renderer.setHorizontalAlignment(JLabel.CENTER);
            jTableAlquileres.getColumnModel().getColumn(1).setCellRenderer(renderer);
            jTableAlquileres.getColumnModel().getColumn(2).setCellRenderer(renderer);
            jTableAlquileres.getColumnModel().getColumn(3).setCellRenderer(renderer);
            jTableAlquileres.getColumnModel().getColumn(4).setCellRenderer(renderer);
            //Asignamos el ancho de las columnas.
            jTableAlquileres.getColumnModel().getColumn(0).setPreferredWidth(190);
            jTableAlquileres.getColumnModel().getColumn(2).setPreferredWidth(60);
            jTableAlquileres.getColumnModel().getColumn(3).setPreferredWidth(60);
            jTableAlquileres.getColumnModel().getColumn(4).setPreferredWidth(25);
            jTableAlquileres.getColumnModel().getColumn(5).setPreferredWidth(70);
        }
    }//GEN-LAST:event_jButtonSiguienteAlquileresActionPerformed

    private void jButtonFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFiltrarActionPerformed

        /**
         * Metodo para mostrar la lista de alquileres filtrada por los parametros de búsqueda.
         *
         * Esta es la primera tabla de alquileres filtradas que se muestra. pagina 0 ( 1 en pantalla.)
         *
         * @Author Carlos.
         */
        //cerramos los paneles que hubieran estado abiertos.
        jPanelCambioEstatus.setVisible(false);
        jPanelPeliculasUsuarios.setVisible(false);
        jPanelAlquileres.setVisible(false);
        jPanelFiltros.setVisible(false);

        //Variables de la url.
        String peliculaId;
        String usuariId;
        String fechaInicio, fechaFin, precio;
        parametros = "";

        // Leemos los campos seleccionados
        // y creamos la cadena de parametros.
        if (!jTextFieldPeliculaId.getText().isEmpty()) {
            peliculaId = jTextFieldPeliculaId.getText();
            parametros = parametros + "&peliculaId=" + peliculaId;

        }

        if (!jTextFieldUsuariId.getText().isEmpty()) {
            usuariId = jTextFieldUsuariId.getText();
            parametros = parametros + "&usuariId=" + usuariId;

        }

        if (!jTextFieldFechaInicio.getText().isEmpty()) {
            fechaInicio = jTextFieldFechaInicio.getText();
            parametros = parametros + "&fechaInicio=" + fechaInicio;

        }

        if (!jTextFieldFechaFin.getText().isEmpty()) {
            fechaFin = jTextFieldFechaFin.getText();
            parametros = parametros + "&fechaFin=" + fechaFin;

        }

        if (!jTextFieldPrecio.getText().isEmpty()) {
            precio = jTextFieldPrecio.getText();
            parametros = parametros + "&precio=" + precio;

        }

        //Leemos el orden que hemos seleccionado...
        String orden = (String) jComboBoxFiltros.getSelectedItem();

        //Asignamos el string parametro del orden.
        orden = switch (orden) {
            case "peliculaId Asc" ->
                "&orden=peliculaIdAsc";
            case "peliculaId Desc" ->
                "&orden=peliculaIdDesc";
            case "usuariId Asc" ->
                "&orden=usuariIdAsc";
            case "usuariId Desc" ->
                "&orden=usuariDesc";
            case "FechaInicio Asc" ->
                "&orden=FechaInicioAsc";
            case "FechaInicio Desc" ->
                "&orden=FechaInicioDesc";
            case "FechaFin Asc" ->
                "&orden=FechaFinAsc";
            case "FechaFin Desc" ->
                "&orden=FechaFinDesc";
            case "precio Asc" ->
                "&orden=precioAsc";
            case "precio Desc" ->
                "&orden=precioDesc";
            default ->
                "";
        };

        //Terminamos de crear el string parametros de la url.
        parametros = parametros + orden;

        //Tabla alquileres filtrados.
        jPanelAlquileresFiltrados.setVisible(true);

        // Creamos la URL
        // Es una url con cuatro parametros en modo PATH.
        StringBuilder resultado = new StringBuilder();
        try {

            URL url = new URL(Constants.urlPeliculasAlquileresPaginados
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
            // y construimos el string 'resultado'
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
        ResponseAlquilerListDTO responseJson = gson.fromJson(responseJsonString, ResponseAlquilerListDTO.class);
        //*************************************************

        paginasTotalesFiltro = responseJson.getValue().getTotalPages();
        jLabelPaginaAlquileresFiltrados.setText(String.valueOf(paginaFiltro + 1) + " de " + paginasTotalesFiltro);

        //Creamos una lista de objetos JSON
        jsonArrayAlquileres = new JSONArray();
        for (int i = 0; i < responseJson.getValue().getContent().size(); i++) {
            objAlquiler = new JSONObject();
            objAlquiler.put("idAlquiler", responseJson.getValue().getContent().get(i).getId());
            objAlquiler.put("idPelicula", responseJson.getValue().getContent().get(i).getPelicula());
            objAlquiler.put("idUsuario", responseJson.getValue().getContent().get(i).getUsuari());
            objAlquiler.put("Fecha Inicio", responseJson.getValue().getContent().get(i).getFechaInicio());
            objAlquiler.put("Fecha Fin", responseJson.getValue().getContent().get(i).getFechaFin());
            objAlquiler.put("Precio", responseJson.getValue().getContent().get(i).getPrecio());
            objAlquiler.put("Estado", responseJson.getValue().getContent().get(i).getEstado());
            //Obtenemos el titulo de la pelicula.
            idPelicula = responseJson.getValue().getContent().get(i).getPelicula();
            tituloPelicula = tituloPelicula(idPelicula);
            objAlquiler.put("Titulo Pelicula", tituloPelicula);
            //Obtenemos el nombre del usuario.
            idUsuario = responseJson.getValue().getContent().get(i).getUsuari();
            nombreUser = nombreUsuario(idUsuario);
            objAlquiler.put("Nombre Usuario", nombreUser);

            jsonArrayAlquileres.put(objAlquiler);
        }

        //Creamos un String[] de columnas
        String[] columnNamesPeliculas = {"Titulo Pelicula", "Nombre Usuario", "Fecha Inicio", "Fecha Fin", "Precio", "Estado"};

        //Creamos el modelo de tabla
        modelAlquileres = new TableAlquileres(jsonArrayAlquileres, columnNamesPeliculas);
        //Asignamos el modelo a la tabla
        jTableAlquileresFiltrados.setModel(modelAlquileres);
        //Mostramos la tabla
        //Añadimos color a la cabecera.
        JTableHeader header = jTableAlquileresFiltrados.getTableHeader();
        header.setBackground(Color.CYAN);

        //Ponemos los datos numericos centrados en la celda.
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
        jTableAlquileresFiltrados.getColumnModel().getColumn(1).setCellRenderer(renderer);
        jTableAlquileresFiltrados.getColumnModel().getColumn(2).setCellRenderer(renderer);
        jTableAlquileresFiltrados.getColumnModel().getColumn(3).setCellRenderer(renderer);
        jTableAlquileresFiltrados.getColumnModel().getColumn(4).setCellRenderer(renderer);
        //Asignamos el ancho de las columnas.
        jTableAlquileresFiltrados.getColumnModel().getColumn(0).setPreferredWidth(190);
        jTableAlquileresFiltrados.getColumnModel().getColumn(2).setPreferredWidth(60);
        jTableAlquileresFiltrados.getColumnModel().getColumn(3).setPreferredWidth(60);
        jTableAlquileresFiltrados.getColumnModel().getColumn(4).setPreferredWidth(25);
        jTableAlquileresFiltrados.getColumnModel().getColumn(5).setPreferredWidth(70);

    }//GEN-LAST:event_jButtonFiltrarActionPerformed

    private void buttonVolver2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVolver2ActionPerformed
        // Cerramos el panel de filtros.
        // y volvemos a pantalla anterior..
        VentanaGestionAlquilerPeliculas volver2 = new VentanaGestionAlquilerPeliculas();
        volver2.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonVolver2ActionPerformed

    private void jButtonFiltrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFiltrosActionPerformed
        /**
         * Metodo para mostrar el panel de entrada de parametros para realizar la búsqueda de alquileres.
         *
         * @Author Carlos.
         */
        //cerramos los paneles que hubieran estado abiertos.
        jPanelCambioEstatus.setVisible(false);
        jPanelPeliculasUsuarios.setVisible(false);
        jPanelAlquileres.setVisible(false);
        jPanelAlquileresFiltrados.setVisible(false);

        //Limpiamos las selecciones de las tablas.
        jTableAlquileres.clearSelection();
        jTablePeliculas.clearSelection();
        jTableUsuarios.clearSelection();

        //Mostramos panel de seleccion de filtros.
        jPanelFiltros.setVisible(true);

        //Ponemos los campos en blanco.
        jTextFieldPeliculaId.setText("");
        jTextFieldUsuariId.setText("");
        jTextFieldFechaInicio.setText("");
        jTextFieldFechaFin.setText("");
        jTextFieldPrecio.setText("");
    }//GEN-LAST:event_jButtonFiltrosActionPerformed

    private void jButtonAnteriorAlquileresFiltradosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnteriorAlquileresFiltradosActionPerformed
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

                URL url = new URL(Constants.urlPeliculasAlquileresPaginados
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
                // y construimos el string 'resultado'
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
            ResponseAlquilerListDTO responseJson = gson.fromJson(responseJsonString, ResponseAlquilerListDTO.class);
            //*************************************************

            paginasTotalesFiltro = responseJson.getValue().getTotalPages();
            jLabelPaginaAlquileresFiltrados.setText(String.valueOf(paginaFiltro + 1) + " de " + paginasTotalesFiltro);

            //Creamos una lista de objetos JSON
            jsonArrayAlquileres = new JSONArray();
            for (int i = 0; i < responseJson.getValue().getContent().size(); i++) {
                objAlquiler = new JSONObject();
                objAlquiler.put("idAlquiler", responseJson.getValue().getContent().get(i).getId());
                objAlquiler.put("idPelicula", responseJson.getValue().getContent().get(i).getPelicula());
                objAlquiler.put("idUsuario", responseJson.getValue().getContent().get(i).getUsuari());
                objAlquiler.put("Fecha Inicio", responseJson.getValue().getContent().get(i).getFechaInicio());
                objAlquiler.put("Fecha Fin", responseJson.getValue().getContent().get(i).getFechaFin());
                objAlquiler.put("Precio", responseJson.getValue().getContent().get(i).getPrecio());
                objAlquiler.put("Estado", responseJson.getValue().getContent().get(i).getEstado());
                //Obtenemos el titulo de la pelicula.
                idPelicula = responseJson.getValue().getContent().get(i).getPelicula();
                tituloPelicula = tituloPelicula(idPelicula);
                objAlquiler.put("Titulo Pelicula", tituloPelicula);
                //Obtenemos el nombre del usuario.
                idUsuario = responseJson.getValue().getContent().get(i).getUsuari();
                nombreUser = nombreUsuario(idUsuario);
                objAlquiler.put("Nombre Usuario", nombreUser);

                jsonArrayAlquileres.put(objAlquiler);
            }

            //Creamos un String[] de columnas
            String[] columnNamesPeliculas = {"Titulo Pelicula", "Nombre Usuario", "Fecha Inicio", "Fecha Fin", "Precio", "Estado"};

            //Creamos el modelo de tabla
            modelAlquileres = new TableAlquileres(jsonArrayAlquileres, columnNamesPeliculas);
            //Asignamos el modelo a la tabla
            jTableAlquileresFiltrados.setModel(modelAlquileres);
            //Mostramos la tabla
            //Añadimos color a la cabecera.
            JTableHeader header = jTableAlquileresFiltrados.getTableHeader();
            header.setBackground(Color.CYAN);

            //Ponemos los datos numericos centrados en la celda.
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            renderer.setHorizontalAlignment(JLabel.CENTER);
            jTableAlquileresFiltrados.getColumnModel().getColumn(1).setCellRenderer(renderer);
            jTableAlquileresFiltrados.getColumnModel().getColumn(2).setCellRenderer(renderer);
            jTableAlquileresFiltrados.getColumnModel().getColumn(3).setCellRenderer(renderer);
            jTableAlquileresFiltrados.getColumnModel().getColumn(4).setCellRenderer(renderer);
            //Asignamos el ancho de las columnas.
            jTableAlquileresFiltrados.getColumnModel().getColumn(0).setPreferredWidth(190);
            jTableAlquileresFiltrados.getColumnModel().getColumn(2).setPreferredWidth(60);
            jTableAlquileresFiltrados.getColumnModel().getColumn(3).setPreferredWidth(60);
            jTableAlquileresFiltrados.getColumnModel().getColumn(4).setPreferredWidth(25);
            jTableAlquileresFiltrados.getColumnModel().getColumn(5).setPreferredWidth(70);
        }
    }//GEN-LAST:event_jButtonAnteriorAlquileresFiltradosActionPerformed

    private void jButtonSiguienteAlquileresFiltradosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSiguienteAlquileresFiltradosActionPerformed
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

                URL url = new URL(Constants.urlPeliculasAlquileresPaginados
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
                // y construimos el string 'resultado'
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
            ResponseAlquilerListDTO responseJson = gson.fromJson(responseJsonString, ResponseAlquilerListDTO.class);
            //*************************************************

            paginasTotalesFiltro = responseJson.getValue().getTotalPages();
            jLabelPaginaAlquileresFiltrados.setText(String.valueOf(paginaFiltro + 1) + " de " + paginasTotalesFiltro);

            //Creamos una lista de objetos JSON
            jsonArrayAlquileres = new JSONArray();
            for (int i = 0; i < responseJson.getValue().getContent().size(); i++) {
                objAlquiler = new JSONObject();
                objAlquiler.put("idAlquiler", responseJson.getValue().getContent().get(i).getId());
                objAlquiler.put("idPelicula", responseJson.getValue().getContent().get(i).getPelicula());
                objAlquiler.put("idUsuario", responseJson.getValue().getContent().get(i).getUsuari());
                objAlquiler.put("Fecha Inicio", responseJson.getValue().getContent().get(i).getFechaInicio());
                objAlquiler.put("Fecha Fin", responseJson.getValue().getContent().get(i).getFechaFin());
                objAlquiler.put("Precio", responseJson.getValue().getContent().get(i).getPrecio());
                objAlquiler.put("Estado", responseJson.getValue().getContent().get(i).getEstado());
                //Obtenemos el titulo de la pelicula.
                idPelicula = responseJson.getValue().getContent().get(i).getPelicula();
                tituloPelicula = tituloPelicula(idPelicula);
                objAlquiler.put("Titulo Pelicula", tituloPelicula);
                //Obtenemos el nombre del usuario.
                idUsuario = responseJson.getValue().getContent().get(i).getUsuari();
                nombreUser = nombreUsuario(idUsuario);
                objAlquiler.put("Nombre Usuario", nombreUser);

                jsonArrayAlquileres.put(objAlquiler);
            }

            //Creamos un String[] de columnas
            String[] columnNamesPeliculas = {"Titulo Pelicula", "Nombre Usuario", "Fecha Inicio", "Fecha Fin", "Precio", "Estado"};

            //Creamos el modelo de tabla
            modelAlquileres = new TableAlquileres(jsonArrayAlquileres, columnNamesPeliculas);
            //Asignamos el modelo a la tabla
            jTableAlquileresFiltrados.setModel(modelAlquileres);
            //Mostramos la tabla
            //Añadimos color a la cabecera.
            JTableHeader header = jTableAlquileresFiltrados.getTableHeader();
            header.setBackground(Color.CYAN);

            //Ponemos los datos numericos centrados en la celda.
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            renderer.setHorizontalAlignment(JLabel.CENTER);
            jTableAlquileresFiltrados.getColumnModel().getColumn(1).setCellRenderer(renderer);
            jTableAlquileresFiltrados.getColumnModel().getColumn(2).setCellRenderer(renderer);
            jTableAlquileresFiltrados.getColumnModel().getColumn(3).setCellRenderer(renderer);
            jTableAlquileresFiltrados.getColumnModel().getColumn(4).setCellRenderer(renderer);
            //Asignamos el ancho de las columnas.
            jTableAlquileresFiltrados.getColumnModel().getColumn(0).setPreferredWidth(190);
            jTableAlquileresFiltrados.getColumnModel().getColumn(2).setPreferredWidth(60);
            jTableAlquileresFiltrados.getColumnModel().getColumn(3).setPreferredWidth(60);
            jTableAlquileresFiltrados.getColumnModel().getColumn(4).setPreferredWidth(25);
            jTableAlquileresFiltrados.getColumnModel().getColumn(5).setPreferredWidth(70);
        }
    }//GEN-LAST:event_jButtonSiguienteAlquileresFiltradosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alquilarPelicula;
    private javax.swing.JButton buttonModificarEstatus;
    private javax.swing.JButton buttonVolver2;
    private javax.swing.JButton eliminarAlquilerPelicula;
    private javax.swing.JButton jButtonAnteriorAlquileres;
    private javax.swing.JButton jButtonAnteriorAlquileresFiltrados;
    private javax.swing.JButton jButtonAnteriorPeliculas;
    private javax.swing.JButton jButtonAnteriorUsuarios;
    private javax.swing.JButton jButtonCerrarSesion;
    private javax.swing.JButton jButtonFiltrar;
    private javax.swing.JButton jButtonFiltros;
    private javax.swing.JButton jButtonSiguienteAlquileres;
    private javax.swing.JButton jButtonSiguienteAlquileresFiltrados;
    private javax.swing.JButton jButtonSiguientePeliculas;
    private javax.swing.JButton jButtonSiguienteUsuarios;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JButton jButtonVolverAlquilerStatus;
    private javax.swing.JComboBox<String> jComboBoxEstatus;
    private javax.swing.JComboBox<String> jComboBoxFiltros;
    private javax.swing.JLabel jLabelAlquileres;
    private javax.swing.JLabel jLabelAlquileresFiltrados;
    private javax.swing.JLabel jLabelDescripcion;
    private javax.swing.JLabel jLabelDescripcion2;
    private javax.swing.JLabel jLabelEstatus;
    private javax.swing.JLabel jLabelFechaFin;
    private javax.swing.JLabel jLabelFechaInicio;
    private javax.swing.JLabel jLabelFiltrosDeBusqueda;
    private javax.swing.JLabel jLabelOrden;
    private javax.swing.JLabel jLabelPaginaAlquileres;
    private javax.swing.JLabel jLabelPaginaAlquileresFiltrados;
    private javax.swing.JLabel jLabelPaginaPeliculas;
    private javax.swing.JLabel jLabelPaginaUsuario;
    private javax.swing.JLabel jLabelPeliculaId;
    private javax.swing.JLabel jLabelPeliculas;
    private javax.swing.JLabel jLabelPrecio;
    private javax.swing.JLabel jLabelStatusActual1;
    private javax.swing.JLabel jLabelStatusAlquiler;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JLabel jLabelUsuarios;
    private javax.swing.JPanel jPanelAlquileres;
    private javax.swing.JPanel jPanelAlquileresFiltrados;
    private javax.swing.JPanel jPanelCambioEstatus;
    private javax.swing.JPanel jPanelFiltros;
    private javax.swing.JPanel jPanelGestionAlquilerPeliculas;
    private javax.swing.JPanel jPanelPeliculasUsuarios;
    private javax.swing.JScrollPane jScrollPaneAlquileres;
    private javax.swing.JScrollPane jScrollPaneAlquileresFiltrados;
    private javax.swing.JScrollPane jScrollPanePeliculas;
    private javax.swing.JScrollPane jScrollPaneUsuarios;
    private javax.swing.JTable jTableAlquileres;
    private javax.swing.JTable jTableAlquileresFiltrados;
    private javax.swing.JTable jTablePeliculas;
    private javax.swing.JTable jTableUsuarios;
    private javax.swing.JLabel jTextEstatusActual;
    private javax.swing.JTextField jTextFieldFechaFin;
    private javax.swing.JTextField jTextFieldFechaInicio;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldPeliculaId;
    private javax.swing.JTextField jTextFieldPrecio;
    private javax.swing.JTextField jTextFieldUsuariId;
    private javax.swing.JLabel jUsuariId;
    private javax.swing.JButton listaAlquileresPeliculas;
    private javax.swing.JButton listaPeliculasUsuarios;
    private javax.swing.JTextArea mensajeAlquilerPeliculas;
    private javax.swing.JButton modificarEstatusAlquiler;
    private javax.swing.JLabel textLogo;
    // End of variables declaration//GEN-END:variables

    private String tituloPelicula(UUID idPelicula) {

        /**
         * Método para obtener los datos de una pelicula y retornar su titulo.
         */
        StringBuilder resultado = new StringBuilder();
        try {
            //Creamos la URL
            URL url = new URL(Constants.urlPeliculaPorId
                    + idPelicula + "?token=" + Constants.token);

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
        ResponsePeliculaDTO responseJson = gson.fromJson(responseJsonString, ResponsePeliculaDTO.class);

        tituloPelicula = responseJson.getValue().getTitulo();
        return tituloPelicula;

    }

    private String nombreUsuario(UUID idUsuario) {

        /**
         * Método para obtener los datos de un usuario y retornar su nombre.
         */
        StringBuilder resultado = new StringBuilder();
        try {
            //Creamos la URL
            URL url = new URL(Constants.urlUsuariosPorId
                    + idUsuario + "?token=" + Constants.token);

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
        ResponseUserDTO responseJson = gson.fromJson(responseJsonString, ResponseUserDTO.class);

        nombreUser = responseJson.getValue().getNombre();
        return nombreUser;

    }

}
