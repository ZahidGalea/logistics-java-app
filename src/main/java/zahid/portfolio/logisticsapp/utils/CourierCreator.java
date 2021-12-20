package zahid.portfolio.logisticsapp.utils;

import zahid.portfolio.logisticsapp.db_entities.couriers.Blue;
import zahid.portfolio.logisticsapp.db_entities.couriers.ChileExpress;
import zahid.portfolio.logisticsapp.db_entities.Courier;
import zahid.portfolio.logisticsapp.db_entities.couriers.Starken;

import java.util.ArrayList;
import java.util.Objects;

public class CourierCreator {


    public Courier createCourier(String region_reparte) {

        // TODO: Cambiar proceso que extraiga couriers desde BD
        ArrayList<Courier> courierArrayList = new ArrayList<Courier>();

        courierArrayList.add(new ChileExpress());
        courierArrayList.add(new Blue());
        courierArrayList.add(new Starken());

        for (Courier i : courierArrayList) {
            if (Objects.equals(i.getRegion_reparte(), region_reparte)) {
                return i;
            }
        }

        return null;


    }

    ;

}
