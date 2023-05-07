package Pantallas;

import Modelos.DTOS.CambioDePasswordDTO;
import Pantallas.peliculas.VentanaGestionPeliculas;
import Pantallas.usuarios.VentanaGestionUsuarios;
import Modelos.DTOS.ResponseLogoutDTO;
import Modelos.DTOS.ranking.DTO.ResponseRankingListDTO;
import Modelos.DTOS.usuarios.DTO.ResponseUserInfoDTO;
import Pantalla.alquiler.VentanaGestionAlquilerPeliculas;
import Tablas.TableRanking;
import com.google.gson.Gson;
import java.awt.Color;
import utils.Constants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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

/**
 * Ventana del usuario ADMINISTRADOR.
 *
 * @author Carlos
 */
public class VentanaAdmin extends javax.swing.JFrame {
    
    TableRanking model;

    /**
     *
     * Constructor de un nuevo formulario Ventana Administrador.
     *
     * Se crea una peticion al servidor para mostrar el nombre del usuario.
     *
     * @Author Carlos.
     */
    public VentanaAdmin() {
        initComponents();
        setLocationRelativeTo(null);
        panelContraseña.setVisible(false);
        jPanelRanking.setVisible(false);
        jPanelFiltros.setVisible(false);
        
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

        jPanelAdmin = new javax.swing.JPanel();
        textLogo = new javax.swing.JLabel();
        mensajeBienvenida = new javax.swing.JTextArea();
        jButtonCerrarSesion = new javax.swing.JButton();
        jLabelUsuario = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        gestionUsuarios = new javax.swing.JButton();
        gestionPeliculas = new javax.swing.JButton();
        gestionAlquiler = new javax.swing.JButton();
        rankingPeliculas = new javax.swing.JButton();
        cambioDeContraseña = new javax.swing.JButton();
        panelContraseña = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelPassword = new javax.swing.JLabel();
        jLabelConfirmPassword = new javax.swing.JLabel();
        jPassword = new javax.swing.JPasswordField();
        jPassword2 = new javax.swing.JPasswordField();
        buttonModificarContraseña = new javax.swing.JButton();
        jButtonVolver = new javax.swing.JButton();
        jPanelRanking = new javax.swing.JPanel();
        jLabelRanking = new javax.swing.JLabel();
        jScrollPaneRanking = new javax.swing.JScrollPane();
        jTableRanking = new javax.swing.JTable();
        jButonFiltros = new javax.swing.JButton();
        jPanelFiltros = new javax.swing.JPanel();
        jLabelFiltrosDeBusqueda = new javax.swing.JLabel();
        jLabelDescripcion = new javax.swing.JLabel();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelDirector = new javax.swing.JLabel();
        jLabelGenero = new javax.swing.JLabel();
        jLabelAño = new javax.swing.JLabel();
        jTextFieldTitulo = new javax.swing.JTextField();
        jTextFieldDirector = new javax.swing.JTextField();
        jTextFieldGenero = new javax.swing.JTextField();
        jTextFieldAño = new javax.swing.JTextField();
        jButtonFiltrar = new javax.swing.JButton();
        buttonVolver2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("ADMINISTRADOR");
        setResizable(false);

        jPanelAdmin.setBackground(new java.awt.Color(255, 255, 255));
        jPanelAdmin.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jPanelAdmin.setPreferredSize(new java.awt.Dimension(800, 400));

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
        mensajeBienvenida.setText("       Bienvenido a MOVIES4RENT\n          Eres ADMINISTRADOR");
        mensajeBienvenida.setBorder(null);
        mensajeBienvenida.setSelectionColor(new java.awt.Color(255, 255, 255));

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

        gestionUsuarios.setBackground(new java.awt.Color(0, 204, 102));
        gestionUsuarios.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        gestionUsuarios.setText("Gestión Usuarios");
        gestionUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestionUsuariosActionPerformed(evt);
            }
        });

        gestionPeliculas.setBackground(new java.awt.Color(0, 204, 102));
        gestionPeliculas.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        gestionPeliculas.setText("Gestión Películas");
        gestionPeliculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestionPeliculasActionPerformed(evt);
            }
        });

        gestionAlquiler.setBackground(new java.awt.Color(0, 204, 102));
        gestionAlquiler.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        gestionAlquiler.setText("Gestión Alquiler Películas");
        gestionAlquiler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestionAlquilerActionPerformed(evt);
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

        jButtonVolver.setBackground(new java.awt.Color(153, 204, 0));
        jButtonVolver.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jButtonVolver.setText("VOLVER");
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
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
                        .addComponent(jPassword2))
                    .addGroup(panelContraseñaLayout.createSequentialGroup()
                        .addComponent(jLabelPassword)
                        .addGap(82, 82, 82)
                        .addComponent(jPassword)))
                .addContainerGap())
            .addGroup(panelContraseñaLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(buttonModificarContraseña)
                .addGap(18, 18, 18)
                .addComponent(jButtonVolver)
                .addContainerGap(91, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(panelContraseñaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonModificarContraseña)
                    .addComponent(jButtonVolver))
                .addGap(32, 32, 32))
        );

        jPanelRanking.setBackground(new java.awt.Color(255, 255, 255));

        jLabelRanking.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        jLabelRanking.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelRanking.setText("Ranking de peliculas");

        jScrollPaneRanking.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPaneRanking.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPaneRanking.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPaneRanking.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N

        jTableRanking.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jTableRanking.setFillsViewportHeight(true);
        jTableRanking.setFocusable(false);
        jTableRanking.setGridColor(new java.awt.Color(153, 153, 153));
        jTableRanking.setSelectionBackground(new java.awt.Color(102, 204, 255));
        jScrollPaneRanking.setViewportView(jTableRanking);

        jButonFiltros.setText("Filtros");
        jButonFiltros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButonFiltrosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelRankingLayout = new javax.swing.GroupLayout(jPanelRanking);
        jPanelRanking.setLayout(jPanelRankingLayout);
        jPanelRankingLayout.setHorizontalGroup(
            jPanelRankingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRankingLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabelRanking, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(22, 22, 22))
            .addGroup(jPanelRankingLayout.createSequentialGroup()
                .addGap(201, 201, 201)
                .addComponent(jButonFiltros)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPaneRanking, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
        );
        jPanelRankingLayout.setVerticalGroup(
            jPanelRankingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRankingLayout.createSequentialGroup()
                .addComponent(jLabelRanking)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPaneRanking, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButonFiltros)
                .addContainerGap())
        );

        jPanelFiltros.setBackground(new java.awt.Color(204, 255, 255));

        jLabelFiltrosDeBusqueda.setFont(new java.awt.Font("Serif", 0, 24)); // NOI18N
        jLabelFiltrosDeBusqueda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFiltrosDeBusqueda.setText("FILTROS DE BUSQUEDA");

        jLabelDescripcion.setFont(new java.awt.Font("Serif", 0, 16)); // NOI18N
        jLabelDescripcion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDescripcion.setText("Puedes filtrar la búsqueda rellenando los campos.");

        jLabelTitulo.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabelTitulo.setText("Titulo :");

        jLabelDirector.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabelDirector.setText("Director :");

        jLabelGenero.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabelGenero.setText("Genero :");

        jLabelAño.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabelAño.setText("Año :");

        jTextFieldTitulo.setBackground(java.awt.SystemColor.control);
        jTextFieldTitulo.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jTextFieldTitulo.setToolTipText("");
        jTextFieldTitulo.setBorder(null);

        jTextFieldDirector.setBackground(java.awt.SystemColor.control);
        jTextFieldDirector.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jTextFieldDirector.setToolTipText("");
        jTextFieldDirector.setBorder(null);

        jTextFieldGenero.setBackground(javax.swing.UIManager.getDefaults().getColor("control"));
        jTextFieldGenero.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jTextFieldGenero.setToolTipText("");
        jTextFieldGenero.setBorder(null);

        jTextFieldAño.setBackground(javax.swing.UIManager.getDefaults().getColor("control"));
        jTextFieldAño.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jTextFieldAño.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextFieldAño.setToolTipText("");
        jTextFieldAño.setBorder(null);

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
                    .addGroup(jPanelFiltrosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelFiltrosDeBusqueda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                            .addGroup(jPanelFiltrosLayout.createSequentialGroup()
                                .addGroup(jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelAño, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabelDirector, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelTitulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelGenero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanelFiltrosLayout.createSequentialGroup()
                                        .addComponent(jButtonFiltrar)
                                        .addGap(54, 54, 54)
                                        .addComponent(buttonVolver2))
                                    .addGroup(jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextFieldGenero, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                                        .addComponent(jTextFieldDirector)
                                        .addComponent(jTextFieldTitulo)
                                        .addComponent(jTextFieldAño)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE))))
                    .addComponent(jLabelDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelFiltrosLayout.setVerticalGroup(
            jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFiltrosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelFiltrosDeBusqueda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelDescripcion)
                .addGap(32, 32, 32)
                .addGroup(jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTitulo)
                    .addComponent(jTextFieldTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(18, 18, 18)
                .addGroup(jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonFiltrar)
                    .addComponent(buttonVolver2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelAdminLayout = new javax.swing.GroupLayout(jPanelAdmin);
        jPanelAdmin.setLayout(jPanelAdminLayout);
        jPanelAdminLayout.setHorizontalGroup(
            jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAdminLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonCerrarSesion)
                .addGap(63, 63, 63))
            .addGroup(jPanelAdminLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rankingPeliculas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(gestionAlquiler, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(gestionPeliculas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(gestionUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(cambioDeContraseña, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                .addGroup(jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAdminLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(mensajeBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jLabelUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelAdminLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(95, Short.MAX_VALUE))
            .addGroup(jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelAdminLayout.createSequentialGroup()
                    .addGap(284, 284, 284)
                    .addComponent(panelContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(109, Short.MAX_VALUE)))
            .addGroup(jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAdminLayout.createSequentialGroup()
                    .addContainerGap(243, Short.MAX_VALUE)
                    .addComponent(jPanelRanking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        jPanelAdminLayout.setVerticalGroup(
            jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAdminLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(mensajeBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelUsuario)
                        .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(textLogo))
                .addGroup(jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAdminLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(gestionUsuarios)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(gestionPeliculas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(gestionAlquiler)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rankingPeliculas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cambioDeContraseña)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAdminLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jButtonCerrarSesion)
                .addContainerGap())
            .addGroup(jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelAdminLayout.createSequentialGroup()
                    .addGap(86, 86, 86)
                    .addComponent(panelContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(49, Short.MAX_VALUE)))
            .addGroup(jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelAdminLayout.createSequentialGroup()
                    .addContainerGap(84, Short.MAX_VALUE)
                    .addComponent(jPanelRanking, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(52, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo que se ejecuta al clicar en el boton CERRAR SESION del formulario.
     *
     * Operacion de logout del servidor.
     *
     * @Author Carlos.
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

    private void gestionAlquilerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestionAlquilerActionPerformed
        /**
         * Metodo para abrir la ventana de gestion de alquileres.
         *
         * @Author Carlos.
         */

        VentanaGestionAlquilerPeliculas alquiler = new VentanaGestionAlquilerPeliculas();
        alquiler.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_gestionAlquilerActionPerformed

    private void gestionUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestionUsuariosActionPerformed
        /**
         * Metodo para abrir la ventana de gestion de usuarios.
         *
         * @Author Carlos.
         */

        VentanaGestionUsuarios gestionUsuarios = new VentanaGestionUsuarios();
        gestionUsuarios.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_gestionUsuariosActionPerformed

    private void gestionPeliculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestionPeliculasActionPerformed
        /**
         * Metodo para abrir la ventana de gestion de peliculas.
         *
         * @Author Carlos.
         */

        VentanaGestionPeliculas gestionPeliculas = new VentanaGestionPeliculas();
        gestionPeliculas.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_gestionPeliculasActionPerformed

    private void cambioDeContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambioDeContraseñaActionPerformed
        /**
         * Metodo para abrir el panel de cambio de contraseña.
         *
         * @Author Carlos.
         */
        jPanelRanking.setVisible(false);
        jPanelFiltros.setVisible(false);
        panelContraseña.setVisible(true);

    }//GEN-LAST:event_cambioDeContraseñaActionPerformed

    private void buttonModificarContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonModificarContraseñaActionPerformed

        /**
         * Metodo para abrir la ventana de modificacion de contraseña.
         *
         * @Author Carlos.
         */
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

    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverActionPerformed
        /**
         *
         * Método para volver a la pantalla anterior.
         *
         * @Author Carlos.
         */

        panelContraseña.setVisible(false);
        
    }//GEN-LAST:event_jButtonVolverActionPerformed

    private void rankingPeliculasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rankingPeliculasActionPerformed
        
        /**
         *
         * Método para crear una tabla que muestre el ranking de las peliculas de la aplicacion.
         *
         * @Author Carlos.
         */
        
        //Se muestra el panel del ranking.
        jPanelRanking.setVisible(true);
        panelContraseña.setVisible(false);
        
        //********************************************
        // Creamos la URL
        // Es una url con tres parametros en modo query.
        StringBuilder resultado = new StringBuilder();
        try {
            // Creamos la URL
            /*
            URL url = new URL(Constants.urlPeliculas + "?token=" + Constants.token);
             */

            URL url = new URL(Constants.urlRankingPeliculas
                    + "?page=0"
                    + "&pageSize=10"
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
        ResponseRankingListDTO responseJson = gson.fromJson(responseJsonString, ResponseRankingListDTO.class);
        //*************************************************

        //Creamos una lista de objetos JSON
        JSONArray jsonArray = new JSONArray();
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
        String[] columnNames = {"TITULO", "DIRECTOR", "GENERO", "AÑO","DURACION", "ALQUILERES"};

        //Creamos el modelo de tabla
        model = new TableRanking(jsonArray, columnNames);
        //Asignamos el modelo a la tabla
        jTableRanking.setModel(model);
        //Mostramos la tabla
        //Añadimos color a la cabecera.
        JTableHeader header = jTableRanking.getTableHeader();
        header.setBackground(Color.CYAN);
        //Ponemos los datos numericos en el centro de la celda.
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
        
        jTableRanking.getColumnModel().getColumn(3).setCellRenderer(renderer);
        jTableRanking.getColumnModel().getColumn(4).setCellRenderer(renderer);
        jTableRanking.getColumnModel().getColumn(5).setCellRenderer(renderer);
        
        //Asignamos el ancho de las columnas.
        jTableRanking.getColumnModel().getColumn(0).setPreferredWidth(110);
        jTableRanking.getColumnModel().getColumn(1).setPreferredWidth(60);
        jTableRanking.getColumnModel().getColumn(2).setPreferredWidth(70);
        jTableRanking.getColumnModel().getColumn(3).setPreferredWidth(8);
        jTableRanking.getColumnModel().getColumn(4).setPreferredWidth(25);
        jTableRanking.getColumnModel().getColumn(5).setPreferredWidth(40);
        
        //********************************************
        
        
    }//GEN-LAST:event_rankingPeliculasActionPerformed

    private void jButonFiltrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButonFiltrosActionPerformed
        /**
         * Metodo para seleccionar los filtros de búsqueda en el ranking.
         * 
         * @Author Carlos.
         */
        
        //Cerramos el panel del ranking 
        jPanelRanking.setVisible(false);
        //Abrimos el panel para seleccionar los filtros.
        jPanelFiltros.setVisible(true);
                
    }//GEN-LAST:event_jButonFiltrosActionPerformed

    private void jButtonFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFiltrarActionPerformed

        /**
        * Metodo para mostrar el ranking de peliculas filtrada por los parametros de búsqueda.
        * 
        * @Author Carlos.
        */
        
        //cerramos los paneles que hubieran estado abiertos.
        jPanelFiltros.setVisible(false);
        
        //Variables de la url.
        String titulo;
        String director;
        String genero;
        String año;
        String parametros="";

        // Leemos los campos seleccionados
        // y creamos la cadena de parametros.
        if (!jTextFieldTitulo.getText().isEmpty()) {
            titulo = jTextFieldTitulo.getText().replace(" ", "%20");
            parametros = parametros + "&titulo=" + titulo;
        }

        if (!jTextFieldDirector.getText().isEmpty()) {
            director = jTextFieldDirector.getText().replace(" ", "%20");
            parametros = parametros + "&director=" + director;
        }

        if (!jTextFieldGenero.getText().isEmpty()) {
            genero = jTextFieldGenero.getText();
            parametros = parametros + "&genero=" + genero;
        }

        if (!jTextFieldAño.getText().isEmpty()) {
            año = jTextFieldAño.getText();
            parametros = parametros + "&ano=" + año;
        }
        
        //Tabla ranking con filtros.
        jPanelRanking.setVisible(true);

        // Creamos la URL
        // Es una url con cuatro parametros en modo PATH.
        StringBuilder resultado = new StringBuilder();
        try {

            URL url = new URL(Constants.urlRankingPeliculas
                + "?page=0"
                + "&pageSize=10"
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
        ResponseRankingListDTO responseJson = gson.fromJson(responseJsonString, ResponseRankingListDTO.class);
        //*************************************************

        //Creamos una lista de objetos JSON
        JSONArray jsonArray = new JSONArray();
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
        String[] columnNames = {"TITULO", "DIRECTOR", "GENERO", "AÑO","DURACION", "ALQUILERES"};

        //Creamos el modelo de tabla
        model = new TableRanking(jsonArray, columnNames);
        //Asignamos el modelo a la tabla
        jTableRanking.setModel(model);
        //Mostramos la tabla
        //Añadimos color a la cabecera.
        JTableHeader header = jTableRanking.getTableHeader();
        header.setBackground(Color.CYAN);
        //Ponemos los datos numericos en el centro de la celda.
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
        
        jTableRanking.getColumnModel().getColumn(3).setCellRenderer(renderer);
        jTableRanking.getColumnModel().getColumn(4).setCellRenderer(renderer);
        jTableRanking.getColumnModel().getColumn(5).setCellRenderer(renderer);
        
        //Asignamos el ancho de las columnas.
        jTableRanking.getColumnModel().getColumn(0).setPreferredWidth(110);
        jTableRanking.getColumnModel().getColumn(1).setPreferredWidth(60);
        jTableRanking.getColumnModel().getColumn(2).setPreferredWidth(70);
        jTableRanking.getColumnModel().getColumn(3).setPreferredWidth(8);
        jTableRanking.getColumnModel().getColumn(4).setPreferredWidth(25);
        jTableRanking.getColumnModel().getColumn(5).setPreferredWidth(40);
        
        //********************************************

    }//GEN-LAST:event_jButtonFiltrarActionPerformed

    private void buttonVolver2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVolver2ActionPerformed
        // Cerramos el panel de filtros.
        jPanelFiltros.setVisible(false);
        //Limpiamos los campos de los filtros.
        jTextFieldTitulo.setText("");
        jTextFieldDirector.setText("");
        jTextFieldGenero.setText("");
        jTextFieldAño.setText("");   
    }//GEN-LAST:event_buttonVolver2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonModificarContraseña;
    private javax.swing.JButton buttonVolver2;
    private javax.swing.JButton cambioDeContraseña;
    private javax.swing.JButton gestionAlquiler;
    private javax.swing.JButton gestionPeliculas;
    private javax.swing.JButton gestionUsuarios;
    private javax.swing.JButton jButonFiltros;
    private javax.swing.JButton jButtonCerrarSesion;
    private javax.swing.JButton jButtonFiltrar;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelAño;
    private javax.swing.JLabel jLabelConfirmPassword;
    private javax.swing.JLabel jLabelDescripcion;
    private javax.swing.JLabel jLabelDirector;
    private javax.swing.JLabel jLabelFiltrosDeBusqueda;
    private javax.swing.JLabel jLabelGenero;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelRanking;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPanel jPanelAdmin;
    private javax.swing.JPanel jPanelFiltros;
    private javax.swing.JPanel jPanelRanking;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JPasswordField jPassword2;
    private javax.swing.JScrollPane jScrollPaneRanking;
    private javax.swing.JTable jTableRanking;
    private javax.swing.JTextField jTextFieldAño;
    private javax.swing.JTextField jTextFieldDirector;
    private javax.swing.JTextField jTextFieldGenero;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldTitulo;
    private javax.swing.JTextArea mensajeBienvenida;
    private javax.swing.JPanel panelContraseña;
    private javax.swing.JButton rankingPeliculas;
    private javax.swing.JLabel textLogo;
    // End of variables declaration//GEN-END:variables

}
