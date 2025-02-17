package manager;

import model.ContactData;
import org.openqa.selenium.By;

public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void createContact(ContactData contact) {
        openContactPage();
        fillContact();
        submitContactCreation();
        openHomePage();
    }

    private void openHomePage() {
        manager.driver.findElement(By.xpath("//a[contains(text(), 'home')]")).click();
    }

    private void submitContactCreation() {
        click(By.name("submit"));
    }

    private void fillContact() {
        type(By.name("firstname"), "firstname");
        type(By.name("middlename"), "middlename");
        type(By.name("lastname"), "lastname");
        type(By.name("nickname"), "nickname");
    }

    private void openContactPage() {
        manager.driver.findElement(By.xpath("//a[contains(text(), 'add new')]")).click();
    }

    public boolean isContactPresent() {
        openHomePage();
        return manager.isElementPresent(By.name("selected[]"));
    }

    public void removeContact() {
        openHomePage();
        selectContact();
        removeSelectedContact();
    }

    private void removeSelectedContact() {
        click(By.xpath("//*[@value=\"Delete\"]"));
    }

    private void selectContact() {
        click(By.name("selected[]"));
    }
}
