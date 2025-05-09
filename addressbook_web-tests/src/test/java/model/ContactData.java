package model;

import org.checkerframework.checker.units.qual.C;

public record ContactData(
        String id,
        String firstName,
        String lastName,
        String address,
        String photo) {

    public ContactData() {
        this("", "", "", "", "");
    }
    public ContactData withId(String id) {
        return new ContactData(id, this.firstName, this.lastName, this.address, this.photo);
    }

    public ContactData withFirstName(String firstName) {
        return new ContactData(this.id, firstName, this.lastName, this.address, this.photo);
    }

    public ContactData withLastName(String lastName) {
        return new ContactData(this.id, this.firstName, this.lastName, this.address, this.photo);
    }

    public ContactData withAll() {
        return new ContactData(this.id, this.firstName, this.lastName, this.address, this.address);
    }

    public ContactData withPhoto(String photo) {
        return new ContactData(this.id, this.firstName, this.lastName, this.address, photo);
    }

}
