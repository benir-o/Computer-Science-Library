import java.util.concurrent.Callable;

public class Summation implements Callable<Integer> {
    private int upper;

    public Summation(int upper) {
        this.upper = upper;
    }

    /* The thread will execute in this method */
    public Integer call() {
        Integer sum = 0;
        for (int i = 1; i <= upper; i++) {
            sum += i;

        }
        return sum;

    }
}
