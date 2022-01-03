package zahid.portfolio.logisticsapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import zahid.portfolio.logisticsapp.db_entities.Envio;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository("oracleEnvio")
public class EnvioDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EnvioDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean addEnvio(Envio envio) {
        String sql = "INSERT INTO ENVIO (ID_ENVIO, FECHA_ENVIO, COSTO_ENVIO, ID_TRACKING, " +
                "COURIER_NOMBRE, ID_PAQUETE, ID_CLIENTE)" +
                "VALUES (?,?,?,?,?,?,?)";

        return Boolean.TRUE.equals(jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {

            @Override
            public Boolean doInPreparedStatement(PreparedStatement pst) throws SQLException, DataAccessException {
                pst.setInt(1, envio.getId_envio());
                pst.setDate(2, new Date(envio.getFecha_envio().getTime()));
                pst.setInt(3, envio.getCosto_envio());
                pst.setInt(4, envio.getId_tracking());
                pst.setString(5, envio.getCourier_nombre());
                pst.setInt(6, envio.getId_paquete());
                pst.setInt(7, envio.getId_cliente());
                return pst.execute();
            }
        }));

    }

}
