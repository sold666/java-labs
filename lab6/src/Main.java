public class Main {
    public static void main(String[] args) {
        Supervisor program = new Supervisor(new AbstractProgram());
        new Thread(program).start();
    }
}