package assignment.data;

import Util.Util;
import assignment.FileReader;
import reactor.core.publisher.Flux;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author efofana
 */
public class FileReadSubscriber {
    public static void main(String[] args) {
        Flux.generate(synchronousSink -> {
                    try {
                        File file = new File(Util.FILEPATH.toString());
                        Scanner scan = new Scanner(file);
                        System.out.println("Emitting");
                        synchronousSink.next(FileReader.readFile("data")); // 1
                        if(!scan.hasNextLine())
                        synchronousSink.complete();
                    } catch (FileNotFoundException e) {
                        synchronousSink.error(new RuntimeException(e));
                    }
                })
                //.take(4)
                .subscribe(Util.subscriber());
    }
}
