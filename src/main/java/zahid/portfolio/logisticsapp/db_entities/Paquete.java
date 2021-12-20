package zahid.portfolio.logisticsapp.db_entities;

import java.util.concurrent.ThreadLocalRandom;

public class Paquete {
    private Integer id_paquete;
    private Integer peso;
    private String tamanio;

    public Paquete(Integer peso, String tamanio) {
        this.id_paquete = generarIdPaquete();
        this.peso = peso;
        this.tamanio = tamanio;
    }

    public int getId_paquete() {
        return id_paquete;
    }

    public void setId_paquete(Integer id_paquete) {
        this.id_paquete = id_paquete;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public Integer generarIdPaquete() {
        return ThreadLocalRandom.current().nextInt(1, 100000 + 1);
    }

}
