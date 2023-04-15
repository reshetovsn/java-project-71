package hexlet.code;

import hexlet.code.Formatters.Plain;
import hexlet.code.Formatters.Stylish;

import java.util.Map;

public class Formatter {
    public static String chooseFormat(Map<String, Object> mapA, Map<String, Object> mapB, String format)
            throws Exception {

        return switch (format) {
            case "stylish" -> Stylish.makeStylish(mapA, mapB);
            case "plain" -> Plain.makePlain(mapA, mapB);
            default -> throw new Exception("Wrong format: " + format);
        };
    }
}
