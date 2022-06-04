package streams_files_and_directories.exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumLines {
    public static void main(String[] args) throws IOException {
        String path = "/home/midas/Desktop/04. Java-Advanced-Files-and-Streams-Exercises-Resources/";

        FileReader fileReader = new FileReader(path + "input.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        try {
            String line;
            while((line = bufferedReader.readLine()) != null) {
                int sumSymbols = 0;
                for (int i = 0; i < line.length(); i++) {
                    sumSymbols += line.charAt(i);
                }
               System.out.println(sumSymbols);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        fileReader.close();
        bufferedReader.close();
    }
}
