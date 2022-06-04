package streams_files_and_directories.exercises;

import java.io.*;
import java.util.Locale;

public class ALLCAPITALS {
    public static void main(String[] args) throws IOException {
        String path = "/home/midas/Desktop/04. Java-Advanced-Files-and-Streams-Exercises-Resources/";

        FileReader fileReader = new FileReader(path + "input.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        PrintWriter writer = new PrintWriter("output.txt");
        try {
            int oneByte;
            while((oneByte = bufferedReader.read()) != -1) {
                int letterToUpperCase =  Character.toUpperCase(oneByte);
                writer.write(letterToUpperCase);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        fileReader.close();
        bufferedReader.close();
        writer.close();
    }
}
