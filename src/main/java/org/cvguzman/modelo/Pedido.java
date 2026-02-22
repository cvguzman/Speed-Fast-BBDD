package org.cvguzman.modelo;

public class Pedido {

    private int id;
    private String direccion;
    private String tipo;
    private EstadoPedido estado;

    public Pedido() {

    }

    public Pedido(String direccion, String tipo) {
        this.direccion = direccion;
        this.tipo = tipo;
        this.estado = EstadoPedido.PENDIENTE;
    }

    public Pedido(int id, String direccion, String tipo, EstadoPedido estado) {
        this.id = id;
        this.direccion = direccion;
        this.tipo = tipo;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTipo() {
        return tipo;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    @Override
    public String toString(){
        return  "Pedido{" +
                "id=" + getId() +
                ", direccion' " + getDireccion() + " \'" +
                ", tipo' " + getTipo() + " \'" +
                ", estadoPedido=" + estado +
                '}';
    }

    public void addRow(Object[] objects) {
    }
}



