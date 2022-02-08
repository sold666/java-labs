public class Supervisor implements Runnable {
    private final AbstractProgram abstractProgram;

    public Supervisor(AbstractProgram abstractProgram) {
        this.abstractProgram = abstractProgram;
    }

    @Override
    public void run() {
        new Thread(abstractProgram).start();
        System.out.println("Supervisor - start");

        synchronized (abstractProgram) {
            while (true) {
                try {
                    abstractProgram.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (abstractProgram.getStatus() == AbstractProgram.States.FATAL) {
                    System.out.println("Supervisor - stopping AbstractProgram");
                    break;
                }
                else if(abstractProgram.getStatus() == AbstractProgram.States.UNKNOWN ||
                        abstractProgram.getStatus() == AbstractProgram.States.STOPPING) {
                    System.out.println("Supervisor - restarting AbstractProgram");
                    abstractProgram.restart();
                }
            }
        }
        abstractProgram.stop();
        System.out.println("Supervisor - stop");
    }
}