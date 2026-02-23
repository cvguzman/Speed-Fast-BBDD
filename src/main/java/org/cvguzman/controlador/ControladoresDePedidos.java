package org.cvguzman.controlador;

import org.cvguzman.dao.PedidoDAO;
import org.cvguzman.dao.RepartidorDAO;
import org.cvguzman.modelo.Pedido;
import org.cvguzman.vista.VentanaListaPedidos;
import org.cvguzman.vista.VentanaPrincipal;
import org.cvguzman.vista.VentanaRegistroPedidos;

import java.util.List;

public class ControladoresDePedidos {

    private VentanaPrincipal vistaPrincipal;
    private VentanaRegistroPedidos vistaRegistro;
    private VentanaListaPedidos vistaLista;
    private PedidoDAO pedidoDAO;
    private RepartidorDAO repartidorDAO;

    public ControladoresDePedidos() {

        vistaPrincipal = new VentanaPrincipal();
        vistaRegistro = new VentanaRegistroPedidos();
        vistaLista = new VentanaListaPedidos();
        pedidoDAO = new PedidoDAO();
        repartidorDAO = new RepartidorDAO();


        configurarEventos();
    }

    public void iniciar() {
        vistaPrincipal.setVisible(true);
    }

    private void configurarEventos() {

        vistaPrincipal.getBtnRegistrar().addActionListener(e ->
                vistaRegistro.setVisible(true));

        vistaPrincipal.getBtnListar().addActionListener(e -> {
            List<Pedido> lista = pedidoDAO.obtenerPedidos();
            vistaLista.actualizarTabla(lista);
            vistaLista.setVisible(true);
        });

        vistaRegistro.getBtnGuardar().addActionListener(e -> {
            String direccion = vistaRegistro.getDireccion();
            String tipo = vistaRegistro.getTipo();

            Pedido nuevoPedido = new Pedido(direccion, tipo);
            pedidoDAO.guardar(nuevoPedido);

            vistaRegistro.mostrarMensaje("Pedido registrado correctamente");

            vistaRegistro.dispose();
        });
    }
}