package cl.duocuc.arqSoftware.evaluacion.couriers;

import cl.duocuc.arqSoftware.evaluacion.Courier;

public class Starken implements Courier {

    public Starken() {

    }

    @Override
    public boolean notificarCourier() {
        System.out.println("Starken.notificarCourier");
        this.setNotificado(true);
        return true;
    }
}
