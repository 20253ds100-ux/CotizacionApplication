package com.example.cotizacion.hospedaje;

import com.example.cotizacion.exception.ReglaNegocioException;
import org.springframework.stereotype.Service;

@Service
public class HospedajeService {
    public HospedajeResponseDTO calcularCotizacion(HospedajeRequestDTO datos) {
        if (datos.getNumeroNoches() > 30) {
            throw new ReglaNegocioException("El número de noches no puede superar los 30 días");
        }

        int capacidadMaxima = switch (datos.getTipoHabitacion()) {
            case INDIVIDUAL -> 1;
            case DOBLE -> 2;
            case SUITE -> 4;
        };

        if (datos.getNumeroHuespedes() > capacidadMaxima) {
            throw new ReglaNegocioException(
                    String.format("La habitación %s no permite más de %d personas",
                            datos.getTipoHabitacion(), capacidadMaxima)
            );
        }
        double costoPorNoche = switch (datos.getTipoHabitacion()) {
            case INDIVIDUAL -> 700.0;
            case DOBLE -> 1100.0;
            case SUITE -> 1800.0;
        };
        double costoBaseHospedaje = costoPorNoche * datos.getNumeroNoches();
        double ajusteTemporada = 0.0;
        if (datos.getTemporada() == Temporada.BAJA) {
            ajusteTemporada = - (costoBaseHospedaje * 0.10);
        } else if (datos.getTemporada() == Temporada.ALTA) {
            ajusteTemporada = costoBaseHospedaje * 0.25;
        }

        double hospedajeAjustado = costoBaseHospedaje + ajusteTemporada;

        double descuentoLargaEstancia = 0.0;
        if (datos.getNumeroNoches() >= 7) {
            descuentoLargaEstancia = hospedajeAjustado * 0.08;
        }

        double hospedajeFinal = hospedajeAjustado - descuentoLargaEstancia;
        double costoDesayuno = datos.getIncluyeDesayuno() ?
                (datos.getNumeroHuespedes() * datos.getNumeroNoches() * 150.0) : 0.0;
        double costoEstacionamiento = datos.getIncluyeEstacionamiento() ?
                (datos.getNumeroNoches() * 100.0) : 0.0;
        double subtotal = hospedajeFinal + costoDesayuno + costoEstacionamiento;
        double impuestoHospedaje = subtotal * 0.04;
        double total = subtotal + impuestoHospedaje;

        HospedajeResponseDTO response = new HospedajeResponseDTO();
        response.setNombreHuesped(datos.getNombreHuesped());
        response.setCostoBaseHospedaje(costoBaseHospedaje);
        response.setAjusteTemporada(ajusteTemporada);
        response.setDescuentoLargaEstancia(descuentoLargaEstancia);
        response.setCostoDesayuno(costoDesayuno);
        response.setCostoEstacionamiento(costoEstacionamiento);
        response.setSubtotal(subtotal);
        response.setImpuestoHospedaje(impuestoHospedaje);
        response.setTotal(total);

        return response;
    }
}