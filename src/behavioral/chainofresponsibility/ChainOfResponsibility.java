package behavioral.chainofresponsibility;

/**
 * Chain of responsibility allows an object send a request but don't know what object will receive and handle it
 * Its implementing by connect objects receive request to a chain and send request to that chain whenever it's handled
 *
 */
public class ChainOfResponsibility {
    public static void main(String[] args) {
        // Build the chain of responsibility
        Logger logger = AppLogger.getLogger();

        // Handled by ConsoleLogger since the console has a LogLevel of DEBUG
        logger.log(LogLevel.INFO, "Info message");
        logger.log(LogLevel.DEBUG, "Debug message");

        // Handled by ConsoleLogger and FileLogger
        logger.log(LogLevel.ERROR, "Error message");

        // Handled by ConsoleLogger, FileLogger, EmailLogger
        logger.log(LogLevel.FATAL, "Factal message");
    }
}
enum LogLevel {
    NONE(0), INFO(1), DEBUG(2), WARNING(4), ERROR(8), FATAL(16), ALL(32);
    private int level;
    private LogLevel(int level) {
        this.level = level;
    }
    public int getLevel() {
        return level;
    }
}
abstract class Logger {
    protected LogLevel logLevel;
    protected Logger nextlogger; // The next Handler in the chain

    public Logger(LogLevel logLevel) {
        this.logLevel = logLevel;
    }
    // Set the next logger to make a list/chain of Handlers.
    public Logger setNext(Logger nextlogger) {
        this.nextlogger = nextlogger;
        return nextlogger;
    }
    public void log(LogLevel severity, String msg) {
        if (logLevel.getLevel() <= severity.getLevel()) {
            writeMessage(msg);
        }
        if (nextlogger != null) {
            nextlogger.log(severity, msg);
        }
    }
    protected abstract void writeMessage(String msg);
}
class ConsoleLogger extends Logger {
    public ConsoleLogger(LogLevel logLevel) {
        super(logLevel);
    }
    @Override
    protected void writeMessage(String msg) {
        System.out.println("Console logger: " + msg);
    }
}
class FileLogger extends Logger {
    public FileLogger(LogLevel logLevel) {
        super(logLevel);
    }
    @Override
    protected void writeMessage(String msg) {
        System.out.println("File logger: " + msg);
    }
}
class EmailLogger extends Logger {
    public EmailLogger(LogLevel logLevel) {
        super(logLevel);
    }
    @Override
    protected void writeMessage(String msg) {
        System.out.println("Email logger: " + msg);
    }
}
class AppLogger {
    public static Logger getLogger() {
        Logger consoleLogger = new ConsoleLogger(LogLevel.DEBUG);
        Logger fileLogger = consoleLogger.setNext(new FileLogger(LogLevel.ERROR));
        fileLogger.setNext(new EmailLogger(LogLevel.FATAL));
        return consoleLogger;
    }
}