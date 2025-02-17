import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;

public class TestBase {

    protected static ApplicationManager app;

    @BeforeEach
    public void setUp() {
        if (app == null) {
            app = new ApplicationManager();
        }
        app.init();
    }

}
