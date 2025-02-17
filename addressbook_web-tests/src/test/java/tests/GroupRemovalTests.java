import org.junit.jupiter.api.Test;

public class GroupRemovalTests extends TestBase {


    @Test
    public void canRemoveGroup() {
        app.openGroupsPage();
        if (!app.isGroupPresent()) {
            app.createGroup("group_name", "group_header", "group_footer");
        }
        app.removeGroup();
    }

}
