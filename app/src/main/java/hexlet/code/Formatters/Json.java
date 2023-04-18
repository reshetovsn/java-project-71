package hexlet.code.Formatters;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.Map;

public class Json {
    public static String makeJson(List<Map<String, Object>> difference) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String result = mapper.writeValueAsString(Stylish.makeStylish(difference));
        return result.trim();
    }
}
