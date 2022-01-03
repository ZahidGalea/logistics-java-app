package zahid.portfolio.logisticsapp.db_entities;

public class Courier {
    String nombre_courier = null;
    double costo_por_peso = 0.0;
    String region_reparte = null;
    boolean notificado = false;

    public Courier(String nombre_courier, double costo_por_peso, String region_reparte) {
        this.nombre_courier = nombre_courier;
        this.costo_por_peso = costo_por_peso;
        this.region_reparte = region_reparte;
    }

    public String getNombre_courier() {
        return nombre_courier;
    }

    public void setNombre_courier(String nombre_courier) {
        this.nombre_courier = nombre_courier;
    }

    public double getCosto_por_peso() {
        return costo_por_peso;
    }

    public void setCosto_por_peso(double costo_por_peso) {
        this.costo_por_peso = costo_por_peso;
    }

    public String getRegion_reparte() {
        return region_reparte;
    }

    public void setRegion_reparte(String region_reparte) {
        this.region_reparte = region_reparte;
    }

    public boolean getNotificado() {
        return notificado;
    }

    public void setNotificado(boolean notificado) {
        this.notificado = notificado;
    }

    public boolean notificarCourier() {
        this.setNotificado(true);
        System.out.println("Courier sin notificar. no se encontró courier en la zona");
        return true;
    }

    public boolean isNotificado() {
        return notificado;
    }


}
