package org.cvguzman.modelo;

public enum EstadoPedido {

    PENDIENTE("PENDIENTE"),
    EN_REPARTO("EN REPARTO"),
    ENTREGADO("ENTREGADO");

    private final String nombreEstado;

    EstadoPedido(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    @Override
    public String toString() {
        return nombreEstado;
    }
}
