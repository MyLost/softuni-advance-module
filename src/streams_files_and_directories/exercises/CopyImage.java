package streams_files_and_directories.exercises;

import java.io.*;

public class CopyImage {
    public static void main(String[] args) throws IOException {
        String path = "/home/midas/Desktop/279003037_3115798121971923_3770887778054830015_n.jpg";
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream("copyPicture.jpg");

        byte[] oneByte;
        while((oneByte = fis.readNBytes(20)).length > 0) {
            fos.write(oneByte);
        }

        fis.close();
        fos.close();
    }
}
