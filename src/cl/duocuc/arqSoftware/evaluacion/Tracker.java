package cl.duocuc.arqSoftware.evaluacion;

import java.util.Date;

public class Tracker {
    private Integer id_tracking;
    private Date fecha_estado;
    private String estado_paquete;

    public Tracker(Integer id_tracking) {
        this.id_tracking = id_tracking;
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

    public String getEstado_paquete() {
        return estado_paquete;
    }

    public void setEstado_paquete(String estado_paquete) {
        this.estado_paquete = estado_paquete;
    }

    public void updatearEstado() {

    }

}
