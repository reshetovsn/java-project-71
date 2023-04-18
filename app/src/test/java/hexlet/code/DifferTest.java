package hexlet.code;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.assertj.core.api.Assertions.assertThat;

class DifferTest {
    private static String resultStylish;
    private static String resultPlain;
    private static String resultJson;

    private static Path getFixturePath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", fileName)
                .toAbsolutePath().normalize();
    }

    private static String getFixtureContent(String fileName) throws Exception {
        Path filePath = getFixturePath(fileName);
        return Files.readString(filePath).trim();
    }

    @BeforeAll
    public static void beforeAll() throws Exception {
        resultStylish = getFixtureContent("result_stylish.txt");
        resultPlain = getFixtureContent("result_plain.txt");
        resultJson = getFixtureContent("result_json.json");
    }

    @Test
    void testJsonStylish() throws Exception {
        String filepath1 = "src/test/resources/file1.json";
        String filepath2 = "src/test/resources/file2.json";
        String format = "stylish";
        String actual = Differ.generate(filepath1, filepath2, format);
        String expected = resultStylish;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testJsonPlain() throws Exception {
        String filepath1 = "src/test/resources/file1.json";
        String filepath2 = "src/test/resources/file2.json";
        String format = "plain";
        String actual = Differ.generate(filepath1, filepath2, format);
        String expected = resultPlain;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testJsonJson() throws Exception {
        String filepath1 = "src/test/resources/file1.json";
        String filepath2 = "src/test/resources/file2.json";
        String format = "json";
        String actual = Differ.generate(filepath1, filepath2, format);
        String expected = resultJson;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testJsonDefault() throws Exception {
        String filepath1 = "src/test/resources/file1.json";
        String filepath2 = "src/test/resources/file2.json";
        String actual = Differ.generate(filepath1, filepath2);
        String expected = resultStylish;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testYamlStylish() throws Exception {
        String filepath1 = "src/test/resources/file1.yaml";
        String filepath2 = "src/test/resources/file2.yaml";
        String format = "stylish";
        String actual = Differ.generate(filepath1, filepath2, format);
        String expected = resultStylish;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testYamlFormat() throws Exception {
        String filepath1 = "src/test/resources/file1.yaml";
        String filepath2 = "src/test/resources/file2.yaml";
        String format = "plain";
        String actual = Differ.generate(filepath1, filepath2, format);
        String expected = resultPlain;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testYamlJson() throws Exception {
        String filepath1 = "src/test/resources/file1.yaml";
        String filepath2 = "src/test/resources/file2.yaml";
        String format = "json";
        String actual = Differ.generate(filepath1, filepath2, format);
        String expected = resultJson;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testYamlDefault() throws Exception {
        String filepath1 = "src/test/resources/file1.yaml";
        String filepath2 = "src/test/resources/file2.yaml";
        String actual = Differ.generate(filepath1, filepath2);
        String expected = resultStylish;
        assertThat(actual).isEqualTo(expected);
    }
}

