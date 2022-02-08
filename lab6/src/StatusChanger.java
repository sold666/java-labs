import java.util.Random;

public class StatusChanger implements Runnable {
    private AbstractProgram object;

    public StatusChanger(AbstractProgram abstractProgram) {
        object = abstractProgram;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Random random = new Random();
            AbstractProgram.States newStatus =  AbstractProgram.States.values()[random.nextInt(AbstractProgram.States.values().length)];
            synchronized (object) {
                object.setStatus(newStatus);
                System.out.println("AbstractProgram status - " + newStatus);
                object.notifyAll();
            }
        }
    }
}