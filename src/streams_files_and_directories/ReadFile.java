package streams_files_and_directories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("/home/midas/Desktop/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt");
            int oneByte;
            while((oneByte = fis.read()) != -1) {
                 System.out.printf("%s ", Integer.toBinaryString(oneByte));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
