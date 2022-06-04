package streams_files_and_directories.exercises;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SerializeArrayList {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String path = "/home/midas/Desktop/04. Java-Advanced-Files-and-Streams-Exercises-Resources/";
        List<String> data = new ArrayList<>();
        FileOutputStream fos = new FileOutputStream("serialize_list.txt");
        FileReader reader = new FileReader(path + "input.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;
        while((line = bufferedReader.readLine()) != null) {
            Arrays.stream(line.split(" ")).forEach(data::add);
        }
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fos);
        objectOutputStream.writeObject(data);

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("serialize_list.txt"));
        List<String> newData = (List<String>) objectInputStream.readObject();
        newData.stream().forEach(System.out::println);

        fos.close();
        reader.close();
        bufferedReader.close();
        objectOutputStream.close();
        objectInputStream.close();

    }
}
