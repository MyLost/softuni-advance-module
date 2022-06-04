package streams_files_and_directories.exercises;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeTwoFiles {
    public static void main(String[] args) throws IOException {

        String path = "/home/midas/Desktop/04. Java-Advanced-Files-and-Streams-Exercises-Resources/";
        FileReader fileReader = new FileReader(path + "inputOne.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> data = new LinkedList<>();
        PrintWriter writer = new PrintWriter("merged-result.txt");

        String line;
        while(( line = bufferedReader.readLine()) != null) {
            data.add(line);
        }
        fileReader = new FileReader(path + "inputTwo.txt");
        bufferedReader = new BufferedReader(fileReader);
        while(( line = bufferedReader.readLine()) != null) {
            data.add(line);
        }

        data.stream().forEach(writer::println);

        fileReader.close();
        bufferedReader.close();
        writer.close();
    }
}
