package org.cvguzman.vista;

import javax.swing.*;
import java.awt.*;

public class VentanaRegistroPedidos extends  JFrame {

    private JTextField txtDireccion;
    private JComboBox<String> comboTipo;
    private JButton btnGuardar;

    public VentanaRegistroPedidos() {
        setTitle("Registro de Pedidos");
        setSize(350, 250);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5,2));

        add(new JLabel("Tipo Pedido"));
        comboTipo = new JComboBox<>(new String[] {
                "Comida",
                "Encomienda",
                "Pedido Express"
        });
        add(comboTipo);

        add(new JLabel("Dirección"));
        txtDireccion = new JTextField();
        add(txtDireccion);

        add(new JLabel(""));
        btnGuardar = new JButton("Guardar");
        add(btnGuardar);
    }

    public String getDireccion() {
        return txtDireccion.getText();
    }

    public String getTipo() {
        return comboTipo.getSelectedItem().toString();
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
}

