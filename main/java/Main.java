import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.util.ArrayList;


public class Main {

    public static void main(String[] args) throws ParseException, IOException {

        for (int year = 1; year <5; year++) {
            for (int i = 0; i < 70; i++) {

                Student.createStudent(year,i);
            }
        }

    }
}