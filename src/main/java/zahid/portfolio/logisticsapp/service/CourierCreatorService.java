package zahid.portfolio.logisticsapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import zahid.portfolio.logisticsapp.dao.*;
import zahid.portfolio.logisticsapp.db_entities.Courier;
import zahid.portfolio.logisticsapp.db_entities.couriers.Blue;
import zahid.portfolio.logisticsapp.db_entities.couriers.ChileExpress;
import zahid.portfolio.logisticsapp.db_entities.couriers.Global;
import zahid.portfolio.logisticsapp.db_entities.couriers.Starken;

import java.util.Objects;

@Service
public class CourierCreatorService {

    private final CourierDAO courierDAO;

    @Autowired
    public CourierCreatorService(@Qualifier("oracleCourier") CourierDAO courierDAO) {
        this.courierDAO = courierDAO;
    }

    public Courier createCourier(String region_reparte) {

        if (Objects.equals(region_reparte, "1")) {
            return new Blue("Blue", 5, region_reparte);
        }
        if (Objects.equals(region_reparte, "2")) {
            return new ChileExpress("ChileExpress", 10, region_reparte);
        }
        if (Objects.equals(region_reparte, "3")) {
            return new Starken("Starken", 8, region_reparte);
        } else {
            return new Global("Global", 20, region_reparte);
        }

    }

    ;

}
