package calculator.service;

public class ArithmeticService {

    public int sum(int a, int b) {
        return a + b;
    }

    public int deduc(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int split(int a, int b) {
        int result = 0;

        try {
            result = a / b;
        } catch (ArithmeticException ex) {
            //TODO: log.ERROR(...)
            ex.printStackTrace();
        }

        return result;
    }
}
