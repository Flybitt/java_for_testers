package ru.stqa.mantis.tests;

import org.junit.jupiter.api.Test;
import ru.stqa.mantis.common.Common;
import ru.stqa.mantis.model.IssueData;

public class IssueCreationTests extends TestBase {

    @Test
    void canCreateIssueRest() {
        app.rest().createIssue(new IssueData()
                .withSummary(Common.randomString(10))
                .withDescription(Common.randomString(10))
                .withProject(1L));
    }

    @Test
    void canCreateIssueSoap() {
        app.soap().createIssue(new IssueData()
                .withSummary(Common.randomString(10))
                .withDescription(Common.randomString(10))
                .withProject(1L));
    }
}
