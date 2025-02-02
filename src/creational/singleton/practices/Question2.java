package creational.singleton.practices;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;

/**
 * Suppose you are building an application that requires a single instance of a logging class
 *  that records logs of different system activities. The logs need to be stored in a file and should
 *  be easily accessible to the rest of the application. Design a logging class that implements the Singleton design
 *  pattern in Java.
 */
public class Question2 {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger();
        logger.write(LogType.INFO, "id 2");
        logger.write(LogType.ERROR, "error 1010");
    }
}
class Logger {
    private FileWriter writer;
    private Logger () {
        try {
            writer = new FileWriter("src/creational/singleton/practices/system.log");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static class Holder {
        private static final Logger LOGGER = new Logger();
    }
    public static Logger getLogger() {
        return Holder.LOGGER;
    }
    public void write(LogType type, String message) {
        try {
            writer.write(Instant.now().toString() + ": " +type.name() + ": " + message);
            writer.write("\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
enum LogType {
    INFO, WARN, ERROR
}
