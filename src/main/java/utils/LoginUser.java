package utils;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
public class LoginUser {
    @Step("Авторизуем пользователя через сервис для получения токена")
     public static Response userLoginResponseFromString(String email, String password) {
        String requestBody = "{\"email\":\"" + email + "\",\"password\":\"" + password + "\"}";
        return given()
                .header("Content-type", "application/json")
                .body(requestBody)
                .when()
                .post("https://stellarburgers.nomoreparties.site/api/auth/login");

    }}
