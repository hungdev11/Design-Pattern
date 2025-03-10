package behavioral.decorator;

import java.time.LocalDate;

public abstract class EmployeeDecorator implements Employee{
    protected Employee employee;

    protected EmployeeDecorator(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String getName() {
        return employee.getName();
    }

    @Override
    public void join(LocalDate joinDate) {
        employee.join(joinDate);
    }

    @Override
    public void terminate(LocalDate terminateDate) {
        employee.terminate(terminateDate);
    }
}
