package com.alura.imersaojava.connectapi;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConnectClient {
    public String apiData(String nameApi){
        HttpClient client = HttpClient.newHttpClient();

        try {
            String url = "https://imdb-api.com/pt/API/Top250Movies/k_66nya69w";
            URI uriConvert = URI.create(url);

            var request = HttpRequest.newBuilder(uriConvert).GET().build();
            var answerApi = client.send(request, HttpResponse.BodyHandlers.ofString());
            return answerApi.body();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
