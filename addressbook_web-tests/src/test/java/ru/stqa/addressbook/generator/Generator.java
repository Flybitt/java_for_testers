package ru.stqa.addressbook.generator;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import model.GroupData;
import ru.stqa.addressbook.generator.common.Common;

import java.util.ArrayList;
import java.util.List;

public class Generator {

    @Parameter(names = {"--type", "-t"})
    String type;

    @Parameter(names = {"--output", "-o"})
    String ouptut;

    @Parameter(names = {"--format", "-f"})
    String format;

    @Parameter(names = {"--count", "-c"})
    int count;


    public static void main(String[] args) {
        var generator = new Generator();
        JCommander.newBuilder().addObject(generator).build().parse(args);
        generator.run();
    }

    private void run() {
        var data = generate();
        save(data);
    }

    private void save(Object data) {

    }

    private Object generate() {
        if ("groups".equals(type)) {
            return generateGroups();
        } else if ("contacts".equals(type)) {
            return generateContacts();
        } else {
            throw new IllegalArgumentException("Неизвестный тип данных " + type);
        }
    }

    private Object generateGroups() {
        var result = new ArrayList<GroupData>(List.of());
        for (int i = 0; i < count; i++) {
            result.add(new GroupData()
                    .withName(Common.randomString(i * 10))
                    .withHeader(Common.randomString(i * 10))
                    .withFooter(Common.randomString(i * 10)));
        }
        return result;
    }

    private Object generateContacts() {
        return null;
    }
}
