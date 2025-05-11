import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import io.qameta.allure.restassured.AllureRestAssured;

public class ApiTest {
    @Test
    public void testGetUserDetails_UsingAssertableResponse() {
        RestAssured.baseURI = "https://api.privatbank.ua/p24api";
        int exchange = 5;
        RestAssured
                .given()
                .filter(new AllureRestAssured())
                .basePath("/pubinfo")
                .param("exchange&coursid", exchange)
                .when()
                .get()
                .then().statusCode(200);
    }
}
