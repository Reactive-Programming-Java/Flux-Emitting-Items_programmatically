package Util;

import com.github.javafaker.Faker;
import org.reactivestreams.Subscriber;

import java.nio.file.Path;
import java.util.function.Consumer;

/**
 * @PROJECT Emit-Flux-Programmatically
 * @Author Elimane on 16/12/2022
 */
public class Util {

  private static final Faker FAKER = Faker.instance();
  //public static final Path FILEPATH = Path.of("/Users/Elimane/JAVA_REACTIVE_PROGRAMMING/Emit-Flux-Programmatically/src/main/java/assignment/data/data.txt");
  public static final Path FILEPATH = Path.of("C:\\projects\\Trainings\\reativeprogramming\\Flux-Emitting-Items_programmatically\\src\\main\\java\\assignment\\data\\data.txt");
  // public static final Path FILEPATH = Path.of("/Users/Elimane/JAVA_REACTIVE_PROGRAMMING/Mono_Project/src/main/resources/assignment/data");

  public static Consumer<Object> onNext(){
    return o -> System.out.println("Received: "+o);
  }

  public static Consumer<Throwable> onError(){
    return o -> System.out.println("ERROR: "+o.getMessage());
  }

  public static Runnable onComplete(){
    return () -> System.out.println("Completed");
  }

  public static Faker faker(){
    return FAKER;
  }

  public static void sleepSeconds(int seconds) {
    try {
      Thread.sleep(seconds * 1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static Subscriber<Object> subscriber(){
    return new DefaultSubscriber();
  }

  public static Subscriber<Object> subscriber(String name){
    return new DefaultSubscriber(name);
  }

}
