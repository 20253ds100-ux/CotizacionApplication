package com.example.cotizacion.hospedaje;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cotizaciones/hospedaje")
@CrossOrigin(origins = "*")
public class HospedajeController {

    private final HospedajeService hospedajeService;

    public HospedajeController(HospedajeService hospedajeService) {
        this.hospedajeService = hospedajeService;
    }
    @PostMapping
    public ResponseEntity<HospedajeResponseDTO> cotizarHospedaje(@Valid @RequestBody HospedajeRequestDTO request) {
        HospedajeResponseDTO response = hospedajeService.calcularCotizacion(request);
        return ResponseEntity.ok(response);
    }
}