package ru.stqa.mantis.manager;


import org.openqa.selenium.os.CommandLine;

import java.util.List;

public class JamesCliHelper extends HelperBase {
    public JamesCliHelper(ApplicationManager manager) {
        super(manager);
    }

    public void addUser(String email, String pass) {
        CommandLine cmd = new CommandLine("java", "-cp", "\"james-server-jpa-app.lib/*\"", "org.apache.james.cli.ServerCmd", "AddUser", email, pass);
        cmd.setWorkingDirectory(manager.property("james.workDir"));
        cmd.execute();
        cmd.waitFor();
        System.out.println(cmd.getStdOut());
    }

    public void delUser(String email) {
        CommandLine cmd = new CommandLine("java", "-cp", "\"james-server-jpa-app.lib/*\"", "org.apache.james.cli.ServerCmd", "RemoveUser", email);
        cmd.setWorkingDirectory(manager.property("james.workDir"));
        cmd.execute();
        cmd.waitFor();
        System.out.println(cmd.getStdOut());
    }
}
