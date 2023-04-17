package hexlet.code.Formatters;

import java.util.List;
import java.util.Map;

public class Plain {
    public static String makePlain(List<Map<String, Object>> diffMap) {

        StringBuilder result = new StringBuilder();
        for (Map<String, Object> element : diffMap) {
            if (element.get("status").equals("deleted")) {
                result.append("Property '")
                        .append(element.get("key"))
                        .append("' was removed")
                        .append("\n");
            } else if (element.get("status").equals("added")) {
                result.append("Property '")
                        .append(element.get("key"))
                        .append("' was added with value: ")
                        .append(checkValue(element.get("newValue")))
                        .append("\n");
            } else if (element.get("status").equals("changed")) {
                result.append("Property '")
                        .append(element.get("key"))
                        .append("' was updated. From ")
                        .append(checkValue(element.get("oldValue")))
                        .append(" to ")
                        .append(checkValue(element.get("newValue")))
                        .append("\n");
            }
        }
        return result.toString().trim();
    }

    public static String checkValue(Object value) {
        if (value instanceof Map || value instanceof List) {
            return "[complex value]";
        } else if (value == null) {
            return null;
        } else if (value instanceof String) {
            return "'" + value + "'";
        } else {
            return value.toString();
        }
    }
}
