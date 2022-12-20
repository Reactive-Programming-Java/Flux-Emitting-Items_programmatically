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
            System.out.println(fluxSink.isCancelled() ? "Cancelled" : "Running");
        })
        .take(3) // Here we are limiting events production to 3 data and after get canceled
        .subscribe(Util.subscriber());

    }

}
