package Pantallas.usuarios;

import Modelos.DTOS.ResponseLogoutDTO;
import Modelos.DTOS.usuarios.DTO.ResponseUserInfoDTO;
import Modelos.DTOS.usuarios.DTO.ResponseUserListDTO;
import Pantallas.VentanaAdmin;
import Pantallas.VentanaLogin;
import com.google.gson.Gson;
import Tablas.TableUsuarios;
import java.awt.Color;
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

/**
 *
 * Ventana para realizar la gestión de los usuarios.
 *
 * @author Carlos
 */
public class VentanaGestionUsuarios extends javax.swing.JFrame {

    //Variable de Clase.
    TableUsuarios model;
    JSONArray jsonArray;
    int pagina = 0, paginaSize = 10, paginasTotales;
    int paginaFiltro = 0, paginaSizeFiltro = 10, paginasTotalesFiltro;
    String parametros = "";

    /**
     * Constructor de un nuevo formulario Ventana de gestion de los usuarios.
     *
     * @Author Carlos.
     */
    public VentanaGestionUsuarios() {
        initComponents();

        jLabelPagina.setVisible(false);
        jButtonAnterior.setVisible(false);
        jButtonSiguiente.setVisible(false);
        jButtonFiltros.setVisible(false);
        jPanelFiltros.setVisible(false);
        jPanelUsuariosFiltrados.setVisible(false);

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
        jTextFieldNombreUsuario.setText(responseJson.getValue().getNombre());
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

        jPanelGestionUsuarios = new javax.swing.JPanel();
        textLogo = new javax.swing.JLabel();
        mensajeGestionUsuarios = new javax.swing.JTextArea();
        jLabelUsuario = new javax.swing.JLabel();
        jTextFieldNombreUsuario = new javax.swing.JTextField();
        listaUsuarios = new javax.swing.JButton();
        modificarRolUsuario = new javax.swing.JButton();
        eliminarUsuario = new javax.swing.JButton();
        jButtonVolver = new javax.swing.JButton();
        jButtonCerrarSesion = new javax.swing.JButton();
        jScrollPane = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jButtonAnterior = new javax.swing.JButton();
        jLabelPagina = new javax.swing.JLabel();
        jButtonSiguiente = new javax.swing.JButton();
        jButtonFiltros = new javax.swing.JButton();
        jPanelFiltros = new javax.swing.JPanel();
        jLabelFiltrosDeBusqueda = new javax.swing.JLabel();
        jLabelDescripcion = new javax.swing.JLabel();
        jLabelDescripcion2 = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelApellidos = new javax.swing.JLabel();
        jLabelUsername = new javax.swing.JLabel();
        jLabelOrden = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldApellidos = new javax.swing.JTextField();
        jTextFieldUsername = new javax.swing.JTextField();
        jComboBoxFiltros = new javax.swing.JComboBox<>();
        jButtonFiltrar = new javax.swing.JButton();
        buttonVolver2 = new javax.swing.JButton();
        jPanelUsuariosFiltrados = new javax.swing.JPanel();
        jScrollPaneUsuariosFiltrados = new javax.swing.JScrollPane();
        jTableUsuariosFiltrados = new javax.swing.JTable();
        jButtonAnteriorUsuariosFiltrados = new javax.swing.JButton();
        jLabelPaginaUsuariosFiltrados = new javax.swing.JLabel();
        jButtonSiguienteUsuariosFiltrados = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GESTION DE USUARIOS");
        setResizable(false);

        jPanelGestionUsuarios.setBackground(new java.awt.Color(255, 255, 255));
        jPanelGestionUsuarios.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jPanelGestionUsuarios.setPreferredSize(new java.awt.Dimension(965, 459));

        textLogo.setBackground(new java.awt.Color(255, 255, 255));
        textLogo.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        textLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textLogo.setText("MOVIES4RENT");
        textLogo.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.black));
        textLogo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        mensajeGestionUsuarios.setEditable(false);
        mensajeGestionUsuarios.setColumns(20);
        mensajeGestionUsuarios.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        mensajeGestionUsuarios.setRows(2);
        mensajeGestionUsuarios.setText("    GESTION DE USUARIOS");
        mensajeGestionUsuarios.setBorder(null);
        mensajeGestionUsuarios.setSelectionColor(new java.awt.Color(255, 255, 255));

        jLabelUsuario.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jLabelUsuario.setText("USUARIO:");

        jTextFieldNombreUsuario.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jTextFieldNombreUsuario.setToolTipText("");
        jTextFieldNombreUsuario.setBorder(null);

        listaUsuarios.setBackground(new java.awt.Color(0, 204, 255));
        listaUsuarios.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        listaUsuarios.setText("Listar Usuarios");
        listaUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listaUsuariosActionPerformed(evt);
            }
        });

        modificarRolUsuario.setBackground(new java.awt.Color(255, 153, 51));
        modificarRolUsuario.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        modificarRolUsuario.setText("Modificar ROL Usuario");
        modificarRolUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarRolUsuarioActionPerformed(evt);
            }
        });

        eliminarUsuario.setBackground(new java.awt.Color(255, 51, 51));
        eliminarUsuario.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        eliminarUsuario.setText("Eliminar Usuario");
        eliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarUsuarioActionPerformed(evt);
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

        jButtonCerrarSesion.setBackground(new java.awt.Color(255, 102, 102));
        jButtonCerrarSesion.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jButtonCerrarSesion.setText("Cerrar Sesion");
        jButtonCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCerrarSesionActionPerformed(evt);
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

        jLabelNombre.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabelNombre.setText("Nombre :");

        jLabelApellidos.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabelApellidos.setText("Apellidos :");

        jLabelUsername.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabelUsername.setText("Username :");

        jLabelOrden.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabelOrden.setText("Orden :");

        jTextFieldNombre.setBackground(java.awt.SystemColor.control);
        jTextFieldNombre.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jTextFieldNombre.setToolTipText("");
        jTextFieldNombre.setBorder(null);

        jTextFieldApellidos.setBackground(java.awt.SystemColor.control);
        jTextFieldApellidos.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jTextFieldApellidos.setToolTipText("");
        jTextFieldApellidos.setBorder(null);

        jTextFieldUsername.setBackground(javax.swing.UIManager.getDefaults().getColor("control"));
        jTextFieldUsername.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jTextFieldUsername.setToolTipText("");
        jTextFieldUsername.setBorder(null);

        jComboBoxFiltros.setBackground(javax.swing.UIManager.getDefaults().getColor("control"));
        jComboBoxFiltros.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jComboBoxFiltros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sin orden", "nombreAsc", "nombreDesc", "apellidosAsc", "apellidosDesc", "usernameAsc", "usernameDesc", " " }));
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
                    .addGroup(jPanelFiltrosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelFiltrosDeBusqueda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                            .addGroup(jPanelFiltrosLayout.createSequentialGroup()
                                .addGroup(jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanelFiltrosLayout.createSequentialGroup()
                                        .addComponent(jButtonFiltrar)
                                        .addGap(25, 25, 25)
                                        .addComponent(buttonVolver2))
                                    .addGroup(jPanelFiltrosLayout.createSequentialGroup()
                                        .addGroup(jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelOrden, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(jLabelApellidos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabelNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabelUsername, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextFieldUsername)
                                            .addComponent(jComboBoxFiltros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldApellidos)
                                            .addComponent(jTextFieldNombre))))
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
                    .addComponent(jLabelNombre)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelApellidos)
                    .addComponent(jTextFieldApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUsername)
                    .addComponent(jTextFieldUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelOrden)
                    .addComponent(jComboBoxFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonFiltrar)
                    .addComponent(buttonVolver2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanelUsuariosFiltrados.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPaneUsuariosFiltrados.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPaneUsuariosFiltrados.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPaneUsuariosFiltrados.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPaneUsuariosFiltrados.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N

        jTableUsuariosFiltrados.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jTableUsuariosFiltrados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableUsuariosFiltrados.setFillsViewportHeight(true);
        jTableUsuariosFiltrados.setFocusable(false);
        jTableUsuariosFiltrados.setGridColor(new java.awt.Color(153, 153, 153));
        jTableUsuariosFiltrados.setSelectionBackground(new java.awt.Color(102, 204, 255));
        jScrollPaneUsuariosFiltrados.setViewportView(jTableUsuariosFiltrados);

        jButtonAnteriorUsuariosFiltrados.setBackground(new java.awt.Color(242, 242, 242));
        jButtonAnteriorUsuariosFiltrados.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jButtonAnteriorUsuariosFiltrados.setText("Anterior");
        jButtonAnteriorUsuariosFiltrados.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonAnteriorUsuariosFiltrados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAnteriorUsuariosFiltradosActionPerformed(evt);
            }
        });

        jLabelPaginaUsuariosFiltrados.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N

        jButtonSiguienteUsuariosFiltrados.setBackground(new java.awt.Color(242, 242, 242));
        jButtonSiguienteUsuariosFiltrados.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jButtonSiguienteUsuariosFiltrados.setText("Siguiente");
        jButtonSiguienteUsuariosFiltrados.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButtonSiguienteUsuariosFiltrados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSiguienteUsuariosFiltradosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelUsuariosFiltradosLayout = new javax.swing.GroupLayout(jPanelUsuariosFiltrados);
        jPanelUsuariosFiltrados.setLayout(jPanelUsuariosFiltradosLayout);
        jPanelUsuariosFiltradosLayout.setHorizontalGroup(
            jPanelUsuariosFiltradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUsuariosFiltradosLayout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(jButtonAnteriorUsuariosFiltrados)
                .addGap(18, 18, 18)
                .addComponent(jLabelPaginaUsuariosFiltrados, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSiguienteUsuariosFiltrados)
                .addContainerGap(311, Short.MAX_VALUE))
            .addGroup(jPanelUsuariosFiltradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPaneUsuariosFiltrados, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE))
        );
        jPanelUsuariosFiltradosLayout.setVerticalGroup(
            jPanelUsuariosFiltradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelUsuariosFiltradosLayout.createSequentialGroup()
                .addContainerGap(258, Short.MAX_VALUE)
                .addGroup(jPanelUsuariosFiltradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonSiguienteUsuariosFiltrados)
                    .addComponent(jLabelPaginaUsuariosFiltrados, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAnteriorUsuariosFiltrados))
                .addContainerGap())
            .addGroup(jPanelUsuariosFiltradosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelUsuariosFiltradosLayout.createSequentialGroup()
                    .addComponent(jScrollPaneUsuariosFiltrados, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 69, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanelGestionUsuariosLayout = new javax.swing.GroupLayout(jPanelGestionUsuarios);
        jPanelGestionUsuarios.setLayout(jPanelGestionUsuariosLayout);
        jPanelGestionUsuariosLayout.setHorizontalGroup(
            jPanelGestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGestionUsuariosLayout.createSequentialGroup()
                .addGap(448, 448, 448)
                .addComponent(jButtonAnterior)
                .addGap(18, 18, 18)
                .addComponent(jLabelPagina, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonSiguiente)
                .addGroup(jPanelGestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelGestionUsuariosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonVolver)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCerrarSesion)
                        .addGap(12, 12, 12))
                    .addGroup(jPanelGestionUsuariosLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jButtonFiltros)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGestionUsuariosLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanelGestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(eliminarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(modificarRolUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(listaUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addGroup(jPanelGestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelGestionUsuariosLayout.createSequentialGroup()
                        .addComponent(mensajeGestionUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jLabelUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelGestionUsuariosLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
            .addGroup(jPanelGestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelGestionUsuariosLayout.createSequentialGroup()
                    .addGap(282, 282, 282)
                    .addComponent(jPanelFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(282, Short.MAX_VALUE)))
            .addGroup(jPanelGestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGestionUsuariosLayout.createSequentialGroup()
                    .addContainerGap(282, Short.MAX_VALUE)
                    .addComponent(jPanelUsuariosFiltrados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(51, 51, 51)))
        );
        jPanelGestionUsuariosLayout.setVerticalGroup(
            jPanelGestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGestionUsuariosLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanelGestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelGestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelUsuario)
                        .addComponent(jTextFieldNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelGestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(textLogo)
                        .addComponent(mensajeGestionUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addGroup(jPanelGestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelGestionUsuariosLayout.createSequentialGroup()
                        .addComponent(listaUsuarios)
                        .addGap(18, 18, 18)
                        .addComponent(modificarRolUsuario)
                        .addGap(18, 18, 18)
                        .addComponent(eliminarUsuario))
                    .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanelGestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelGestionUsuariosLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButtonFiltros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelGestionUsuariosLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanelGestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonAnterior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonSiguiente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelPagina, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(99, 99, 99)
                .addGroup(jPanelGestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCerrarSesion)
                    .addComponent(jButtonVolver))
                .addGap(23, 23, 23))
            .addGroup(jPanelGestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelGestionUsuariosLayout.createSequentialGroup()
                    .addGap(83, 83, 83)
                    .addComponent(jPanelFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(92, Short.MAX_VALUE)))
            .addGroup(jPanelGestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelGestionUsuariosLayout.createSequentialGroup()
                    .addGap(81, 81, 81)
                    .addComponent(jPanelUsuariosFiltrados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(90, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelGestionUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelGestionUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

    private void listaUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listaUsuariosActionPerformed

        /**
         *
         * Método para crear una tabla que muestre la lista de usuarios de la aplicacion.
         *
         * @Author Carlos.
         */
        jLabelPagina.setVisible(true);
        jButtonAnterior.setVisible(true);
        jButtonSiguiente.setVisible(true);
        jButtonFiltros.setVisible(true);
        jScrollPane.setVisible(true);
        jPanelFiltros.setVisible(false);
        jPanelUsuariosFiltrados.setVisible(false);
        pagina = 0;

        /**
         * Esta es la primera tabla de usuarios que se muestra. pagina 0 ( 1 en pantalla.)
         *
         * @Author Carlos.
         */
        StringBuilder resultado = new StringBuilder();
        try {
            // Creamos la URL
            // Es una url con tres parametros en modo query.

            URL url = new URL(Constants.urlUsuariosPaginados
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
        ResponseUserListDTO responseJson = gson.fromJson(responseJsonString, ResponseUserListDTO.class);
        //*************************************************

        paginasTotales = responseJson.getValue().getTotalPages();
        jLabelPagina.setText(String.valueOf(pagina + 1) + " de " + paginasTotales);

        //Creamos una lista de objetos JSON
        jsonArray = new JSONArray();
        for (int i = 0; i < responseJson.getValue().getContent().size(); i++) {
            JSONObject obj = new JSONObject();
            obj.put("id", responseJson.getValue().getContent().get(i).getId());
            obj.put("NOMBRE", responseJson.getValue().getContent().get(i).getNombre());
            obj.put("APELLIDOS", responseJson.getValue().getContent().get(i).getApellidos());
            obj.put("TELEFONO", responseJson.getValue().getContent().get(i).getTelefono());
            obj.put("EMAIL", responseJson.getValue().getContent().get(i).getEmail());
            obj.put("DIRECCION", responseJson.getValue().getContent().get(i).getDireccion());
            obj.put("USERNAME", responseJson.getValue().getContent().get(i).getUsername());
            obj.put("IsAdmin", responseJson.getValue().getContent().get(i).getIsAdmin());
            jsonArray.put(obj);
        }

        //Creamos un String[] de columnas
        String[] columnNames = {"NOMBRE", "APELLIDOS", "USERNAME", "EMAIL", "DIRECCION", "IsAdmin"};

        //Creamos el modelo de tabla
        model = new TableUsuarios(jsonArray, columnNames);
        //Asignamos el modelo a la tabla
        jTable.setModel(model);
        //Mostramos la lista
        //Añadimos color a la cabecera.
        JTableHeader header = jTable.getTableHeader();
        header.setBackground(Color.cyan);

        //Ponemos los datos de tipo de usuario en el centro de la celda.
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
        jTable.getColumnModel().getColumn(5).setCellRenderer(renderer);
        //Asignamos el ancho de la columna.
        jTable.getColumnModel().getColumn(5).setPreferredWidth(40);

    }//GEN-LAST:event_listaUsuariosActionPerformed

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

    private void eliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarUsuarioActionPerformed
        /**
         * metodo para eliminar un usuario de la aplicacion.
         *
         * @Author Carlos.
         *
         */

        //Obtenemos la fila seleccionada.
        int posicion = jTable.getSelectedRow();

        if (posicion == -1) {
            // No se ha seleccionado un usuario de la tabla
            // Mostramos mensaje emergente de informacion.
            JOptionPane.showMessageDialog(this,
                    "Primero debes seleccionar un\n"
                    + "usuario en la lista de usuarios",
                    "ELIMINAR USUARIO", JOptionPane.INFORMATION_MESSAGE);

        } else {
            // Se ha seleccionado un usuario
            // Creamos un objeto JSON temporal de la fila seleccionada.
            JSONObject obj = new JSONObject();
            obj = jsonArray.getJSONObject(posicion);

            // Mostramos mensaje emergente de confirmacion.
            int opcion = JOptionPane.showConfirmDialog(this,
                    "Deseas eliminar el usuario\n"
                    + obj.get("NOMBRE") + " "
                    + obj.getString("APELLIDOS") + " ?",
                    "ELIMINAR USUARIO",
                    JOptionPane.YES_NO_OPTION);

            if (opcion == JOptionPane.YES_OPTION) {
                //Eliminamos usuario.
                //1º obtenemos su id .
                UUID id = (UUID) obj.get("id");
                //****************************************************************
                // Creamos el cliente de acceso
                Client client = ClientBuilder.newClient();

                // Creamos el target (URL)
                WebTarget target = client.target(Constants.urlUsersDeleteId
                        + id + "?token=" + Constants.token);

                // Creamos la solicitud
                Invocation.Builder solicitud = target.request();

                // Enviamos nuestro peticion DELETE a la API
                Response deleteUser = solicitud.delete();

                // Recibimos la respuesta del servidor.
                String responseJsonString = deleteUser.readEntity(String.class);

                //Covertimos el JsonString en un objeto JSON.
                JSONObject json = new JSONObject(responseJsonString);
                System.out.println(json.getString("message"));

                // Si todo ha salido correcto.
                if (deleteUser.getStatus() == 200) {
                    // Mostramos mensaje emergente de informacion.
                    JOptionPane.showMessageDialog(this,
                            "Usuario eliminado correctamente.",
                            "ELIMINAR USUARIO", JOptionPane.INFORMATION_MESSAGE);

                    jTable.clearSelection();
                    //****************************************************************
                } else {
                    // Si ha habido error en la operacion.
                    // Mostramos mensaje emergente de informacion.
                    JOptionPane.showMessageDialog(this,
                            "Ha ocurrido un error inesperado.",
                            "ELIMINAR USUARIO", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                //Limpiamos la seleccion de la tabla. 
                jTable.clearSelection();
            }
        }
    }//GEN-LAST:event_eliminarUsuarioActionPerformed

    private void modificarRolUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarRolUsuarioActionPerformed
        /**
         * Metodo para modificar el ROL del usuario
         *
         * administrador o usuario.
         *
         * @Author Carlos.
         */

        //Obtenemos la fila seleccionada.
        int posicion = jTable.getSelectedRow();

        if (posicion == -1) {
            // No se ha seleccionado un usuario de la tabla
            // Mostramos mensaje emergente de informacion.
            JOptionPane.showMessageDialog(this,
                    "Primero debes seleccionar un\n"
                    + "usuario en la lista de usuarios",
                    "MODIFICAR ROL USUARIO", JOptionPane.INFORMATION_MESSAGE);

        } else {

            // Se ha seleccionado un usuario
            // Creamos un objeto JSON temporal de la fila seleccionada.
            JSONObject obj = new JSONObject();
            obj = jsonArray.getJSONObject(posicion);

            //Obtenemos su id.
            UUID id = (UUID) obj.get("id");

            //Comprobamos que tipo de usuario es.
            //Si es un administrador...
            if ((obj.getBoolean("IsAdmin")) == true) {

                // Mostramos mensaje emergente de confirmacion.
                int opcion = JOptionPane.showConfirmDialog(null,
                        "  Usuario ADMINISTRADOR.\n"
                        + "Deseas cambiarlo a USUARIO?",
                        "CONFIRMACION", 0);

                //Si opcion es SI...
                if (opcion == 0) {
                    //Cambiamos su ROL a usuario.
                    Boolean admin = false;
                    try {
                        // Creamos la URL.
                        URL url = new URL(Constants.urlUpdateUsuarioAdmin + id + "/" + admin + "?token=" + Constants.token);
                        //Creamos la conexion al servidor.
                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                        //Metodo PUT
                        conn.setDoOutput(true);
                        conn.setRequestMethod("PUT");
                        // Si todo ha salido correcto.
                        if (conn.getResponseCode() == 200) {
                            // Mostramos mensaje emergente de informacion.
                            JOptionPane.showMessageDialog(this,
                                    "ROL del usuario modificado correctamente.\n"
                                    + "Volverás a la pantalla de login.",
                                    "MODIFICAR ROL USUARIO", JOptionPane.INFORMATION_MESSAGE);
                        }
                        jTable.clearSelection();
                        // Cerramos la ventana. 
                        // y volvemos a inicio.
                        this.dispose();
                        VentanaLogin inicio = new VentanaLogin();
                        inicio.setVisible(true);

                    } catch (MalformedURLException ex) {
                        Logger.getLogger(VentanaGestionUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(VentanaGestionUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    //Limpiamos la seleccion de la tabla. 
                    jTable.clearSelection();
                }
            } else { //Si es Usuario...
                // Mostramos mensaje emergente de confirmacion.
                int opcion = JOptionPane.showConfirmDialog(null,
                        "          Es un USUARIO.\n"
                        + "Deseas cambiarlo a ADMINISTRADOR?",
                        "CONFIRMACION", 0);

                //Si opcion es SI...
                if (opcion == 0) {
                    //Cambiamos su ROL a administrador.
                    Boolean admin = true;
                    try {
                        // Creamos la URL.
                        URL url = new URL(Constants.urlUpdateUsuarioAdmin + id + "/" + admin + "?token=" + Constants.token);
                        //Creamos la conexion al servidor.
                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                        //Metodo PUT
                        conn.setDoOutput(true);
                        conn.setRequestMethod("PUT");
                        // Si todo ha salido correcto.
                        if (conn.getResponseCode() == 200) {
                            // Mostramos mensaje emergente de informacion.
                            JOptionPane.showMessageDialog(this,
                                    "ROL del usuario modificado correctamente.\n"
                                    + "Volverás a la pantalla de login.",
                                    "MODIFICAR ROL USUARIO", JOptionPane.INFORMATION_MESSAGE);
                        }
                        jTable.clearSelection();
                        // Cerramos la ventana. 
                        // y volvemos a inicio.
                        this.dispose();
                        VentanaLogin inicio = new VentanaLogin();
                        inicio.setVisible(true);

                    } catch (MalformedURLException ex) {
                        Logger.getLogger(VentanaGestionUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(VentanaGestionUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    //Limpiamos la seleccion de la tabla. 
                    jTable.clearSelection();
                }
            }
        }
    }//GEN-LAST:event_modificarRolUsuarioActionPerformed

    private void jButtonSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSiguienteActionPerformed

        /**
         * Hago la consulta de tabla. Con la siguiente pagina. Leo los datos en el DTO para ello. Paso los datos a la tabla.
         *
         */
        if (pagina < paginasTotales - 1) {
            pagina++;

            //**************************************************************
            StringBuilder resultado = new StringBuilder();
            try {
                // Creamos la URL
                // Es una url con tres parametros en modo query.

                URL url = new URL(Constants.urlUsuariosPaginados
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
            ResponseUserListDTO responseJson = gson.fromJson(responseJsonString, ResponseUserListDTO.class);
            //*************************************************

            //Actualizo el label del contador de paginas.
            jLabelPagina.setText(String.valueOf(pagina + 1) + " de " + paginasTotales);

            //Creamos una lista de objetos JSON
            jsonArray = new JSONArray();
            for (int i = 0; i < responseJson.getValue().getContent().size(); i++) {
                JSONObject obj = new JSONObject();
                obj.put("id", responseJson.getValue().getContent().get(i).getId());
                obj.put("NOMBRE", responseJson.getValue().getContent().get(i).getNombre());
                obj.put("APELLIDOS", responseJson.getValue().getContent().get(i).getApellidos());
                obj.put("TELEFONO", responseJson.getValue().getContent().get(i).getTelefono());
                obj.put("EMAIL", responseJson.getValue().getContent().get(i).getEmail());
                obj.put("DIRECCION", responseJson.getValue().getContent().get(i).getDireccion());
                obj.put("USERNAME", responseJson.getValue().getContent().get(i).getUsername());
                obj.put("IsAdmin", responseJson.getValue().getContent().get(i).getIsAdmin());
                jsonArray.put(obj);
            }
            //*********************************************+++++++++++++++****

            //Actualizo la tabla.
            //Creamos un String[] de columnas
            String[] columnNames = {"NOMBRE", "APELLIDOS", "USERNAME", "EMAIL", "DIRECCION", "IsAdmin"};

            //Creamos el modelo de tabla
            model = new TableUsuarios(jsonArray, columnNames);
            //Asignamos el modelo a la tabla
            jTable.setModel(model);
            //Mostramos la lista
            //Añadimos color a la cabecera.
            JTableHeader header = jTable.getTableHeader();
            header.setBackground(Color.cyan);
            //Ponemos los datos de tipo de usuario en el centro de la celda.
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            renderer.setHorizontalAlignment(JLabel.CENTER);
            jTable.getColumnModel().getColumn(5).setCellRenderer(renderer);
            //Asignamos el ancho de la columna.
            jTable.getColumnModel().getColumn(5).setPreferredWidth(40);
        }
    }//GEN-LAST:event_jButtonSiguienteActionPerformed

    private void jButtonAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnteriorActionPerformed

        /**
         * Hago la consulta de tabla. Con la pagina anterior. Leo los datos en el DTO para ello. Paso los datos a la tabla.
         *
         */
        if (pagina > 0) {
            pagina--;
            //**************************************************************
            StringBuilder resultado = new StringBuilder();
            try {
                // Creamos la URL
                // Es una url con tres parametros en modo query.

                URL url = new URL(Constants.urlUsuariosPaginados
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
            ResponseUserListDTO responseJson = gson.fromJson(responseJsonString, ResponseUserListDTO.class);
            //*************************************************

            //Actualizo el label del contador de paginas.
            jLabelPagina.setText(String.valueOf(pagina + 1) + " de " + paginasTotales);

            //Creamos una lista de objetos JSON
            jsonArray = new JSONArray();
            for (int i = 0; i < responseJson.getValue().getContent().size(); i++) {
                JSONObject obj = new JSONObject();
                obj.put("id", responseJson.getValue().getContent().get(i).getId());
                obj.put("NOMBRE", responseJson.getValue().getContent().get(i).getNombre());
                obj.put("APELLIDOS", responseJson.getValue().getContent().get(i).getApellidos());
                obj.put("TELEFONO", responseJson.getValue().getContent().get(i).getTelefono());
                obj.put("EMAIL", responseJson.getValue().getContent().get(i).getEmail());
                obj.put("DIRECCION", responseJson.getValue().getContent().get(i).getDireccion());
                obj.put("USERNAME", responseJson.getValue().getContent().get(i).getUsername());
                obj.put("IsAdmin", responseJson.getValue().getContent().get(i).getIsAdmin());
                jsonArray.put(obj);
            }
            //*********************************************+++++++++++++++****

            //Actualizo la tabla.
            //Creamos un String[] de columnas
            String[] columnNames = {"NOMBRE", "APELLIDOS", "USERNAME", "EMAIL", "DIRECCION", "IsAdmin"};

            //Creamos el modelo de tabla
            model = new TableUsuarios(jsonArray, columnNames);
            //Asignamos el modelo a la tabla
            jTable.setModel(model);
            //Mostramos la lista
            //Añadimos color a la cabecera.
            JTableHeader header = jTable.getTableHeader();
            header.setBackground(Color.cyan);
            //Ponemos los datos de tipo de usuario en el centro de la celda.
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            renderer.setHorizontalAlignment(JLabel.CENTER);
            jTable.getColumnModel().getColumn(5).setCellRenderer(renderer);
            //Asignamos el ancho de la columna.
            jTable.getColumnModel().getColumn(5).setPreferredWidth(40);
        }
    }//GEN-LAST:event_jButtonAnteriorActionPerformed

    private void jButtonFiltrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFiltrosActionPerformed
        /**
         * Metodo para mostrar el panel de entrada de parametros para realizar la búsqueda de peliculas.
         *
         * @Author Carlos.
         */

        //cerramos los paneles que hubieran estado abiertos.
        jScrollPane.setVisible(false);
        jLabelPagina.setVisible(false);
        jButtonAnterior.setVisible(false);
        jButtonSiguiente.setVisible(false);
        jButtonFiltros.setVisible(false);
        jTable.clearSelection();

        //Mostramos panel de seleccion de filtros.
        jPanelFiltros.setVisible(true);

        //Ponemos los campos en blanco.
        jTextFieldNombre.setText("");
        jTextFieldApellidos.setText("");
        jTextFieldUsername.setText("");

    }//GEN-LAST:event_jButtonFiltrosActionPerformed

    private void buttonVolver2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVolver2ActionPerformed
        // Cerramos el panel de filtros.
        // y volvemos a inicio.
        VentanaGestionUsuarios ventanaGestionUsuarios = new VentanaGestionUsuarios();
        ventanaGestionUsuarios.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_buttonVolver2ActionPerformed

    private void jButtonFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFiltrarActionPerformed

        /**
         * Metodo para mostrar la lista de usuarios filtrada por los parametros de búsqueda.
         *
         * Esta es la primera tabla de usuarios filtradas que se muestra. pagina 0 ( 1 en pantalla.)
         *
         * @Author Carlos.
         */
        //cerramos los paneles que hubieran estado abiertos.
        jLabelPagina.setVisible(false);
        jButtonAnterior.setVisible(false);
        jButtonSiguiente.setVisible(false);
        jButtonFiltros.setVisible(false);
        jPanelFiltros.setVisible(false);

        //Limpiamos la tabla de usuarios filtradas.
        jTableUsuariosFiltrados.clearSelection();

        //Variables de la url.
        String nombre;
        String apellidos;
        String username;
        parametros = "";

        // Leemos los campos seleccionados
        // y creamos la cadena de parametros.
        if (!jTextFieldNombre.getText().isEmpty()) {
            nombre = jTextFieldNombre.getText().replace(" ", "%20");
            parametros = parametros + "&nombre=" + nombre;
        }

        if (!jTextFieldApellidos.getText().isEmpty()) {
            apellidos = jTextFieldApellidos.getText().replace(" ", "%20");
            parametros = parametros + "&apellidos=" + apellidos;
        }

        if (!jTextFieldUsername.getText().isEmpty()) {
            username = jTextFieldUsername.getText();
            parametros = parametros + "&username=" + username;
        }

        //Leemos el orden que hemos seleccionado...
        String orden = (String) jComboBoxFiltros.getSelectedItem();

        //Asignamos el string parametro del orden.
        orden = switch (orden) {
            case "nombreAsc" ->
                "&orden=nombreAsc";
            case "nombreDesc" ->
                "&orden=nombreDesc";
            case "apellidosAsc" ->
                "&orden=apellidosAsc";
            case "apellidosDesc" ->
                "&orden=apellidosDesc";
            case "usernameAsc" ->
                "&orden=usernameAsc";
            case "usernameDesc" ->
                "&orden=usernameDesc";
            default ->
                "";
        };

        //Terminamos de crear el string parametros de la url.
        parametros = parametros + orden;

        //Tabla usuarios filtrados.
        jPanelUsuariosFiltrados.setVisible(true);

        // Creamos la URL
        // Es una url con cuatro parametros en modo PATH.
        StringBuilder resultado = new StringBuilder();
        try {

            URL url = new URL(Constants.urlUsuariosPaginados
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
        ResponseUserListDTO responseJson = gson.fromJson(responseJsonString, ResponseUserListDTO.class);
        //*************************************************

        paginasTotalesFiltro = responseJson.getValue().getTotalPages();
        jLabelPaginaUsuariosFiltrados.setText(String.valueOf(paginaFiltro + 1) + " de " + paginasTotalesFiltro);

        //Creamos una lista de objetos JSON
        jsonArray = new JSONArray();
        for (int i = 0; i < responseJson.getValue().getContent().size(); i++) {
            JSONObject obj = new JSONObject();
            obj.put("id", responseJson.getValue().getContent().get(i).getId());
            obj.put("NOMBRE", responseJson.getValue().getContent().get(i).getNombre());
            obj.put("APELLIDOS", responseJson.getValue().getContent().get(i).getApellidos());
            obj.put("TELEFONO", responseJson.getValue().getContent().get(i).getTelefono());
            obj.put("EMAIL", responseJson.getValue().getContent().get(i).getEmail());
            obj.put("DIRECCION", responseJson.getValue().getContent().get(i).getDireccion());
            obj.put("USERNAME", responseJson.getValue().getContent().get(i).getUsername());
            obj.put("IsAdmin", responseJson.getValue().getContent().get(i).getIsAdmin());
            jsonArray.put(obj);
        }

        //Creamos un String[] de columnas
        String[] columnNames = {"NOMBRE", "APELLIDOS", "USERNAME", "EMAIL", "DIRECCION", "IsAdmin"};

        //Creamos el modelo de tabla
        model = new TableUsuarios(jsonArray, columnNames);
        //Asignamos el modelo a la tabla
        jTableUsuariosFiltrados.setModel(model);
        //Mostramos la lista
        //Añadimos color a la cabecera.
        JTableHeader header = jTableUsuariosFiltrados.getTableHeader();
        header.setBackground(Color.cyan);
        //Ponemos los datos de tipo de usuario en el centro de la celda.
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
        jTableUsuariosFiltrados.getColumnModel().getColumn(5).setCellRenderer(renderer);
        //Asignamos el ancho de la columna.
        jTableUsuariosFiltrados.getColumnModel().getColumn(5).setPreferredWidth(40);

    }//GEN-LAST:event_jButtonFiltrarActionPerformed

    private void jButtonAnteriorUsuariosFiltradosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAnteriorUsuariosFiltradosActionPerformed
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

                URL url = new URL(Constants.urlUsuariosPaginados
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
            ResponseUserListDTO responseJson = gson.fromJson(responseJsonString, ResponseUserListDTO.class);
            //*************************************************

            paginasTotalesFiltro = responseJson.getValue().getTotalPages();
            jLabelPaginaUsuariosFiltrados.setText(String.valueOf(paginaFiltro + 1) + " de " + paginasTotalesFiltro);

            //Creamos una lista de objetos JSON
            jsonArray = new JSONArray();
            for (int i = 0; i < responseJson.getValue().getContent().size(); i++) {
                JSONObject obj = new JSONObject();
                obj.put("id", responseJson.getValue().getContent().get(i).getId());
                obj.put("NOMBRE", responseJson.getValue().getContent().get(i).getNombre());
                obj.put("APELLIDOS", responseJson.getValue().getContent().get(i).getApellidos());
                obj.put("TELEFONO", responseJson.getValue().getContent().get(i).getTelefono());
                obj.put("EMAIL", responseJson.getValue().getContent().get(i).getEmail());
                obj.put("DIRECCION", responseJson.getValue().getContent().get(i).getDireccion());
                obj.put("USERNAME", responseJson.getValue().getContent().get(i).getUsername());
                obj.put("IsAdmin", responseJson.getValue().getContent().get(i).getIsAdmin());
                jsonArray.put(obj);
            }

            //Creamos un String[] de columnas
            String[] columnNames = {"NOMBRE", "APELLIDOS", "USERNAME", "EMAIL", "DIRECCION", "IsAdmin"};

            //Creamos el modelo de tabla
            model = new TableUsuarios(jsonArray, columnNames);
            //Asignamos el modelo a la tabla
            jTableUsuariosFiltrados.setModel(model);
            //Mostramos la lista
            //Añadimos color a la cabecera.
            JTableHeader header = jTableUsuariosFiltrados.getTableHeader();
            header.setBackground(Color.cyan);
            //Ponemos los datos de tipo de usuario en el centro de la celda.
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            renderer.setHorizontalAlignment(JLabel.CENTER);
            jTableUsuariosFiltrados.getColumnModel().getColumn(5).setCellRenderer(renderer);
            //Asignamos el ancho de la columna.
            jTableUsuariosFiltrados.getColumnModel().getColumn(5).setPreferredWidth(40);
        }
    }//GEN-LAST:event_jButtonAnteriorUsuariosFiltradosActionPerformed

    private void jButtonSiguienteUsuariosFiltradosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSiguienteUsuariosFiltradosActionPerformed
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

                URL url = new URL(Constants.urlUsuariosPaginados
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
            ResponseUserListDTO responseJson = gson.fromJson(responseJsonString, ResponseUserListDTO.class);
            //*************************************************

            paginasTotalesFiltro = responseJson.getValue().getTotalPages();
            jLabelPaginaUsuariosFiltrados.setText(String.valueOf(paginaFiltro + 1) + " de " + paginasTotalesFiltro);

            //Creamos una lista de objetos JSON
            jsonArray = new JSONArray();
            for (int i = 0; i < responseJson.getValue().getContent().size(); i++) {
                JSONObject obj = new JSONObject();
                obj.put("id", responseJson.getValue().getContent().get(i).getId());
                obj.put("NOMBRE", responseJson.getValue().getContent().get(i).getNombre());
                obj.put("APELLIDOS", responseJson.getValue().getContent().get(i).getApellidos());
                obj.put("TELEFONO", responseJson.getValue().getContent().get(i).getTelefono());
                obj.put("EMAIL", responseJson.getValue().getContent().get(i).getEmail());
                obj.put("DIRECCION", responseJson.getValue().getContent().get(i).getDireccion());
                obj.put("USERNAME", responseJson.getValue().getContent().get(i).getUsername());
                obj.put("IsAdmin", responseJson.getValue().getContent().get(i).getIsAdmin());
                jsonArray.put(obj);
            }

            //Creamos un String[] de columnas
            String[] columnNames = {"NOMBRE", "APELLIDOS", "USERNAME", "EMAIL", "DIRECCION", "IsAdmin"};

            //Creamos el modelo de tabla
            model = new TableUsuarios(jsonArray, columnNames);
            //Asignamos el modelo a la tabla
            jTableUsuariosFiltrados.setModel(model);
            //Mostramos la lista
            //Añadimos color a la cabecera.
            JTableHeader header = jTableUsuariosFiltrados.getTableHeader();
            header.setBackground(Color.cyan);
            //Ponemos los datos de tipo de usuario en el centro de la celda.
            DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
            renderer.setHorizontalAlignment(JLabel.CENTER);
            jTableUsuariosFiltrados.getColumnModel().getColumn(5).setCellRenderer(renderer);
            //Asignamos el ancho de la columna.
            jTableUsuariosFiltrados.getColumnModel().getColumn(5).setPreferredWidth(40);

        }
    }//GEN-LAST:event_jButtonSiguienteUsuariosFiltradosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonVolver2;
    private javax.swing.JButton eliminarUsuario;
    private javax.swing.JButton jButtonAnterior;
    private javax.swing.JButton jButtonAnteriorUsuariosFiltrados;
    private javax.swing.JButton jButtonCerrarSesion;
    private javax.swing.JButton jButtonFiltrar;
    private javax.swing.JButton jButtonFiltros;
    private javax.swing.JButton jButtonSiguiente;
    private javax.swing.JButton jButtonSiguienteUsuariosFiltrados;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JComboBox<String> jComboBoxFiltros;
    private javax.swing.JLabel jLabelApellidos;
    private javax.swing.JLabel jLabelDescripcion;
    private javax.swing.JLabel jLabelDescripcion2;
    private javax.swing.JLabel jLabelFiltrosDeBusqueda;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelOrden;
    private javax.swing.JLabel jLabelPagina;
    private javax.swing.JLabel jLabelPaginaUsuariosFiltrados;
    private javax.swing.JLabel jLabelUsername;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPanel jPanelFiltros;
    private javax.swing.JPanel jPanelGestionUsuarios;
    private javax.swing.JPanel jPanelUsuariosFiltrados;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JScrollPane jScrollPaneUsuariosFiltrados;
    private javax.swing.JTable jTable;
    private javax.swing.JTable jTableUsuariosFiltrados;
    private javax.swing.JTextField jTextFieldApellidos;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldNombreUsuario;
    private javax.swing.JTextField jTextFieldUsername;
    private javax.swing.JButton listaUsuarios;
    private javax.swing.JTextArea mensajeGestionUsuarios;
    private javax.swing.JButton modificarRolUsuario;
    private javax.swing.JLabel textLogo;
    // End of variables declaration//GEN-END:variables

}
