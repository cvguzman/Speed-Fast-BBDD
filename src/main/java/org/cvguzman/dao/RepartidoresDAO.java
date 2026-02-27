package org.cvguzman.dao;

import org.cvguzman.modelo.Repartidores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepartidoresDAO implements ClienteDAO<Repartidores> {

    private final Connection connection;

    public RepartidoresDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Repartidores repartidores) {

        String sql = " INSERT INTO repartidores(nombre) VALUES(?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, repartidores.getNombre());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error al registrar repartidores", e);
        }
    }
    @Override
       public List<Repartidores> readAll() {
            List<Repartidores> lista = new ArrayList<>();
            String sql1 = """
                    SELECT id, nombre FROM repartidores
                    """;
            try (PreparedStatement stmt = connection.prepareStatement(sql1);

                 ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    lista.add(new Repartidores(

                            rs.getInt("id"),
                            rs.getString("nombre")

                    ));
                }
            } catch (SQLException e) {
                throw new RuntimeException("Error al listar los repartidores", e);
            }
            return lista;
        }

    @Override
    public void update(Repartidores repartidores) {
        String sql = "UPDATE repartidores SET nombre=? WHERE id=?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, repartidores.getNombre());
            stmt.setInt(2, repartidores.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar repartidores", e);
        }
    }

    @Override
    public void delete(Repartidores repartidores) {
        String sql = "DELETE FROM repartidores WHERE id=?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, repartidores.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar id repartidor", e);
        }
    }
}

