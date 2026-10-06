package com.example.cotizacion.vehiculos;
import jakarta.validation.constraints.*;

public class VehiculoRequestDTO {

    @NotBlank(message = "El nombre del cliente es obligatorio")
    private String nombreCliente;

    @NotNull(message = "La edad del conductor es obligatoria")
    @Min(value = 1, message = "La edad debe ser mayor a 0")
    private Integer edadConductor;

    @NotNull(message = "El tipo de vehículo es obligatorio")
    private TipoVehiculo tipoVehiculo;

    @NotNull(message = "El número de días de renta es obligatorio")
    @Min(value = 1, message = "Mínimo 1 día de renta")
    private Integer diasRenta;

    @NotNull(message = "Los kilmetros estimados son obligatorios")
    @PositiveOrZero(message = "Los kilómetros deben ser mayores o iguales a 0")
    private Integer kilometrosEstimados;

    @NotNull(message = "Debe especificar si requiere seguro completo")
    private Boolean seguroCompleto;
    public String getNombreCliente() { return nombreCliente; }
    public void setNombreCliente(String nombreCliente) { this.nombreCliente = nombreCliente; }
    public Integer getEdadConductor() { return edadConductor; }
    public void setEdadConductor(Integer edadConductor) { this.edadConductor = edadConductor; }
    public TipoVehiculo getTipoVehiculo() { return tipoVehiculo; }
    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) { this.tipoVehiculo = tipoVehiculo; }
    public Integer getDiasRenta() { return diasRenta; }
    public void setDiasRenta(Integer diasRenta) { this.diasRenta = diasRenta; }
    public Integer getKilometrosEstimados() { return kilometrosEstimados; }
    public void setKilometrosEstimados(Integer kilometrosEstimados) { this.kilometrosEstimados = kilometrosEstimados; }
    public Boolean getSeguroCompleto() { return seguroCompleto; }
    public void setSeguroCompleto(Boolean seguroCompleto) { this.seguroCompleto = seguroCompleto; }
}