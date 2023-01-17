import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CalculatorTest {
    Calculator sut;

    @BeforeAll
    public static void startAllTest() {
        System.out.println("Calculator all tests started");
    }

    @BeforeEach
    public void startTest() {
        sut = new Calculator();
        System.out.println("Calculator test started");
    }

    @AfterAll
    public static void stopAllTests() {
        System.out.println("Calculator all tests completed");
    }

    @AfterEach
    public void stopTest() {
        sut = null;
        System.out.println("Calculator tests completed");
    }

    @Test
    public void testPlus() {
//        arrange (given)
        int a = 2, b = 10, expected = 12;
//        act (when)
        int result = sut.plus.apply(a, b);
//        assert (then)
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testMinus() {
//        arrange (given)
        int a = 2, b = 10, expected = -8;
//        act (when)
        int result = sut.minus.apply(a, b);
//        assert (then)
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testMultiply() {
//        arrange (given)
        int a = 2, b = 10, expected = 20;
//        act (when)
        int result = sut.multiply.apply(a, b);
//        assert (then)
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testDivideByNonZero() {
//        arrange (given)
        int a = 20, b = 10, expected = 2;
//        act (when)
        int result = sut.divide.apply(a, b);
//        assert (then)
        Assertions.assertEquals(expected, result);
    }


    @ParameterizedTest
    @MethodSource("sourceDivide")
    public void paramTestDivideByZero(/*arrange (given)*/ int a, int b) {
        Class<ArithmeticException> expectedExceptionClass = ArithmeticException.class;
//        act (when)
        Executable executable = () -> sut.divide.apply(a, b);
//        assert (then)
        Assertions.assertDoesNotThrow(executable);
    }

    public static Stream<Arguments> sourceDivide() {
        return Stream.of(Arguments.of(1, 0),
                Arguments.of(50, 0));
    }

    @Test
    public void testPow() {
//        arrange (given)
        int a = 12, expected = 144;
//        act (when)
        int result = sut.pow.apply(a);
//        assert (then)
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testAbs() {
//        arrange (given)
        int a = -10;
//        act (when)
        boolean result = sut.abs.apply(a) > 0;
//        assert (then)
        Assertions.assertTrue(result);
    }

    @Test
    public void testIsPositive() {
//        arrange (given)
        int a = -10, expected = 10;
//        act (when)
        int result = Math.abs(a);
//        assert (then)
        Assertions.assertEquals(result, expected);
    }
}
