package manager;

import manager.hbm.GroupRecord;
import model.GroupData;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class HibernateHelper extends HelperBase {

    private SessionFactory sessionFactory;

    public HibernateHelper(ApplicationManager manager) {
        super(manager);

        sessionFactory = new Configuration()
                .addAnnotatedClass(GroupRecord.class)
                .setProperty(AvailableSettings.URL, "jdbc:mysql://localhost/addressbook")
                .setProperty(AvailableSettings.USER, "root")
                .setProperty(AvailableSettings.PASS, "")
                .buildSessionFactory();
    }

    static List<GroupData> convertList(List<GroupRecord> records) {
        List<GroupData> res = new ArrayList<>();
        for (var record : records) {
            res.add(convert(record));
        }
        return res;
    }

    private static GroupData convert(GroupRecord record) {
        return new GroupData("" + record.id, record.name, record.header, record.footer);
    }

    public List<GroupData> getGroupList() {
        return convertList(sessionFactory.fromSession(session -> {
            return session.createQuery("from GroupRecord", GroupRecord.class).list();
        }));
    }
}
