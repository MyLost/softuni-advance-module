package streams_files_and_directories;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class ListFiles {
    public static void main(String[] args) {
        File file = new File("/home/midas/Desktop/04. Java-Advanced-Files-and-Streams-Lab-Resources/Files-and-Streams/");
        Arrays.stream(file.listFiles()).forEach(item -> {
            try {
                if(item.isFile()) {
                    System.out.println(item.getName() + ": " + "[" + Files.size(item.toPath()) + "]");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
