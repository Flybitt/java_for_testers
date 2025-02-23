package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContactRemovalTests extends TestBase {

    @Test
    void canDeleteContact() {
        if (!app.contacts().isContactPresent()) {
            app.contacts().createContact(new ContactData().withFirstNameOnly("first name"));
        }
        app.contacts().removeContact();
    }

    @Test
    void canRemoveAllContactsAtOnce() {
        if (app.contacts().getCount() == 0) {
            app.contacts().createContact(new ContactData("first name", "middle name", "last name", "nickname"));
        }
        app.contacts().remmoveAllContacts();
        Assertions.assertEquals(0, app.contacts().getCount());
    }
}
