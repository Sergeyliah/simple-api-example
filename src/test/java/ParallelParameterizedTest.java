import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@Execution(ExecutionMode.CONCURRENT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ParallelParameterizedTest {

    @ParameterizedTest
    @ValueSource(strings = {"A", "B", "C", "D"})
    void testWithParams(String value) throws InterruptedException {
        System.out.printf("Thread: %s, Value: %s%n", Thread.currentThread().getName(), value);
        Thread.sleep(500); // симуляция нагрузки
    }
}
