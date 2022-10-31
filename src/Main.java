import entity.Patient;
import org.apache.log4j.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        Patient paciente = new Patient("Jaramillo", "Raul", "Envigado", 123456);

    }
}