package ru.stqa.mantis.manager;

import io.swagger.client.ApiClient;
import io.swagger.client.ApiException;
import io.swagger.client.Configuration;
import io.swagger.client.api.IssuesApi;
import io.swagger.client.api.UserApi;
import io.swagger.client.auth.ApiKeyAuth;
import io.swagger.client.model.Identifier;
import io.swagger.client.model.Issue;
import io.swagger.client.model.User;
import ru.stqa.mantis.model.IssueData;
import ru.stqa.mantis.model.UserData;


public class RestApiHelper extends HelperBase{

    public RestApiHelper(ApplicationManager manager) {
        super(manager);
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        ApiKeyAuth Authorization = (ApiKeyAuth) defaultClient.getAuthentication("Authorization");
        Authorization.setApiKey(manager.property("apiKey"));
        // Мантис стал очень долго отвечать на запрос создания пользователя, в стандартный таймаут не укладывался
        defaultClient.setReadTimeout(100_000);
    }

    public void createIssue(IssueData issueData) {
        IssuesApi apiIssuance = new IssuesApi();
        Issue issue = new Issue();
        issue.setSummary(issueData.summary());
        issue.setDescription(issueData.description());
        var projectId = new Identifier();
        projectId.setId(issueData.project());
        issue.setProject(projectId);
        var categoryId = new Identifier();
        categoryId.setId(issueData.category());
        issue.setCategory(categoryId);

        try {
            apiIssuance.issueAdd(issue);
        } catch (ApiException e ) {
            throw new RuntimeException(e);
        }
    }

    public void createUser(UserData newUser) {
        UserApi userApi = new UserApi();
        User user = new User();
        user.setUsername(newUser.username());
        user.setPassword(newUser.password());
        user.setEmail(newUser.email());
        user.setEnabled(newUser.enabled());
        System.out.println(user);
        try {
            userApi.userAdd(user);
        } catch (ApiException e) {
            System.err.println("Status code: " + e.getCode());
            System.err.println("Response body: " + e.getResponseBody());
            throw new RuntimeException("Failed to create user: " + e.getMessage(), e);
        }
    }
}
