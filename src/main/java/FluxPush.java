import Util.Util;
import helper.NameProducer;
import reactor.core.publisher.Flux;

/**
 * @author efofana
 */
public class FluxPush {
    public static void main(String[] args) {
        NameProducer producer = new NameProducer();

        // Because producer inherit of fluxSink consumer
        // we can put it in Flux pipeline
        Flux.push(producer).subscribe(Util.subscriber());

        // To make it produce name in above pipeline
        Runnable runnable = producer::produce;

        // FluxSink can be shared with multiple threads
        for (int i = 0; i < 10; i++) {
            new Thread(runnable).start();
            Util.sleepSeconds(2);
        }
    }
}
