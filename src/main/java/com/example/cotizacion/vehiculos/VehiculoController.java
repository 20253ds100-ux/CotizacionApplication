package com.example.cotizacion.vehiculos;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cotizaciones/vehiculos")
@CrossOrigin(origins = "*")
public class VehiculoController {

    private final VehiculoService vehiculoService;

    public VehiculoController(VehiculoService vehiculoService) {
        this.vehiculoService = vehiculoService;
    }
    @PostMapping
    public ResponseEntity<VehiculoResponseDTO> cotizarVehiculo(@Valid @RequestBody VehiculoRequestDTO request) {
        VehiculoResponseDTO response = vehiculoService.calcularCotizacion(request);
        return ResponseEntity.ok(response);
    }
}