package zahid.portfolio.logisticsapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import zahid.portfolio.logisticsapp.db_entities.Courier;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository("oracleCourier")
public class CourierDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CourierDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Courier> getCouriers() {
        String sql = "SELECT NOMBRE, COSTO_POR_PESO, REGION_REPARTE FROM COURIER";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new Courier(
                        rs.getString("NOMBRE"),
                        Double.parseDouble(rs.getString("COSTO_POR_PESO")),
                        rs.getString("REGION_REPARTE")
                )
        );

    }

    public List<Courier> getCouriersByRegion(String region_reparte) {
        String sql = "SELECT NOMBRE, COSTO_POR_PESO, REGION_REPARTE FROM COURIER " +
                "WHERE REGION_REPARTE = ?";

        PreparedStatementSetter pst = new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, region_reparte);
            }
        };


        return jdbcTemplate.query(sql, pst, (rs, rowNum) ->
                new Courier(
                        rs.getString("NOMBRE"),
                        Double.parseDouble(rs.getString("COSTO_POR_PESO")),
                        rs.getString("REGION_REPARTE")
                ));


    }

}
