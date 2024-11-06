package com.elianisdev.ConversorMonedas;
import com.google.gson.annotations.SerializedName;

public class Resultado {
    @SerializedName("conversion_result")
    private double cantidad;
    @SerializedName("target_code")
    private String paisSalida;

    public Resultado(double cantidad, String paisSalida) {
        this.cantidad = cantidad;
        this.paisSalida = paisSalida;
    }

    public double getCantidad() {
        return cantidad;
    }

    public String getPaisSalida() {
        return paisSalida;
    }
}
