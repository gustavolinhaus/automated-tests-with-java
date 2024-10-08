package br.com.gustavo.math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * A anotação {@code @RepeatedTest} no JUnit é usada para executar o mesmo teste várias vezes, ou seja, repetir o teste um determinado número de vezes. Isso pode ser útil em várias situações, como para verificar a consistência de resultados ou detectar comportamentos não determinísticos (quando os testes falham ou passam de maneira intermitente).
*/
class DemoRepeatedTest {

    SimpleMath math;

    @BeforeEach
    void beforeEachMethod() {
        math = new SimpleMath();
        System.out.println("Running @BeforeEach method!");
    }

    /* Repete o teste 3 vezes */
    @RepeatedTest(value = 3, name = "{displayName}. Repetition "
            + "{currentRepetition} of {totalRepetitions}!")
    @DisplayName("Test Division by Zero")
    void testDivision_When_FirstNumberIsDividedByZero_ShouldThrowArithmeticException(
            RepetitionInfo repetitionInfo,
            TestInfo testInfo
    ) {

        System.out.println("Repetition N° " + repetitionInfo.getCurrentRepetition() +
                " of " + repetitionInfo.getTotalRepetitions());
        System.out.println("Running " + testInfo.getTestMethod().get().getName());

        //given
        double firstNumber = 6.2D;
        double secondNumber = 0D;

        var expectedMessage = "Impossible to divide by zero!";

        //when & then
        ArithmeticException actual = assertThrows(
                ArithmeticException.class, () -> {
                    //when & then
                    math.division(firstNumber, secondNumber);
                }, () -> "Division by zero should throw an ArithmeticException");

        assertEquals(expectedMessage, actual.getMessage(),
                () -> "Unexpected exception message!");
    }
}
