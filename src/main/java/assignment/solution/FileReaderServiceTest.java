package assignment.solution;

import Util.Util;
import assignment.resolution.FileReader;

import java.nio.file.Path;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author efofana
 */
public class FileReaderServiceTest {

    public static void main(String[] args) {
        Path path = Util.FILEPATH;
        FileReaderService.read(path)
                .take(4) // To read only 4 lines
                .subscribe(Util.subscriber());
    }
}
