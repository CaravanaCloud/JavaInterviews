package cloud.caravana.rs;

import java.util.logging.Logger;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class Main {
    static final Logger log = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        log.fine("Running main method");
        Quarkus.run(args);
    }
}
