package com.uzhnu.epam.course.week7;

import java.util.EmptyStackException;
import java.util.Stack;
import java.util.function.BiFunction;

public class Application {
    public static Double parse(String input) {
        try {
            Double calc = calc(input);
            if (Double.isNaN(calc) || Double.isInfinite(calc)) throw new ArithmeticException();
            return calc;
        } catch (EmptyStackException | NumberFormatException ex) {
            throw new RPNParserException();
        }
    }

    private static Double calc(String input) {
        Stack<Double> numbers = new Stack<>();
        String[] numbersSting = input.split(" ");

        for (String number : numbersSting) {
            switch (number) {
                case "+":
                    calcSign(numbers, new BiFunction<Double, Double, Double>() {
                        @Override
                        public Double apply(Double n1, Double n2) {
                            return n2 + n1;
                        }
                    });
                    break;
                case "-":
                    calcSign(numbers, new BiFunction<Double, Double, Double>() {
                        @Override
                        public Double apply(Double n1, Double n2) {
                            return n2 - n1;
                        }
                    });
                    break;
                case "*":
                    calcSign(numbers, new BiFunction<Double, Double, Double>() {
                        @Override
                        public Double apply(Double n1, Double n2) {
                            return n2 * n1;
                        }
                    });
                    break;
                case "/":
                    calcSign(numbers, new BiFunction<Double, Double, Double>() {
                        @Override
                        public Double apply(Double n1, Double n2) {
                            return n2 / n1;
                        }
                    });
                    break;
                default:
                    numbers.push(Double.parseDouble(number));
            }
        }

        return numbers.pop();
    }

    private static Stack<Double> calcSign(
            Stack<Double> numbers,
            BiFunction<Double, Double, Double> operation
    ) {
        numbers.push(operation.apply(numbers.pop(), numbers.pop()));
        return numbers;
    }
}
