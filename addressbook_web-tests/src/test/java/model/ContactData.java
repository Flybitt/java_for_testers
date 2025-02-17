package model;

public record ContactData(String firstName, String middleName, String lastName, String nickName) {

    public ContactData() {
        this("", "", "", "");
    }

    public ContactData withFirstNameOnly(String firstName) {
        return new ContactData(firstName, this.middleName, this.lastName, this.nickName);
    }

    public ContactData withFullName(String firstName, String middleName, String lastName, String nickName) {
        return new ContactData(firstName, middleName, lastName, nickName);
    }
}
