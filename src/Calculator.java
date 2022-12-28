import java.util.function.*;

public class Calculator {
    static Supplier<Calculator> instance = Calculator::new;
    BinaryOperator<Integer> plus = Integer::sum;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;
    //    Calculator.BinaryOperator<Integer> devide = (x, y) -> x / y;
    //    Данная реализация деления не предотвращает попытку делении на ноль, можно решить через:
    BinaryOperator<Integer> divide = (x, y) -> y != 0 ? x / y : y;
    UnaryOperator<Integer> pow = x -> x * x;
    UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;
    Predicate<Integer> isPositive = x -> x > 0;
    Consumer<Integer> println = System.out::println;
}
