package org.cvguzman.modelo;

import java.sql.Date;
import java.sql.Time;

public class Entregas {

    private int id;
    private int idPedido;
    private int idRepartidor;
    private Date fecha;
    private Time hora;

    public Entregas(int id, int idPedido, int idRepartidor, Date fecha, Time hora) {
        this.id = id;
        this.idPedido = idPedido;
        this.idRepartidor = idRepartidor;
        this.fecha = fecha;
        this.hora = hora;
    }

    public int getId() {
        return id;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public int getIdRepartidor() {
        return idRepartidor;
    }

    public Date getFecha() {
        return fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public void setIdRepartidor(int idRepartidor) {
        this.idRepartidor = idRepartidor;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Entregas{" +
                "id=" + id +
                ", idPedido=" + idPedido +
                ", idRepartidor=" + idRepartidor +
                ", fecha=" + fecha +
                ", hora=" + hora +
                '}';
    }
}
