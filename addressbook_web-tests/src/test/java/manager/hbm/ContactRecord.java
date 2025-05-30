package manager.hbm;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "addressbook")
public class ContactRecord {

    @Id
    @Column(name = "id")
    public int id;

    @Column(name = "firstname")
    public String firstName;

    @Column(name = "middlename")
    public String middleName;

    @Column(name = "lastname")
    public String lastName;

    @Column(name = "nickname")
    public String nickName;

    @Column(name = "company")
    public String company;

    @Column(name = "address")
    public String address;

    @Column(name = "mobile")
    public String mobile;

    @Column(name = "work")
    public String work;

    @Column(name = "home")
    public String home;

    @Column(name = "phone2")
    public String phone2;

    @Column(name = "email")
    public String email;

    @Column(name = "email2")
    public String email2;

    @Column(name = "email3")
    public String email3;

    @Column(name = "title")
    public String title;

    public ContactRecord() {}

    public ContactRecord(int id, String firstName, String middleName, String lastName, String nickName, String company, String address, String mobile, String work, String home, String phone2, String email, String email2, String email3, String title) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.company = company;
        this.address = address;
        this.mobile = mobile;
        this.work = work;
        this.home = home;
        this.phone2 = phone2;
        this.email = email;
        this.email2 = email2;
        this.email3 = email3;
        this.title = title;
    }
}
