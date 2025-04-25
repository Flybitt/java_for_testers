package ru.stqa.addressbook.generator;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import model.GroupData;
import ru.stqa.addressbook.generator.common.Common;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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


    public static void main(String[] args) throws IOException {
        var generator = new Generator();
        JCommander.newBuilder().addObject(generator).build().parse(args);
        generator.run();
    }

    private void run() throws IOException {
        var data = generate();
        save(data);
    }

    private void save(Object data) throws IOException {
        if ("json".equals(format)) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            var json = mapper.writeValueAsString(data);

            try (var writer = new FileWriter(ouptut)) {
                writer.write(json);
            }
        }
        if ("yaml".equals(format)) {
            ObjectMapper mapper = new YAMLMapper();
            mapper.writeValue(new File(ouptut), data);
        } if ("xml".equals(format)) {
            ObjectMapper mapper = new XmlMapper();
            mapper.writeValue(new File(ouptut), data);
        }else {
            throw new IllegalArgumentException("Незвестный формат данных " + format);
        }

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
