package Pantallas;

import Modelos.DTOS.CambioDePasswordDTO;
import Modelos.DTOS.ResponseLogoutDTO;
import Modelos.DTOS.alquiler.DTO.ResponseAlquilerPeliculaDTO;
import Modelos.DTOS.alquiler.DTO.ResponseAlquilerUsuarioDTO;
import Modelos.DTOS.peliculas.DTO.ResponsePeliculaListDTO;
import Modelos.DTOS.usuarios.DTO.ResponseUserInfoDTO;
import Pantallas.usuarios.VentanaModificarUsuario;
import com.google.gson.Gson;
import java.awt.Color;
import utils.Constants;
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
import Tablas.TableAlquileres;
import Tablas.TablePeliculas;

/**
 * Ventana del usuario USUARIO .
 *
 * @author Carlos
 */
public class VentanaUsuario extends javax.swing.JFrame {

    //Variable de Clase.
    TablePeliculas modelPeliculas;
    TableAlquileres modelAlquileres;
    JSONArray jsonArrayPeliculas;
    int posicionPelicula;
    UUID idUsuario, idPelicula;
    int pagina = 0, paginaSize = 10, paginasTotales;
    int paginaFiltro = 0, paginaSizeFiltro = 10, paginasTotalesFiltro;
    String parametros = "";

