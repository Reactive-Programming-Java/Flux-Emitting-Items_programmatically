package assignment.solution;

import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.invoke.CallSite;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Consumer;

/**
 * @author efofana
 */
public class FileReaderService {

    // 1 - Start open reader by passing path of the file process
    private static Callable<BufferedReader> openReader(Path path){
        return () -> Files.newBufferedReader(path);
    }

    // Start to read file process

    // 2 - br (BufferedReader) => Is allowing to read in file
    // sink (SynchronousSink<String>) => allows to construct event in the flux pipeline and also to complete or not event's generation
    /***
     * @Type_Returned Functional interface BiFunction which always get 2 args as input, and output 1 as result => BiFunction<T, U, R> => BufferedReader (T), SynchronousSink<String> (U), BufferedReader (R)
     * @Args null
     * @return BiFunction
     */
    private static BiFunction<BufferedReader, SynchronousSink<String>, BufferedReader> read(){
        return (br, sink) -> {
            try{
                String line = br.readLine();
                System.out.println("Reading: ["+line+"]");
                if(Objects.isNull(line))
                    sink.complete();
                else
                    sink.next(line);
            }catch (IOException e){
                sink.error(e);
            }
            return br;
        };

    }

    // 3 - Close reading process

    /***
     * @Type_Returned Functional interface Consumer which always get 1 args as input, and no output => Consumer<T> => BufferedReader (T)
     * @Args null
     * @return Consumer
     */
    private static Consumer<BufferedReader> closeReader(){
        return br -> {
            try{
                br.close();
                System.out.println(" -- Closed -- ");
            }catch (IOException e){
                e.printStackTrace();
            }
        };
    }

    // 4 - GAther all processes into a flux
    /***
     * @Type_Returned Abstract Class Flux of type String
     * @Args Path of the file to read
     * @return Flux<String>
     */
    public static Flux<String> read(Path path){
        return Flux.generate(
                openReader(path),
                read(),
                closeReader()
        );
    }

}
