package org.cvguzman.vista;

import javax.swing.*;
import java.awt.*;

public class VentanaRegistroPedidos extends  JFrame {

    private JTextField txtID;
    private JTextField txtDireccion;
    private JTextField txtEstado;
    private JComboBox<String> comboTipo;
    private JButton btnGuardar;

    public VentanaRegistroPedidos() {
        setTitle("Registro de Pedidos");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5,2, 10, 10));

        add(new JLabel("ID"));
        txtID = new JTextField();
        add(txtID);

        add(new JLabel("Dirección"));
        txtDireccion = new JTextField();
        add(txtDireccion);

        add(new JLabel("Tipo"));
        comboTipo = new JComboBox<>(new String[] {
                "COMIDA",
                "ENCOMIENDA",
                "EXPRESS"
        });
        add(comboTipo);

        add(new JLabel("Estado"));
        txtEstado = new JTextField();
        add(txtEstado);

        add(new JLabel(""));
        btnGuardar = new JButton("Guardar");
        add(btnGuardar);
    }

    public String getId() {
        return txtID.getText();
    }

    public String getDireccion() {
        return txtDireccion.getText();
    }

    public String getTipo() {
        return comboTipo.getSelectedItem().toString();
    }

    public String getEstado() {
        return txtEstado.getText();
    }

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
}

