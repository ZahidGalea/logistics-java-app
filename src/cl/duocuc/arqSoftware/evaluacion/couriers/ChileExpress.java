package cl.duocuc.arqSoftware.evaluacion.couriers;

import cl.duocuc.arqSoftware.evaluacion.Courier;

public class ChileExpress implements Courier {

    public ChileExpress() {
    }

    @Override
    public boolean notificarCourier() {
        System.out.println("ChileExpress.notificarCourier");
        return true;
    }
}
