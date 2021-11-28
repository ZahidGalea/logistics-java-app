package cl.duocuc.arqSoftware.evaluacion.couriers;

import cl.duocuc.arqSoftware.evaluacion.Courier;


public class Blue implements Courier {
    String region_reparte = "c";
    String nombre_courier = "Blue";
    double costo_por_peso = 10;
    boolean notificado = false;

    public Blue() {
    }

    @Override
    public boolean notificarCourier() {
        System.out.println("Blue notificado.");
        this.setNotificado(true);
        return true;
    }
}
