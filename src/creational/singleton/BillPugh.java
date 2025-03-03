package creational.singleton;

// separate into 2 classes that one is for create and one is for get instance, have a good performance
// BillPugh class load first, Creator class loaded when and only when getInstance() called
// avoid re-init instance in Multi-thread and good performance by distinct function
public class BillPugh {
    private BillPugh (){}
    public static BillPugh getInstance() {
        return BillPugh.Creator.INSTANCE;
    }
    private static class Creator {
        private static final BillPugh  INSTANCE = new BillPugh();
    }
}
