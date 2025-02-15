import org.junit.jupiter.api.Test;


public class GroupCreationTests extends TestBase {


    @Test
    public void canCreateGroup() {
        openGroupsPage();
        createGroup("group_name", "group_header", "group_footer");
    }

    @Test
    public void canCreateGroupWithEmptyName() {
        openGroupsPage();
        createGroup("", "", "");
    }
}
