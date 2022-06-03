package streams_files_and_directories;

import java.io.*;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("/home/midas/Desktop/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt"));
        PrintWriter out = new PrintWriter(new FileWriter("Write_Every_Third_Line.txt"));
        String line;
        int count = 1;
        while((line=in.readLine()) != null) {
            if(count % 3 ==0) {
                out.println(line);
            }
            count++;
        }
        in.close();
        out.close();
    }
}
