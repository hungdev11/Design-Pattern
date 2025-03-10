package behavioral.decorator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public interface Employee {
    String getName();
    void doTask();
    void join(LocalDate joinDate);
    void terminate(LocalDate terminateDate);
    default String formatDate(LocalDate theDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return theDate.format(formatter);
    }

    default void showBasicInformation() {
        System.out.println("-------");
        System.out.println("The basic information of " + getName());

        join(LocalDate.now());

        LocalDate terminateDate = LocalDate.now().plusMonths(6);
        terminate(terminateDate);
    }
}
