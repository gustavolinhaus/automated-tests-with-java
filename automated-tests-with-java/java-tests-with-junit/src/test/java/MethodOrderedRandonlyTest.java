import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * O JUnit executa os métodos de acordo com o nome. O {@code @TestMethodOrder(MethodOrderer.Random.class)}, faz executar os testes randomicamente.
*/
@TestMethodOrder(MethodOrderer.Random.class)
public class MethodOrderedRandonlyTest {

    @Test
    void testA() {
        System.out.println("Running Test A");
    }

    @Test
    void testB() {
        System.out.println("Running Test B");
    }

    @Test
    void testC() {
        System.out.println("Running Test C");
    }

    @Test
    void testD() {
        System.out.println("Running Test D");
    }

}
