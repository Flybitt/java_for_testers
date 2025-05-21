package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.stqa.addressbook.generator.common.Common;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContactInfoTests extends TestBase {

    final ContactData contact = new ContactData("",
            Common.randomString(5),
            Common.randomString(5),
            Common.randomString(5),
            Common.randomString(5),
            Common.randomString(5),
            Common.randomString(5),
            Common.randomString(5),
            Common.randomString(5),
            "",
            Common.randomString(5),
            Common.randomString(5),
            Common.randomString(5),
            Common.randomString(5),
            Common.randomString(5), "");

    @BeforeEach
    void checkContacts() {
        if (app.hbm().getContactsCount() == 0) {
            app.hbm().createContact(contact);
        }
    }

    @Test
    void testPhones() {
        var contacts = app.contacts().getList();
        var homePageInfo = app.contacts().getContactPhones(contacts.get(0));
        var expectedInfo = Stream.of(contacts.get(0).mobile(), contacts.get(0).work(), contacts.get(0).home(), contacts.get(0).secondary())
                .filter(s -> s != null && !"".equals(s))
                .collect(Collectors.joining("\n"));
        Assertions.assertEquals(expectedInfo, homePageInfo);
    }

    @Test
    void testAddress() {
        var contacts = app.contacts().getList();
        var homePageInfo = app.contacts().getContactAddress(contacts.get(0));
        var expectedInfo = Stream.of(contacts.get(0).address())
                .filter(s -> s != null && !"".equals(s))
                .collect(Collectors.joining("\n"));
        Assertions.assertEquals(expectedInfo, homePageInfo);
    }

    @Test
    void testEmails() {
        var contacts = app.contacts().getList();
        var homePageInfo = app.contacts().getContactEmails(contacts.get(0));
        var expectedInfo = Stream.of(contacts.get(0).email(), contacts.get(0).email2(), contacts.get(0).email3())
                        .filter(s -> s != null && !"".equals(s))
                        .collect(Collectors.joining("\n"));
        Assertions.assertEquals(expectedInfo, homePageInfo);
    }
}