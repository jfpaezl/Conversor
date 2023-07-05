package com.JuanFe.conversor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class ConversorMonedas {
    private String provider;
    private String base;
    private String date;
    private Map<String, Double> rates;

    // Getters

    public String getProvider() {
        return provider;
    }

    public String getBase() {
        return base;
    }

    public String getDate() {
        return date;
    }

    public Map<String, Double> getRates() {
        return rates;
    }



    //Metodo para hacer una peticion get
    public static String optenerRespuesta(String url) throws IOException {
        HttpURLConnection conectar = (HttpURLConnection) new URL(url).openConnection();
        conectar.setRequestMethod("GET");

        int responseCode = conectar.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(conectar.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            reader.close();
            return response.toString();
        } else {
            throw new IOException("Request failed with response code: " + responseCode);
        }
    }


}
