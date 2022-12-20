import Util.Util;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author efofana
 */
public class FluxGenerateWithState {
    public static void main(String[] args) {

        // Initialize counter: 1
        Flux.generate(()->1,(counter,sink) -> {
        String country = Util.faker().country().name();
        sink.next(country);

        if(counter >= 10 || country.equalsIgnoreCase("canada"))
            sink.complete();

            return counter + 1;

                })
        .take(4)
        .subscribe(Util.subscriber());

    }
}
