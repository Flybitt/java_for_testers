package tests;

import model.ContactData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;

public class ContactCreationTests extends TestBase {


    public static List<ContactData> contactProvider() {
        var result = new ArrayList<ContactData>(List.of());
        for (var name : List.of("", "first name")) {
            for (var middleName : List.of("", "middle name")) {
                for (var lastName : List.of("", "last name")) {
                    for (var nickName : List.of("", "nickname")) {
                        result.add(new ContactData(name, middleName, lastName, nickName));
                    }
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            result.add(new ContactData(randomString(i * 2), randomString(i * 2), randomString(i * 2), randomString(i * 2)));
        }
        return result;
    }

    public static List<ContactData> negativeContactProvider() {
        var result = new ArrayList<ContactData>(List.of(
                new ContactData("first name'", "", "", "")));
        return result;
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultipleContacts(ContactData contact) {
        int contactCount = app.contacts().getCount();
        app.contacts().createContact(contact);
        int newContactCount = app.contacts().getCount();
        Assertions.assertEquals(contactCount + 1, newContactCount);
    }

    @ParameterizedTest
    @MethodSource("negativeContactProvider")
    public void cannotCreateMultipleContacts(ContactData contact) {
        int contactCount = app.contacts().getCount();
        app.contacts().createContact(contact);
        int newContactCount = app.contacts().getCount();
        Assertions.assertEquals(contactCount, newContactCount);
    }
}
