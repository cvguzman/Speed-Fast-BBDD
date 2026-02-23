package org.cvguzman.vista;

import org.cvguzman.modelo.Pedido;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class VentanaListaPedidos extends JFrame {

    private JTable tablaPedidos;
    private DefaultTableModel gestionDatos;

    public VentanaListaPedidos() {
        setTitle("Lista de Pedidos");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        gestionDatos = new DefaultTableModel();
        gestionDatos.addColumn("ID");
        gestionDatos.addColumn("Dirección");
        gestionDatos.addColumn("Estado");

        tablaPedidos = new JTable(gestionDatos);
        add(new JScrollPane(tablaPedidos));
    }

    public void actualizarTabla(List<Pedido> lista) {
        gestionDatos.setRowCount(0);

        for (Pedido p : lista) {
            gestionDatos.addRow(new Object[]{
                    p.getId(),
                    p.getDireccion(),
                    p.getTipo(),
                    p.getEstado()
            });
        }
    }
}

