import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Utils {

    /**
     * javadoc.
     */
    public static String readContentFromFile(String path) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            return String.join(System.lineSeparator(), lines);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * javadoc.
     */
    public static void writeContentToFile(String path, String content) {
        try {
            Files.write(Paths.get(path), content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * javadoc.
     */
    public static void appendContentToFile(String path, String content) {
        try {
            Files.write(Paths.get(path), content.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * javadoc.
     */
    public static File findFileByName(String folderPath, String fileName) {
        File folder = new File(folderPath);
        if (folder.isDirectory()) {
            File[] files = folder.listFiles((dir, name) -> name.equals(fileName));
            if (files != null && files.length > 0) {
                return files[0];
            }
        }
        return null;
    }

    public static void main(String[] args) {

        String filePath = "C:\\example.txt";

        String content = readContentFromFile(filePath);
        System.out.println("Nội dung tệp:");
        System.out.println(content);

        String newContent = "Nội dung mới";
        writeContentToFile(filePath, newContent);

        String additionalContent = "\nNội dung bổ sung";
        appendContentToFile(filePath, additionalContent);

        String folderPath = "C:\\";
        String fileNameToFind = "example.txt";
        File foundFile = findFileByName(folderPath, fileNameToFind);
        if (foundFile != null) {
            System.out.println("Tìm thấy tệp: " + foundFile.getAbsolutePath());
        } else {
            System.out.println("Không tìm thấy tệp.");
        }
    }
}
