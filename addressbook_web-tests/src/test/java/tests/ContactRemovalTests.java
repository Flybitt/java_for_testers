package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

public class ContactRemovalTests extends TestBase {

    @Test
    void canDeleteContact() {
        if (app.hbm().getContactsCount() == 0) {
            app.contacts().createContact(new ContactData().withAll());
        }
        var oldContacts = app.hbm().getContactList();
        var rnd = new Random();
        var index = rnd.nextInt(oldContacts.size());
        app.contacts().removeContact(oldContacts.get(index));
        var newContacts = app.hbm().getContactList();
        var expectedList = new ArrayList<>(oldContacts);
        expectedList.remove(index);
        Assertions.assertEquals(newContacts.size(), oldContacts.size() - 1);
    }

    @Test
    void canRemoveAllContactsAtOnce() {
        if (app.contacts().getCount() == 0) {
            app.contacts().createContact(new ContactData("","first name", "last name", "address", "", "", "", "", "", ""));
        }
        app.contacts().remmoveAllContacts();
        var exptectedList = new ArrayList<>();
        Assertions.assertEquals(exptectedList, app.contacts().getList());
    }
}
