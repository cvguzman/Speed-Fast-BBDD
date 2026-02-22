package org.cvguzman.controlador;

import org.cvguzman.dao.PedidoDAO;
import org.cvguzman.modelo.Pedido;
import org.cvguzman.vista.VentanaListaPedidos;
import org.cvguzman.vista.VentanaPrincipal;
import org.cvguzman.vista.VentanaRegistroPedidos;

public class ControladoresDePedidos {

    private VentanaPrincipal vistaPrincipal;
    private VentanaRegistroPedidos vistaRegistro;
    private VentanaListaPedidos vistaLista;

    private PedidoDAO pedidoDAO;

    public ControladoresDePedidos() {

        vistaPrincipal = new VentanaPrincipal();
        vistaRegistro = new VentanaRegistroPedidos();
        vistaLista = new VentanaListaPedidos();
        pedidoDAO = new PedidoDAO();

        configurarEventos();
    }

    public void iniciar() {
        vistaPrincipal.setVisible(true);
    }

    private void configurarEventos() {

        // Abrir ventana registro
        vistaPrincipal.getBtnRegistrar().addActionListener(e ->
                vistaRegistro.setVisible(true));

        // Listar pedidos desde BD
        vistaPrincipal.getBtnListar().addActionListener(e -> {
            vistaLista.setVisible(true);
        });

        // Guardar en BD
        vistaRegistro.getBtnGuardar().addActionListener(e -> {
            String direccion = vistaRegistro.getDireccion();
            String tipo = vistaRegistro.getTipo();

            Pedido nuevoPedido = new Pedido(direccion, tipo);
            pedidoDAO.guardar(nuevoPedido);

            vistaRegistro.mostrarMensaje("Pedido registrado correctamente");

            vistaRegistro.dispose(); // opcional: cerrar ventana
        });
    }
}