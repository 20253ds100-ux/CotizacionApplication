package com.example.cotizacion.envios;
public class EnvioResponseDTO {
    private String codigoPostal;
    private double volumenCm3;
    private double costoBase;
    private double costoPeso;
    private double recargoVolumen;
    private double recargoTipoEnvio;
    private double costoSeguro;
    private double costoTotal;
    public EnvioResponseDTO() {}

    public String getCodigoPostal() { return codigoPostal; }
    public void setCodigoPostal(String codigoPostal) { this.codigoPostal = codigoPostal; }
    public double getVolumenCm3() { return volumenCm3; }
    public void setVolumenCm3(double volumenCm3) { this.volumenCm3 = volumenCm3; }
    public double getCostoBase() { return costoBase; }
    public void setCostoBase(double costoBase) { this.costoBase = costoBase; }
    public double getCostoPeso() { return costoPeso; }
    public void setCostoPeso(double costoPeso) { this.costoPeso = costoPeso; }
    public double getRecargoVolumen() { return recargoVolumen; }
    public void setRecargoVolumen(double recargoVolumen) { this.recargoVolumen = recargoVolumen; }
    public double getRecargoTipoEnvio() { return recargoTipoEnvio; }
    public void setRecargoTipoEnvio(double recargoTipoEnvio) { this.recargoTipoEnvio = recargoTipoEnvio; }
    public double getCostoSeguro() { return costoSeguro; }
    public void setCostoSeguro(double costoSeguro) { this.costoSeguro = costoSeguro; }
    public double getCostoTotal() { return costoTotal; }
    public void setCostoTotal(double costoTotal) { this.costoTotal = costoTotal; }
}
