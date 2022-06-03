package streams_files_and_directories;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class SortLines {

    public static void main(String[] args) throws IOException {
        Path path = Path.of("/home/midas/Desktop/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt");
        List<String> lines = Files.readAllLines(path);
        PrintWriter out = new PrintWriter(new FileWriter("SortLines.txt"));
        Collections.sort(lines);

        for (String line : lines) {
            out.write(line);
            out.write("\n");

        }
        out.close();
    }
}
