package assignment.solution;

import Util.Util;
import assignment.resolution.FileReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * @author efofana
 */
public class FileReaderServiceTest {

    public static void main(String[] args) {


      try (InputStream input = new FileInputStream("src/main/resources/test.properties")) {

        Properties prop = new Properties();
        // load a properties file
        prop.load(input);

        int times = Integer.valueOf(prop.getProperty("take"));

        // get the property value and print it out
        System.out.println(times);

        Path path = Util.FILEPATH;
        FileReaderService.read(path)
          .map(s -> {
            Integer integer = Util.faker().random().nextInt(0,8);
            if(integer > 4)
              throw new RuntimeException("oops");
            return s;
          })
          .take(times) // To read only 4 lines
          .subscribe(Util.subscriber());

      } catch (IOException ex) {
        ex.printStackTrace();
      }

    }
}
