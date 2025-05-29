package ru.stqa.mantis.manager;


import org.openqa.selenium.io.CircularOutputStream;
import org.openqa.selenium.os.CommandLine;

public class JamesCliHelper extends HelperBase {
    public JamesCliHelper(ApplicationManager manager) {
        super(manager);
    }

    public void addUser(String email, String pass) {
        CommandLine cmd = new CommandLine("java", "-cp", "\"james-server-jpa-app.lib/*\"", "org.apache.james.cli.ServerCmd", "AddUser", email, pass);
        cmd.setWorkingDirectory(manager.property("james.workDir"));
        CircularOutputStream outputStream = new CircularOutputStream();
        cmd.copyOutputTo(outputStream);
        cmd.execute();
        cmd.waitFor();
    }
}
