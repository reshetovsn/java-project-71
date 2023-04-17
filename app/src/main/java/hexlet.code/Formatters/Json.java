package hexlet.code.Formatters;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;


public class Json {
    public static String makeJson(Map<String, Object> mapA, Map<String, Object> mapB) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String result = "";
        try {
            result = mapper.writeValueAsString(Stylish.makeStylish(mapA, mapB));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result.trim();
    }
}
