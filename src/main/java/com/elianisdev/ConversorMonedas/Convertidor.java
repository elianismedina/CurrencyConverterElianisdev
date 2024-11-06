package com.elianisdev.ConversorMonedas;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Convertidor {
    String url_api = "https://v6.exchangerate-api.com/v6/d710fbe52f341e65337bbaba/pair/";
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
     *Esta función se encarga de crear la petición a la API con los datos seleccionados en el menú de opciones en el Main.
     * @return Es un String que contiene la información devuelta en formato JSON por la API.
     * Esto incluye la cantidad a convertir junto con el país de origen y la cantidad equivalente
     * en la moneda del país de destino.
     *
     */
    public String conversion() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(this.url_api + getPrimerPais() +
                        "/"+ getSegundoPais() + "/" + String.valueOf(getCantidad())))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        Gson gson = new Gson();
        Resultado results = gson.fromJson(response.body(), Resultado.class);
        return "El Resultado es " + getCantidad() + " " + getPrimerPais() + " a " +
                getSegundoPais() + " es: " + results.getCantidad() + " " +results.getPaisSalida();
    }


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