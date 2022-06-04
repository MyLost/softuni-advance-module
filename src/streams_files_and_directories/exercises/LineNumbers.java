package streams_files_and_directories.exercises;

import java.io.*;

public class LineNumbers {
    public static void main(String[] args) throws IOException {
        String path = "/home/midas/Desktop/04. Java-Advanced-Files-and-Streams-Exercises-Resources/";

        FileReader fileReader = new FileReader(path + "inputLineNumbers.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        PrintWriter writer = new PrintWriter("LineNumbers.txt");

        String line;
        int count = 1;
        while((line = bufferedReader.readLine()) != null) {
            line = count + ". " + line;
            writer.println(line);
            count++;
        }
        fileReader.close();
        bufferedReader.close();
        writer.close();
    }
}
