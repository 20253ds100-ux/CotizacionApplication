package com.example.cotizacion.hospedaje;
public class HospedajeResponseDTO {
    private String nombreHuesped;
    private double costoBaseHospedaje;
    private double ajusteTemporada;
    private double descuentoLargaEstancia;
    private double costoDesayuno;
    private double costoEstacionamiento;
    private double subtotal;
    private double impuestoHospedaje;
    private double total;
    public String getNombreHuesped() { return nombreHuesped; }
    public void setNombreHuesped(String nombreHuesped) { this.nombreHuesped = nombreHuesped; }
    public double getCostoBaseHospedaje() { return costoBaseHospedaje; }
    public void setCostoBaseHospedaje(double costoBaseHospedaje) { this.costoBaseHospedaje = costoBaseHospedaje; }
    public double getAjusteTemporada() { return ajusteTemporada; }
    public void setAjusteTemporada(double ajusteTemporada) { this.ajusteTemporada = ajusteTemporada; }
    public double getDescuentoLargaEstancia() { return descuentoLargaEstancia; }
    public void setDescuentoLargaEstancia(double descuentoLargaEstancia) { this.descuentoLargaEstancia = descuentoLargaEstancia; }
    public double getCostoDesayuno() { return costoDesayuno; }
    public void setCostoDesayuno(double costoDesayuno) { this.costoDesayuno = costoDesayuno; }
    public double getCostoEstacionamiento() { return costoEstacionamiento; }
    public void setCostoEstacionamiento(double costoEstacionamiento) { this.costoEstacionamiento = costoEstacionamiento; }
    public double getSubtotal() { return subtotal; }
    public void setSubtotal(double subtotal) { this.subtotal = subtotal; }
    public double getImpuestoHospedaje() { return impuestoHospedaje; }
    public void setImpuestoHospedaje(double impuestoHospedaje) { this.impuestoHospedaje = impuestoHospedaje; }
    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
}