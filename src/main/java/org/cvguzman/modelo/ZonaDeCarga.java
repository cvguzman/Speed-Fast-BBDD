package org.cvguzman.modelo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ZonaDeCarga {

    private BlockingQueue<Pedido> pedidosPendientes;

    public ZonaDeCarga() {
        this.pedidosPendientes = new LinkedBlockingQueue<>();
        System.out.println("[ZONA DE CARGA INICIALIZADA]");
    }

    public synchronized void agregarPedido(Pedido p) {
        pedidosPendientes.add(p);
        System.out.println("Pedido N° " + p.getId() + " agregado. Destino: " + p.getDireccion());
    }

    public synchronized Pedido retirarPedido() {
        Pedido p = pedidosPendientes.poll();

        if(p == null) {
            System.out.println("[ZONA DE CARGA VACIA]");
        }
        return p;
    }
}
