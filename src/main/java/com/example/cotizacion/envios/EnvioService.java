package com.example.cotizacion.envios;
import com.example.cotizacion.exception.ReglaNegocioException;
import org.springframework.stereotype.Service;

@Service
public class EnvioService {

    public EnvioResponseDTO calcularCotizacion(EnvioRequestDTO datos) {
        double volumen = datos.getLargoCm() * datos.getAnchoCm() * datos.getAltoCm();
        if (datos.getPesoKg() > 50) {
            throw new ReglaNegocioException("El paquete supera el peso maximo permitido (50 kg)");
        }
        if (datos.getLargoCm() > 150 || datos.getAnchoCm() > 150 || datos.getAltoCm() > 150) {
            throw new ReglaNegocioException("Alguna dimensipn del paquete supera los 150 cm");
        }
        if (volumen > 1_000_000) {
            throw new ReglaNegocioException("El volumen del paquete supera el máximo permitido (1,000,000 cm³)");
        }

        double costoBase = 80.0;
        double costoPeso = datos.getPesoKg() *12.0;
        double recargoVolumen = (volumen >50_000) ? 100.0 : 0.0;

        double subtotal = costoBase + costoPeso + recargoVolumen;

        double recargoTipoEnvio = 0.0;
        if (datos.getTipoEnvio() == TipoEnvio.EXPRESS) {
            recargoTipoEnvio = subtotal * 0.40;
        } else if (datos.getTipoEnvio() == TipoEnvio.MISMO_DIA) {
            recargoTipoEnvio = subtotal * 0.70;
        }

        double subtotalConEnvio = subtotal + recargoTipoEnvio;

        double costoSeguro = 0.0;
        if (datos.getValorDeclaratedo() > 10_000) {
            costoSeguro = datos.getValorDeclaratedo() * 0.02;
        }

        double costoTotal = subtotalConEnvio + costoSeguro;

        EnvioResponseDTO response = new EnvioResponseDTO();
        response.setCodigoPostal(datos.getCodigoPostal());
        response.setVolumenCm3(volumen);
        response.setCostoBase(costoBase);
        response.setCostoPeso(costoPeso);
        response.setRecargoVolumen(recargoVolumen);
        response.setRecargoTipoEnvio(recargoTipoEnvio);
        response.setCostoSeguro(costoSeguro);
        response.setCostoTotal(costoTotal);

        return response;
    }
}