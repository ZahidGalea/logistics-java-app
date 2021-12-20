package zahid.portfolio.logisticsapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zahid.portfolio.logisticsapp.dao.*;

import zahid.portfolio.logisticsapp.dao.ClienteDAO;
import zahid.portfolio.logisticsapp.dao.EnvioDAO;
import zahid.portfolio.logisticsapp.dao.EstadoEnvioDAO;
import zahid.portfolio.logisticsapp.dao.PaqueteDAO;
import zahid.portfolio.logisticsapp.db.Conexion;
import zahid.portfolio.logisticsapp.db_entities.*;
import zahid.portfolio.logisticsapp.utils.CourierCreator;

import java.util.Date;

@SpringBootApplication
public class LogisticsApp {

    public static void main(String[] args) {
        SpringApplication.run(LogisticsApp.class, args);
    }


}