    /**
     * Constructor de un nuevo formulario Ventana USUARIO. Se crea una peticion al servidor para mostrar el nombre del usuario.
     *
     * @author Carlos.
     *
     */
    public VentanaUsuario() {
        initComponents();
        setLocationRelativeTo(null);
        panelContraseña.setVisible(false);
        jPanelAlquileres.setVisible(false);
        jPanelPeliculas.setVisible(false);
        jPanelFiltros.setVisible(false);
        jPanelPeliculasFiltradas.setVisible(false);

        //***********************************************
        StringBuilder resultado = new StringBuilder();
        try {
            // Creamos la URL
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
        // System.out.println(responseJson.getValue().getNombre());
        // Ponemos el nombre en el textfield correspondiente.
        jTextFieldNombre.setText(responseJson.getValue().getNombre());

        //Obtenemos el idUsuario del usuario.
        idUsuario = responseJson.getValue().getId();

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

        jPanelUsuario = new javax.swing.JPanel();
        textLogo = new javax.swing.JLabel();
        mensajeBienvenida = new javax.swing.JTextArea();
        jButtonCerrarSesion = new javax.swing.JButton();
        jLabelUsuario = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        listaPeliculas = new javax.swing.JButton();
        rankingPeliculas = new javax.swing.JButton();
        listaAlquileresUsuario = new javax.swing.JButton();
        alquilarPelicula = new javax.swing.JButton();
        modificarPerfil = new javax.swing.JButton();
        cambioDeContraseña = new javax.swing.JButton();
        panelContraseña = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelPassword = new javax.swing.JLabel();
        jLabelConfirmPassword = new javax.swing.JLabel();
        jPassword = new javax.swing.JPasswordField();
        jPassword2 = new javax.swing.JPasswordField();
        buttonModificarContraseña = new javax.swing.JButton();
        buttonInicio = new javax.swing.JButton();
        jPanelAlquileres = new javax.swing.JPanel();
        jScrollPaneAlquileresUsuario = new javax.swing.JScrollPane();
        jTableAlquileresUsuario = new javax.swing.JTable();
        jPanelPeliculas = new javax.swing.JPanel();
        jScrollPanePeliculas = new javax.swing.JScrollPane();
        jTablePeliculas = new javax.swing.JTable();
        jButtonAnteriorPeliculas = new javax.swing.JButton();
        jLabelPaginaPeliculas = new javax.swing.JLabel();
        jButtonSiguientePeliculas = new javax.swing.JButton();
        jButtonFiltros = new javax.swing.JButton();
        jPanelFiltros = new javax.swing.JPanel();
        jLabelFiltrosDeBusqueda = new javax.swing.JLabel();
        jLabelDescripcion = new javax.swing.JLabel();
        jLabelDirector = new javax.swing.JLabel();
        jLabelGenero = new javax.swing.JLabel();
        jLabelAño = new javax.swing.JLabel();
        jLabelVecesAlquilada = new javax.swing.JLabel();
        jLabelOrden = new javax.swing.JLabel();
        jTextFieldDirector = new javax.swing.JTextField();
        jTextFieldGenero = new javax.swing.JTextField();
        jTextFieldAño = new javax.swing.JTextField();
        jTextFieldVecesAlquilada = new javax.swing.JTextField();
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
        setTitle("USUARIO");
        setResizable(false);

        jPanelUsuario.setBackground(new java.awt.Color(255, 255, 255));
        jPanelUsuario.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jPanelUsuario.setPreferredSize(new java.awt.Dimension(800, 400));

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
        mensajeBienvenida.setText("       Bienvenido a MOVIES4RENT\n                Eres USUARIO\n");
        mensajeBienvenida.setBorder(null);
        mensajeBienvenida.setSelectionColor(new java.awt.Color(255, 255, 255));

        jButtonCerrarSesion.setBackground(new java.awt.Color(255, 102, 102));
        jButtonCerrarSesion.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jButtonCerrarSesion.setText("Cerrar Sesion");
        jButtonCerrarSesion.setBorderPainted(false);
        jButtonCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarSesionActionPerformed(evt);
            }
        });

        jLabelUsuario.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabelUsuario.setText("USUARIO:");

        jTextFieldNombre.setEditable(false);
        jTextFieldNombre.setBackground(new java.awt.Color(255, 255, 255));
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

        rankingPeliculas.setBackground(new java.awt.Color(0, 204, 255));
        rankingPeliculas.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        rankingPeliculas.setText("Ranking de Películas");
        rankingPeliculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rankingPeliculasActionPerformed(evt);
            }
        });

        listaAlquileresUsuario.setBackground(new java.awt.Color(0, 204, 255));
        listaAlquileresUsuario.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        listaAlquileresUsuario.setText("Lista de Alquileres Usuario");
        listaAlquileresUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaAlquileresUsuarioActionPerformed(evt);
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

        modificarPerfil.setBackground(new java.awt.Color(255, 153, 51));
        modificarPerfil.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        modificarPerfil.setText("Modificar Perfil");
        modificarPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarPerfilActionPerformed(evt);
            }
        });

        cambioDeContraseña.setBackground(new java.awt.Color(255, 153, 51));
        cambioDeContraseña.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        cambioDeContraseña.setText("Cambiar Contraseña");
        cambioDeContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambioDeContraseñaActionPerformed(evt);
            }
        });

        panelContraseña.setBackground(new java.awt.Color(204, 255, 255));
        panelContraseña.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cambio de Contraseña");

        jLabelPassword.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabelPassword.setText("Password :");

        jLabelConfirmPassword.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabelConfirmPassword.setText("Confirm Password :");

        jPassword.setBackground(java.awt.SystemColor.control);
        jPassword.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N

        jPassword2.setBackground(java.awt.SystemColor.control);
        jPassword2.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N

        buttonModificarContraseña.setBackground(new java.awt.Color(255, 153, 51));
        buttonModificarContraseña.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        buttonModificarContraseña.setText("MODIFICAR");
        buttonModificarContraseña.setBorderPainted(false);
        buttonModificarContraseña.setFocusable(false);
        buttonModificarContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonModificarContraseñaActionPerformed(evt);
            }
        });

        buttonInicio.setBackground(new java.awt.Color(153, 204, 0));
        buttonInicio.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        buttonInicio.setText("VOLVER");
        buttonInicio.setBorderPainted(false);
        buttonInicio.setFocusable(false);
        buttonInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInicioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelContraseñaLayout = new javax.swing.GroupLayout(panelContraseña);
        panelContraseña.setLayout(panelContraseñaLayout);
        panelContraseñaLayout.setHorizontalGroup(
            panelContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContraseñaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelContraseñaLayout.createSequentialGroup()
                        .addComponent(jLabelConfirmPassword)
                        .addGap(14, 14, 14)
                        .addComponent(jPassword2, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE))
                    .addGroup(panelContraseñaLayout.createSequentialGroup()
                        .addComponent(jLabelPassword)
                        .addGap(82, 82, 82)
                        .addComponent(jPassword)))
                .addContainerGap())
            .addGroup(panelContraseñaLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(buttonModificarContraseña)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonInicio)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelContraseñaLayout.setVerticalGroup(
            panelContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContraseñaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(panelContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPassword)
                    .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(panelContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelConfirmPassword)
                    .addComponent(jPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addGroup(panelContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonModificarContraseña)
                    .addComponent(buttonInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31))
        );

        jPanelAlquileres.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPaneAlquileresUsuario.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPaneAlquileresUsuario.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPaneAlquileresUsuario.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPaneAlquileresUsuario.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N

        jTableAlquileresUsuario.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jTableAlquileresUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableAlquileresUsuario.setFillsViewportHeight(true);
        jTableAlquileresUsuario.setFocusable(false);
        jTableAlquileresUsuario.setGridColor(new java.awt.Color(153, 153, 153));
        jTableAlquileresUsuario.setSelectionBackground(new java.awt.Color(102, 204, 255));
        jScrollPaneAlquileresUsuario.setViewportView(jTableAlquileresUsuario);

        javax.swing.GroupLayout jPanelAlquileresLayout = new javax.swing.GroupLayout(jPanelAlquileres);
        jPanelAlquileres.setLayout(jPanelAlquileresLayout);
        jPanelAlquileresLayout.setHorizontalGroup(
            jPanelAlquileresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAlquileresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneAlquileresUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jPanelAlquileresLayout.setVerticalGroup(
            jPanelAlquileresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAlquileresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneAlquileresUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                .addGap(49, 49, 49))
        );

        jPanelPeliculas.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPanePeliculas.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPanePeliculas.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPanePeliculas.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPanePeliculas.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N

        jTablePeliculas.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jTablePeliculas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTablePeliculas.setFillsViewportHeight(true);
        jTablePeliculas.setFocusable(false);
        jTablePeliculas.setGridColor(new java.awt.Color(153, 153, 153));
        jTablePeliculas.setSelectionBackground(new java.awt.Color(102, 204, 255));
        jScrollPanePeliculas.setViewportView(jTablePeliculas);

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

        jButtonSiguientePeliculas.setBackground(new java.awt.Color(242, 242, 242));
        jButtonSiguientePeliculas.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jButtonSiguientePeliculas.setText("Siguiente");
        jButtonSiguientePeliculas.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonSiguientePeliculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSiguientePeliculasActionPerformed(evt);
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

        javax.swing.GroupLayout jPanelPeliculasLayout = new javax.swing.GroupLayout(jPanelPeliculas);
        jPanelPeliculas.setLayout(jPanelPeliculasLayout);
        jPanelPeliculasLayout.setHorizontalGroup(
            jPanelPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPeliculasLayout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(jButtonAnteriorPeliculas)
                .addGap(18, 18, 18)
                .addComponent(jLabelPaginaPeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSiguientePeliculas)
                .addGap(51, 51, 51)
                .addComponent(jButtonFiltros)
                .addContainerGap(77, Short.MAX_VALUE))
            .addGroup(jPanelPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPanePeliculas, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE))
        );
        jPanelPeliculasLayout.setVerticalGroup(
            jPanelPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPeliculasLayout.createSequentialGroup()
                .addContainerGap(208, Short.MAX_VALUE)
                .addGroup(jPanelPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonSiguientePeliculas)
                        .addComponent(jButtonFiltros))
                    .addComponent(jLabelPaginaPeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAnteriorPeliculas))
                .addContainerGap())
            .addGroup(jPanelPeliculasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelPeliculasLayout.createSequentialGroup()
                    .addComponent(jScrollPanePeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 44, Short.MAX_VALUE)))
        );

        jPanelFiltros.setBackground(new java.awt.Color(204, 255, 255));

        jLabelFiltrosDeBusqueda.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        jLabelFiltrosDeBusqueda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFiltrosDeBusqueda.setText("FILTROS DE BUSQUEDA");

        jLabelDescripcion.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        jLabelDescripcion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDescripcion.setText("Puedes filtrar la búsqueda rellenando uno de los campos.");

        jLabelDirector.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabelDirector.setText("Director :");

        jLabelGenero.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabelGenero.setText("Genero :");

        jLabelAño.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabelAño.setText("Año :");

        jLabelVecesAlquilada.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabelVecesAlquilada.setText("Veces Alquilada :");

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

        jTextFieldVecesAlquilada.setBackground(java.awt.SystemColor.control);
        jTextFieldVecesAlquilada.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jTextFieldVecesAlquilada.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldVecesAlquilada.setBorder(null);

        jComboBoxFiltros.setBackground(javax.swing.UIManager.getDefaults().getColor("control"));
        jComboBoxFiltros.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jComboBoxFiltros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sin orden", "directorAsc", "directorDesc", "vecesAlquiladaAsc", "vecesAlquiladaDesc", "duracionAsc", "duracionDesc", "añoAsc", "añoDesc", " " }));
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
                                                .addComponent(jLabelGenero, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabelDirector, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                                                .addComponent(jLabelAño, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextFieldAño)
                                            .addComponent(jComboBoxFiltros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldGenero)
                                            .addComponent(jTextFieldDirector)))
                                    .addGroup(jPanelFiltrosLayout.createSequentialGroup()
                                        .addComponent(jLabelVecesAlquilada, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldVecesAlquilada, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(jLabelDirector)
                    .addComponent(jTextFieldDirector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelGenero)
                    .addComponent(jTextFieldGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelAño)
                    .addComponent(jTextFieldAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelVecesAlquilada)
                    .addComponent(jTextFieldVecesAlquilada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelOrden)
                    .addComponent(jComboBoxFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonFiltrar)
                    .addComponent(buttonInicio1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
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
                .addContainerGap(244, Short.MAX_VALUE))
            .addGroup(jPanelPeliculasFiltradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPanePeliculasFiltradas, javax.swing.GroupLayout.DEFAULT_SIZE, 565, Short.MAX_VALUE))
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

        javax.swing.GroupLayout jPanelUsuarioLayout = new javax.swing.GroupLayout(jPanelUsuario);
        jPanelUsuario.setLayout(jPanelUsuarioLayout);
        jPanelUsuarioLayout.setHorizontalGroup(
            jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(textLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(mensajeBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(jLabelUsuario))
                    .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(modificarPerfil, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(alquilarPelicula, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(listaAlquileresUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                            .addComponent(listaPeliculas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cambioDeContraseña, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rankingPeliculas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jButtonCerrarSesion))
                    .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29))
            .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelUsuarioLayout.createSequentialGroup()
                    .addContainerGap(197, Short.MAX_VALUE)
                    .addComponent(jPanelAlquileres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(30, Short.MAX_VALUE)))
            .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelUsuarioLayout.createSequentialGroup()
                    .addContainerGap(204, Short.MAX_VALUE)
                    .addComponent(jPanelPeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(31, Short.MAX_VALUE)))
            .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelUsuarioLayout.createSequentialGroup()
                    .addContainerGap(228, Short.MAX_VALUE)
                    .addComponent(jPanelFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(175, Short.MAX_VALUE)))
            .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelUsuarioLayout.createSequentialGroup()
                    .addContainerGap(214, Short.MAX_VALUE)
                    .addComponent(jPanelPeliculasFiltradas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(21, 21, 21)))
        );
        jPanelUsuarioLayout.setVerticalGroup(
            jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(mensajeBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelUsuario)
                        .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(textLogo))
                .addGap(51, 51, 51)
                .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                        .addComponent(panelContraseña, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                        .addComponent(listaPeliculas)
                        .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                                .addGap(0, 216, Short.MAX_VALUE)
                                .addComponent(jButtonCerrarSesion)
                                .addGap(18, 18, 18))
                            .addGroup(jPanelUsuarioLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rankingPeliculas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(listaAlquileresUsuario)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(alquilarPelicula)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(modificarPerfil)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cambioDeContraseña)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
            .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelUsuarioLayout.createSequentialGroup()
                    .addContainerGap(104, Short.MAX_VALUE)
                    .addComponent(jPanelAlquileres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(50, 50, 50)))
            .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelUsuarioLayout.createSequentialGroup()
                    .addContainerGap(110, Short.MAX_VALUE)
                    .addComponent(jPanelPeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(51, Short.MAX_VALUE)))
            .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelUsuarioLayout.createSequentialGroup()
                    .addContainerGap(103, Short.MAX_VALUE)
                    .addComponent(jPanelFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
            .addGroup(jPanelUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelUsuarioLayout.createSequentialGroup()
                    .addContainerGap(120, Short.MAX_VALUE)
                    .addComponent(jPanelPeliculasFiltradas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(41, 41, 41)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo que se ejecuta al clicar en el boton CERRAR SESION del formulario. Operacion de logout del servidor.
     *
     * @author Carlos.
     *
     */
    private void jButtonCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCerrarSesionActionPerformed
        StringBuilder resultado = new StringBuilder();
        try {

            // Creamos la URL
            URL url = new URL(Constants.urlLogout + "?token=" + Constants.token);
            // Creamos la conexion al servidor.
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            // Metodo GET
            conn.setRequestMethod("GET");

            // Abrimos un InputStream de datos del servidor
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

    /**
     * Metodo que llama a la ventana de modificacion del perfil del usuario.
     *
     * @author Carlos.
     */
    private void modificarPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarPerfilActionPerformed
        VentanaModificarUsuario ventanaModificarUsuario = new VentanaModificarUsuario();
        ventanaModificarUsuario.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_modificarPerfilActionPerformed

    /**
     * Metodo que muestra el panel de cambio de contraseña del usuario.
     *
     * @author Carlos.
     */
    private void cambioDeContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambioDeContraseñaActionPerformed
        //cerramos los paneles que hubieran abiertos.        
        jScrollPanePeliculas.setVisible(false);
        jScrollPaneAlquileresUsuario.setVisible(false);
        jPanelFiltros.setVisible(false);
        jPanelPeliculasFiltradas.setVisible(false);
        //Mostramos panel cambio de contraseña.
        panelContraseña.setVisible(true);

    }//GEN-LAST:event_cambioDeContraseñaActionPerformed

    /**
     * Metodo que muestra el formulario de cambio de contraseña del usuario.
     *
     * @author Carlos.
     */
    private void buttonModificarContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModificarContraseñaActionPerformed

        // Leemos los campos password introducidos.
        // Comprobamos que los password sean iguales...
        char[] password = jPassword.getPassword();
        String pass = new String(password);

        char[] passwordConfirmacion = jPassword2.getPassword();
        String passConfirm = new String(passwordConfirmacion);

        // Comparamos...
        if (pass.equals(passConfirm)) {

            // Creamos el cliente
            Client client = ClientBuilder.newClient();

            // Creamos el target (URL) con el token.
            WebTarget target = client.target(Constants.urlUpdatePasswordUsuario + "?token=" + Constants.token);

            // Creamos la solicitud
            Invocation.Builder solicitud = target.request();

            // Creamos el objeto DTO que espera el servidor
            CambioDePasswordDTO cambioPassword = new CambioDePasswordDTO();

            // Asignamos los valores
            cambioPassword.setPassword(pass);

            // Creamos una instancia de Gson para convertir nuestro String a JSON
            Gson gson = new Gson();

            // lo pasamos a objeto Json
            String jsonString = gson.toJson(cambioPassword);

            // Enviamos nuestro json via PUT a la API
            Response put = solicitud.put(Entity.json(jsonString));

            // Recibimos la respuesta y la leemos en una clase String
            String responseJsonString = put.readEntity(String.class);

            // Si todo ha salido correcto.
            if (put.getStatus() == 200) {
                // Comprobacion por consola.
                System.out.println(responseJsonString);

                // Mostramos mensaje emergente de informacion.
                JOptionPane.showMessageDialog(this,
                        "Contraseña actualizada correctamente."
                        + "\nVolverás a la pantalla de login.",
                        "CAMBIO de CONTRASEÑA", JOptionPane.INFORMATION_MESSAGE);
                // Cerramos la ventana. 
                // y volvemos a inicio.
                this.dispose();
                VentanaLogin inicio = new VentanaLogin();
                inicio.setVisible(true);
            } else {
                // Mostramos mensaje emergente de aviso.
                JOptionPane.showMessageDialog(this,
                        "Error en cambio de contraseña.\n"
                        + "Vuelve a introducir los datos.",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
                // Limpiamos todos los campos.
                jPassword.setText("");
                jPassword2.setText("");
                // Continuamos en ventana de nuevo registro.
            }
        } else {
            // Mostramos mensaje emergente de aviso.
            JOptionPane.showMessageDialog(this,
                    "Las contraseñas no coinciden.\n"
                    + "Vuelve a introducir los datos.",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
            // Limpiamos todos los campos.
            jPassword.setText("");
            jPassword2.setText("");
            // Continuamos en ventana de nuevo registro.
        }

    }//GEN-LAST:event_buttonModificarContraseñaActionPerformed

    /**
     *
     * Metodo que usa el usuario para hacer el alquiler de una pelicula.
     *
     * @author Carlos.
     */
    private void alquilarPeliculaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alquilarPeliculaActionPerformed

        //cerramos el panel de contraseña si estaba abierto.
        panelContraseña.setVisible(false);
        jPanelPeliculasFiltradas.setVisible(false);
        //Obtenemos la fila seleccionada de pelicula.
        posicionPelicula = jTablePeliculas.getSelectedRow();

        if ((posicionPelicula == -1)) {
            // No se ha seleccionado pelicula.
            // Mostramos mensaje emergente de informacion.
            JOptionPane.showMessageDialog(this,
                    "Debes seleccionar una\n"
                    + "PELICULA de la tabla.",
                    "ALQUILAR PELICULA", JOptionPane.INFORMATION_MESSAGE);
        } else {

            // Se ha seleccionado una película.
            // Creamos objeto JSON temporales de la pelicula seleccionada.
            JSONObject objPelicula = new JSONObject();
            objPelicula = jsonArrayPeliculas.getJSONObject(posicionPelicula);
            //Asignamos el id de la pelicula a su variable UUID.
            idPelicula = (UUID) objPelicula.get("id");

            // Mostramos mensaje emergente de confirmacion.
            int opcion = JOptionPane.showConfirmDialog(this,
                    "Deseas alquilar la pelicula\n"
                    + objPelicula.get("TITULO") + "  ?",
                    "CONFIRMACION",
                    JOptionPane.YES_NO_OPTION);

            if (opcion == JOptionPane.YES_OPTION) {
                //****************************************************************
                // Realizamos la peticion de alquiler nuevo 
                // para el usuario.
                // Creamos el cliente de acceso
                Client client = ClientBuilder.newClient();
                // Creamos el target (URL)
                WebTarget target = client.target(Constants.urlPeliculasAddAlquiler
                        + idPelicula + "?token=" + Constants.token);

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
                        // Mostramos mensaje emergente de informacion.
                        JOptionPane.showMessageDialog(this,
                                "Película alquilada correctamente.\n"
                                + "Fecha de inicio:           " + responseJson.getValue().getFechaInicio() + "\n"
                                + "Fecha de finalizacion: " + responseJson.getValue().getFechaFin() + "\n"
                                + "Estado: " + responseJson.getValue().getEstado(),
                                "ALQUILER PELICULA", JOptionPane.INFORMATION_MESSAGE);
                        // y volvemos a inicio.

                    }
                } catch (MalformedURLException ex) {
                    System.out.println(ex);
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            } else {
                //No hacemos nada...
            }
        }
    }//GEN-LAST:event_alquilarPeliculaActionPerformed

    /**
     *
     * Metodo para mostrar la tabla de peliculas para poder seleccionarlas.
     *
     * @author Carlos.
     */
    private void listaPeliculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaPeliculasActionPerformed

        //cerramos los paneles que hubieran estado abiertos.
        panelContraseña.setVisible(false);
        jPanelAlquileres.setVisible(false);
        jPanelFiltros.setVisible(false);
        jPanelPeliculasFiltradas.setVisible(false);

        //Tabla peliculas. 
        jPanelPeliculas.setVisible(true);

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
        jLabelPaginaPeliculas.setText(String.valueOf(pagina + 1) + " de " + paginasTotales);

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
        String[] columnNames = {"TITULO", "DIRECTOR", "GENERO", "AÑO", "DURACION", "PRECIO", "ALQUILERES"};

        //Creamos el modelo de tabla
        modelPeliculas = new TablePeliculas(jsonArrayPeliculas, columnNames);
        //Asignamos el modelo a la tabla
        jTablePeliculas.setModel(modelPeliculas);
        //Mostramos la tabla
        //Añadimos color a la cabecera.
        JTableHeader header = jTablePeliculas.getTableHeader();
        header.setBackground(Color.CYAN);
        //Ponemos los datos numericos en el centro de la celda.
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
        jTablePeliculas.getColumnModel().getColumn(3).setCellRenderer(renderer);
        jTablePeliculas.getColumnModel().getColumn(4).setCellRenderer(renderer);
        jTablePeliculas.getColumnModel().getColumn(5).setCellRenderer(renderer);
        jTablePeliculas.getColumnModel().getColumn(6).setCellRenderer(renderer);
        //Asignamos el ancho de las columnas.
        jTablePeliculas.getColumnModel().getColumn(0).setPreferredWidth(110);
        jTablePeliculas.getColumnModel().getColumn(1).setPreferredWidth(60);
        jTablePeliculas.getColumnModel().getColumn(2).setPreferredWidth(60);
        jTablePeliculas.getColumnModel().getColumn(3).setPreferredWidth(10);
        jTablePeliculas.getColumnModel().getColumn(4).setPreferredWidth(30);
        jTablePeliculas.getColumnModel().getColumn(5).setPreferredWidth(15);
        jTablePeliculas.getColumnModel().getColumn(6).setPreferredWidth(40);

    }//GEN-LAST:event_listaPeliculasActionPerformed

    /**
     *
     * Metodo para volver a la pantalla anterior.
     *
     * @author Carlos.
     */
    private void buttonInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInicioActionPerformed
        // Cerramos la ventana de registro.
        // y volvemos a inicio.
        this.dispose();
        VentanaUsuario usuario = new VentanaUsuario();
        usuario.setVisible(true);
    }//GEN-LAST:event_buttonInicioActionPerformed

    /**
     *
     * Metodo para mostrar la lista de alquileres de un usuario.
     *
     * @author Carlos.
     */
    private void listaAlquileresUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaAlquileresUsuarioActionPerformed

        //Mostramos la tabla.
        jPanelAlquileres.setVisible(true);

        //cerramos los paneles que hubieran estado abiertos.
        panelContraseña.setVisible(false);
        jPanelPeliculas.setVisible(false);
        jPanelFiltros.setVisible(false);
        jPanelPeliculasFiltradas.setVisible(false);

        //Leemos la lista de alquileres.
        StringBuilder resultadoListaAlquileres = new StringBuilder();
        try {
            // Creamos la URL
            URL url = new URL(Constants.urlPeliculasAlquileresByUser
                    + idUsuario + "?token=" + Constants.token);

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
                resultadoListaAlquileres.append(linea);
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
        String responseJsonString = resultadoListaAlquileres.toString();
        //*************************************************
        // El array de objetos JSON lo convertimos en un array de objetos DTO.
        // Lo transformamos gracias al objeto DTO creado para ello.
        ResponseAlquilerUsuarioDTO responseJson = gson.fromJson(responseJsonString, ResponseAlquilerUsuarioDTO.class);
        //*************************************************

        //Creamos una lista de objetos JSON
        JSONArray jsonArrayAlquileresUsuario = new JSONArray();
        for (int i = 0; i < responseJson.getValue().size(); i++) {
            JSONObject objAlquilerUsuario = new JSONObject();
            objAlquilerUsuario.put("idAlquiler", responseJson.getValue().get(i).getId());
            objAlquilerUsuario.put("Titulo", responseJson.getValue().get(i).getTitulo());
            objAlquilerUsuario.put("Director", responseJson.getValue().get(i).getDirector());
            objAlquilerUsuario.put("Genero", responseJson.getValue().get(i).getGenero());
            objAlquilerUsuario.put("Duracion", responseJson.getValue().get(i).getDuracion());
            objAlquilerUsuario.put("Año", responseJson.getValue().get(i).getAño());
            objAlquilerUsuario.put("Precio", responseJson.getValue().get(i).getPrecio());
            jsonArrayAlquileresUsuario.put(objAlquilerUsuario);
        }

        //Creamos un String[] de columnas
        String[] columnNamesPeliculas = {"Titulo", "Director", "Año", "Duracion", "Precio"};

        //Creamos el modelo de tabla
        modelAlquileres = new TableAlquileres(jsonArrayAlquileresUsuario, columnNamesPeliculas);
        //Asignamos el modelo a la tabla
        jTableAlquileresUsuario.setModel(modelAlquileres);
        //Mostramos la tabla

        //Añadimos color a la cabecera.
        JTableHeader header = jTableAlquileresUsuario.getTableHeader();
        header.setBackground(Color.CYAN);

        //Ponemos los datos numericos en el lado derecho de la celda.
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
        jTableAlquileresUsuario.getColumnModel().getColumn(2).setCellRenderer(renderer);
        jTableAlquileresUsuario.getColumnModel().getColumn(3).setCellRenderer(renderer);
        jTableAlquileresUsuario.getColumnModel().getColumn(4).setCellRenderer(renderer);
        //Asignamos el ancho de las columnas.
        jTableAlquileresUsuario.getColumnModel().getColumn(0).setPreferredWidth(230);
        jTableAlquileresUsuario.getColumnModel().getColumn(2).setPreferredWidth(15);
        jTableAlquileresUsuario.getColumnModel().getColumn(3).setPreferredWidth(30);
        jTableAlquileresUsuario.getColumnModel().getColumn(4).setPreferredWidth(15);

    }//GEN-LAST:event_listaAlquileresUsuarioActionPerformed

    private void jButtonAnteriorPeliculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnteriorPeliculasActionPerformed
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
            jLabelPaginaPeliculas.setText(String.valueOf(pagina + 1) + " de " + paginasTotales);

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
            String[] columnNames = {"TITULO", "DIRECTOR", "GENERO", "AÑO", "DURACION", "PRECIO", "ALQUILERES"};

            //Creamos el modelo de tabla
            modelPeliculas = new TablePeliculas(jsonArrayPeliculas, columnNames);
            //Asignamos el modelo a la tabla
            jTablePeliculas.setModel(modelPeliculas);
            //Mostramos la tabla
            //Añadimos color a la cabecera.
            JTableHeader header = jTablePeliculas.getTableHeader();
            header.setBackground(Color.CYAN);
            //Ponemos los datos numericos en el centro de la celda.
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            renderer.setHorizontalAlignment(JLabel.CENTER);
            jTablePeliculas.getColumnModel().getColumn(3).setCellRenderer(renderer);
            jTablePeliculas.getColumnModel().getColumn(4).setCellRenderer(renderer);
            jTablePeliculas.getColumnModel().getColumn(5).setCellRenderer(renderer);
            jTablePeliculas.getColumnModel().getColumn(6).setCellRenderer(renderer);
            //Asignamos el ancho de las columnas.
            jTablePeliculas.getColumnModel().getColumn(0).setPreferredWidth(110);
            jTablePeliculas.getColumnModel().getColumn(1).setPreferredWidth(60);
            jTablePeliculas.getColumnModel().getColumn(2).setPreferredWidth(60);
            jTablePeliculas.getColumnModel().getColumn(3).setPreferredWidth(10);
            jTablePeliculas.getColumnModel().getColumn(4).setPreferredWidth(30);
            jTablePeliculas.getColumnModel().getColumn(5).setPreferredWidth(15);
            jTablePeliculas.getColumnModel().getColumn(6).setPreferredWidth(40);
        }
    }//GEN-LAST:event_jButtonAnteriorPeliculasActionPerformed

    private void jButtonSiguientePeliculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSiguientePeliculasActionPerformed
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
            jLabelPaginaPeliculas.setText(String.valueOf(pagina + 1) + " de " + paginasTotales);

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
            String[] columnNames = {"TITULO", "DIRECTOR", "GENERO", "AÑO", "DURACION", "PRECIO", "ALQUILERES"};

            //Creamos el modelo de tabla
            modelPeliculas = new TablePeliculas(jsonArrayPeliculas, columnNames);
            //Asignamos el modelo a la tabla
            jTablePeliculas.setModel(modelPeliculas);
            //Mostramos la tabla
            //Añadimos color a la cabecera.
            JTableHeader header = jTablePeliculas.getTableHeader();
            header.setBackground(Color.CYAN);
            //Ponemos los datos numericos en el centro de la celda.
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            renderer.setHorizontalAlignment(JLabel.CENTER);
            jTablePeliculas.getColumnModel().getColumn(3).setCellRenderer(renderer);
            jTablePeliculas.getColumnModel().getColumn(4).setCellRenderer(renderer);
            jTablePeliculas.getColumnModel().getColumn(5).setCellRenderer(renderer);
            jTablePeliculas.getColumnModel().getColumn(6).setCellRenderer(renderer);
            //Asignamos el ancho de las columnas.
            jTablePeliculas.getColumnModel().getColumn(0).setPreferredWidth(110);
            jTablePeliculas.getColumnModel().getColumn(1).setPreferredWidth(60);
            jTablePeliculas.getColumnModel().getColumn(2).setPreferredWidth(60);
            jTablePeliculas.getColumnModel().getColumn(3).setPreferredWidth(10);
            jTablePeliculas.getColumnModel().getColumn(4).setPreferredWidth(30);
            jTablePeliculas.getColumnModel().getColumn(5).setPreferredWidth(15);
            jTablePeliculas.getColumnModel().getColumn(6).setPreferredWidth(40);
        }
    }//GEN-LAST:event_jButtonSiguientePeliculasActionPerformed

    private void jButtonFiltrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFiltrosActionPerformed

        /**
         * Metodo para mostrar el panel de entrada de parametros para realizar la búsqueda de peliculas.
         *
         * @Author Carlos.
         */
        //cerramos los paneles que hubieran estado abiertos.
        jPanelPeliculas.setVisible(false);
        panelContraseña.setVisible(false);
        jPanelAlquileres.setVisible(false);
        //Mostramos panel de seleccion de filtros.
        jPanelFiltros.setVisible(true);

        jTextFieldDirector.setText("");
        jTextFieldGenero.setText("");
        jTextFieldAño.setText("");
        
    }//GEN-LAST:event_jButtonFiltrosActionPerformed

    private void jButtonFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFiltrarActionPerformed

        /**
         * Metodo para mostrar la lista de peliculas filtrada por los parametros de búsqueda.
         *
         * Esta es la primera tabla de peliculas filtradas que se muestra. pagina 0 ( 1 en pantalla.)
         *
         * @Author Carlos.
         */
        //cerramos los paneles que hubieran estado abiertos.
        panelContraseña.setVisible(false);
        jPanelAlquileres.setVisible(false);
        jPanelFiltros.setVisible(false);
        jPanelPeliculas.setVisible(false);

        //Variables de la url.
        
        String director;
        String genero;
        String año;
        String vecesAlquilada;
        parametros ="";
        
        // Leemos los campos seleccionados
        // y creamos la cadena de parametros.
        if (!jTextFieldDirector.getText().isEmpty()) {
            director = jTextFieldDirector.getText().replace(" ", "%20");
            parametros = parametros + "&director=" + director;
        }

        if (!jTextFieldGenero.getText().isEmpty()) {
            genero = jTextFieldGenero.getText().replace(" ", "%20");
            parametros = parametros + "&genero=" + genero;
        }
        if (!jTextFieldAño.getText().isEmpty()) {
            año = jTextFieldAño.getText();
            parametros = parametros + "&ano=" + año;
        }
        if (!jTextFieldVecesAlquilada.getText().isEmpty()) {
            vecesAlquilada = jTextFieldVecesAlquilada.getText();
            parametros = parametros + "&vecesAlquilada=" + vecesAlquilada;
        }

        //Leemos el orden que hemos seleccionado...
        String orden = (String) jComboBoxFiltros.getSelectedItem();

        //Asignamos el string parametro del orden.
        orden = switch (orden) {
            case "directorAsc" ->
                "&orden=directorAsc";
            case "directorDesc" ->
                "&orden=directorDesc";
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
        String[] columnNames = {"TITULO", "DIRECTOR", "GENERO", "AÑO", "DURACION", "PRECIO", "ALQUILERES"};

        //Creamos el modelo de tabla
        modelPeliculas = new TablePeliculas(jsonArrayPeliculas, columnNames);
        //Asignamos el modelo a la tabla
        jTablePeliculasFiltradas.setModel(modelPeliculas);
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
        String[] columnNames = {"TITULO", "DIRECTOR", "GENERO", "AÑO", "DURACION", "PRECIO", "ALQUILERES"};

        //Creamos el modelo de tabla
        modelPeliculas = new TablePeliculas(jsonArrayPeliculas, columnNames);
        //Asignamos el modelo a la tabla
        jTablePeliculasFiltradas.setModel(modelPeliculas);
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
        String[] columnNames = {"TITULO", "DIRECTOR", "GENERO", "AÑO", "DURACION", "PRECIO", "ALQUILERES"};

        //Creamos el modelo de tabla
        modelPeliculas = new TablePeliculas(jsonArrayPeliculas, columnNames);
        //Asignamos el modelo a la tabla
        jTablePeliculasFiltradas.setModel(modelPeliculas);
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

    private void buttonInicio1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInicio1ActionPerformed
        // Cerramos la ventana de registro.
        // y volvemos a inicio.
        this.dispose();
        VentanaUsuario usuario = new VentanaUsuario();
        usuario.setVisible(true);
    }//GEN-LAST:event_buttonInicio1ActionPerformed

    private void rankingPeliculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rankingPeliculasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rankingPeliculasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alquilarPelicula;
    private javax.swing.JButton buttonInicio;
    private javax.swing.JButton buttonInicio1;
    private javax.swing.JButton buttonModificarContraseña;
    private javax.swing.JButton cambioDeContraseña;
    private javax.swing.JButton jButtonAnteriorPeliculas;
    private javax.swing.JButton jButtonAnteriorPeliculasFiltradas;
    private javax.swing.JButton jButtonCerrarSesion;
    private javax.swing.JButton jButtonFiltrar;
    private javax.swing.JButton jButtonFiltros;
    private javax.swing.JButton jButtonSiguientePeliculas;
    private javax.swing.JButton jButtonSiguientePeliculasFiltradas;
    private javax.swing.JComboBox<String> jComboBoxFiltros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelAño;
    private javax.swing.JLabel jLabelConfirmPassword;
    private javax.swing.JLabel jLabelDescripcion;
    private javax.swing.JLabel jLabelDescripcion2;
    private javax.swing.JLabel jLabelDirector;
    private javax.swing.JLabel jLabelFiltrosDeBusqueda;
    private javax.swing.JLabel jLabelGenero;
    private javax.swing.JLabel jLabelOrden;
    private javax.swing.JLabel jLabelPaginaPeliculas;
    private javax.swing.JLabel jLabelPaginaPeliculasFiltradas;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JLabel jLabelVecesAlquilada;
    private javax.swing.JPanel jPanelAlquileres;
    private javax.swing.JPanel jPanelFiltros;
    private javax.swing.JPanel jPanelPeliculas;
    private javax.swing.JPanel jPanelPeliculasFiltradas;
    private javax.swing.JPanel jPanelUsuario;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JPasswordField jPassword2;
    private javax.swing.JScrollPane jScrollPaneAlquileresUsuario;
    private javax.swing.JScrollPane jScrollPanePeliculas;
    private javax.swing.JScrollPane jScrollPanePeliculasFiltradas;
    private javax.swing.JTable jTableAlquileresUsuario;
    private javax.swing.JTable jTablePeliculas;
    private javax.swing.JTable jTablePeliculasFiltradas;
    private javax.swing.JTextField jTextFieldAño;
    private javax.swing.JTextField jTextFieldDirector;
    private javax.swing.JTextField jTextFieldGenero;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldVecesAlquilada;
    private javax.swing.JButton listaAlquileresUsuario;
    private javax.swing.JButton listaPeliculas;
    private javax.swing.JTextArea mensajeBienvenida;
    private javax.swing.JButton modificarPerfil;
    private javax.swing.JPanel panelContraseña;
    private javax.swing.JButton rankingPeliculas;
    private javax.swing.JLabel textLogo;
    // End of variables declaration//GEN-END:variables

}
