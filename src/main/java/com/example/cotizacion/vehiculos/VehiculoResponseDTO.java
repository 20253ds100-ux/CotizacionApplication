package com.example.cotizacion.vehiculos;
public class VehiculoResponseDTO {
    private String nombreCliente;
    private double costoRentaBase;
    private double descuentoLargaRenta;
    private double cargoKmAdicionales;
    private double cargoJovenConductor;
    private double costoSeguro;
    private double costoTotal;
    public String getNombreCliente() { return nombreCliente; }
    public void setNombreCliente(String nombreCliente) { this.nombreCliente = nombreCliente; }
    public double getCostoRentaBase() { return costoRentaBase; }
    public void setCostoRentaBase(double costoRentaBase) { this.costoRentaBase = costoRentaBase; }
    public double getDescuentoLargaRenta() { return descuentoLargaRenta; }
    public void setDescuentoLargaRenta(double descuentoLargaRenta) { this.descuentoLargaRenta = descuentoLargaRenta; }
    public double getCargoKmAdicionales() { return cargoKmAdicionales; }
    public void setCargoKmAdicionales(double cargoKmAdicionales) { this.cargoKmAdicionales = cargoKmAdicionales; }
    public double getCargoJovenConductor() { return cargoJovenConductor; }
    public void setCargoJovenConductor(double cargoJovenConductor) { this.cargoJovenConductor = cargoJovenConductor; }
    public double getCostoSeguro() { return costoSeguro; }
    public void setCostoSeguro(double costoSeguro) { this.costoSeguro = costoSeguro; }
    public double getCostoTotal() { return costoTotal; }
    public void setCostoTotal(double costoTotal) { this.costoTotal = costoTotal; }
}