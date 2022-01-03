package zahid.portfolio.logisticsapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import zahid.portfolio.logisticsapp.dao.*;
import zahid.portfolio.logisticsapp.db_entities.Courier;
import zahid.portfolio.logisticsapp.db_entities.couriers.Blue;
import zahid.portfolio.logisticsapp.db_entities.couriers.ChileExpress;
import zahid.portfolio.logisticsapp.db_entities.couriers.Starken;

import java.util.List;
import java.util.Objects;

@Service
public class CourierCreatorService {

    private final CourierDAO courierDAO;

    @Autowired
    public CourierCreatorService(@Qualifier("oracleCourier") CourierDAO courierDAO) {
        this.courierDAO = courierDAO;
    }


    public Courier createCourier(String region_reparte) throws Exception {
        try {
            List<Courier> couriers = this.courierDAO.getCouriersByRegion(region_reparte);

            Courier courier = this.courierDAO.getCouriersByRegion(region_reparte).get(0);
            if (Objects.equals(courier.getNombre_courier(), "Blue")) {
                return new Blue(courier.getNombre_courier(), courier.getCosto_por_peso(), courier.getRegion_reparte());
            }
            if (Objects.equals(courier.getNombre_courier(), "ChileExpress")) {
                return new ChileExpress(courier.getNombre_courier(), courier.getCosto_por_peso(), courier.getRegion_reparte());
            }
            if (Objects.equals(courier.getNombre_courier(), "Starken")) {
                return new Starken(courier.getNombre_courier(), courier.getCosto_por_peso(), courier.getRegion_reparte());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        throw new Exception("Region no encontrada");

    }

    ;

}
