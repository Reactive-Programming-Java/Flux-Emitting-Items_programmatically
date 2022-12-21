package assignment.resolution;

import Util.Util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author efofana
 */
public class FileReader {
    public static String readFile(){
       // System.out.println("Reading file "+fileName+"...");
        try {
            Path path = Util.FILEPATH;
            File file = Util.FILEPATH.toFile();

            if(!file.exists())
            Files.createFile(path);

            return Files.readString(file.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
