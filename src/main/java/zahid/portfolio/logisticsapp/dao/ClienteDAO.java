package zahid.portfolio.logisticsapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import zahid.portfolio.logisticsapp.db_entities.Cliente;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository("postgresqlCliente")
public class ClienteDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ClienteDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean addCliente(Cliente cliente) {
        String sql = "INSERT INTO CLIENTE (ID_CLIENTE, DIRECCION, COMUNA, NOMBRE, NUMERO_TLF, REGION, RUT)" +
                "VALUES (?,?,?,?,?,?,?)";

        return Boolean.TRUE.equals(jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                ps.setInt(1, cliente.getId_cliente());
                ps.setString(2, cliente.getDireccion());
                ps.setString(3, cliente.getComuna());
                ps.setString(4, cliente.getNombre_apellido());
                ps.setString(5, cliente.getNumero_telefono());
                ps.setString(6, cliente.getRegion());
                ps.setString(7, cliente.getRut());
                return ps.execute();
            }
        }));
    }

}
