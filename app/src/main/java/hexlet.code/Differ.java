package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Differ {
    public static String generate(String filepath1, String filepath2) throws Exception {
        Path absPath1 = Paths.get(filepath1).toAbsolutePath().normalize();
        Path absPath2 = Paths.get(filepath2).toAbsolutePath().normalize();
        String content1 = Files.readString(absPath1);
        String content2 = Files.readString(absPath2);

        ObjectMapper objectMapper = new ObjectMapper();
        Map file1 = objectMapper.readValue(content1, Map.class);
        Map file2 = objectMapper.readValue(content2, Map.class);
        return Parser.parsingRes(file1, file2);
    }
}
