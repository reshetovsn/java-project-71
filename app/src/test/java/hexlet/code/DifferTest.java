package hexlet.code;

import org.junit.jupiter.api.Test;

//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class DifferTest {
    @Test
    void testJSON() throws Exception {
        String filepath1 = "src/test/resources/file1.json";
        String filepath2 = "src/test/resources/file2.json";
        String actual = Differ.generate(filepath1, filepath2);
//        Path result = Paths.get("src/test/resources/result_json.txt").toAbsolutePath().normalize();
//        String expected = Files.readString(result);
        String expected = """
                {
                - follow: false
                  host: hexlet.io
                - proxy: 123.234.53.22
                - timeout: 50
                + timeout: 20
                + verbose: true
                }""";
        assertThat(actual).isEqualTo(expected);
    }
}