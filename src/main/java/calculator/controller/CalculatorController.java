package calculator.controller;

import calculator.service.ArithmeticService;
import calculator.view.BaseInterface;
import calculator.view.imlp.TerminalView;

public class CalculatorController {

    private ArithmeticService arithmeticService;
    private BaseInterface baseInterface;

    public static void main(String[] args) {
        CalculatorController calculatorController = new CalculatorController(
            new ArithmeticService(),
            new TerminalView()
        );

        int num1 = calculatorController.baseInterface.getNumber();
        int num2 = calculatorController.baseInterface.getNumber();
        char operation = calculatorController.baseInterface.getChar();

        System.out.println(
            calculatorController.calc(num1, num2, operation)
        );
    }

    public CalculatorController(
        final ArithmeticService arithmeticService,
        final BaseInterface baseInterface
    ) {
        this.arithmeticService = arithmeticService;
        this.baseInterface = baseInterface;
    }

    private char getOperation() {
        return baseInterface.getChar();
    }

    public int calc(int num1, int num2, char operation) {
        int result;

        switch (operation) {
            case '+':
                result = arithmeticService.sum(num1, num2);
                break;
            case '-':
                result = arithmeticService.deduc(num1, num2);
                break;
            case '*':
                result = arithmeticService.multiply(num1, num2);
                break;
            case '/':
                result = arithmeticService.split(num1, num2);
                break;
            default:
                System.out.println("Incorrect operation...Please try again");
                result = calc(num1, num2, getOperation());//рекурсия
        }

        return result;
    }
}
