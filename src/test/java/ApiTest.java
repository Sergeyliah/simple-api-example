import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import io.qameta.allure.restassured.AllureRestAssured;
import java.util.Arrays;

@Slf4j
public class ApiTest {
    @Test
    public void testGetUserDetails_UsingAssertableResponse() {
        log.info("Test started");
        RestAssured.baseURI = "https://api.privatbank.ua/p24api";
        int exchange = 5;
        RestAssured
                .given()
                .filters(Arrays.asList(new RequestLoggingFilter(), new ResponseLoggingFilter(), new AllureRestAssured()))
                .basePath("/pubinfo")
                .param("exchange&coursid", exchange)
                .when()
                .get()
                .then().statusCode(200);
    }
}
