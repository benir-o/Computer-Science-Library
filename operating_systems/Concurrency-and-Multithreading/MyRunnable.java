public class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Thread is running");
    }

    public static void main(String[] args) {
        var task = new MyRunnable();
        // We then pass a runnable object into our thread instantiation
        Thread thread2 = new Thread(task);
        thread2.start();

    }

}
