import org.junit.jupiter.api.RepeatedTest;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class EndpointPerformanceTest {

    private final HttpClient client = HttpClient.newHttpClient();

    @RepeatedTest(10)
    void performanceTest() throws Exception {
        long start = System.currentTimeMillis();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://api.privatbank.ua/p24api/exchange_rates?date=01.12.2014"))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        long duration = System.currentTimeMillis() - start;

        System.out.println(Thread.currentThread().getName() + " took " + duration + "ms, status: " + response.statusCode());

        // Simple performance assertion
        assert duration < 500 : "Request took too long: " + duration + "ms";
        assert response.statusCode() == 200;
    }
}
