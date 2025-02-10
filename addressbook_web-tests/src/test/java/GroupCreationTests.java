import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


public class GroupCreationTests {
    private static WebDriver driver;

    @BeforeEach
    public void setUp() {
        if (driver == null) {
            driver = new ChromeDriver();
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
            driver.get("http://localhost/addressbook/");
            driver.manage().window().setSize(new Dimension(1440, 1282));
            driver.findElement(By.name("user")).sendKeys("admin");
            driver.findElement(By.name("pass")).sendKeys("secret");
            driver.findElement(By.id("LoginForm")).click();
            driver.findElement(By.name("pass")).sendKeys(Keys.ENTER);
        }
    }


    @Test
    public void canCreateGroup() {
        if (!isElementPresent(By.name("new"))) {
            driver.findElement(By.linkText("groups")).click();
        }
        driver.findElement(By.linkText("groups")).click();
        driver.findElement(By.name("new")).click();
        driver.findElement(By.name("group_name")).click();
        driver.findElement(By.name("group_name")).sendKeys("group name");
        driver.findElement(By.name("group_header")).sendKeys("group header");
        driver.findElement(By.name("group_footer")).sendKeys("group footer");
        driver.findElement(By.name("submit")).click();
        driver.findElement(By.linkText("groups")).click();
        driver.findElement(By.cssSelector("body")).click();
    }

    private boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            return false;
        }
    }

    @Test
    public void canCreateGroupWithEmptyName() {
        if (!isElementPresent(By.name("new"))) {
            driver.findElement(By.linkText("groups")).click();
        }
        driver.findElement(By.linkText("groups")).click();
        driver.findElement(By.name("new")).click();
        driver.findElement(By.name("group_name")).click();
        driver.findElement(By.name("group_name")).sendKeys("group name");
        driver.findElement(By.name("group_header")).sendKeys("group header");
        driver.findElement(By.name("group_footer")).sendKeys("group footer");
        driver.findElement(By.name("submit")).click();
        driver.findElement(By.linkText("groups")).click();
    }
}
