package utils;

import base.UserCreate;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CreateUser {
    @Step("Создаем пользователя через сервис")
    public static Response userCreateResponse(UserCreate userCreate) {
        return given()
                .header("Content-type", "application/json")
                .body(userCreate)
                .when()
                .post("https://stellarburgers.nomoreparties.site/api/auth/register");

    }

}


