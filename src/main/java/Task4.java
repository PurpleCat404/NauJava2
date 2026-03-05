import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Iterator;

public class Task4 {

    public static void main(String[] args) throws Exception {

        String url = "https://httpbin.org/headers";

        String jsonResponse = sendRequest(url);

        printHeaderValues(jsonResponse);
    }

    public static String sendRequest(String url) throws Exception {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    public static void printHeaderValues(String json) throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        JsonNode root = mapper.readTree(json);
        JsonNode headers = root.get("headers");

        Iterator<JsonNode> values = headers.elements();

        StringBuilder result = new StringBuilder();

        while (values.hasNext()) {
            result.append(values.next().asText());

            if (values.hasNext()) {
                result.append(", ");
            }
        }

        System.out.println(result);
    }
}