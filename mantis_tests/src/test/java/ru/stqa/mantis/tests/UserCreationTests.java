package ru.stqa.mantis.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.stqa.mantis.common.Common;
import ru.stqa.mantis.model.UserData;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserCreationTests extends TestBase {

    public static List<String> usernameProvider() {
        return new ArrayList<>(List.of(Common.randomString(5)));
    }

    String pass = "password";

    String email = "test@localhost";

    @AfterEach
    void cleanTestEmail() {
        app.mail().drain(email, pass);
        app.jamesApi().deleteUser(email);
    }

    @ParameterizedTest
    @MethodSource("usernameProvider")
    void canCreateUser(String username) {
        app.jamesApi().addUser(email, pass);

        UserData user = new UserData().withUsername(username).withPass(pass).withEmail(email).withEnabled(true);
        app.rest().createUser(user);

        var messages = app.mail().receive(email, pass, Duration.ofSeconds(5));
        var text = messages.get(0).content();
        Pattern pattern = Pattern.compile("http://\\S*");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            var url = text.substring(matcher.start(), matcher.end());
            app.driver().get(url);
        }
        else {
            System.out.println("В полученном сообщении, не найдена ссылка");
        }

        app.userReg().fillUserData(username, pass);
        app.userReg().loginUser(username);
        Assertions.assertEquals(app.userReg().loggedUser(), username);
    }
}
