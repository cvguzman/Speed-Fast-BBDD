package org.cvguzman.vista;

import org.cvguzman.modelo.Pedidos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class VentanaListaPedidos extends JFrame {

    private JTable tablaPedidos;
    private DefaultTableModel gestionDatos;
    private JButton btnAsignar;

    public VentanaListaPedidos() {
        setTitle("Lista de Pedidos");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        gestionDatos = new DefaultTableModel();
        gestionDatos.addColumn("ID");
        gestionDatos.addColumn("Dirección");
        gestionDatos.addColumn("Tipo");
        gestionDatos.addColumn("Estado");

        tablaPedidos = new JTable(gestionDatos);
        add(new JScrollPane(tablaPedidos), BorderLayout.CENTER);

        JPanel panelInferior = new JPanel();
        btnAsignar = new JButton("Asignar Repartidor");
        panelInferior.add(btnAsignar);

        add(panelInferior, BorderLayout.SOUTH);
    }

    public void actualizarTabla(List<Pedidos> lista) {
        gestionDatos.setRowCount(0);

        for (Pedidos p : lista) {
            gestionDatos.addRow(new Object[]{
                    p.getId(),
                    p.getDireccion(),
                    p.getTipo(),
                    p.getEstado()
            });
        }
    }

    public JButton getBtnAsignar() {
        return btnAsignar;
    }

    public JTable getTablaPedidos() {
        return tablaPedidos;
    }
}

