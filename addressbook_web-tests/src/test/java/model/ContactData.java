package model;

public record ContactData(
        String id,
        String firstName,
        String middleName,
        String lastName,
        String nickName,
        String company,
        String address,
        String mobile,
        String work,
        String photo,
        String home,
        String secondary,
        String email,
        String email2,
        String email3, String title) {

    public ContactData() {
        this("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "");
    }

    public ContactData withAll() {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, this.nickName, this.company, this.address, this.mobile, this.work, this.photo, this.home, this.secondary, this.email, this.email2, this.email3, this.title);
    }

    public ContactData withId(String id) {
        return new ContactData(id, this.firstName, this.middleName, this.lastName, this.nickName, this.company, this.address, this.mobile, this.work, this.photo, this.home, this.secondary, this.email, this.email2, this.email3,  this.title);
    }

    public ContactData withFirstName(String firstName) {
        return new ContactData(this.id, firstName, this.middleName, this.lastName, this.nickName, this.company, this.address, this.mobile, this.work, this.photo, this.home, this.secondary, this.email, this.email2, this.email3,  this.title);
    }

    public ContactData withMiddleName(String middleName) {
        return new ContactData(this.id, this.firstName, middleName, this.lastName, this.nickName, this.company, this.address, this.mobile, this.work, this.photo, this.home, this.secondary, this.email, this.email2, this.email3,  this.title);
    }

    public ContactData withLastName(String lastName) {
        return new ContactData(this.id, this.firstName, this.middleName, lastName, this.nickName, this.company, this.address, this.mobile, this.work, this.photo, this.home, this.secondary, this.email, this.email2, this.email3,  this.title);
    }

    public ContactData withNickName(String nickName) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, nickName, this.company, this.address, this.mobile, this.work, this.photo, this.home, this.secondary, this.email, this.email2, this.email3,  this.title);
    }

    public ContactData withCompany(String company) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, this.nickName, company, this.address, this.mobile, this.work, this.photo, this.home, this.secondary, this.email, this.email2, this.email3,  this.title);
    }

    public ContactData withAddress(String address) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, this.nickName, this.company, address, this.mobile, this.work, this.photo, this.home, this.secondary, this.email, this.email2, this.email3,  this.title);
    }

    public ContactData withMobile(String mobile) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, this.nickName, this.company, this.address, mobile, this.work, this.photo, this.home, this.secondary, this.email, this.email2, this.email3,  this.title);
    }

    public ContactData withWork(String work) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, this.nickName, this.company, this.address, this.mobile, work, this.photo, this.home, this.secondary, this.email, this.email2, this.email3,  this.title);
    }

    public ContactData withPhoto(String photo) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, this.nickName, this.company, this.address, this.mobile, this.work, photo, this.home, this.secondary, this.email, this.email2, this.email3,  this.title);
    }

    public ContactData withHome(String home) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, this.nickName, this.company, this.address, this.mobile, this.work, this.photo, home, this.secondary, this.email, this.email2, this.email3,  this.title);
    }

    public ContactData withSecondary(String secondary) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, this.nickName, this.company, this.address, this.mobile, this.work, this.photo, this.home, secondary, this.email, this.email2, this.email3,  this.title);
    }

    public ContactData withEmail(String email) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, this.nickName, this.company, this.address, this.mobile, this.work, this.photo, this.home, this.secondary, email, this.email2, this.email3,  this.title);
    }

    public ContactData withEmail2(String email2) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, this.nickName, this.company, this.address, this.mobile, this.work, this.photo, this.home, this.secondary, this.email, email2, this.email3,  this.title);
    }

    public ContactData withEmail3(String email3) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, this.nickName, this.company, this.address, this.mobile, this.work, this.photo, this.home, this.secondary, this.email, this.email2, email3,  this.title);
    }

    public ContactData withTitle(String title) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, this.nickName, this.company, this.address, this.mobile, this.work, this.photo, this.home, this.secondary, this.email, this.email2, this.email3,  title);
    }

}
