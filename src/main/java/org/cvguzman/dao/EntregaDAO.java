package org.cvguzman.dao;

import org.cvguzman.conexion.ConexionBD;

import javax.swing.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Time;

public class EntregaDAO {

    public void guardar(int idPedido, int idRepartidor, Date fecha, Time hora) {

        String sql = """
                INSERT INTO (id_pedido, id_repartidor, fecha, hora)
                VALUES (?, ?, ?, ?)
                """;

        try(Connection con = ConexionBD.obtenerConexion();
            PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, Integer.parseInt("idPedido"));
            stmt.setInt(2, Integer.parseInt("idRepartidor"));
            stmt.setDate(3, Date.valueOf("fecha"));
            stmt.setTime(4, Time.valueOf("hora"));

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Entrega registrada correctamente");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al registrar la entrega");
        }
    }
}
