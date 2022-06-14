package com.hello;

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
        InputStream input=CsvToJson.class.getClassLoader().getResourceAsStream("employ.csv");
        String csvAsString=new BufferedReader(new InputStreamReader(input)).lines().collect(Collectors.joining("\n"));
        String json=CDL.toJsonArray(csvAsString).toString();
        try{
            Files.write(Path.of("result.json"),json.getBytes(StandardCharsets.UTF_8));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*  employ.csv
id,first_name,last_name,email,gender,ip_address
1,Abe,Foord,afoord0@harvard.edu,Female,81.38.18.88
2,Editha,Castagnaro,ecastagnaro1@nih.gov,Genderqueer,181.63.39.199
3,Tildie,Furminger,tfurminger2@hud.gov,Male,0.199.18.3
 */
/* result.json
[
  {
    "id": "1",
    "first_name": "Abe",
    "last_name": "Foord",
    "email": "afoord0@harvard.edu",
    "gender": "Female",
    "ip_address": "81.38.18.88"
  },
  {
    "id": "2",
    "first_name": "Editha",
    "last_name": "Castagnaro",
    "email": "ecastagnaro1@nih.gov",
    "gender": "Genderqueer",
    "ip_address": "181.63.39.199"
  },
  {
    "id": "3",
    "first_name": "Tildie",
    "last_name": "Furminger",
    "email": "tfurminger2@hud.gov",
    "gender": "Male",
    "ip_address": "0.199.18.3"
  }
]
 */
