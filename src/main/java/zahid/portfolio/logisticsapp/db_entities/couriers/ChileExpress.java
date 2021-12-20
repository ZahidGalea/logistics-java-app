package zahid.portfolio.logisticsapp.db_entities.couriers;

import zahid.portfolio.logisticsapp.db_entities.Courier;

public class ChileExpress extends Courier {
    boolean notificado = false;

    public ChileExpress() {
        this.setRegion_reparte("a");
        this.setNombre_courier("ChileExpress");
        this.setCosto_por_peso(10);
    }

    @Override
    public boolean notificarCourier() {
        System.out.println("ChileExpress notificado.");
        this.setNotificado(true);
        return true;
    }
}
