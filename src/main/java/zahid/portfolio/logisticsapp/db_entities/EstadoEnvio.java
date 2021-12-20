package zahid.portfolio.logisticsapp.db_entities;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class EstadoEnvio {
    private Integer id_tracking;
    private Date fecha_estado;
    private String estado;

    public EstadoEnvio(Date fecha_estado, String estado) {
        this.id_tracking = this.generateIdTracking();
        this.fecha_estado = fecha_estado;
        this.estado = estado;
    }

    public void setId_tracking(Integer id_tracking) {
        this.id_tracking = id_tracking;
    }

    public Integer getId_tracking() {
        return id_tracking;
    }

    public Date getFecha_estado() {
        return fecha_estado;
    }

    public void setFecha_estado(Date fecha_estado) {
        this.fecha_estado = fecha_estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    private Integer generateIdTracking() {
        return ThreadLocalRandom.current().nextInt(1, 100000 + 1);
    }

    ;

}
