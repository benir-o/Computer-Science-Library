package concurrency_multithreading;

public class MyThread extends Thread {
    // by extension, we override the run method of the thread class
    public void run() {
        System.out.println("Thread is running....");
        try {
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Thread interrupted");
        }

    }

}
