package hexlet.code.Formatters;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Map;

public class Json {
    public static String makeJson(List<Map<String, Object>> diffMap) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String result = "";
        result = mapper.writeValueAsString(Stylish.makeStylish(diffMap));
        return result.trim();
    }
}
