package streams_files_and_directories.exercises;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CreateZipArchive {
    public static void main(String[] args) throws IOException {
        String path = "/home/midas/Desktop/04. Java-Advanced-Files-and-Streams-Exercises-Resources/";
        ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream("output.zip"));
        FileReader reader = new FileReader(path + "input.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);
        String content = "";
        String line;
        while((line=bufferedReader.readLine()) !=null) {
            content += line;
        }
        try {
            for (int i = 0; i < 10; i++) {
                // not available on BufferedOutputStream
                zipOutputStream.putNextEntry(new ZipEntry("input-" + i + ".txt"));
                zipOutputStream.write(content.getBytes());
                // not available on BufferedOutputStream
                zipOutputStream.closeEntry();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            zipOutputStream.close();
            reader.close();
            bufferedReader.close();
        }
    }
}
