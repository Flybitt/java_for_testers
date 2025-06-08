package ru.stqa.mantis.manager;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;

public class ApplicationManager {

    private WebDriver driver;

    private Properties properties;

    private String string;

    private SessionHelper sessionHelper;

    private HttpSessionHelper httpSessionHelper;

    private JamesCliHelper jamesCliHelper;

    private MailHelper mailHelper;

    private RegistrationHelper userRegHelper;

    private JamesApiHelper jamesApiHelper;

    private RestApiHelper restApiHelper;

    private SoapApiHelper soapApiHelper;

    public void init(String browser, Properties properties) {
        this.string = browser;
        this.properties = properties;
    }


    public WebDriver driver() {
        if (driver == null) {
            if ("firefox".equals(string)) {
                driver = new FirefoxDriver();
            } else if ("chrome".equals(string)) driver = new ChromeDriver();
            else {
                throw new IllegalArgumentException(String.format("Unkown browser %s", string));
            }
            Runtime.getRuntime().addShutdownHook(new Thread(driver::quit));
            driver.get(properties.getProperty("web.baseUrl"));
            driver.manage().window().setSize(new Dimension(1440, 1282));
        }
        return driver;
    }

    public SessionHelper session() {
        if (sessionHelper == null) {
            sessionHelper = new SessionHelper(this);
        }
        return sessionHelper;
    }

    public HttpSessionHelper http() {
        if (httpSessionHelper == null) {
            httpSessionHelper = new HttpSessionHelper(this);
        }
        return httpSessionHelper;
    }

    public String property(String name) {
        return properties.getProperty(name);
    }

    public JamesCliHelper jamesCli() {
        if (jamesCliHelper == null) {
            jamesCliHelper = new JamesCliHelper(this);
        }
        return jamesCliHelper;
    }

    public MailHelper mail() {
        if (mailHelper == null) {
            mailHelper = new MailHelper(this);
        }
        return mailHelper;
    }

    public RegistrationHelper userReg() {
        if (userRegHelper == null) {
            userRegHelper = new RegistrationHelper(this);
        }
        return userRegHelper;
    }

    public JamesApiHelper jamesApi() {
        if (jamesApiHelper == null) {
            jamesApiHelper = new JamesApiHelper(this);
        }
        return jamesApiHelper;
    }

    public RestApiHelper rest() {
        if (restApiHelper == null) {
            restApiHelper = new RestApiHelper(this);
        }
        return restApiHelper;

    }

    public SoapApiHelper soap() {
        if (soapApiHelper == null) {
            soapApiHelper = new SoapApiHelper(this);
        }
        return soapApiHelper;

    }
}
