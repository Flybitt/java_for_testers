package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Test;
import ru.stqa.mantis.common.Common;

public class JamesTest extends TestBase {

    @Test
    public void canCreateUser() {
        app.jamesCli().addUser(String.format("%s@localhost", Common.randomString(8)), "password");
    }
}
