package cl.duocuc.arqSoftware.evaluacion;

import java.util.Date;

public class Registro {
    private Integer id_registro;

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

    private Date fecha_registro;
    private Integer costo_envio;
    private Date fecha_delivery;
    private Integer id_paquete;
    private Integer id_cliente;

    public Registro(Date fecha_registro, Integer costo_envio, Date fecha_delivery, Integer id_paquete, Integer id_cliente) {
        this.id_registro = generarIdRegistro();
        this.fecha_registro = fecha_registro;
        this.costo_envio = costo_envio;
        this.fecha_delivery = fecha_delivery;
        this.id_paquete = id_paquete;
        this.id_cliente = id_cliente;
    }

    public Integer getId_registro() {
        return id_registro;
    }

    public void setId_registro(Integer id_registro) {
        this.id_registro = id_registro;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public Integer getCosto_envio() {
        return costo_envio;
    }

    public void setCosto_envio(Integer costo_envio) {
        this.costo_envio = costo_envio;
    }

    public Date getFecha_delivery() {
        return fecha_delivery;
    }

    public void setFecha_delivery(Date fecha_delivery) {
        this.fecha_delivery = fecha_delivery;
    }

    public Integer generarIdRegistro() {
        return null;
    }

    public Integer RegistrarBD() {
        return 1;
    }
}
