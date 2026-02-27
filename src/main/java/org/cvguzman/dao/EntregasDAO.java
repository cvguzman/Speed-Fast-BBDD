package org.cvguzman.dao;

import org.cvguzman.modelo.Entregas;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EntregasDAO implements ClienteDAO<Entregas> {

  private final Connection connection;

    public EntregasDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Entregas entregas) {

        String sql = " INSERT INTO entregas(id_pedido, id_repartidor, fecha, hora) VALUES(?, ?,  ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, entregas.getIdPedido());
            stmt.setInt(2, entregas.getIdRepartidor());
            stmt.setDate(3, Date.valueOf(entregas.getFecha().toLocalDate()));
            stmt.setTime(4, Time.valueOf(entregas.getHora().toLocalTime()));

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error al registrar entregas", e);
        }
    }

    @Override
    public List<Entregas> readAll() {
        List<Entregas> lista = new ArrayList<>();

        String sql = """
                SELECT id, id_pedido, id_repartidor, fecha, hora FROM entregas
                """;

        try (PreparedStatement stmt = connection.prepareStatement(sql);

             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(new Entregas(
                        rs.getInt("id"),
                        rs.getInt("id_pedido"),
                        rs.getInt("id_repartidor"),
                        rs.getDate("fecha"),
                        rs.getTime("hora")
                ));

            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar entregas", e);
        }
        return lista;

    }

    @Override
    public void update(Entregas entregas) {

        String sql = "UPDATE entregas SET id_pedido=?, id_repartidor=?, fecha=?, hora=? WHERE id=?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, entregas.getIdPedido());
            stmt.setInt(2, entregas.getIdRepartidor());
            stmt.setDate(3, entregas.getFecha());
            stmt.setTime(4, entregas.getHora());
            stmt.setInt(5, entregas.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar entregas", e);
        }
    }

    @Override
    public void delete(Entregas entregas) {

        String sql = "DELETE FROM entregas WHERE id=?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, entregas.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar entregas", e);
        }
    }
}
