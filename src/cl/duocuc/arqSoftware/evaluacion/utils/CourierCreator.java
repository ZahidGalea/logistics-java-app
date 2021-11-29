package cl.duocuc.arqSoftware.evaluacion.utils;

import cl.duocuc.arqSoftware.evaluacion.entities.couriers.Blue;
import cl.duocuc.arqSoftware.evaluacion.entities.couriers.ChileExpress;
import cl.duocuc.arqSoftware.evaluacion.entities.Courier;
import cl.duocuc.arqSoftware.evaluacion.entities.couriers.Starken;

import java.util.ArrayList;
import java.util.Objects;

public class CourierCreator {


    public Courier createCourier(String region_reparte) {

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
