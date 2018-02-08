package calculator.view.imlp;

import calculator.view.BaseInterface;
import java.util.Scanner;

public class TerminalView implements BaseInterface {

    @Override
    public int getNumber() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(
            "int plz: "
        );

        int num;

        if(scanner.hasNextInt()){
            num = scanner.nextInt();
        } else {
            System.out.println(
                "Incorrect int... Please try again"
            );
            scanner.next();//recursion
            num = getNumber();
        }

        return num;
    }

    @Override
    public char getChar() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(
            "char plz: "
        );

        char operation;

        if(scanner.hasNext()){
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Incorrect chat...Please try again");
            scanner.next();//рекурсия
            operation = getChar();
        }

        return operation;
    }

    @Override
    public void stdOut(String message) {
        System.out.println(
            message
        );
    }
}
