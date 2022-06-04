package streams_files_and_directories.exercises;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        String path = "/home/midas/Desktop/04. Java-Advanced-Files-and-Streams-Exercises-Resources/";

        FileReader fileReader = new FileReader(path + "input.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        Map<String, Integer> characterTypes = new LinkedHashMap<>();
        characterTypes.put("Vowels", 0);
        characterTypes.put("Consonants", 0);
        characterTypes.put("Punctuation", 0);
        int oneByte;
        while((oneByte = bufferedReader.read()) != -1) {
            if(oneByte != 32) {
                if ((char) oneByte == 'a' || (char) oneByte == 'e' || (char) oneByte == 'i' || (char) oneByte == 'o' || (char) oneByte == 'u') {
                    characterTypes.put("Vowels", characterTypes.get("Vowels").intValue() + 1);
                } else if ((char) oneByte == '!' || (char) oneByte == ',' || (char) oneByte == '.' || (char) oneByte == '?') {
                    characterTypes.put("Punctuation", characterTypes.get("Punctuation").intValue() + 1);
                } else {
                    characterTypes.put("Consonants", characterTypes.get("Consonants").intValue() + 1);
                }
            }
        }
        for (Map.Entry<String, Integer> stringIntegerEntry : characterTypes.entrySet()) {
            System.out.println(stringIntegerEntry.getKey() + ": " + stringIntegerEntry.getValue());
        }
        fileReader.close();
        bufferedReader.close();
    }
}
