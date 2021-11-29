package cl.duocuc.arqSoftware.evaluacion.entities.couriers;

import cl.duocuc.arqSoftware.evaluacion.entities.Courier;

public class Blue extends Courier {
    boolean notificado = false;

    public Blue() {
        this.setRegion_reparte("c");
        this.setNombre_courier("Blue");
        this.setCosto_por_peso(10);
    }

    @Override
    public boolean notificarCourier() {
        System.out.println("Blue notificado.");
        this.setNotificado(true);
        return true;
    }
}
