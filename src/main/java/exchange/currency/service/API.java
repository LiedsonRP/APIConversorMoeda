package exchange.currency.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class API {

    public String getData(String url) {
        
        HttpClient client = HttpClient.newHttpClient(); //cria um cliente http

        HttpRequest request = HttpRequest.newBuilder() //configura a request a ser feita
            .uri(URI.create(url))
            .build();

        HttpResponse<String> response = null; //recebe a resposta da request

        try {
            response = client.
                send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String json = response.body();
        return json;
        
    }
    
}
