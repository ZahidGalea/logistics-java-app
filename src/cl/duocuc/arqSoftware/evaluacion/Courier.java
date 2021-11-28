package cl.duocuc.arqSoftware.evaluacion;

public interface Courier {
    String nombre_courier = null;
    double costo_por_peso = 0.0;
    String region_reparte = null;
    boolean notificado = false;

    public default String getNombre_courier() {
        return nombre_courier;
    }

    public default void setNombre_courier(String nombre_courier) {

    }

    public default double getCosto_por_peso() {
        return costo_por_peso;
    }

    public default void setCosto_por_peso(Float costo_por_peso) {

    }

    public default String getRegion_reparte() {
        return region_reparte;
    }

    public default void setRegion_reparte(String region_reparte) {

    }

    public default boolean getNotificado() {
        return notificado;
    }

    public default void setNotificado(boolean notificado) {

    }

    abstract public boolean notificarCourier();


}
