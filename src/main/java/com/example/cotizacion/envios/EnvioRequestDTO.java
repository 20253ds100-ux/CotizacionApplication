package com.example.cotizacion.envios;
import jakarta.validation.constraints.*;

public class EnvioRequestDTO {

    @NotBlank(message = "El cpdigo postal es obligatorio")
    @Pattern(regexp = "\\d{5}", message = "el codigo postal debe ser de 5 dígitos")
    private String codigoPostal;

    @NotNull(message = "El peso es obligatorio")
    @Positive(message = "El peso debe ser mayor a 0")
    private Double pesoKg;

    @NotNull(message = "El largo es obligatorio")
    @Positive(message = "El largo debe ser mayor a 0")
    private Double largoCm;

    @NotNull(message = "El ancho es obligatorio")
    @Positive(message = "El ancho debe ser mayor a 0")
    private Double anchoCm;

    @NotNull(message = "El alto es obligatorio")
    @Positive(message = "el alto debe ser mayor a 0")
    private Double altoCm;

    @NotNull(message = "El tipo de envio es obligatorio")
    private TipoEnvio tipoEnvio;

    @NotNull(message = "el valor  es obligatorio")
    @PositiveOrZero(message = "el valorno puede ser negativo")
    private Double valorDeclaratedo;

    public String getCodigoPostal() { return codigoPostal; }
    public void setCodigoPostal(String codigoPostal) { this.codigoPostal = codigoPostal; }
    public Double getPesoKg() { return pesoKg; }
    public void setPesoKg(Double pesoKg) { this.pesoKg = pesoKg; }
    public Double getLargoCm() { return largoCm; }
    public void setLargoCm(Double largoCm) { this.largoCm = largoCm; }
    public Double getAnchoCm() { return anchoCm; }
    public void setAnchoCm(Double anchoCm) { this.anchoCm = anchoCm; }
    public Double getAltoCm() { return altoCm; }
    public void setAltoCm(Double altoCm) { this.altoCm = altoCm; }
    public TipoEnvio getTipoEnvio() { return tipoEnvio; }
    public void setTipoEnvio(TipoEnvio tipoEnvio) { this.tipoEnvio = tipoEnvio; }
    public Double getValorDeclaratedo() { return valorDeclaratedo; }
    public void setValorDeclaratedo(Double valorDeclaratedo) { this.valorDeclaratedo = valorDeclaratedo; }
}