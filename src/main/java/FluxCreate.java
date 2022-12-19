/**
 * @PROJECT Emit-Flux-Programmatically
 * @Author Elimane on 16/12/2022
 */

import Util.Util;
import reactor.core.publisher.Flux;

/***
 * The create() method in Flux is used when we want to calculate
 * multiple (0 to infinity) values that are not influenced by the application's state
 *  https://www.baeldung.com/java-flux-create-generate
 */
public class FluxCreate {
  public static void main(String[] args) {
    // FluxSink => Allows to emit events through multiple threads if necessary
    Flux.create(fluxSink -> {
        String country;
      do{
        country = Util.faker().country().name();
        fluxSink.next(country);
      }while (!country.equals("Canada"));
      fluxSink.complete();

    }).subscribe(Util.subscriber());

  }
}
