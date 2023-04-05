package ru.ubrr;

import io.restassured.http.Header;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ru.ubrr.models.Forecast;

import java.util.List;

import static io.restassured.RestAssured.*;

public class YandexWeatherTest {

    String yandexWeatherKey;
    String yandexUrl;
    double lat;
    double lon;
    int limit;

    @BeforeTest
    public void setup() {
        yandexUrl ="https://api.weather.yandex.ru/v2/forecast";
        yandexWeatherKey = "a49998ad-a704-4ebe-bc97-f7ef9ef87594";
        lat = 55.75396;
        lon = 37.620393;
        limit = 7;
    }
    @Test
    public void yandexWeatherGetWindPowerForSevenDays() {
        Header yandexKey = new Header("X-Yandex-API-Key", yandexWeatherKey);
        List<Forecast> list =
        given()
                .header(yandexKey)
                .contentType("application/json")
                .param("lat", lat)
                .param("lon", lon)
                .param("limit", limit)
                .get("https://api.weather.yandex.ru/v2/forecast")
                .then()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .getList("forecasts", Forecast.class);
        list.forEach(x -> System.out.println(x.parts.day_short.wind_speed));
    }

}
