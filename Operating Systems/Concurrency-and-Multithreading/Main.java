class Main {
    public static void main(String[] args) {
        System.out.println("Concurrency and Multithreading");
        var thread1 = new MyThread();
        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            System.out.println("Main Thread got Interrupted");
        }

        System.out.println("Main Thread Completed");
    }
}