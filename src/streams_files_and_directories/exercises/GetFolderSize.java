package streams_files_and_directories.exercises;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class GetFolderSize {
    public static void main(String[] args) throws IOException {
        String path = "/home/midas/Desktop/04. Java-Advanced-Files-and-Streams-Exercises-Resources/Exercises Resources/";
        File file = new File(path);
        System.out.println("Folder size: " + getSizeFiles(file));
    }

    private static long getSizeFiles(File file) throws IOException {
        long size = 0;
        for (File listFile : file.listFiles()) {
            if(listFile.isDirectory()) {
                getSizeFiles(listFile);
            }
            size += Files.size(Path.of(listFile.getPath()));
        }
        return size;
    }
}
