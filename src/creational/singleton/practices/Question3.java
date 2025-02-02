package creational.singleton.practices;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Implement a singleton class PrintSpooler that presents a print spooler. The print spooler is responsible
 * for managing the printing of documents. The spooler should only allow one instance of itself to be created,
 * and it should provide a method printDocument(String documentName) that adds a document to a queue for printing.
 * The spooler should also have a method startPrinting() that start the printing process, which should run in separate thread.
 * When the printing process is finish, the spooler should send a notification to all registered listeners indicating that is finished.
 */
public class Question3 {
    public static void main(String[] args) {
        PrintSpooler printSpooler = PrintSpooler.getInstance();
        printSpooler.addListener(new Listener1("Hung"));
        printSpooler.addListener(new Listener1("Hao"));
        printSpooler.printDocument("1");
        printSpooler.printDocument("3");
        printSpooler.printDocument("12");
        printSpooler.printDocument("1222");

        printSpooler.startPrinting();
    }
}
class Listener1 implements PrintSpoolerListener{
    private String name;
    public Listener1 (String name) {
        this.name = name;
    }
    @Override
    public void onPrintingFinished() {
        System.out.println(name + " Getting");
    }
}
interface PrintSpoolerListener {
    void onPrintingFinished();
}
class PrintSpooler {
    private final Queue<String> printQueue;
    private final List<PrintSpoolerListener> listeners;

    private PrintSpooler () {
        printQueue = new LinkedList<>();
        listeners = new ArrayList<>();
    }
    private static class Holder {
        private static final PrintSpooler PRINT_SPOOLER = new PrintSpooler();
    }
    public static PrintSpooler getInstance() {
        return Holder.PRINT_SPOOLER;
    }
    public void printDocument(String documentName) {
        printQueue.offer(documentName);
    }
    public void addListener(PrintSpoolerListener listener) {
        listeners.add(listener);
    }
    public void startPrinting() {
        Thread printThread = new Thread(() -> {
            while (!printQueue.isEmpty()) {
                System.out.println("Printing: " + printQueue.poll());
            }
            listeners.forEach(PrintSpoolerListener::onPrintingFinished);
        });
        printThread.start();
    }
}
