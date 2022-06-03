package streams_files_and_directories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CopyBytes {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("/home/midas/Desktop/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt");
            FileOutputStream fos = new FileOutputStream("copyBytes.txt");
            int oneByte;
            while((oneByte = fis.read()) != -1) {
                String digit = String.valueOf(oneByte);
                if (digit.equals("32")) {
                    fos.write(' ');
                } else if (digit.equals("10")) {
                    fos.write('\n');
                } else {
                    fos.write(digit.getBytes());
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
