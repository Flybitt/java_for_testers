package tests;

import io.qameta.allure.Allure;
import model.GroupData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Random;

public class GroupRemovalTests extends TestBase {


    @Test
    public void canRemoveGroup() {
        Allure.step("check precondition", step -> {
            if (app.hbm().getGroupCount() == 0) {
                app.hbm().createGroup(new GroupData("", "group_name", "group_header", "group_footer"));
            }
        });
        var oldGroups = app.hbm().getGroupList();
        var rnd = new Random();
        var index = rnd.nextInt(oldGroups.size());
        app.groups().removeGroup(oldGroups.get(index));
        var newGroups = app.hbm().getGroupList();
        var expectedList = new ArrayList<>(oldGroups);
        expectedList.remove(index);
        Allure.step("validate result", step -> {
            Assertions.assertEquals(newGroups.size(), oldGroups.size() -1);
        });
    }

    @Test
    void canRemoveAllGroupsAtOnce() {
        if (app.hbm().getGroupCount() == 0) {
            app.hbm().createGroup(new GroupData("", "group_name", "group_header", "group_footer"));
        }
        app.groups().removeAllGroups();
        Assertions.assertEquals(0, app.hbm().getGroupCount());
    }

}
