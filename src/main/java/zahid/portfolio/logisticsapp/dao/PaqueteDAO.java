package zahid.portfolio.logisticsapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import zahid.portfolio.logisticsapp.db_entities.Paquete;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository("oraclePaquete")
public class PaqueteDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PaqueteDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean addPaquete(Paquete paquete) {
        String sql = "INSERT INTO PAQUETE (ID_PAQUETE, PESO, TAMANIO)" +
                "VALUES (?,?,?)";


        return Boolean.TRUE.equals(jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement pst) throws SQLException, DataAccessException {
                pst.setInt(1, paquete.getId_paquete());
                pst.setInt(2, paquete.getPeso());
                pst.setString(3, paquete.getTamanio());
                return pst.execute();
            }
        }));

    }
}
