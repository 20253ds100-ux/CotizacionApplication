package com.example.cotizacion.envios;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cotizaciones/envios")
@CrossOrigin(origins = "*")
public class EnvioController {

    private final EnvioService envioService;

    public EnvioController(EnvioService envioService) {
        this.envioService = envioService;
    }

    @PostMapping
    public ResponseEntity<EnvioResponseDTO> cotizarEnvio(@Valid @RequestBody EnvioRequestDTO request) {
        EnvioResponseDTO response = envioService.calcularCotizacion(request);
        return ResponseEntity.ok(response);
    }
}
