package ru.stqa.mantis.manager;

import org.openqa.selenium.By;

public class RegistrationHelper extends HelperBase {
    public RegistrationHelper(ApplicationManager manager) {
        super(manager);
    }

    public void openLoginForm() {
        manager.driver().get(String.format("%s/login_page.php", manager.property("web.baseUrl")));
    }

    public void openSignUpForm() {
        openLoginForm();
        manager.driver().findElement(By.cssSelector("#login-box > div > div.toolbar.center > a")).click();
    }

    public void fillRegistrationData(String username, String email) {
        type(By.name("username"), username);
        type(By.name("email"), email);
        manager.driver().findElement(By.xpath("//fieldset/input[2]")).click();
    }

    public void fillUserData(String realName) {
        type(By.name("realname"), realName);
        type(By.name("password"), "password");
        type(By.name("password_confirm"), "password");
        manager.driver().findElement(By.tagName("button")).click();
    }

    public void loginUser(String username) {
        openLoginForm();
        type(By.name("username"), username);
        manager.driver().findElement(By.xpath("//fieldset/input[2]")).click();
        type(By.name("password"), "password");
        manager.driver().findElement(By.xpath("//fieldset/input[3]")).click();
    }

    public String loggedUser() {
        return manager.driver().findElement(By.xpath("//*[@id=\"navbar-container\"]/div[2]/ul/li/a/span")).getText();
    }
}
