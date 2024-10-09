package utils;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DeleteUser {
    @Step("Удаляем пользователя через сервис")
    public static Response deleteUserResponse(String accessToken) {
        return given()
                .header("authorization", accessToken)
                .when()
                .delete("https://stellarburgers.nomoreparties.site/api/auth/user");

    }
}
