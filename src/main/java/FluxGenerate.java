import Util.Util;
import reactor.core.publisher.Flux;

/**
 * @author efofana
 */
public class FluxGenerate {
    public static void main(String[] args) {
        // synchronousSink => used to generate a maximum of one value event at a time
        // generate() => Run like an infinite loop,
        // take() => Used to limit infinite generation
        Flux.generate(synchronousSink -> {
            System.out.println("Emitting");
            synchronousSink.next(Util.faker().country().name()); // 1
            synchronousSink.complete(); // Complete() => Predominates take() and will allow only one event to be produced
           // synchronousSink.error(new RuntimeException("OOps"));
        })
        .take(4)
        .subscribe(Util.subscriber());

    }
}
