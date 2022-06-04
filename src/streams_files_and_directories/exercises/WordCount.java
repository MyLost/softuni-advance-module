package streams_files_and_directories.exercises;

import java.io.*;
import java.util.*;

public class WordCount {
    public static void main(String[] args) throws IOException {
        String path = "/home/midas/Desktop/04. Java-Advanced-Files-and-Streams-Exercises-Resources/";
        FileReader fileReader = new FileReader(path + "words.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String content = "";
        PrintWriter writer = new PrintWriter("result.txt");
        List<String> words = new ArrayList<>();
        List<String> textWords = new ArrayList<>();
        Map<String, Integer> data = new LinkedHashMap<>();

        String line;
        while(( line = bufferedReader.readLine()) != null) {
            content += line;
        }
        Arrays.stream(content.split(" ")).forEach(words::add);
        content = "";
        fileReader = new FileReader(path + "text.txt");
        bufferedReader = new BufferedReader(fileReader);
        while(( line = bufferedReader.readLine()) != null) {
            content += line;
        }
        Arrays.stream(content.split(" ")).forEach(textWords::add);

        for (String word : words) {
            textWords.stream().forEach(item -> {
                if(word.equals(item)) {
                    if (!data.containsKey(item)) {
                        data.put(item, 1);
                    } else {
                        data.put(item, data.get(item).intValue() + 1);
                    }
                }
            });
        }

        for (var stringIntegerEntry : data.entrySet()) {
          writer.println(stringIntegerEntry.getKey() + " - " + stringIntegerEntry.getValue());
        }
        fileReader.close();
        bufferedReader.close();
        writer.close();
    }
}
