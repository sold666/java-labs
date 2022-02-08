import java.util.concurrent.ThreadFactory;

public class CreateOwnThread implements ThreadFactory {
    private String threadName;
    private int counter;

    public CreateOwnThread(String name) {
        threadName = name;
    }

    @Override
    public String toString() {
        return  ++counter + " " + threadName;
    }

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r, toString());
    }
}
