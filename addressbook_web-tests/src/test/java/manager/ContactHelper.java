package manager;

import model.ContactData;
import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

public class ContactHelper extends HelperBase {

    public ContactHelper(ApplicationManager manager) {
        super(manager);
    }

    public void createContact(ContactData contact) {
        openContactCreationPage();
        fillContact(contact);
        submitContactCreation();
        clickTitle();
    }

    public void createContact(ContactData contact, GroupData group) {
        openContactCreationPage();
        fillContact(contact);
        selectGroupInCreateContact(group);
        submitContactCreation();
        clickTitle();
    }

    private void selectGroupInCreateContact(GroupData group) {
        new Select(manager.driver.findElement(By.name("new_group"))).selectByValue(group.id());
    }

    private void selectGroup(GroupData group) {
        new Select(manager.driver.findElement(By.name("group"))).selectByValue(group.id());
    }

    // почему-то иногда не срабатывает и вылетает на stale element reference: stale element not found
    private void openHomePage() {
        manager.driver.findElement(By.xpath("//a[contains(text(), 'home')]")).click();
    }

    private void clickTitle() {
        click(By.linkText("home page"));
    }

    private void submitContactCreation() {
        click(By.name("submit"));
    }

    private void submitUpdateContact() {
        click(By.name("update"));
    }

    private void fillContact(ContactData contact) {
        type(By.name("firstname"), contact.firstName());
        type(By.name("middlename"), contact.middleName());
        type(By.name("lastname"), contact.lastName());
        type(By.name("nickname"), contact.nickName());
        type(By.name("company"), contact.company());
        type(By.name("address"), contact.address());
        type(By.name("mobile"), contact.mobile());
        type(By.name("work"), contact.work());
    }

    private void openContactCreationPage() {
        manager.driver.findElement(By.xpath("//a[contains(text(), 'add new')]")).click();
    }

    public boolean isContactPresent() {
        openHomePage();
        return manager.isElementPresent(By.name("selected[]"));
    }

    public void removeContact(ContactData contact) {
        openHomePage();
        selectContact(contact);
        removeSelectedContact();
    }

    private void removeSelectedContact() {
        click(By.xpath("//*[@value=\"Delete\"]"));
    }

    private void selectContact(ContactData contact) {
        click(By.cssSelector(String.format("input[value=\"%s\"]", contact.id())));
    }

    public int getCount() {
        openHomePage();
        return manager.driver.findElements(By.name("selected[]")).size();
    }

    public void remmoveAllContacts() {
        openHomePage();
        selectAllContacts();
        removeSelectedContact();
    }

    private void selectAllContacts() {
        var checkboxes = manager.driver.findElements(By.name("selected[]"));
        for (var checkbox : checkboxes) {
            checkbox.click();
        }
    }

    public List<ContactData> getList() {
        openHomePage();
        var contacts = new ArrayList<ContactData>();
        var table = manager.driver.findElement(By.id("maintable"));
        // теперь ищем в таблице все элементы с именем класса = entry
        List<WebElement> trs = table.findElements(By.name("entry"));
        for (var tr : trs) {
            String lastName = tr.findElement(By.cssSelector("td:nth-child(2)")).getText();
            String firstName = tr.findElement(By.cssSelector("td:nth-child(3)")).getText();
            String address = tr.findElement(By.cssSelector("td:nth-child(4)")).getText();
            String emails = tr.findElement(By.cssSelector("td:nth-child(5)")).getText();
            var checkbox = tr.findElement(By.name("selected[]"));
            var id = checkbox.getAttribute("value");
            contacts.add(new ContactData().withId(id).withFirstName(firstName).withLastName(lastName).withAddress(address).withEmail(emails));
        }
        return contacts;
    }

    public void modifyContact(ContactData contact, ContactData modifyContact, int index) {
        openHomePage();
//        selectContact(contact);
        initContactModify(index);
        fillContact(modifyContact);
//        refreshPage();
        submitUpdateContact();
        clickTitle();
    }

    private void initContactModify(int index) {
        index = index + 2;
        click(By.cssSelector(String.format("#maintable > tbody > tr:nth-child(%s) > td:nth-child(8) > a > img", index)));
    }

    private void refreshPage() {
        manager.driver.navigate().refresh();
    }

    public void deleteContactFromGroup(ContactData contact, GroupData group) {
        removeContactFromGroup(contact, group);
    }

    public void removeContactFromGroup(ContactData contact, GroupData group) {
        openHomePage();
        selectGroup(group);
        selectContact(contact);
        clickRemoveContactFromGroup();
        openHomePage();
    }

    private void clickRemoveContactFromGroup() {
        manager.driver.findElement(By.name("remove")).click();
    }

    public void addContactToGroup(ContactData contact, GroupData group) {
        openHomePage();
        selectContact(contact);
        List<WebElement> selectOptions = manager.driver.findElements(By.cssSelector("#content > form:nth-child(10) > div.right > select > option"));
        for (WebElement option : selectOptions) {
            System.out.println(option);
            if (option.getText().equals(group.name())) {
                manager.driver.findElement(By.name("add")).click();
                break;
            }
            else {
                throw new RuntimeException("Группа не найдена в списке на добавление");
            }
        }
    }

    public String getPhones(ContactData contact) {
        return manager.driver.findElement(By.xpath(String.format("//input[@id='%s']/../../td[6]", contact.id()))).getText();
    }

    public String getContactPhones(ContactData contact) {
        String phones = null;
        List<WebElement> rows = manager.driver.findElements(By.name("entry"));
        for (WebElement row : rows) {
            if (Objects.equals(row.findElement(By.tagName("input")).getAttribute("id"), contact.id())) {
                phones = row.findElements(By.tagName("td")).get(5).getText();
            }
        }
        return phones;
    }

    public String getContactAddress(ContactData contact) {
        String address = null;
        List<WebElement> rows = manager.driver.findElements(By.name("entry"));
        for (WebElement row : rows) {
            if (Objects.equals(row.findElement(By.tagName("input")).getAttribute("id"), contact.id())) {
                address = row.findElements(By.tagName("td")).get(3).getText();
            }
        }
        return address;
    }


    public String getContactEmails(ContactData contact) {
        String emails = null;
        List<WebElement> rows = manager.driver.findElements(By.name("entry"));
        for (WebElement row : rows) {
            if (Objects.equals(row.findElement(By.tagName("input")).getAttribute("id"), contact.id())) {
                emails = row.findElements(By.tagName("td")).get(4).getText();
            }
        }
        return emails;
    }
}
