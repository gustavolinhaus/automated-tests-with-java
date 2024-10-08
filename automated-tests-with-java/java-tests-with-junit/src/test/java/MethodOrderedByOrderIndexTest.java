import org.junit.jupiter.api.*;

/**
 * Ao utilizar {@code @TestInstance(TestInstance.Lifecycle.PER_CLASS)}, você instrui o JUnit a criar uma única instância da classe de teste e a reutilizá-la para todos os métodos de teste dessa classe.
 * <ul>
 * <li>Usado quando os testes dependem de um estado comum ou precisam compartilhar dados entre eles</li>
 * </ul>
 * O JUnit executa os métodos de acordo com o nome. O {@code @TestMethodOrder(MethodOrderer.OrderAnnotation.class)}, faz executar os testes de acordo com o order.
*/
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MethodOrderedByOrderIndexTest {

    StringBuilder actualValue = new StringBuilder("");

    @AfterEach
    void afterEach() {
        System.out.println("The actual value is: " + actualValue);
    }

    @Test
    @Order(1)
    void testC() {
        System.out.println("Running Test C");
        actualValue.append("1");
    }

    @Test
    @Order(2)
    void testD() {
        System.out.println("Running Test D");
        actualValue.append("2");
    }

    @Test
    @Order(3)
    void testA() {
        System.out.println("Running Test A");
        actualValue.append("3");
    }

    @Test
    @Order(4)
    void testB() {
        System.out.println("Running Test B");
        actualValue.append("4");
    }
}

