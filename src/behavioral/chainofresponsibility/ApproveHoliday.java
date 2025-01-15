package behavioral.chainofresponsibility;

public class ApproveHoliday {
    public static void main(String[] args) {
        HolidayRequest request = new HolidayRequest(2);
        HolidayRequest request1 = new HolidayRequest(4);
        HolidayRequest request2 = new HolidayRequest(8);

        Approver approver = HolidayRequestFlow.getApprover();
        approver.approveHoliday(request);
        approver.approveHoliday(request1);
        approver.approveHoliday(request2);
    }
}
class HolidayRequestFlow {
    public static Approver getApprover() {
        Approver supervisor = new Supervisor();
        Approver manager = new Manager();
        Approver director = new Director();
        manager.setNext(director);
        supervisor.setNext(manager);
        return supervisor;
    }
}
class HolidayRequest {
    private int days;
    public HolidayRequest(int days) {
        this.days = days;
    }
    public int getDays(){return days;}
}
abstract class Approver {
    protected Approver nextApprover;
    public abstract boolean canApprove(int numberOfDays);
    public abstract void doApproving(HolidayRequest request);
    public void setNext(Approver approver) {
        nextApprover = approver;
    }
    public void approveHoliday(HolidayRequest holidayRequest) {
        if (canApprove(holidayRequest.getDays())) {
            doApproving(holidayRequest);
        } else if (nextApprover != null) {
            nextApprover.approveHoliday(holidayRequest);
        }
    }
}
class Supervisor extends Approver {
    @Override
    public boolean canApprove(int numberOfDays) {
        return numberOfDays <= 3;
    }
    @Override
    public void doApproving(HolidayRequest request) {
        System.out.println("Leave request approved for " + request.getDays() + " days by Supervisor");

    }
}
class Manager extends Approver {
    @Override
    public boolean canApprove(int numberOfDays) {
        return numberOfDays <= 5;
    }
    @Override
    public void doApproving(HolidayRequest request) {
        System.out.println("Leave request approved for " + request.getDays() + " days by Manager");

    }
}
class Director extends Approver {
    @Override
    public boolean canApprove(int numberOfDays) {
        return numberOfDays > 5;
    }
    @Override
    public void doApproving(HolidayRequest request) {
        System.out.println("Leave request approved for " + request.getDays() + " days by Director");

    }
}
