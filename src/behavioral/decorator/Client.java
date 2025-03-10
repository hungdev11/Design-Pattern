package behavioral.decorator;

public class Client {
    public static void main(String[] args) {
        System.out.println("NORMAL EMPLOYEE: ");
        Employee employee = new EmployeeConcreteComponent("HUNG");
        employee.showBasicInformation();
        employee.doTask();

        System.out.println("\nTEAM LEADER: ");
        Employee teamLeader = new TeamLeader(employee);
        teamLeader.showBasicInformation();
        teamLeader.doTask();

        System.out.println("\nMANAGER: ");
        Employee manager = new Manager(employee);
        manager.showBasicInformation();
        manager.doTask();

        System.out.println("\nTEAM LEADER AND MANAGER: ");
        Employee teamLeaderAndManager = new Manager(teamLeader);
        teamLeaderAndManager.showBasicInformation();
        teamLeaderAndManager.doTask();
    }
}
