import Util.Util;
import reactor.core.publisher.Flux;

/**
 * @author efofana
 */
public class FluxTakeOperator {
    public static void main(String[] args) {

        Flux.range(1,10)
                .log()
                .take(3) // Limit request
                .log() // logger INFO
                .subscribe(Util.subscriber());
//        Result: (After third event it cancel subscription)
//                [ INFO] (main) | onSubscribe([Synchronous Fuseable] FluxRange.RangeSubscription)
//                 [ INFO] (main) | onSubscribe([Fuseable] FluxTake.TakeFuseableSubscriber)
//                [ INFO] (main) | request(unbounded)
//                [ INFO] (main) | request(unbounded)
//                [ INFO] (main) | onNext(1)
//                [ INFO] (main) | onNext(1)
//                - Received : 1
//                [ INFO] (main) | onNext(2)
//                [ INFO] (main) | onNext(2)
//                - Received : 2
//                [ INFO] (main) | onNext(3)
//                [ INFO] (main) | onNext(3)
//                - Received : 3
//                [ INFO] (main) | cancel()
//                [ INFO] (main) | onComplete()
//                - Completed


    }
}
