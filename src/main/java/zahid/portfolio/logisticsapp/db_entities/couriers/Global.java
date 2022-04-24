package zahid.portfolio.logisticsapp.db_entities.couriers;

import zahid.portfolio.logisticsapp.db_entities.Courier;

public class Global extends Courier {
    boolean notificado = false;

    public Global(String nombre_courier, double costo_por_peso, String region_reparte) {
        super(nombre_courier, costo_por_peso, region_reparte);
    }

    @Override
    public boolean notificarCourier() {
        System.out.println("Global notificado.");
        this.setNotificado(true);
        return true;
    }
}
