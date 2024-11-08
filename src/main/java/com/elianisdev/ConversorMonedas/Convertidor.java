package com.elianisdev.ConversorMonedas;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Convertidor {

    /**
     * Utilizamos la variable de entorno establecida para poder consultar la API
     */
    public static final String API_KEY = System.getenv("EXCHANGE_RATE_API_KEY");

    String url_api = "https://v6.exchangerate-api.com/v6/"+API_KEY+"/pair/";

    private int cantidad;
    private String primerPais;
    private String segundoPais;

    public Convertidor(String s, int i, String s1, String s2) {
    }

    /**
     * Constructor de la clase
     */
    public void Convertidor(String url_api, int cantidad, String paisEntrada, String paisSalida){
        this.cantidad = cantidad;
        this.primerPais = paisEntrada;
        this.segundoPais = paisSalida;
    }

    /**
     * Este metodo se encarga de realizar la conversión
     * consultando la API de acuerdo con la operación escogida
     * por el usuario y el monto establecido.
     */
    public String conversion() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(this.url_api + getPrimerPais() +
                                "/" + getSegundoPais() + "/" + getCantidad()))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        Gson gson = new Gson();
        Resultado results = gson.fromJson(response.body(), Resultado.class);
        return "El Resultado es " + getCantidad() + " " + getPrimerPais() + " a " +
                getSegundoPais() + " es: " + results.getCantidad() + " " +results.getPaisSalida();
    }

    /**
     * Getters and setters
     *
     */
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getPrimerPais() {
        return primerPais;
    }

    public void setPrimerPais(String primerPais) {
        this.primerPais = primerPais;
    }

    public String getSegundoPais() {
        return segundoPais;
    }

    public void setSegundoPais(String segundoPais) {
        this.segundoPais = segundoPais;
    }
}
