package org.cvguzman.dao;

import org.cvguzman.conexion.ConexionBD;
import org.cvguzman.modelo.Repartidor;
import org.cvguzman.modelo.ZonaDeCarga;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepartidorDAO {

    public List<Repartidor> listarTodos() {

        List<Repartidor> lista = new ArrayList<>();

        String sql = " SELECT id, nombre FROM repartidor";

        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            {

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nombre = rs.getString("nombre");

                    Repartidor repaetidor = new Repartidor(nombre, new ZonaDeCarga());
                    lista.add(repaetidor);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}

