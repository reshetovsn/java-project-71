package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import hexlet.code.Formats.Stylish;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Differ {
    private static ObjectMapper mapper;
    public static String generate(String filepath1, String filepath2, String format) throws Exception {

        Path absPath1 = Paths.get(filepath1).toAbsolutePath().normalize();
        Path absPath2 = Paths.get(filepath2).toAbsolutePath().normalize();
        String content1 = Files.readString(absPath1);
        String content2 = Files.readString(absPath2);
        if (filepath1.contains(".json")) {
            mapper = new ObjectMapper();
        } else if (filepath1.contains(".yaml") || filepath1.contains(".yml")) {
            mapper = new ObjectMapper(new YAMLFactory());
        }
        Map<String, Object> mapA = new HashMap<>();
        try {
            mapA = mapper.readValue(content1, Map.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Map<String, Object> mapB = new HashMap<>();
        try {
            mapB = mapper.readValue(content2, Map.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return switch (format) {
            case "stylish" -> Stylish.makeStylish(mapA, mapB);
            default -> throw new Exception("Wrong format: " + format);
        };
    }
}
