/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import Modelo.Prestador;
import Modelo.Productor;
import Modelo.Servicio;
import Modelo.ServicioPrestador;
import Modelo.TipoServicio;
import controlador.Controlador;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author nico2
 */
public class ventanaTerminarServicio extends javax.swing.JFrame {
    private final Controlador c;
    private final JFrame vAnterior;

    /**
     * Creates new form ventanaTerminarServicio
     */
    public ventanaTerminarServicio(Controlador c, JFrame vAnterior) {
        initComponents();
        this.c=c;
        this.vAnterior=vAnterior;
        limpiar();
    }
    
    public void limpiar(){
        //limpiamos lo campos de texto
        this.txtCantidadUnidades.setText("");
        //creamos el combo y lo desseleccionamos
        DefaultComboBoxModel comboProd = new DefaultComboBoxModel(this.c.listarProductores().toArray());
        this.comboProductor.setModel(comboProd);
        this.comboProductor.setSelectedIndex(-1);
        
        //creamos la lista vacía
        DefaultListModel modelolista = new DefaultListModel();
        this.listaServicios.setModel(modelolista);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        label5 = new java.awt.Label();
        comboProductor = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaServicios = new javax.swing.JList();
        txtCantidadUnidades = new javax.swing.JTextField();
        label6 = new java.awt.Label();
        comboPuntaje = new javax.swing.JComboBox<>();
        botonTerminarServicio = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        label1.setText("Servicios contratados");

        label2.setText("Puntaje");

        label5.setText("Productor");

        comboProductor.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboProductorItemStateChanged(evt);
            }
        });
        comboProductor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboProductorActionPerformed(evt);
            }
        });

        listaServicios.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaServiciosValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(listaServicios);

        txtCantidadUnidades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadUnidadesActionPerformed(evt);
            }
        });

        label6.setText("Cantidad de unidades");

        comboPuntaje.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Positivo", "Negativo", "Neutro" }));
        comboPuntaje.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboPuntajeItemStateChanged(evt);
            }
        });
        comboPuntaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPuntajeActionPerformed(evt);
            }
        });

        botonTerminarServicio.setLabel("Terminar servicio");
        botonTerminarServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonTerminarServicioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(comboProductor, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCantidadUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(botonTerminarServicio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboPuntaje, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboProductor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCantidadUnidades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(comboPuntaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonTerminarServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(142, 142, 142))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        this.vAnterior.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_formWindowClosing

    private void comboProductorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboProductorActionPerformed
        if(this.comboProductor.getSelectedItem() != null){
            Productor p = (Productor) this.comboProductor.getSelectedItem();
            this.listaServicios.setListData(this.c.listarServiciosEnProceso(p).toArray());
        }
        else{
            this.comboPuntaje.setEnabled(false);
        }
    }//GEN-LAST:event_comboProductorActionPerformed

    private void txtCantidadUnidadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadUnidadesActionPerformed
        
    }//GEN-LAST:event_txtCantidadUnidadesActionPerformed

    private void comboProductorItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboProductorItemStateChanged
        
    }//GEN-LAST:event_comboProductorItemStateChanged

    private void comboPuntajeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboPuntajeItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_comboPuntajeItemStateChanged

    private void comboPuntajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPuntajeActionPerformed
 
    }//GEN-LAST:event_comboPuntajeActionPerformed

    private void listaServiciosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listaServiciosValueChanged
        this.comboPuntaje.setEnabled(true);
    }//GEN-LAST:event_listaServiciosValueChanged

    private void botonTerminarServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonTerminarServicioActionPerformed
        if(this.txtCantidadUnidades.getText().isEmpty()!=true){
            if (this.comboProductor.getSelectedItem() != null && this.listaServicios.getSelectedValue() != null){
                Productor p = (Productor) this.comboProductor.getSelectedItem();
                Servicio s = (Servicio) this.listaServicios.getSelectedValue();
                String unidad2 = txtCantidadUnidades.getText();
                int unidades = Integer.parseInt(unidad2);
                String puntaje = (String) this.comboPuntaje.getSelectedItem();

                this.c.termiarServicio(s, puntaje, unidades);
                JOptionPane.showMessageDialog(null, "Servicio terminado, su costo es: "+s.getCostoTotal());
         }
        limpiar();
        }
        else {
            JOptionPane.showMessageDialog(null, "Por favor complete todos los campos");
        }
    }//GEN-LAST:event_botonTerminarServicioActionPerformed

    
    
    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button botonTerminarServicio;
    private javax.swing.JComboBox<String> comboProductor;
    private javax.swing.JComboBox<String> comboPuntaje;
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label5;
    private java.awt.Label label6;
    private javax.swing.JList listaServicios;
    private javax.swing.JTextField txtCantidadUnidades;
    // End of variables declaration//GEN-END:variables
}
