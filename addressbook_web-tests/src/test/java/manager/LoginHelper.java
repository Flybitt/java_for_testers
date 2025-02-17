package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class LoginHelper extends HelperBase {

    public LoginHelper(ApplicationManager manager) {
        super(manager);
    }

    void login(String user, String password) {
        type(By.name("user"), user);
        type(By.name("pass"), password);
        click(By.cssSelector("#LoginForm > input[type=submit]"));
    }
}
