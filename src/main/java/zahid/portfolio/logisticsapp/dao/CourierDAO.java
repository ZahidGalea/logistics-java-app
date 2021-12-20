package zahid.portfolio.logisticsapp.dao;

import zahid.portfolio.logisticsapp.db_entities.Courier;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.util.ArrayList;

@Repository
public class CourierDAO {


    public Courier getCourier(Connection conn, String nombre_courier) {
        return null;
    }

    public ArrayList<Courier> getCouriers(Connection conn) {
        return null;
    }

}
