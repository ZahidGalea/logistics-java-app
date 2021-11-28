package cl.duocuc.arqSoftware.evaluacion;

import cl.duocuc.arqSoftware.evaluacion.couriers.Blue;
import cl.duocuc.arqSoftware.evaluacion.couriers.ChileExpress;
import cl.duocuc.arqSoftware.evaluacion.couriers.Starken;

import java.util.Objects;

public class CourierCreator {
    public Courier createCourier(String region_reparte) {

        if (Objects.equals(region_reparte, "a")) {
            return new ChileExpress();
        } else if (Objects.equals(region_reparte, "b")) {
            return new Starken();
        } else if (Objects.equals(region_reparte, "c")) {
            return new Blue();
        }
        ;

        return null;


    }

    ;

}
