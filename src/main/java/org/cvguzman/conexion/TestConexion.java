package org.cvguzman.conexion;

import java.sql.Connection;

public class TestConexion {
    public static void main(String[] args) {
        try (Connection conn = ConexionBD.obtenerConexion()) {
            System.out.println("✅ Conexión exitosa a la base de datos");
        } catch (Exception e) {
            System.out.println("❌ Error al conectar");
            e.printStackTrace();
        }
    }
}