import org.json.CDL;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class CsvToJson {
    public static void main(String[] args) {
        InputStream input=CsvToJson.class.getClassLoader().getResourceAsStream("aaa.csv");
        String csvAsString=new BufferedReader(new InputStreamReader(input)).lines().collect(Collectors.joining("\n"));
        String json=CDL.toJsonArray(csvAsString).toString();
        try{
            Files.write(Path.of("bbb.json"),json.getBytes(StandardCharsets.UTF_8));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}