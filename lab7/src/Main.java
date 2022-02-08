import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            throw new RuntimeException("You have to pass arguments! (Number of threads)");
        }
        int numberOfThreads = Integer.parseInt(args[0]);
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        ThreadFactory readerFactory = new CreateOwnThread("Reader");
        ThreadFactory writerFactory = new CreateOwnThread("Writer");
        ExecutorService writersService = Executors.newFixedThreadPool(numberOfThreads, writerFactory);
        ExecutorService readersService = Executors.newFixedThreadPool(numberOfThreads, readerFactory);

        for (int i = 0; i < numberOfThreads; i++) {
            writersService.execute(() -> {
                System.out.println("Writing task is running");
                try {
                    while(true) {
                        Thread.sleep(3000);
                        queue.put("Message from - " + Thread.currentThread().getName());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            readersService.execute(() -> {
                System.out.println("Reading task is running");
                try {
                    while(true) {
                        String resultMessage = queue.take();
                        System.out.println("Received message: " + "\"" + resultMessage + "\"" + " " + Thread.currentThread().getName());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }
}