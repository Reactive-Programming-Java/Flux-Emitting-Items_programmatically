import Util.Util;
import reactor.core.publisher.Flux;

/**
 * @author efofana
 */
public class FluxCreateUntilWithCounter {
    public static void main(String[] args) {

        // Canada
        // max = 10
        // subscriber cancels - exit

        Flux.create(fluxSink -> {
            String country;
            int counter = 0;
            do {
                country = Util.faker().country().name();
                System.out.println("Emitting: "+country);
                fluxSink.next(country); // 1
                counter++;
            }while (!country.equalsIgnoreCase("canada") && !fluxSink.isCancelled() && counter < 10);
            fluxSink.complete();
        })
        .take(4)
        .subscribe(Util.subscriber());

    }
}
