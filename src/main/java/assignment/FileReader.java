package assignment;

import Util.Util;

import java.io.IOException;
import java.nio.file.Files;

/**
 * @author efofana
 */
public class FileReader {
    public static String readFile(String  fileName){
        System.out.println("Reading file "+fileName+"...");
        try {
            return Files.readString(Util.FILEPATH.resolve(fileName+".txt").normalize());
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
