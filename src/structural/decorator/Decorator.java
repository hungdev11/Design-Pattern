package structural.decorator;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/**
 * Attach additional responsibilities to an object dynamically
 * Decorators provide a flexible alternative to subclassing for extending functionality.
 */
public class Decorator {
    public static void main(String[] args) {
        System.out.println("NORMAL EMPLOYEE: ");
        EmployeeComponent employee = new EmployeeConcreteComponent("Hung");
        employee.showBasicInformation();
        employee.doTask();

        System.out.println("\nTEAM LEADER: ");
        EmployeeComponent teamLeader = new TeamLeader(employee);
        teamLeader.showBasicInformation();
        teamLeader.doTask();

        System.out.println("\nMANAGER: ");
        EmployeeComponent manager = new Manager(employee);
        manager.showBasicInformation();
        manager.doTask();

        System.out.println("\nTEAM LEADER AND MANAGER: ");
        EmployeeComponent teamLeaderAndManager = new Manager(teamLeader);
        teamLeaderAndManager.showBasicInformation();
        teamLeaderAndManager.doTask();
    }
}
interface EmployeeComponent {
    String getName();
    void doTask();
    void join(Date joinDate);
    void terminate(Date terminateDate);

    default String formatDate(Date theDate) {
        DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(theDate);
    }
    default void showBasicInformation() {
        System.out.println("-------");
        System.out.println("The basic information of " + getName());

        join(Calendar.getInstance().getTime());

        Calendar terminateDate = Calendar.getInstance();
        terminateDate.add(Calendar.MONTH, 6);
        terminate(terminateDate.getTime());
    }
}
class EmployeeConcreteComponent implements EmployeeComponent {
    private String name;
    public EmployeeConcreteComponent (String name) {
        this.name = name;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public void join(Date joinDate) {
        System.out.println(this.getName() + " joined on " + formatDate(joinDate));
    }
    @Override
    public void terminate(Date terminateDate) {
        System.out.println(this.getName() + " terminated on " + formatDate(terminateDate));
    }
    @Override
    public void doTask() {
        // Unassigned task
    }
}
abstract class EmployeeDecorator implements EmployeeComponent {
    protected EmployeeComponent employee;
    protected EmployeeDecorator(EmployeeComponent employee) {
        this.employee = employee;
    }
    @Override
    public String getName() {
        return employee.getName();
    }
    @Override
    public void join(Date joinDate) {
        employee.join(joinDate);
    }
    @Override
    public void terminate(Date terminateDate) {
        employee.terminate(terminateDate);
    }
}
class Manager extends EmployeeDecorator {
    protected Manager(EmployeeComponent employee) {
        super(employee);
    }
    public void createRequirement() {
        System.out.println(this.employee.getName() + " is create requirements.");
    }
    public void assignTask() {
        System.out.println(this.employee.getName() + " is assigning tasks.");
    }
    public void manageProgress() {
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
class TeamLeader extends EmployeeDecorator {
    protected TeamLeader(EmployeeComponent employee) {
        super(employee);
    }
    public void planing() {
        System.out.println(this.employee.getName() + " is planing.");
    }
    public void motivate() {
        System.out.println(this.employee.getName() + " is motivating his members.");
    }
    public void monitor() {
        System.out.println(this.employee.getName() + " is monitoring his members.");
    }
    @Override
    public void doTask() {
        employee.doTask();
        planing();
        motivate();
        monitor();
    }
}

class TeamMember extends EmployeeDecorator {
    protected TeamMember(EmployeeComponent employee) {
        super(employee);
    }
    public void reportTask() {
        System.out.println(this.employee.getName() + " is reporting his assigned tasks.");
    }
    public void coordinateWithOthers() {
        System.out.println(this.employee.getName() + " is coordinating with other members of his team.");
    }
    @Override
    public void doTask() {
        employee.doTask();
        reportTask();
        coordinateWithOthers();
    }
}