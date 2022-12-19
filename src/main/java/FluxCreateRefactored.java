import Util.Util;
import helper.NameProducer;
import reactor.core.publisher.Flux;

/**
 * @PROJECT Emit-Flux-Programmatically
 * @Author Elimane on 17/12/2022
 */
public class FluxCreateRefactored {
  public static void main(String[] args) {

    NameProducer producer = new NameProducer();

    // Because producer inherit of fluxSink consumer
    // we can put it in Flux pipeline
    Flux.create(producer).subscribe(Util.subscriber());

    // To make it produce name in above pipeline
    Runnable runnable = producer::produce;

    // FluxSink can be shared with multiple threads
    for (int i = 0; i < 10; i++) {
      new Thread(runnable).start();
      Util.sleepSeconds(2);
    }



  }
}
