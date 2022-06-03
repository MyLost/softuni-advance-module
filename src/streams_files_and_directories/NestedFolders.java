package streams_files_and_directories;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

public class NestedFolders {
    public static void main(String[] args) {

        File file = new File("/home/midas/Desktop/04. Java-Advanced-Files-and-Streams-Lab-Resources/Files-and-Streams/");

    }

    public static void traverse(File file) {
        for (File listFile : file.listFiles()) {
            if(listFile.isDirectory()) {

            }
        }
    }
}
