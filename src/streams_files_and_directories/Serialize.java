package streams_files_and_directories;

import java.io.*;

public class Serialize {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Cube cube = new Cube();
        cube.color = "green";
        cube.width = 15.3d;
        cube.height = 12.4d;
        cube.depth = 3d;
        String path = "save.txt";
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(cube);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
        Cube cubeSer = (Cube) ois.readObject();
        System.out.println(cubeSer.color + " " + cubeSer.width + " " + cubeSer.depth + " " + cubeSer.height);
    }
    private static class Cube implements Serializable {
        String color;
        double width;
        double height;
        double depth;
    }
}
