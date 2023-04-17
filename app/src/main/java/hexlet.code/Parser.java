package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Parser {
    public static Map<String, Object> makeParsing(String filepath) throws Exception {
        Path absPath = Paths.get(filepath).toAbsolutePath().normalize();
        String content = Files.readString(absPath);

        Map<String, Object> map = new HashMap<>();
        ObjectMapper mapper;
        if (filepath.contains(".json")) {
            mapper = new ObjectMapper();
            map = mapper.readValue(content, Map.class);
        } else if (filepath.contains(".yaml") || filepath.contains(".yml")) {
            mapper = new ObjectMapper(new YAMLFactory());
            map = mapper.readValue(content, Map.class);
        }
        return map;
    }
}