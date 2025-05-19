package tests;

import model.ContactData;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.stqa.addressbook.generator.common.Common;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {


    public static List<ContactData> contactProvider() {
        var result = new ArrayList<ContactData>(List.of());
        for (var firstName : List.of("", "first name")) {
            for (var middleName : List.of("", "middle name")) {
                for (var lastName : List.of("", "last name")) {
                    for (var nickName : List.of("", "nickname")) {
                        for (var company : List.of("", "company")) {
                            for (var address : List.of("", "address")) {
                                for (var mobile : List.of("", "mobile")) {
                                    for (var work : List.of("", "work")) {
                                        result.add(new ContactData()
                                                .withFirstName(firstName)
                                                .withMiddleName(middleName)
                                                .withLastName(lastName)
                                                .withNickName(nickName)
                                                .withCompany(company)
                                                .withAddress(address)
                                                .withMobile(mobile)
                                                .withWork(work));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            result.add(new ContactData()
                    .withFirstName(Common.randomString(i * 10))
                    .withMiddleName(Common.randomString(i * 10))
                    .withLastName(Common.randomString(i * 10))
                    .withNickName(Common.randomString(i * 10))
                    .withCompany(Common.randomString(i * 10))
                    .withAddress(Common.randomString(i * 10))
                    .withMobile(Common.randomString(i * 10))
                    .withWork(Common.randomString(i * 10)));
        }
//        ObjectMapper mapper = new ObjectMapper();
//        var value = mapper.readValue(new File("contact.json"), new TypeReference<List<ContactData>>() {});
//        result.addAll(value);
        return result;
    }

    public static List<ContactData> negativeContactProvider() {
        return new ArrayList<ContactData>(List.of(
                new ContactData("", "first name'", "", "", "", "", "", "", "", "")));
    }

    @ParameterizedTest
    @MethodSource("contactProvider")
    public void canCreateMultipleContacts(ContactData contact) {
        var oldContacts = app.hbm().getContactList();
        app.contacts().createContact(contact);
        var newContacts = app.hbm().getContactList();
        Comparator<ContactData> compareById = (o1, o2) -> Integer.compare(Integer.parseInt(o1.id()), Integer.parseInt(o2.id()));
        newContacts.sort(compareById);
        var expectedList = new ArrayList<>(oldContacts);
        var previousContact = newContacts.get(newContacts.size() - 1);
        expectedList.add(contact
                .withId(previousContact.id())
                .withFirstName(previousContact.firstName())
                .withMiddleName(previousContact.middleName())
                .withLastName(previousContact.lastName())
                .withNickName(previousContact.nickName())
                .withCompany(previousContact.company())
                .withAddress(previousContact.address())
                .withMobile(previousContact.mobile())
                .withWork(previousContact.work()));
        expectedList.sort(compareById);
        Assertions.assertEquals(expectedList, newContacts);
    }

    @ParameterizedTest
    @MethodSource("negativeContactProvider")
    public void cannotCreateMultipleContacts(ContactData contact) {
        var oldContacts = app.hbm().getContactList();
        app.contacts().createContact(contact);
        var newContacts = app.hbm().getContactList();
        Assertions.assertEquals(newContacts, oldContacts);
    }

    @Test
    public void canCreateContact() {
        var contact = new ContactData()
                .withFirstName("first name")
                .withMiddleName("middle name")
                .withLastName("last name")
                .withNickName("nickname")
                .withCompany("company")
                .withAddress("address")
                .withMobile("mobile")
                .withWork("work")
                .withPhoto(randomFile("src/test/resources/images/"));
        app.contacts().createContact(contact);

    }

    @Test
    public void canCreateContactInGroup() {
        var contact = new ContactData()
                .withFirstName(Common.randomString(10))
                .withLastName(Common.randomString(10))
                .withPhoto(randomFile("src/test/resources/images/"));
        if (app.hbm().getGroupCount() == 0) {
            app.hbm().createGroup(new GroupData("", "group_name", "group_header", "group_footer"));
        }
        var group = app.hbm().getGroupList().get(0);
        var oldRelated = app.hbm().getContactsInGroup(group);
        app.contacts().createContact(contact, group);
        var newRelated = app.hbm().getContactsInGroup(group);
        Assertions.assertEquals(oldRelated.size() + 1, newRelated.size());
    }

    @Test
    public void canDeleteContactFromGroup() {
        var contact = new ContactData()
                .withFirstName(Common.randomString(10))
                .withLastName(Common.randomString(10));

        if (app.hbm().getGroupCount() == 0) {
            app.hbm().createGroup(new GroupData("", "group_name", "group_header", "group_footer"));
        }

        var group = app.hbm().getGroupList().get(0);

        if (app.hbm().getContactsCount() == 0) {
            app.hbm().createContact(contact);
        }

        if (app.hbm().getContactsInGroup(group).isEmpty()) {
            app.contacts().createContact(contact, group);
        }
        else {
            contact = app.hbm().getContactsInGroup(group).get(0);
            app.contacts().deleteContactFromGroup(contact, group);
        }
    }
}
