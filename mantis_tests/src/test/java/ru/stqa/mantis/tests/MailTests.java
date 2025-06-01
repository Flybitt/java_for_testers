package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailTests extends TestBase {

    @Test
    void canReceiveEmail() {
        var messages = app.mail().receive("user2@localhost", "password", Duration.ofSeconds(10));
        Assertions.assertEquals(1, messages.size());
        System.out.println(messages);
    }

    @Test
    void canDeleteMessagesInbox() {
        app.mail().drain("user2@localhost", "password");
    }

    @Test
    void canExtractUrl() {
        var messages = app.mail().receive("user2@localhost", "password", Duration.ofSeconds(10));
        var text = messages.get(0).content();
        Pattern pattern = Pattern.compile("http://\\s*");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            var url = text.substring(matcher.start(), matcher.end());
            System.out.println(url);
        }
    }
}
