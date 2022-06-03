package streams_files_and_directories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteToFile {
    public static void main(String[] args) {
        List<Character> punctuation = new ArrayList<>();
        punctuation.add(',');
        punctuation.add('.');
        punctuation.add('!');
        punctuation.add('?');
        try {
            FileInputStream fis = new FileInputStream("/home/midas/Desktop/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt");
            FileOutputStream fos = new FileOutputStream("punctuation.txt");
            int oneByte;
            while((oneByte = fis.read()) != -1) {
                if(!punctuation.contains((char)oneByte)) {
                    fos.write(oneByte);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
