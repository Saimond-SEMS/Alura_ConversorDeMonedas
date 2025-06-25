import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

/**
 * ParseJson
 */
public class ParseJson {

    public static ExchangeRate askExchangeRate(String _apiKey, String _code) {

        _code.toUpperCase();

        URI dir = URI.create("https://v6.exchangerate-api.com/v6/" + _apiKey + "/latest/" + _code );
        Gson gson = new Gson();

        HttpClient client = HttpClient.newHttpClient( );
        HttpRequest request = HttpRequest.newBuilder().uri(dir).build( );
        HttpResponse<String> response = null;
        
        try {
            response = client.send( request, HttpResponse.BodyHandlers.ofString() );
        } catch ( IOException | InterruptedException e ) {
            throw new RuntimeException("Null response");
        }

        // return exchange;
        return gson.fromJson(response.body(), ExchangeRate.class);
    }
}