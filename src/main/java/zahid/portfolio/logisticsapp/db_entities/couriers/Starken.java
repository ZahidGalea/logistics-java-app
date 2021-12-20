package zahid.portfolio.logisticsapp.db_entities.couriers;

import zahid.portfolio.logisticsapp.db_entities.Courier;

public class Starken extends Courier {
    boolean notificado = false;

    public Starken() {
        this.setRegion_reparte("b");
        this.setNombre_courier("Starken");
        this.setCosto_por_peso(15);
    }

    @Override
    public boolean notificarCourier() {
        System.out.println("Starken notificado.");
        this.setNotificado(true);
        return true;
    }
}
