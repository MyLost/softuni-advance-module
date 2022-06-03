package streams_files_and_directories;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class NestedFolders {
    public static void main(String[] args) {

//        File file = new File("/home/midas/Desktop/04. Java-Advanced-Files-and-Streams-Lab-Resources/");
//        int counter = 0;
//        List<String> folderNames = new ArrayList<>();
//        counter = traverse(file, counter, folderNames);
//        System.out.println("[folder count] " + counter);
//
//    }
//
//    public static int traverse(File file, int counter, List<String> folderNames) {
//        for (File listFile : file.listFiles()) {
//            if(listFile.isDirectory()) {
//                counter++;
//                folderNames.add(listFile.getName());
//                counter = traverse(listFile, counter, folderNames);
//            }
//        }
//        return counter;

        File root = new File("/home/midas/Desktop/04. Java-Advanced-Files-and-Streams-Lab-Resources/");
        Deque<File> dirs = new ArrayDeque<>();
        dirs.offer(root);

        System.out.println(root.getName());
        int countDirectory = 1;
        while (!dirs.isEmpty()) {
            File current = dirs.poll();
            File[] nestedFiles = current.listFiles();
            for (File f : Objects.requireNonNull(nestedFiles)) {
                if (f.isDirectory()) {
                    dirs.offer(f);
                    System.out.println(f.getName());
                    countDirectory++;
                }
            }
        }
        System.out.println(countDirectory + " folders");
    }
}
