package zahid.portfolio.logisticsapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import zahid.portfolio.logisticsapp.db_entities.EstadoEnvio;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository("oracleEstadoEnvio")
public class EstadoEnvioDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EstadoEnvioDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public boolean addEstadoEnvio(EstadoEnvio estadoEnvio) {
        String sql = "INSERT INTO ESTADO_ENVIO (FECHA_ESTADO, ID_TRACKING, ESTADO)" +
                "VALUES (?,?,?)";


        return Boolean.TRUE.equals(jdbcTemplate.execute(sql, new PreparedStatementCallback<Boolean>() {
            @Override
            public Boolean doInPreparedStatement(PreparedStatement pst) throws SQLException, DataAccessException {
                pst.setDate(1, new Date(estadoEnvio.getFecha_estado().getTime()));
                pst.setInt(2, estadoEnvio.getId_tracking());
                pst.setString(3, estadoEnvio.getEstado());
                return pst.execute();
            }
        }));


    }


}
