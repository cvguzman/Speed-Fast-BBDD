package org.cvguzman.main;

import org.cvguzman.conexion.ConexionBD;
import org.cvguzman.controlador.ControladoresDePedidos;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        try {
            Connection connection = ConexionBD.obtenerConexion();

            ControladoresDePedidos controlador = new ControladoresDePedidos(connection);
            controlador.iniciar();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
