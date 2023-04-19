package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.util.HashMap;
import java.util.Map;

public class Parser {
    public static Map<String, Object> makeParsing(String stringToDir, String content) throws Exception {
        Map<String, Object> map = new HashMap<>();
        ObjectMapper mapper;
        if (stringToDir.contains(".json")) {
            mapper = new ObjectMapper();
            map = mapper.readValue(content, Map.class);
        } else if (stringToDir.contains(".yaml") || stringToDir.contains(".yml")) {
            mapper = new ObjectMapper(new YAMLFactory());
            map = mapper.readValue(content, Map.class);
        }
        return map;
    }
}
