import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Driver {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newSingleThreadExecutor();
        Future<Integer> result = pool.submit(new Summation(10));
        try {
            System.out.println("sum=" + result.get());
            pool.shutdown();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();

        }
    }
}
