import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.RepeatedTest;

public class ParallelSingleTest {

    @Test
    void runSingleTestInTenThreads() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10; i++) {
            executor.submit(() -> {
                runTestLogic();
            });
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
    }

    private void runTestLogic() {
        System.out.println("Running in thread: " + Thread.currentThread().getName());
        // your actual test logic here
    }

    @RepeatedTest(10)
    void myTest() {
        System.out.println("Running in thread: " + Thread.currentThread().getName());
        // your actual test logic here
    }

    @Test
    void myTest2() throws InterruptedException {
        System.out.println("Running in thread: " + Thread.currentThread().getName());
        Thread.sleep(1000);
    }

    @Test
    void myTest3() throws InterruptedException {
        System.out.println("Running in thread: " + Thread.currentThread().getName());
        Thread.sleep(1000);
    }

    @Test
    void myTest4() throws InterruptedException {
        System.out.println("Running in thread: " + Thread.currentThread().getName());
        Thread.sleep(1000);
    }

    @Test
    void myTest5() throws InterruptedException {
        System.out.println("Running in thread: " + Thread.currentThread().getName());
        Thread.sleep(1000);
    }
}
