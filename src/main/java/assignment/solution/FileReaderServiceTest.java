package assignment.solution;

import Util.Util;
import assignment.resolution.FileReader;

import java.nio.file.Path;

/**
 * @author efofana
 */
public class FileReaderServiceTest {
    public static void main(String[] args) {
        Path path = Util.FILEPATH;
        FileReaderService.read(path).subscribe(Util.subscriber());
    }
}
