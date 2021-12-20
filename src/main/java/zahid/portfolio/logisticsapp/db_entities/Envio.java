package zahid.portfolio.logisticsapp.db_entities;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class Envio {
    private Integer id_envio;
    private Date fecha_envio;
    private Integer costo_envio;
    private Integer id_paquete;
    private Integer id_cliente;
    private Integer id_tracking;
    private String courier_nombre;

    public Envio(Date fecha_envio, Integer costo_envio, Integer id_paquete, Integer id_cliente, Integer id_tracking, String courier_nombre) {
        this.id_envio = generarIdEnvio();
        this.fecha_envio = fecha_envio;
        this.costo_envio = costo_envio;
        this.id_tracking = id_tracking;
        this.courier_nombre = courier_nombre;
        this.id_paquete = id_paquete;
        this.id_cliente = id_cliente;
    }

    public Integer getId_paquete() {
        return id_paquete;
    }

    public void setId_paquete(Integer id_paquete) {
        this.id_paquete = id_paquete;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Integer getId_tracking() {
        return id_tracking;
    }

    public void setId_tracking(Integer id_tracking) {
        this.id_tracking = id_tracking;
    }

    public String getCourier_nombre() {
        return courier_nombre;
    }

    public void setCourier_nombre(String courier_nombre) {
        this.courier_nombre = courier_nombre;
    }

    public Integer getId_envio() {
        return id_envio;
    }

    public void setId_envio(Integer id_envio) {
        this.id_envio = id_envio;
    }

    public Date getFecha_envio() {
        return fecha_envio;
    }

    public void setFecha_envio(Date fecha_envio) {
        this.fecha_envio = fecha_envio;
    }

    public Integer getCosto_envio() {
        return costo_envio;
    }

    public void setCosto_envio(Integer costo_envio) {
        this.costo_envio = costo_envio;
    }

    public Integer generarIdEnvio() {
        return ThreadLocalRandom.current().nextInt(1, 100000 + 1);
    }
}
