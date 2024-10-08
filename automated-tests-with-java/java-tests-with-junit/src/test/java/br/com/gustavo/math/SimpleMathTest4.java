package br.com.gustavo.math;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * A anotação {@code @ParameterizedTest} no JUnit permite que você execute o mesmo teste várias vezes com diferentes conjuntos de parâmetros.
 * <ul>
 *     <li>É usada em conjunto com um dos "fornecedores de argumentos" (argument sources), como {@code @ValueSource}, {@code @CsvSource}, {@code @MethodSource}, etc., que fornecem os parâmetros que serão usados em cada execução do teste.</li>
 * </ul>
 */
@DisplayName("Test Math Operations in SimpleMath Class")
class SimpleMathTest4 {

    SimpleMath math;

    @BeforeEach
    void beforeEachMethod() {
        math = new SimpleMath();
    }

    @DisplayName("Test double subtraction [firstNumber, secondNumber, expected]")
    @ParameterizedTest
    //@MethodSource("testDivision")
    /* Se o method source tiver o mesmo nome do teste, eu não preciso informá-lo. Se o nome for diferente, é preciso informar no //@MethodSource("nomeMetodo") */
    @MethodSource()
    void testDivisionMethodSource(double firstNumber, double secondNumber, double expected) {

        System.out.println("Test " + firstNumber + " / " +
                secondNumber + " = " + expected + "!");

        Double actual = math.division(firstNumber, secondNumber);

        assertEquals(expected, actual, 2D,
                () -> firstNumber + "/" + secondNumber +
                        " did not produce " + expected + "!");
    }

    public static Stream<Arguments> testDivisionMethodSource() {
        return Stream.of(
                Arguments.of(6.2D, 2D, 3.1D),
                Arguments.of(71D, 14D, 5.07D),
                Arguments.of(18.3, 3.1D, 5.90D)
        );
    }

    @DisplayName("Test double subtraction [firstNumber, secondNumber, expected]")
    @ParameterizedTest
    @CsvSource({
            "6.2, 2, 3.1",
            "71, 14, 5.07",
            "18.3, 3.1, 5.90"
    })
    /**
     @CsvSource({
     "Pelé, Football",
     "Senna, F1",
     "Keith Moon, ''"
     })
     */
    void testDivisionCsvSource(double firstNumber, double secondNumber, double expected) {

        System.out.println("Test " + firstNumber + " / " +
                secondNumber + " = " + expected + "!");

        Double actual = math.division(firstNumber, secondNumber);

        assertEquals(expected, actual, 2D,
                () -> firstNumber + "/" + secondNumber +
                        " did not produce " + expected + "!");
    }

    @DisplayName("Test double subtraction [firstNumber, secondNumber, expected]")
    @ParameterizedTest
    @CsvFileSource(resources = "/testDivision.csv")
    void testDivisionCsvFileSource(double firstNumber, double secondNumber, double expected) {

        System.out.println("Test " + firstNumber + " / " +
                secondNumber + " = " + expected + "!");

        Double actual = math.division(firstNumber, secondNumber);

        assertEquals(expected, actual, 2D,
                () -> firstNumber + "/" + secondNumber +
                        " did not produce " + expected + "!");
    }

    @ParameterizedTest
    /* Com @ValueSource, o teste será executado para cada valor definido */
    @ValueSource(strings = {"Pelé", "Senna", "Keith Moon"})
    void testValueSource(String firsName) {
        System.out.println(firsName);
        assertNotNull(firsName);
    }
}
