import Util.Util;
import reactor.core.publisher.Flux;

/**
 * @author efofana
 */
public class FluxCreateIssueFix {
    public static void main(String[] args) {
        // FluxSink => Allows to emit events through multiple threads if necessary
        Flux.create(fluxSink -> {
            String country;
            do{
                country = Util.faker().country().name();
                System.out.println("Emitting "+country);
                fluxSink.next(country);
            }while (!country.equals("Canada") && !fluxSink.isCancelled());
            fluxSink.complete();
            System.out.println(fluxSink.isCancelled());
        })
        .log()
        .take(3) // Here we want to receive only 3 events
        .subscribe(Util.subscriber());

    }

}
