package zahid.portfolio.logisticsapp.db_entities.couriers;

import zahid.portfolio.logisticsapp.db_entities.Courier;

public class ChileExpress extends Courier {
    boolean notificado = false;


    public ChileExpress(String nombre_courier, double costo_por_peso, String region_reparte) {
        super(nombre_courier, costo_por_peso, region_reparte);
    }

    @Override
    public boolean notificarCourier() {
        System.out.println("ChileExpress notificado.");
        this.setNotificado(true);
        return true;
    }
}
