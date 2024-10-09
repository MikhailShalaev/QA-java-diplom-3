package utils;
import base.UserCreate;
import com.github.javafaker.Faker;
import io.qameta.allure.Step;

public class RandomUserGenerator {
    static Faker faker = new Faker();
    public  static String randomName = faker.name().toString();
    public static String randomEmail = faker.internet().emailAddress();
    public static String randomPasswordInRange = faker.internet().password(6, 12);
    public static String randomPasswordOutOfRange = faker.internet().password(1, 5);

    @Step("Создаем произвольного пользователя для регистрации через сервис")
    public static UserCreate createRandomUser() {

        return new UserCreate(randomEmail, randomPasswordInRange, randomName);
    }

    }
