package assignment;

import Util.Util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author efofana
 */
public class FileReader {
    public static String readFile(String  fileName){
        System.out.println("Reading file "+fileName+"...");
        try {
          System.out.println(Files.readString(Util.FILEPATH.resolve(fileName+".txt").normalize()));
          Path file = Util.FILEPATH.resolve(fileName+".txt").normalize();
          Files.createFile(file);
            return Files.readString(file);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
