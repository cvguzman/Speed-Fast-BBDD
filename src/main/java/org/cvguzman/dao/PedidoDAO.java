package org.cvguzman.dao;

import org.cvguzman.conexion.ConexionBD;
import org.cvguzman.modelo.Pedido;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class PedidoDAO {

    public void guardar(Pedido pedido) {

        String sql = """
                INSERT INTO pedido (id, direccion, tipo, estado)
                VALUES (?, ?, ?, ?)
                """;

        try(Connection con = ConexionBD.obtenerConexion();
            PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, String.valueOf(pedido.getId()));
            stmt.setString(2, pedido.getDireccion());
            stmt.setString(3, pedido.getTipo());
            stmt.setString(4, String.valueOf(pedido.getEstado()));

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Pedido guardado correctamente");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al cargar pedidos desde la Base Datos");
        }
    }
}
