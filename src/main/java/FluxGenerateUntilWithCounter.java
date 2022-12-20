import Util.Util;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author efofana
 */
public class FluxGenerateUntilWithCounter {
    public static void main(String[] args) {

        // synchronousSink => used to generate a maximum of one value event at a time
        // generate() => Run like an infinite loop,
        // take() => Used to limit infinite generation
        AtomicInteger atomicInteger = new AtomicInteger();
        Flux.generate(synchronousSink -> {
            String country = Util.faker().country().name();
            System.out.println("Emitting: " + country);
            synchronousSink.next(country); // 1
            atomicInteger.incrementAndGet();
            if(!country.equalsIgnoreCase("canada") && !(atomicInteger.get() < 10))
            synchronousSink.complete(); // Complete() => Predominates take() and will allow only one event to be produced
           // synchronousSink.error(new RuntimeException("OOps"));
        })
        .take(4)
        .subscribe(Util.subscriber());

    }
}
