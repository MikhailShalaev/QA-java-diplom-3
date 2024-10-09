package utils;

import io.qameta.allure.Step;
import io.restassured.response.Response;

public class AccessTokenExtractor {
    @Step("Извлекаем токен из ответа метода регистрации")
    public static String extractAccessToken(Response response) {
        String accessToken = response.jsonPath().getString("accessToken");
        return accessToken;
    }
    @Step("Извлекаем токен из ответа метода авторизации")
    public static String extractAccessTokenFromLogin(Response response) {
        String accessToken = response.jsonPath().getString("accessToken");
        return accessToken;
    }
}

