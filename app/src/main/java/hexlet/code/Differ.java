package hexlet.code;

import java.util.Map;

public class Differ {
    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        Map<String, Object> mapA = Parser.makeParsing(filepath1);
        Map<String, Object> mapB = Parser.makeParsing(filepath2);
        return Formatter.chooseFormat(mapA, mapB, format);
    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        String format = "stylish";
        return generate(filepath1, filepath2, format);
    }
}
