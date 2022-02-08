public class AbstractProgram implements Runnable {
    enum States {UNKNOWN, STOPPING, RUNNING, FATAL, ERROR}

    private boolean isRunning;
    private States status;

    public AbstractProgram() {
        isRunning = true;
        status = States.RUNNING;
    }

    @Override
    public void run() {
        System.out.println("AbstractProgram - start");

        Thread statusChanger = new Thread(new StatusChanger(this));
        statusChanger.setDaemon(true);
        statusChanger.start();

        synchronized (this) {
            while(isRunning) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("AbstractProgram - stop");
    }

    public synchronized States getStatus() {
        return this.status;
    }

    public synchronized void setStatus(States status) {
        this.status = status;
    }

    public synchronized void restart() {
        this.status = States.RUNNING;
        System.out.println("AbstractProgram - restart");
        this.notifyAll();
    }

    public synchronized void stop() {
        this.isRunning = false;
        this.notifyAll();
    }
}
