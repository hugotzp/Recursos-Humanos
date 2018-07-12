/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estructura;

import Personas.Personal;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

/**
 *
 * @author Edwin Chocoy
 */
public class Modulo_Estructura extends javax.swing.JFrame {

    /**
     * Creates new form Modulo_Estructura
     */
    
    Organizacion organizacion;
    
    ModeloTablaDepartamentos modeloTablaDepartamentos;    
    ModeloTablaTrabajadores modeloTablaTrabajadores = new ModeloTablaTrabajadores();   
    ModeloTablaInfoPersonal modeloTablaInfoPersonal;
    
    public int departamentoSeleccionado;
    public int trabajadorSeleccionado;
    
    public Modulo_Estructura() {
        initComponents();

        organizacion = new Organizacion();
        organizacion.crearEstructura();
        
        modeloTablaInfoPersonal= new ModeloTablaInfoPersonal(organizacion.getEstructura());
        jComboBoxDepartamentos.setModel(new ModeloComboBoxDepartamentos(organizacion.getEstructura(),modeloTablaTrabajadores) );
        
        
        setLblColor(label_Departamentos); 
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItemD1 = new javax.swing.JMenuItem();
        jPopupMenuDepartamentos = new javax.swing.JPopupMenu();
        jMenuItemT1 = new javax.swing.JMenuItem();
        jPopupMenuTrabajadores = new javax.swing.JPopupMenu();
        jPanelOpciones = new javax.swing.JPanel();
        label_Departamentos = new javax.swing.JLabel();
        label_Trabajadores = new javax.swing.JLabel();
        label_Infopersonal = new javax.swing.JLabel();
        jPanelPrincipal = new javax.swing.JPanel();
        jPanelDepatementos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableDepartamentos = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldNombreDepartamento = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabelActuzalizarTablaDepartamentos = new javax.swing.JLabel();
        jPanelTrabajadores = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableTrabajadores = new javax.swing.JTable();
        jComboBoxDepartamentos = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jPanelPersonal = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableInfoPersonal = new javax.swing.JTable();
        jLabelActuzalizarTablaInforPersonal = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jMenuItemD1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_People_18px.png"))); // NOI18N
        jMenuItemD1.setText("Ver Trabajadores");
        jMenuItemD1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemD1ActionPerformed(evt);
            }
        });

        jPopupMenuDepartamentos.add(jMenuItemD1);

        jMenuItemT1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Name_Tag_18px.png"))); // NOI18N
        jMenuItemT1.setText("Ver Informacion Personal");
        jMenuItemT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemT1ActionPerformed(evt);
            }
        });

        jPopupMenuTrabajadores.add(jMenuItemT1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanelOpciones.setBackground(new java.awt.Color(34, 41, 50));

        label_Departamentos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        label_Departamentos.setForeground(new java.awt.Color(166, 166, 166));
        label_Departamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Department_18px.png"))); // NOI18N
        label_Departamentos.setText("Departamentos");
        label_Departamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                label_DepartamentosMousePressed(evt);
            }
        });

        label_Trabajadores.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        label_Trabajadores.setForeground(new java.awt.Color(166, 166, 166));
        label_Trabajadores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Conference_18px.png"))); // NOI18N
        label_Trabajadores.setText("Trabajadores");
        label_Trabajadores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                label_TrabajadoresMousePressed(evt);
            }
        });

        label_Infopersonal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        label_Infopersonal.setForeground(new java.awt.Color(166, 166, 166));
        label_Infopersonal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Contact_Details_18px.png"))); // NOI18N
        label_Infopersonal.setText("Información Personal");
        label_Infopersonal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                label_InfopersonalMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanelOpcionesLayout = new javax.swing.GroupLayout(jPanelOpciones);
        jPanelOpciones.setLayout(jPanelOpcionesLayout);
        jPanelOpcionesLayout.setHorizontalGroup(
            jPanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOpcionesLayout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addGroup(jPanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(label_Departamentos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_Trabajadores, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label_Infopersonal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanelOpcionesLayout.setVerticalGroup(
            jPanelOpcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelOpcionesLayout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(label_Departamentos)
                .addGap(18, 18, 18)
                .addComponent(label_Trabajadores)
                .addGap(18, 18, 18)
                .addComponent(label_Infopersonal)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        jPanelPrincipal.setLayout(new java.awt.CardLayout());

        jPanelDepatementos.setBackground(new java.awt.Color(255, 255, 255));

        jTableDepartamentos.setBackground(new java.awt.Color(255, 255, 255));
        jTableDepartamentos.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(jTableDepartamentos);
        jTableDepartamentos.setComponentPopupMenu(jPopupMenuDepartamentos);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setForeground(new java.awt.Color(48, 201, 235));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Nuevo Departamento");

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Nombre");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel5)
                        .addGap(35, 35, 35)
                        .addComponent(jTextFieldNombreDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldNombreDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Visualizar Departamentos");

        jLabelActuzalizarTablaDepartamentos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Refresh_25px_1.png"))); // NOI18N
        jLabelActuzalizarTablaDepartamentos.setText("Actualizar");
        jLabelActuzalizarTablaDepartamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelActuzalizarTablaDepartamentosMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDepatementosLayout = new javax.swing.GroupLayout(jPanelDepatementos);
        jPanelDepatementos.setLayout(jPanelDepatementosLayout);
        jPanelDepatementosLayout.setHorizontalGroup(
            jPanelDepatementosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDepatementosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDepatementosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDepatementosLayout.createSequentialGroup()
                        .addGroup(jPanelDepatementosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDepatementosLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelActuzalizarTablaDepartamentos)
                        .addGap(25, 25, 25))))
        );
        jPanelDepatementosLayout.setVerticalGroup(
            jPanelDepatementosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDepatementosLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelDepatementosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabelActuzalizarTablaDepartamentos))
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelPrincipal.add(jPanelDepatementos, "card2");

        jPanelTrabajadores.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Trabajadores");

        jTableTrabajadores.setModel(modeloTablaTrabajadores);
        jScrollPane2.setViewportView(jTableTrabajadores);
        jTableTrabajadores.setComponentPopupMenu(jPopupMenuTrabajadores);

        jComboBoxDepartamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxDepartamentosActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Seleccione Departamento");

        javax.swing.GroupLayout jPanelTrabajadoresLayout = new javax.swing.GroupLayout(jPanelTrabajadores);
        jPanelTrabajadores.setLayout(jPanelTrabajadoresLayout);
        jPanelTrabajadoresLayout.setHorizontalGroup(
            jPanelTrabajadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTrabajadoresLayout.createSequentialGroup()
                .addGroup(jPanelTrabajadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelTrabajadoresLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE))
                    .addGroup(jPanelTrabajadoresLayout.createSequentialGroup()
                        .addGroup(jPanelTrabajadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelTrabajadoresLayout.createSequentialGroup()
                                .addGap(308, 308, 308)
                                .addComponent(jLabel2))
                            .addGroup(jPanelTrabajadoresLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBoxDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelTrabajadoresLayout.setVerticalGroup(
            jPanelTrabajadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTrabajadoresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanelTrabajadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jComboBoxDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanelPrincipal.add(jPanelTrabajadores, "card2");

        jPanelPersonal.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane3.setViewportView(jTableInfoPersonal);

        jLabelActuzalizarTablaInforPersonal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/icons8_Refresh_25px_1.png"))); // NOI18N
        jLabelActuzalizarTablaInforPersonal.setText("Actualizar");
        jLabelActuzalizarTablaInforPersonal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabelActuzalizarTablaInforPersonalMousePressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Información Personal");

        javax.swing.GroupLayout jPanelPersonalLayout = new javax.swing.GroupLayout(jPanelPersonal);
        jPanelPersonal.setLayout(jPanelPersonalLayout);
        jPanelPersonalLayout.setHorizontalGroup(
            jPanelPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPersonalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPersonalLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPersonalLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanelPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPersonalLayout.createSequentialGroup()
                                .addComponent(jLabelActuzalizarTablaInforPersonal)
                                .addGap(314, 314, 314))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPersonalLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(287, 287, 287))))))
        );
        jPanelPersonalLayout.setVerticalGroup(
            jPanelPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPersonalLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jLabelActuzalizarTablaInforPersonal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanelPrincipal.add(jPanelPersonal, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelOpciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    

    private void label_DepartamentosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_DepartamentosMousePressed
        // TODO add your handling code here:
        
        
        setLblColor(label_Departamentos); 
        jPanelDepatementos.setVisible(true);
        
        jPanelTrabajadores.setVisible(false);
        jPanelPersonal.setVisible(false);
        resetLblColor(label_Infopersonal);
        resetLblColor(label_Trabajadores);
    }//GEN-LAST:event_label_DepartamentosMousePressed

    private void label_InfopersonalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_InfopersonalMousePressed
        // TODO add your handling code here:
        setLblColor(label_Infopersonal);
        jPanelPersonal.setVisible(true);
        
        jPanelTrabajadores.setVisible(false);
        jPanelDepatementos.setVisible(false);
        resetLblColor(label_Departamentos);
        resetLblColor(label_Trabajadores);
    }//GEN-LAST:event_label_InfopersonalMousePressed

    private void label_TrabajadoresMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_TrabajadoresMousePressed
        // TODO add your handling code here:
        setLblColor(label_Trabajadores);
        jPanelTrabajadores.setVisible(true);
        
        jPanelDepatementos.setVisible(false);
        jPanelPersonal.setVisible(false);
        resetLblColor(label_Departamentos);
        resetLblColor(label_Infopersonal);
        
        
    }//GEN-LAST:event_label_TrabajadoresMousePressed

    private void jLabelActuzalizarTablaDepartamentosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelActuzalizarTablaDepartamentosMousePressed
        // TODO add your handling code here:
        modeloTablaDepartamentos = new ModeloTablaDepartamentos(organizacion.getEstructura());
        jTableDepartamentos.setModel(modeloTablaDepartamentos);     
    }//GEN-LAST:event_jLabelActuzalizarTablaDepartamentosMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(!"".equals(jTextFieldNombreDepartamento.getText())){
            Departamentos departamento = new Departamentos();
            departamento.setNombre(jTextFieldNombreDepartamento.getText());
            organizacion.setDepartamento(departamento);
            jTextFieldNombreDepartamento.setText("");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItemD1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemD1ActionPerformed
        // TODO add your handling code here:       
        
        departamentoSeleccionado = jTableDepartamentos.getSelectedRow();
        if(departamentoSeleccionado>=0){
            setLblColor(label_Trabajadores);
            jPanelTrabajadores.setVisible(true);

            jPanelDepatementos.setVisible(false);
            jPanelPersonal.setVisible(false);
            resetLblColor(label_Departamentos);

            modeloTablaTrabajadores.LlenarTabla((Departamentos) organizacion.getEstructura().get(departamentoSeleccionado));
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Seleccione un departamento","",JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_jMenuItemD1ActionPerformed

    private void jComboBoxDepartamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxDepartamentosActionPerformed
        // TODO add your handling code here:       
        departamentoSeleccionado=jComboBoxDepartamentos.getSelectedIndex();
    }//GEN-LAST:event_jComboBoxDepartamentosActionPerformed

    private void jLabelActuzalizarTablaInforPersonalMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelActuzalizarTablaInforPersonalMousePressed
        // TODO add your handling code here:
        
        modeloTablaInfoPersonal = new ModeloTablaInfoPersonal(organizacion.getEstructura());
        jTableInfoPersonal.setModel(modeloTablaInfoPersonal); 
        
    }//GEN-LAST:event_jLabelActuzalizarTablaInforPersonalMousePressed

    private void jMenuItemT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemT1ActionPerformed
        // TODO add your handling code here:
        trabajadorSeleccionado = jTableTrabajadores.getSelectedRow();
        if((departamentoSeleccionado>=0)&&(trabajadorSeleccionado>=0)){
            setLblColor(label_Infopersonal);
            jPanelPersonal.setVisible(true);
            
            jPanelTrabajadores.setVisible(false);
            jPanelDepatementos.setVisible(false);
            
            resetLblColor(label_Trabajadores); 
            
            modeloTablaInfoPersonal = new ModeloTablaInfoPersonal(organizacion.getEstructura());
            jTableInfoPersonal.setModel(modeloTablaInfoPersonal); 
            modeloTablaInfoPersonal.informacionUnica(departamentoSeleccionado,trabajadorSeleccionado);
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Seleccione un trabajador","",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItemT1ActionPerformed

    public void setLblColor(JLabel lb){
        lb.setForeground(new Color(48,201,235));
    }
    
    public void resetLblColor(JLabel lb){
        lb.setForeground(new Color(166,166,166));
    }
    
    
    
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
            java.util.logging.Logger.getLogger(Modulo_Estructura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Modulo_Estructura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Modulo_Estructura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Modulo_Estructura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Modulo_Estructura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBoxDepartamentos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelActuzalizarTablaDepartamentos;
    private javax.swing.JLabel jLabelActuzalizarTablaInforPersonal;
    private javax.swing.JMenuItem jMenuItemD1;
    private javax.swing.JMenuItem jMenuItemT1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelDepatementos;
    private javax.swing.JPanel jPanelOpciones;
    private javax.swing.JPanel jPanelPersonal;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JPanel jPanelTrabajadores;
    private javax.swing.JPopupMenu jPopupMenuDepartamentos;
    private javax.swing.JPopupMenu jPopupMenuTrabajadores;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTableDepartamentos;
    private javax.swing.JTable jTableInfoPersonal;
    private javax.swing.JTable jTableTrabajadores;
    private javax.swing.JTextField jTextFieldNombreDepartamento;
    private javax.swing.JLabel label_Departamentos;
    private javax.swing.JLabel label_Infopersonal;
    private javax.swing.JLabel label_Trabajadores;
    // End of variables declaration//GEN-END:variables
}
