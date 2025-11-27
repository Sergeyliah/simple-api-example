import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT)
class ParallelOnlyThisClassTest {

    @Test
    void testA() {
        System.out.println("Test A — " + Thread.currentThread().getName());
    }

    @Test
    void testB() {
        System.out.println("Test B — " + Thread.currentThread().getName());
    }

    @Test
    void testC() {
        System.out.println("Test C — " + Thread.currentThread().getName());
    }
}
