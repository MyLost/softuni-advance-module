package streams_files_and_directories.exercises;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SumBytes {
    public static void main(String[] args) throws IOException {
        String path = "/home/midas/Desktop/04. Java-Advanced-Files-and-Streams-Exercises-Resources/";

        FileReader fileReader = new FileReader(path + "input.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        try {
            String line;
            int sumSymbols = 0;
            while((line = bufferedReader.readLine()) != null) {
                for (int i = 0; i < line.length(); i++) {
                    sumSymbols += line.charAt(i);
                }
            }
            System.out.println(sumSymbols);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        fileReader.close();
        bufferedReader.close();
    }
}
