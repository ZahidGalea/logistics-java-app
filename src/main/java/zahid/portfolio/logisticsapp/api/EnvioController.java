package zahid.portfolio.logisticsapp.api;

import org.springframework.web.bind.annotation.*;
import zahid.portfolio.logisticsapp.api.bodies.Venta;
import zahid.portfolio.logisticsapp.service.RegistrarEnvioService;
import org.springframework.beans.factory.annotation.Autowired;


@RequestMapping("api/v1/registrar-venta")
@RestController
public class EnvioController {

    private final RegistrarEnvioService registroEnvioService;

    @Autowired
    public EnvioController(RegistrarEnvioService registrarEnvioService) {
        this.registroEnvioService = registrarEnvioService;
    }

    @PostMapping
    public void registrarEnvio(@RequestBody Venta venta) {
        this.registroEnvioService.registrarEnvio(venta);
    }


}
