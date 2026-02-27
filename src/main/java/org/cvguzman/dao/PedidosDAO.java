package org.cvguzman.dao;

import org.cvguzman.modelo.Estado;
import org.cvguzman.modelo.Pedidos;
import org.cvguzman.modelo.Tipo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PedidosDAO implements ClienteDAO<Pedidos> {

    private final Connection connection;

    public PedidosDAO(Connection connection) {
        this.connection = connection;
    }

    public void asignarRepartidor(int idPedido, int idRepartidor) {

        String sql = """
            INSERT INTO entregas (id_pedido, id_repartidor, fecha, hora)
            VALUES (?, ?, CURRENT_DATE(), CURRENT_TIME())
            """;

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, idPedido);
            stmt.setInt(2, idRepartidor);

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error al asignar repartidor", e);
        }
    }

    @Override
    public void create(Pedidos pedidos) {

        String sql = " INSERT INTO pedidos(direccion, tipo, estado) VALUES(?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, pedidos.getDireccion());
            stmt.setString(2, String.valueOf(pedidos.getTipo()));
            stmt.setString(3, String.valueOf(pedidos.getEstado()));

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error al registrar pedidos", e);
        }
    }

    @Override
    public List<Pedidos> readAll() {
        List<Pedidos> lista = new ArrayList<>();
        String sql = """
                SELECT id, direccion, tipo, estado FROM pedidos
                """;
        try (PreparedStatement stmt = connection.prepareStatement(sql);

             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Tipo tipo = Tipo.valueOf(rs.getString("tipo").trim().toUpperCase());
                Estado estado = Estado.valueOf(rs.getString("estado").trim().toUpperCase());
                lista.add(new Pedidos(

                        rs.getInt("id"),
                        rs.getString("direccion"),
                        tipo,
                        estado
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar los pedidos", e);
        }
        return lista;
    }

    @Override
    public void update(Pedidos pedidos) {
        String sql = "UPDATE pedidos SET direccion=?, tipo=?, estado=? WHERE id=?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, pedidos.getDireccion());
            stmt.setString(2, pedidos.getTipo().name());
            stmt.setString(3, pedidos.getEstado().name());
            stmt.setInt(4, pedidos.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar pedidos", e);
        }
    }

    @Override
    public void delete(Pedidos pedidos) {

        String sql = "DELETE FROM pedidos WHERE id=?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, pedidos.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar id pedidos", e);
        }
    }
}
