package behavioral.decorator;

public class Manager extends EmployeeDecorator{
    protected Manager(Employee employee) {
        super(employee);
    }

    private void createRequirement(){
        System.out.println(this.employee.getName() + " is create requirements.");
    }
    private void assignTask(){
        System.out.println(this.employee.getName() + " is assigning tasks.");
    }
    private void manageProgress() {
        System.out.println(this.employee.getName() + " is managing the progress.");
    }

    @Override
    public void doTask() {
        employee.doTask();
        createRequirement();
        assignTask();
        manageProgress();
    }
}
