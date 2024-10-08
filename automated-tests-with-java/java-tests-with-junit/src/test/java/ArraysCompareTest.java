import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * A anotação {@code @Timeout} no JUnit 5 é usada para definir um limite de tempo máximo para a execução de um método de teste. Se o teste demorar mais do que o tempo especificado, ele será interrompido e falhará com uma exceção de timeout.
 */
class ArraysCompareTest {

    @Test
    void test() {
        int[] numbers = {25,8,21,32,3};
        int[] expectedArray = {3,8,21,25,32};

        Arrays.sort(numbers);

        assertArrayEquals(numbers, expectedArray);
    }

    @Test
    // @Timeout(1)
//    @Timeout(value = 15, unit = TimeUnit.MILLISECONDS)
    void testSortPerformance() {

        int[] numbers = {25,8,21,32,3};
        for (int i = 0; i < 10000000; i++) {
            numbers[0] = i;
            Arrays.sort(numbers);
        }
    }

}
