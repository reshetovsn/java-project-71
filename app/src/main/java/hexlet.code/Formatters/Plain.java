package hexlet.code.Formatters;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.List;

public class Plain {
    public static String makePlain(Map<String, Object> mapA, Map<String, Object> mapB) {
        Set<String> keys = new TreeSet<>();
        keys.addAll(mapA.keySet());
        keys.addAll(mapB.keySet());

        StringBuilder result = new StringBuilder();
        for (String elements : keys) {
            var valueA = mapA.get(elements);
            var valueB = mapB.get(elements);
            if (mapA.containsKey(elements) && !mapB.containsKey(elements)) {
                result.append("Property '")
                        .append(elements)
                        .append("' was removed")
                        .append("\n");
            } else if (!mapA.containsKey(elements) && mapB.containsKey(elements)) {
                result.append("Property '")
                        .append(elements)
                        .append("' was added with value: ")
                        .append(checkValue(valueB))
                        .append("\n");
            } else if (mapA.containsKey(elements) && mapB.containsKey(elements)) {
                if (!Objects.equals(valueA, valueB)) {
                    result.append("Property '")
                            .append(elements)
                            .append("' was updated. From ")
                            .append(checkValue(valueA))
                            .append(" to ")
                            .append(checkValue(valueB))
                            .append("\n");
                }
            }
        }
        return result.toString();
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
