package com.JuanFe.conversor;
import java.io.IOException;
//importar el metodo statico para llamar el api
import  static  com.JuanFe.conversor.ConversorMonedas.optenerRespuesta;
import com.google.gson.Gson;


public class Test {
    public static void main(String[] args) throws IOException {
        String respuesta = optenerRespuesta("https://api.exchangerate-api.com/v4/latest/USD");

        Gson gson = new Gson();

        ConversorMonedas response = gson.fromJson(respuesta, ConversorMonedas.class);
        System.out.println("USD buscar valor = " + response.getRates().get("USD"));
        System.out.println("Base: " + response.getBase());
        System.out.println("Date: " + response.getDate());

        // Imprimir las tasas
        System.out.println("Rates:");
        for (String currency : response.getRates().keySet()) {
            double rate = response.getRates().get(currency);
            System.out.println(currency + ": " + rate);
        }

    }
}
