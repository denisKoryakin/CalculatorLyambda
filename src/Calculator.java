
import java.util.function.Supplier;

public class Calculator {
    static Supplier<Calculator> instance = Calculator::new;

    public Calculator() {
    }

    @FunctionalInterface
    public interface BinaryOperator<Integer> {
        Integer apply(Integer x, Integer y);
    }

    @FunctionalInterface
    public interface UnaryOperator<Integer> {
        Integer apply(Integer x);
    }

    @FunctionalInterface
    public interface Predicate<Integer> {
        boolean apply(Integer x);
    }

    @FunctionalInterface
    public interface Consumer<T> {
        void accept(T t);
    }

    Calculator.BinaryOperator<Integer> plus = (x, y) -> x + y;
    Calculator.BinaryOperator<Integer> minus = (x, y) -> x - y;
    Calculator.BinaryOperator<Integer> multiply = (x, y) -> x * y;
    //    Calculator.BinaryOperator<Integer> devide = (x, y) -> x / y;
//    Данная реализация деления не предусматривает обработку ошибки при делении на ноль, можно решить через:
//    1. обработку исключения ArithmeticException в функциональном методе devide;
    Calculator.BinaryOperator<Integer> devide = (x, y) -> {
        try {
            return (x / y);
        } catch (ArithmeticException e) {
            System.out.println("Разделить на 0 не возможно");
            return y;
        }
    };
    //    2. Через тернарный оператор, но в таком случае из-за того, что возвращаемое значение строго типизировано вернуть
//    пояснение в виде строки не получится
//    Calculator.BinaryOperator<Integer> devide = (x, y) -> y != 0 ? x / y : y;
    Calculator.UnaryOperator<Integer> pow = x -> x * x;
    Calculator.UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;
    Calculator.Predicate<Integer> isPositive = x -> x > 0;
    Consumer<Integer> println = System.out::println;
}
