package org.cvguzman.modelo;

public class Repartidor {
    private String nombre;
    private org.cvguzman.modelo.ZonaDeCarga zonaDeCarga;

    public Repartidor(String nombre, ZonaDeCarga zonaDeCarga) {
    }

    public Repartidor setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public Repartidor setZonaDeCarga(org.cvguzman.modelo.ZonaDeCarga zonaDeCarga) {
        this.zonaDeCarga = zonaDeCarga;
        return this;
    }

    public Repartidor createRepartidor() {
        return new Repartidor(nombre, zonaDeCarga);
    }
}
