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
        String secondary) {

    public ContactData() {
        this("", "", "", "", "", "", "", "", "", "", "", "");
    }

    public ContactData withAll() {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, this.nickName, this.company, this.address, this.mobile, this.work, this.photo, this.home, this.secondary);
    }

    public ContactData withId(String id) {
        return new ContactData(id, this.firstName, this.middleName, this.lastName, this.nickName, this.company, this.address, this.mobile, this.work, this.photo, this.home, this.secondary);
    }

    public ContactData withFirstName(String firstName) {
        return new ContactData(this.id, firstName, this.middleName, this.lastName, this.nickName, this.company, this.address, this.mobile, this.work, this.photo, this.home, this.secondary);
    }

    public ContactData withMiddleName(String middleName) {
        return new ContactData(this.id, this.firstName, middleName, this.lastName, this.nickName, this.company, this.address, this.mobile, this.work, this.photo, this.home, this.secondary);
    }

    public ContactData withLastName(String lastName) {
        return new ContactData(this.id, this.firstName, this.middleName, lastName, this.nickName, this.company, this.address, this.mobile, this.work, this.photo, this.home, this.secondary);
    }

    public ContactData withNickName(String nickName) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, nickName, this.company, this.address, this.mobile, this.work, this.photo, this.home, this.secondary);
    }

    public ContactData withCompany(String company) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, this.nickName, company, this.address, this.mobile, this.work, this.photo, this.home, this.secondary);
    }

    public ContactData withAddress(String address) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, this.nickName, this.company, address, this.mobile, this.work, this.photo, this.home, this.secondary);
    }

    public ContactData withMobile(String mobile) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, this.nickName, this.company, this.address, mobile, this.work, this.photo, this.home, this.secondary);
    }

    public ContactData withWork(String work) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, this.nickName, this.company, this.address, this.mobile, work, this.photo, this.home, this.secondary);
    }

    public ContactData withPhoto(String photo) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, this.nickName, this.company, this.address, this.mobile, this.work, photo, this.home, this.secondary);
    }

    public ContactData withHome(String home) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, this.nickName, this.company, this.address, this.mobile, this.work, this.photo, home, this.secondary);
    }

    public ContactData withSecondary(String secondary) {
        return new ContactData(this.id, this.firstName, this.middleName, this.lastName, this.nickName, this.company, this.address, this.mobile, this.work, this.photo, this.home, secondary);
    }

}
