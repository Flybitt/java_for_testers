package tests;

import model.ContactData;
import org.junit.jupiter.api.Test;

public class ContactCreationTests extends TestBase {

    @Test
    void canCreateContactWithFullName() {
        app.contacts().createContact(new ContactData().withFullName("first name", "middle name", "last name", "nickname"));
    }

    @Test
    void canCreateContactWithFirstName() {
        app.contacts().createContact(new ContactData().withFirstNameOnly("first name"));
    }


    @Test
    void canCreateEmptyContact() {
        app.contacts().createContact(new ContactData());
    }
}
