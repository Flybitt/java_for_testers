package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.stqa.mantis.common.Common;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserRegTests extends TestBase {

    public static List<String> usernameProvider() {
        return new ArrayList<>(List.of(Common.randomString(5)));
    }

    public void removeEmail(String email) {
        app.jamesCli().delUser(email);
    }

    @ParameterizedTest
    @MethodSource("usernameProvider")
    void canRegisterNewUser(String username) {
        var email = String.format("%s@localhost", username);
        System.out.println(email);
        app.jamesCli().addUser(email, "password");
        app.userReg().openSignUpForm();
        app.userReg().fillRegistrationData(username, email);
        var messages = app.mail().receive(email, "password", Duration.ofSeconds(5));
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
        app.userReg().fillUserData(username);
        app.userReg().loginUser(username);
        Assertions.assertEquals(app.userReg().loggedUser(), username);
        removeEmail(email);
    }
}
