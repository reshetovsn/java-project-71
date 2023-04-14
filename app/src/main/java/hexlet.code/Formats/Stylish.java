package hexlet.code.Formats;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Stylish {
    public static String makeStylish(Map<String, Object> mapA, Map<String, Object> mapB) {
        Set<String> keys = new TreeSet<>();
        keys.addAll(mapA.keySet());
        keys.addAll(mapB.keySet());

        StringBuilder result = new StringBuilder();
        result.append("{\n");
        for (String elements : keys) {
            var valueA = mapA.get(elements);
            var valueB = mapB.get(elements);
            if (mapA.containsKey(elements) && !mapB.containsKey(elements)) {
                result.append("- ").append(elements).append(": ").append(valueA).append("\n");
            } else if (!mapA.containsKey(elements) && mapB.containsKey(elements)) {
                result.append("+ ").append(elements).append(": ").append(valueB).append("\n");
            } else if (mapA.containsKey(elements) && mapB.containsKey(elements)) {
                if (Objects.equals(valueA, valueB)) {
                    result.append("  ").append(elements).append(": ").append(valueA).append("\n");
                } else {
                    result.append("- ").append(elements).append(": ").append(valueA).append("\n");
                    result.append("+ ").append(elements).append(": ").append(valueB).append("\n");
                }
            }
        }
        result.append("}");
        return result.toString();
    }
}
