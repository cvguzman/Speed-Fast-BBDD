package org.cvguzman.controlador;

import org.cvguzman.dao.PedidosDAO;
import org.cvguzman.dao.RepartidoresDAO;
import org.cvguzman.modelo.Estado;
import org.cvguzman.modelo.Pedidos;
import org.cvguzman.modelo.Tipo;
import org.cvguzman.vista.VentanaListaPedidos;
import org.cvguzman.vista.VentanaPrincipal;
import org.cvguzman.vista.VentanaRegistroPedidos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.util.List;

public class ControladoresDePedidos {

    private VentanaPrincipal vistaPrincipal;
    private VentanaRegistroPedidos vistaRegistro;
    private VentanaListaPedidos vistaLista;
    private PedidosDAO pedidoDAO;
    private RepartidoresDAO repartidorDAO;

    public ControladoresDePedidos(Connection connection) {

        vistaPrincipal = new VentanaPrincipal();
        vistaRegistro = new VentanaRegistroPedidos();
        vistaLista = new VentanaListaPedidos();
        pedidoDAO = new PedidosDAO(connection);
        repartidorDAO = new RepartidoresDAO(connection);

        configurarEventos();
    }

    public void iniciar() {
        vistaPrincipal.setVisible(true);
    }

    private void configurarEventos() {

        vistaPrincipal.getBtnRegistrar().addActionListener(e ->
                vistaRegistro.setVisible(true));

        vistaPrincipal.getBtnListar().addActionListener(e -> {
            List<Pedidos> lista = pedidoDAO.readAll();
            vistaLista.actualizarTabla(lista);
            vistaLista.setVisible(true);
        });

        vistaLista.getBtnAsignar().addActionListener(e -> {

            int fila = vistaLista.getTablaPedidos().getSelectedRow();

            if (fila == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione un pedido");
                return;
            }

            int idPedido = (int) vistaLista.getTablaPedidos().getValueAt(fila, 0);

            var listaRepartidores = repartidorDAO.readAll();

            if(listaRepartidores.isEmpty()) {
                JOptionPane.showMessageDialog(null,"No hay repartidores disponibles");
                return;
            }

            JComboBox combo = new JComboBox(
                    listaRepartidores.stream()
                            .map(r -> r.getNombre())
                            .toArray()
            );

            int opcion = JOptionPane.showConfirmDialog(
                    null,
                    combo,
                    "Seleccione Repartidor",
                    JOptionPane.OK_CANCEL_OPTION
            );

            if (opcion == JOptionPane.OK_OPTION) {

                int index = combo.getSelectedIndex();
                int idRepartidor = listaRepartidores.get(index).getId();

                pedidoDAO.asignarRepartidor(idPedido, idRepartidor);


                JOptionPane.showMessageDialog(null, "Repartidor asignado correctamente");
            }
        });

        vistaRegistro.getBtnGuardar().addActionListener(this::actionPerformed);
    }


    private void actionPerformed(ActionEvent e) {

        String direccion = vistaRegistro.getDireccion();
        String tipoStr = vistaRegistro.getTipo();
        String estadoStr = vistaRegistro.getEstado();

        Tipo tipo = Tipo.valueOf(tipoStr.toUpperCase());
        Estado estado = Estado.valueOf(estadoStr.toUpperCase());


        Pedidos nuevoPedido = new Pedidos(
                0,
                direccion,
                tipo,
                estado
        );

        pedidoDAO.create(nuevoPedido);

        vistaRegistro.mostrarMensaje("Pedido registrado correctamente");

        vistaRegistro.dispose();
    }
}