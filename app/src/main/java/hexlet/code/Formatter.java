package hexlet.code;

import hexlet.code.Formatters.Json;
import hexlet.code.Formatters.Plain;
import hexlet.code.Formatters.Stylish;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String chooseFormat(Map<String, Object> mapA, Map<String, Object> mapB, String format)
            throws Exception {
        List<Map<String, Object>> difference = Difference.makeDifference(mapA, mapB);
        return switch (format) {
            case "stylish" -> Stylish.makeStylish(difference);
            case "plain" -> Plain.makePlain(difference);
            case "json" -> Json.makeJson(difference);
            default -> throw new Exception("Wrong format: " + format);
        };
    }
}
