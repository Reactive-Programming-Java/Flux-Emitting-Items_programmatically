package assignment;

import Util.Util;
import assignment.FileReader;
import reactor.core.publisher.Flux;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * @author efofana
 */
public class FileReadSubscriber {
    public static void main(String[] args) {
        Flux.generate(synchronousSink -> {
            try {
              Path file = Util.FILEPATH.resolve("data.txt").normalize();
              Scanner scan = new Scanner(file);
              System.out.println("Emitting");
              synchronousSink.next(FileReader.readFile("data")); // 1
              Util.sleepSeconds(2);
              if(scan.hasNextLine())
                synchronousSink.complete();
            } catch (IOException e) {
              e.printStackTrace();
            }
          })
                //.take(4)
                .subscribe(Util.subscriber());
    }
}
