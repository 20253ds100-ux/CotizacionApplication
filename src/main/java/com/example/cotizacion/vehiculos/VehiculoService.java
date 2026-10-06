package com.example.cotizacion.vehiculos;
import com.example.cotizacion.exception.ReglaNegocioException;
import org.springframework.stereotype.Service;

@Service
public class VehiculoService {
    public VehiculoResponseDTO calcularCotizacion(VehiculoRequestDTO datos) {

        if (datos.getEdadConductor() < 18) {
            throw new ReglaNegocioException("El conductor debe ser mayor de 18 años");
        }
        if (datos.getDiasRenta() > 30) {
            throw new ReglaNegocioException("La renta no puede superar los 30 días");
        }
        if (datos.getKilometrosEstimados() > 5000) {
            throw new ReglaNegocioException("Los kilómetros estimados no pueden superar los 5,000 km");
        }
        if (datos.getTipoVehiculo() == TipoVehiculo.CAMIONETA && datos.getEdadConductor() < 25) {
            throw new ReglaNegocioException("Para rentar una CAMIONETA el conductor debe tener al menos 25 años");
        }

        double costoDiario = switch (datos.getTipoVehiculo()) {
            case COMPACTO -> 550.0;
            case SEDAN -> 700.0;
            case SUV -> 950.0;
            case CAMIONETA -> 1200.0;
        };
        double costoRentaBase = costoDiario * datos.getDiasRenta();

        int kmIncluidos = datos.getDiasRenta() * 100;
        double cargoKmAdicionales = 0.0;
        if (datos.getKilometrosEstimados() > kmIncluidos) {
            cargoKmAdicionales = (datos.getKilometrosEstimados() - kmIncluidos) * 4.0;
        }

        double cargoJovenConductor = 0.0;
        if (datos.getEdadConductor() >= 18 && datos.getEdadConductor() <= 24) {
            cargoJovenConductor = (costoRentaBase + cargoKmAdicionales) * 0.15;
        }

        double costoSeguro = datos.getSeguroCompleto() ? (180.0 * datos.getDiasRenta()) : 0.0;
double descuentoLargaRenta = 0.0;
        if (datos.getDiasRenta() >= 7) {
            descuentoLargaRenta = costoRentaBase * 0.10;
        }

        double costoTotal = (costoRentaBase - descuentoLargaRenta) + cargoKmAdicionales + cargoJovenConductor + costoSeguro;

        VehiculoResponseDTO response = new VehiculoResponseDTO();
        response.setNombreCliente(datos.getNombreCliente());
        response.setCostoRentaBase(costoRentaBase);
        response.setDescuentoLargaRenta(descuentoLargaRenta);
        response.setCargoKmAdicionales(cargoKmAdicionales);
        response.setCargoJovenConductor(cargoJovenConductor);
        response.setCostoSeguro(costoSeguro);
        response.setCostoTotal(costoTotal);

        return response;
    }
}