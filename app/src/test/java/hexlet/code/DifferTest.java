package hexlet.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class DifferTest {
    private static String filepath1 = "src/test/resources/file1.json";
    private static String filepath2 = "src/test/resources/file2.json";
//    private static Path result = Paths.get("src/test/resources/result_json.txt").toAbsolutePath().normalize();

    @Test
    void testJSON() throws Exception {
        String actual = Differ.generate(filepath1, filepath2);
//        String expected = Files.readString(result);
        String expected = """
                {
                - follow: false
                  host: hexlet.io
                - timeout: 50
                + timeout: 20
                + verbose: true
                }""";
        assertThat(actual).isEqualTo(expected);
    }
}