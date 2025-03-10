package behavioral.decorator;

import java.time.LocalDate;

public class EmployeeConcreteComponent implements Employee{

    private String name;

    public EmployeeConcreteComponent(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void doTask() {
        // Unassigned task
    }

    @Override
    public void join(LocalDate joinDate) {
        System.out.println(this.getName() + " joined on " + formatDate(joinDate));
    }

    @Override
    public void terminate(LocalDate terminateDate) {
        System.out.println(this.getName() + " terminated on " + formatDate(terminateDate));
    }
}
