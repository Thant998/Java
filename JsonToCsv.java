import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONTokener;
 
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
 
public class JsonToCsv {
 
    public static void main(String[] args) {
        InputStream inputStream = JsonToCsv.class.getClassLoader().getResourceAsStream("input.json");
        JSONArray jsonArray = new JSONArray(new JSONTokener(inputStream));
        try {
            Files.write(Path.of("src/main/resources/output.csv"), CDL.toString(jsonArray).getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}