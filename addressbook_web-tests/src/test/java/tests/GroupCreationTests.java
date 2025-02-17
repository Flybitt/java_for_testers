import org.junit.jupiter.api.Test;


public class GroupCreationTests extends TestBase {


    @Test
    public void canCreateGroup() {
        app.openGroupsPage();
        app.createGroup("group_name", "group_header", "group_footer");
    }

    @Test
    public void canCreateGroupWithEmptyName() {
        app.openGroupsPage();
        app.createGroup("", "", "");
    }
}
