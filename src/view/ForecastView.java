/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Year;

/**
 *
 * @author santi
 */
public class ForecastView extends javax.swing.JFrame {
    private DefaultTableModel modelo = new DefaultTableModel();
    private DefaultTableModel modelo1 = new DefaultTableModel();

    /**
     * Creates new form view
     */
    public ForecastView() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        lblDatoAModificar.setVisible(false);
        menuBorrar(false);
        menuModificar(false);
    }
    
    /**
     *@param visible Boolean
     * Hace visible el menú para seleccionar el año a borrar.
     */
    public void menuBorrar(boolean visible){
        lblDatoAModificar.setVisible(visible);
        btnAceptar.setText("Aceptar");
        lblAñoABorrar.setText("Año a borrar");
        txtAñoABorrar.setText("");
        lblAñoABorrar.setVisible(visible);
        txtAñoABorrar.setVisible(visible);
        btnAceptar.setBorder(null);
        btnAceptar.setVisible(visible);
        txtAñoABorrar.requestFocusInWindow();
        txtCantidadNueva.setVisible(false);
        lblCantidadNueva.setVisible(false);
    }
    
    /**
     *@param visible Boolean
     * Hace visible el menú para seleccionar el año a Modificar.
     */
    public void menuModificar(boolean visible){
        lblDatoAModificar.setVisible(visible);
        btnAceptar.setText("Modificar");
        lblAñoABorrar.setText("Año a Modificar");
        txtAñoABorrar.setText("");
        txtCantidadNueva.setText("");
        lblAñoABorrar.setVisible(visible);
        lblCantidadNueva.setVisible(visible);
        txtAñoABorrar.setVisible(visible);
        txtCantidadNueva.setVisible(visible);
        btnAceptar.setVisible(visible);
        txtAñoABorrar.requestFocusInWindow();
    }
    
    /**
     * Elimina el texto de txtVentas y le da focus.
     */
    public void sellsModifier(){
        txtVentas.setText("");
        txtVentas.requestFocusInWindow();
    }
    
    /**
     * @param years ArrayList<Year>
     * Elimina las filas de la tabla y las vuelve a crear para mostrar los cambios
     * que tenga la tabla.
     */
    public void updateTable(ArrayList<Year> years){
        removeRowsTable1();
        for(Year year : years){
            Object[] fila = {year.getYearNumber(), year.getSales(), year.getYearSquared(),
            year.getSalesSquared(), year.getYearForSales()};
            modelo.addRow(fila);
        }
    }
    
    /**
     * Elimina las filas de la tabla.
     */
    public void removeRowsTable1(){
        int filas = jTableHistoricoVentas.getRowCount();
        for(int fila = 0; fila < filas; fila++){
            modelo.removeRow(0);
        }
    }
    
    /**
     * Elimina las filas de la tabla 2 y elimina el texto de txtCrecimientoPromedio.
     */
    public void removeRowsTable2(){
        int filas = jTable2.getRowCount();
        for(int fila = 0; fila < filas; fila++){
            modelo1.removeRow(0);
        }
        txtCrecimientoPromedio.setText("");
    }
    
    /**
     * @param txt String
     * Asigna el valor a txtCrecimientoPromedio.
     */
    public void setAverageGrowth(String txt) {
        txtCrecimientoPromedio.setText(txt);
    }
    
    /**
     * @param sumOfYears int
     * @param sumOfSales Double
     * @param yearSquared int
     * @param saleSquared Double
     * @param salesForYear Double
     * Asigna el valor a los txt de las sumatorias.
     */
    public void setTotales(int sumOfYears, Double sumOfSales, int yearSquared,
        Double saleSquared, Double salesForYear){
        txtSumOfYears.setText(""+sumOfYears);
        txtSumOfSales.setText(""+sumOfSales);
        txtSumOfyearSquared.setText(""+yearSquared);
        txtSumOfSaleSquared.setText(""+saleSquared);
        txtSumOfYearForSale.setText(""+salesForYear);
    }
    
    /**
     * limpia los txt de las sumatorias.
     */
    public void clearTotales(){
        txtSumOfYears.setText("");
        txtSumOfSales.setText("");
        txtSumOfyearSquared.setText("");
        txtSumOfSaleSquared.setText("");
        txtSumOfYearForSale.setText("");
    }
    
    
    /**
     * @param listenController ActionListener
     * Asigna el listener al btnAgregarAño.
     */
    public void addListenerBtnAgregarAño(ActionListener listenController){
        btnAgregarAño.addActionListener(listenController);
    }
    
    /**
     * @param listenController ActionListener
     * Asigna el listener al btnBorrarAño.
     */
    public void addListenerBtnBorrarAño(ActionListener listenController){
        btnBorrarAño.addActionListener(listenController);
    }
    
    /**
     * @param listenController ActionListener
     * Asigna el listener al btnModificarAño.
     */
    public void addListenerBtnModificarAño(ActionListener listenController){
        btnModificarAño.addActionListener(listenController);
    }
    
    /**
     * @param listenController ActionListener
     * Asigna el listener al btnNuevoPronostico.
     */
    public void addListenerBtnNuevoPronostico(ActionListener listenController){
        btnNuevoPronostico.addActionListener(listenController);
    }
    
    /**
     * @param listenController ActionListener
     * Asigna el listener al btnCalcularPronostico.
     */
    public void addListenerBtnCalcularPronostico(ActionListener listenController){
        btnCalcularPronostico.addActionListener(listenController);
    }
    
    /**
     * @param listenController ActionListener
     * Asigna el listener al btnAceptar.
     */
    public void addListenerBtnAceptar(ActionListener listenController){
        btnAceptar.addActionListener(listenController);
    }
    
    /**
     * Retorna el valor ingresado en el txtVentas.
     */
    public double getSales(){
        return Double.parseDouble(txtVentas.getText());
    }
    
    /**
     * Retorna el valor de los años a calcular.
     */
    public int getForecastYears(){
        return Integer.parseInt(txtCantidad.getText());
    }
    
    /**
     * Retorna el año a borrar.
     */
    public int getWhichYear(){
        return Integer.parseInt(txtAñoABorrar.getText());
    }
    
    /**
     * Retorna la venta del año a agregar.
     */
    public Double getNewSale(){
        return Double.parseDouble(txtCantidadNueva.getText());
    }
    
    /**
     * Muestra un mensaje de error.
     */
    public void displayErrorMessage(String erroMessage){
        JOptionPane.showMessageDialog(this, erroMessage);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel2 = new javax.swing.JPanel();
        lblQVentas = new javax.swing.JLabel();
        txtVentas = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lblQAñosAPronosticar = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        lblDatoAModificar = new javax.swing.JPanel();
        lblAñoABorrar = new javax.swing.JLabel();
        lblCantidadNueva = new javax.swing.JLabel();
        txtAñoABorrar = new javax.swing.JTextField();
        txtCantidadNueva = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        lblCrecimientoPromedio = new javax.swing.JLabel();
        txtCrecimientoPromedio = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        btnAgregarAño = new javax.swing.JButton();
        btnBorrarAño = new javax.swing.JButton();
        btnModificarAño = new javax.swing.JButton();
        btnNuevoPronostico = new javax.swing.JButton();
        btnCalcularPronostico = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableHistoricoVentas = new javax.swing.JTable();
        lblTotal = new javax.swing.JLabel();
        txtSumOfYears = new javax.swing.JTextField();
        txtSumOfSales = new javax.swing.JTextField();
        txtSumOfyearSquared = new javax.swing.JTextField();
        txtSumOfSaleSquared = new javax.swing.JTextField();
        txtSumOfYearForSale = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 102, 255));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.gray), "Datos de Venta", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri Light", 1, 14), new java.awt.Color(51, 51, 51))); // NOI18N

        lblQVentas.setFont(new java.awt.Font("Calibri Light", 1, 12)); // NOI18N
        lblQVentas.setText("Cantidad de Venta");

        txtVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtVentasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblQVentas)
                .addGap(32, 32, 32)
                .addComponent(txtVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQVentas)
                    .addComponent(txtVentas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.gray), "Años a Pronosticar", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Calibri Light", 1, 14), new java.awt.Color(51, 51, 51))); // NOI18N

        lblQAñosAPronosticar.setFont(new java.awt.Font("Calibri Light", 1, 12)); // NOI18N
        lblQAñosAPronosticar.setText("Cantidad de Años a Pronosticar");

        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblQAñosAPronosticar)
                .addGap(18, 18, 18)
                .addComponent(txtCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQAñosAPronosticar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        lblDatoAModificar.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, java.awt.Color.gray), "Dato a Modificar", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Candara Light", 1, 14), new java.awt.Color(51, 51, 51))); // NOI18N

        lblAñoABorrar.setFont(new java.awt.Font("Calibri Light", 1, 12)); // NOI18N
        lblAñoABorrar.setText("Año a Borrar");

        lblCantidadNueva.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        lblCantidadNueva.setText("Cantidad Nueva");

        txtAñoABorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAñoABorrarActionPerformed(evt);
            }
        });

        btnAceptar.setBackground(new java.awt.Color(255, 255, 255));
        btnAceptar.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(51, 51, 51));
        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/aceptarModificar.png"))); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.setBorderPainted(false);
        btnAceptar.setContentAreaFilled(false);
        btnAceptar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAceptar.setName(""); // NOI18N
        btnAceptar.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/aceptarModificar.png"))); // NOI18N
        btnAceptar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/aceptarModificarGrande.png"))); // NOI18N
        btnAceptar.setVerifyInputWhenFocusTarget(false);
        btnAceptar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout lblDatoAModificarLayout = new javax.swing.GroupLayout(lblDatoAModificar);
        lblDatoAModificar.setLayout(lblDatoAModificarLayout);
        lblDatoAModificarLayout.setHorizontalGroup(
            lblDatoAModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblDatoAModificarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(lblDatoAModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(lblDatoAModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(lblDatoAModificarLayout.createSequentialGroup()
                            .addComponent(lblAñoABorrar)
                            .addGap(27, 27, 27)
                            .addComponent(txtAñoABorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(lblDatoAModificarLayout.createSequentialGroup()
                            .addComponent(lblCantidadNueva)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtCantidadNueva)))
                    .addComponent(btnAceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        lblDatoAModificarLayout.setVerticalGroup(
            lblDatoAModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(lblDatoAModificarLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(lblDatoAModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtAñoABorrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(lblDatoAModificarLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lblAñoABorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(lblDatoAModificarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCantidadNueva)
                    .addComponent(txtCantidadNueva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(btnAceptar))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.white, null, java.awt.Color.gray), "Pronostico de Ventas", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri Light", 1, 14))); // NOI18N

        lblCrecimientoPromedio.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        lblCrecimientoPromedio.setText("Crecimiento promedio");

        txtCrecimientoPromedio.setEditable(false);

        modelo1.addColumn("Año");
        modelo1.addColumn("Forecast Sales");
        jTable2.setModel(modelo1);
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lblCrecimientoPromedio)
                        .addGap(18, 18, 18)
                        .addComponent(txtCrecimientoPromedio, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 48, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCrecimientoPromedio)
                    .addComponent(txtCrecimientoPromedio, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        btnAgregarAño.setBackground(new java.awt.Color(204, 204, 204));
        btnAgregarAño.setFont(new java.awt.Font("Calibri Light", 1, 12)); // NOI18N
        btnAgregarAño.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/agregar.png"))); // NOI18N
        btnAgregarAño.setText("Agregar Año");
        btnAgregarAño.setBorder(null);
        btnAgregarAño.setBorderPainted(false);
        btnAgregarAño.setContentAreaFilled(false);
        btnAgregarAño.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAgregarAño.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgregarAño.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/agregarGrande.png"))); // NOI18N
        btnAgregarAño.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/agregar.png"))); // NOI18N
        btnAgregarAño.setVerifyInputWhenFocusTarget(false);
        btnAgregarAño.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnAgregarAño.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAgregarAño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAñoActionPerformed(evt);
            }
        });

        btnBorrarAño.setFont(new java.awt.Font("Calibri Light", 1, 12)); // NOI18N
        btnBorrarAño.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/borrar.png"))); // NOI18N
        btnBorrarAño.setText("Borrar Año");
        btnBorrarAño.setBorderPainted(false);
        btnBorrarAño.setContentAreaFilled(false);
        btnBorrarAño.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBorrarAño.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/borrarGrande.png"))); // NOI18N
        btnBorrarAño.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/borrar.png"))); // NOI18N
        btnBorrarAño.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBorrarAño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarAñoActionPerformed(evt);
            }
        });

        btnModificarAño.setFont(new java.awt.Font("Calibri Light", 1, 12)); // NOI18N
        btnModificarAño.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/modificar.png"))); // NOI18N
        btnModificarAño.setText("Modifica Año");
        btnModificarAño.setBorderPainted(false);
        btnModificarAño.setContentAreaFilled(false);
        btnModificarAño.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnModificarAño.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/modificarGrande.png"))); // NOI18N
        btnModificarAño.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/modificar.png"))); // NOI18N
        btnModificarAño.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnNuevoPronostico.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        btnNuevoPronostico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/nuevoAnalisis.png"))); // NOI18N
        btnNuevoPronostico.setText("Nuevo Pronostico");
        btnNuevoPronostico.setBorderPainted(false);
        btnNuevoPronostico.setContentAreaFilled(false);
        btnNuevoPronostico.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNuevoPronostico.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/nuevoAnalisisGrande.png"))); // NOI18N
        btnNuevoPronostico.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/nuevoAnalisis.png"))); // NOI18N
        btnNuevoPronostico.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnCalcularPronostico.setFont(new java.awt.Font("Candara Light", 1, 12)); // NOI18N
        btnCalcularPronostico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/calcular.png"))); // NOI18N
        btnCalcularPronostico.setText("Calcular Pronostico");
        btnCalcularPronostico.setBorderPainted(false);
        btnCalcularPronostico.setContentAreaFilled(false);
        btnCalcularPronostico.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCalcularPronostico.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/calcularGrande.png"))); // NOI18N
        btnCalcularPronostico.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/calcular.png"))); // NOI18N
        btnCalcularPronostico.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCalcularPronostico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularPronosticoActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(204, 204, 204), null, java.awt.Color.gray), "Historico de Ventas ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Calibri Light", 1, 14))); // NOI18N

        jTableHistoricoVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTableHistoricoVentas.setToolTipText("");
        modelo.addColumn("Año X");
        modelo.addColumn("Cantidad de Ventas Y");
        modelo.addColumn("X^2");
        modelo.addColumn("Y^2");
        modelo.addColumn("X*Y");
        jTableHistoricoVentas.setModel(modelo);
        jScrollPane1.setViewportView(jTableHistoricoVentas);

        lblTotal.setFont(new java.awt.Font("Calibri Light", 1, 12)); // NOI18N
        lblTotal.setText("Total:");

        txtSumOfYears.setEditable(false);

        txtSumOfSales.setEditable(false);

        txtSumOfyearSquared.setEditable(false);
        txtSumOfyearSquared.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSumOfyearSquaredActionPerformed(evt);
            }
        });

        txtSumOfSaleSquared.setEditable(false);

        txtSumOfYearForSale.setEditable(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(lblTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtSumOfYears, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(txtSumOfSales, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(txtSumOfyearSquared, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtSumOfSaleSquared, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(txtSumOfYearForSale, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(101, 101, 101))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTotal)
                        .addComponent(txtSumOfSales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSumOfyearSquared, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSumOfSaleSquared, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSumOfYearForSale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtSumOfYears, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(70, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Candara Light", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/imagens/pronostico.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel1.setMaximumSize(new java.awt.Dimension(176, 64));
        jLabel1.setPreferredSize(new java.awt.Dimension(50, 20));

        jLabel2.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        jLabel2.setText("POR MÉTODO DE CUADRADOS");

        jLabel3.setFont(new java.awt.Font("Candara Light", 1, 24)); // NOI18N
        jLabel3.setText("PRONOSTICO DE VENTAS");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(68, 68, 68)))
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnAgregarAño, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBorrarAño, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnModificarAño, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblDatoAModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(382, 382, 382)
                                .addComponent(btnNuevoPronostico, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCalcularPronostico, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblDatoAModificar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAgregarAño, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBorrarAño, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                    .addComponent(btnModificarAño, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCalcularPronostico, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
                    .addComponent(btnNuevoPronostico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Asigna los valores a las filas de la tabla 1.
     */
    public void pintarLista(Year year){
        Object[] fila = {year.getYearNumber(), year.getSales(), year.getYearSquared(),
        year.getSalesSquared(), year.getYearForSales()};
        modelo.addRow(fila);
    }
    
    /**
     * Asigna el valor a las filas de la tabla 2.
     */
    public void printRowsTable2(Year year, Double forecast){
        Object[] fila = {year.getYearNumber(), forecast};
        modelo1.addRow(fila);
    }
    
    private void txtVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtVentasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtVentasActionPerformed

    private void btnAgregarAñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAñoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarAñoActionPerformed

    private void btnBorrarAñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarAñoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBorrarAñoActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void txtAñoABorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAñoABorrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAñoABorrarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void txtSumOfyearSquaredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSumOfyearSquaredActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSumOfyearSquaredActionPerformed

    private void btnCalcularPronosticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularPronosticoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCalcularPronosticoActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ForecastView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForecastView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForecastView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForecastView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForecastView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnAgregarAño;
    private javax.swing.JButton btnBorrarAño;
    private javax.swing.JButton btnCalcularPronostico;
    private javax.swing.JButton btnModificarAño;
    private javax.swing.JButton btnNuevoPronostico;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTableHistoricoVentas;
    private javax.swing.JLabel lblAñoABorrar;
    private javax.swing.JLabel lblCantidadNueva;
    private javax.swing.JLabel lblCrecimientoPromedio;
    private javax.swing.JPanel lblDatoAModificar;
    private javax.swing.JLabel lblQAñosAPronosticar;
    private javax.swing.JLabel lblQVentas;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTextField txtAñoABorrar;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCantidadNueva;
    private javax.swing.JTextField txtCrecimientoPromedio;
    private javax.swing.JTextField txtSumOfSaleSquared;
    private javax.swing.JTextField txtSumOfSales;
    private javax.swing.JTextField txtSumOfYearForSale;
    private javax.swing.JTextField txtSumOfYears;
    private javax.swing.JTextField txtSumOfyearSquared;
    private javax.swing.JTextField txtVentas;
    // End of variables declaration//GEN-END:variables
}
