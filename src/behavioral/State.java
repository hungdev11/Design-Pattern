package behavioral;

/**
 * State pattern lets object alter its behavior when its internal states changes
 * Can use state like an enum ,but it violates Open/close principle when adding new state
 */
class Client {
    public static void main(String[] args) {
        Context context = new Context();

        context.setState(new NewState());
        context.applyState();

        context.setState(new SubmittedState());
        context.applyState();

        context.setState(new ApprovedState());
        context.applyState();
    }
}
public interface State {
    void handle();
}
class Context {
    private State state;
    public void setState(State state) {
        this.state = state;
    }
    public void applyState() {
        state.handle();
    }
}
class NewState implements State {
    @Override
    public void handle() {
        System.out.println("New");
    }
}
class SubmittedState implements State {
    @Override
    public void handle() {
        System.out.println("Submit");
    }
}
class ApprovedState implements State {
    @Override
    public void handle() {
        System.out.println("Approve");
    }
}
class RejectedState implements State {
    @Override
    public void handle() {
        System.out.println("Reject");
    }
}

