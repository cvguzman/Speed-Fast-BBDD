package org.cvguzman.vista;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends  JFrame {
    private JButton btnRegistrar;
    private JButton btnListar;
    private JButton btnAsignar;

    public VentanaPrincipal() {
        setTitle("Speed Fast");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4,1,10,10));
        ((JComponent) getContentPane()).setBorder(
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        );

        add(new JLabel("Bienvenido a SpeedFast", SwingConstants.CENTER));
        btnRegistrar = new JButton("Registrar Pedidos");
        btnListar = new JButton("Listar Pedidos");
        btnAsignar = new JButton("Asignar Repartidores");

        add(btnRegistrar);
        add(btnListar);
        add(btnAsignar);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public JButton getBtnRegistrar() {
        return btnRegistrar;
    }

    public  JButton getBtnListar() {
        return  btnListar;
    }

    public  JButton getBtnAsignar() {
        return btnAsignar;
    }
}
