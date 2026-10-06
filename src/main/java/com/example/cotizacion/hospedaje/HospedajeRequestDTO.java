package com.example.cotizacion.hospedaje;

import jakarta.validation.constraints.*;
public class HospedajeRequestDTO {

    @NotBlank(message = "El nombre del huésped es obligatorio")
    private String nombreHuesped;

    @NotNull(message = "El tipo de habitación es obligatorio")
    private TipoHabitacion tipoHabitacion;

    @NotNull(message = "El numero de noches es obligatorio")
    @Min(value = 1, message = "Debe reservar al menos 1 noche")
    private Integer numeroNoches;

    @NotNull(message = "El nmero de huéspedes es obligatorio")
    @Min(value = 1, message = "Debe haber al menos 1 huésped")
    private Integer numeroHuespedes;

    @NotNull(message = "La temporada es obligatoria")
    private Temporada temporada;

    @NotNull(message = "Debe especificar si incluye desayuno")
    private Boolean incluyeDesayuno;

    @NotNull(message = "Debe especificar si incluye estacionamiento")
    private Boolean incluyeEstacionamiento;
    public String getNombreHuesped() { return nombreHuesped; }
    public void setNombreHuesped(String nombreHuesped) { this.nombreHuesped = nombreHuesped; }
    public TipoHabitacion getTipoHabitacion() { return tipoHabitacion; }
    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) { this.tipoHabitacion = tipoHabitacion; }
    public Integer getNumeroNoches() { return numeroNoches; }
    public void setNumeroNoches(Integer numeroNoches) { this.numeroNoches = numeroNoches; }
    public Integer getNumeroHuespedes() { return numeroHuespedes; }
    public void setNumeroHuespedes(Integer numeroHuespedes) { this.numeroHuespedes = numeroHuespedes; }
    public Temporada getTemporada() { return temporada; }
    public void setTemporada(Temporada temporada) { this.temporada = temporada; }
    public Boolean getIncluyeDesayuno() { return incluyeDesayuno; }
    public void setIncluyeDesayuno(Boolean incluyeDesayuno) { this.incluyeDesayuno = incluyeDesayuno; }
    public Boolean getIncluyeEstacionamiento() { return incluyeEstacionamiento; }
    public void setIncluyeEstacionamiento(Boolean incluyeEstacionamiento) { this.incluyeEstacionamiento = incluyeEstacionamiento; }
}