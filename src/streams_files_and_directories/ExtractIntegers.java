package streams_files_and_directories;

import java.io.*;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("/home/midas/Desktop/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt");
        Scanner scanner = new Scanner(fis);
        FileOutputStream fos = new FileOutputStream("extractIntegers.txt");
        PrintWriter writer = new PrintWriter(fos);
        while(scanner.hasNext()) {
            if(scanner.hasNextInt()) {
                writer.println(scanner.nextInt());
            }
            scanner.next();
        }
        writer.close();
    }
}
