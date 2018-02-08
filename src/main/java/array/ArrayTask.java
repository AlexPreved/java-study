package array;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayTask {

    public static void main(String[] args) {
        System.out.println(
            "Please, choose your task's type \n"
                + String.format(
                "Exist: [%s], [%s}",
                "text",
                "num"
            )
        );

        System.out.println(
            "Please, choose your task's type \n"
                + String.format(
                "Exist: [%s], [%s}",
                "text",
                "num"
            )
        );

        switch (getString()) {
            case "text":
                runTextTask();
                break;

            case "num":
                runIntTask();
                break;

            default:
                System.out.println(
                    "Operation not found!"
                );
                break;
        }
    }

    private static void runTextTask() {
        System.out.println(
            "Enter array lenght plz: "
        );
        int size = getNumber();
        String array[] = new String[size];

        System.out.println(
            "Text plz:"
        );
        for (int i = 0; i < array.length; i++) {
            array[i] = getString();
        }

        System.out.println(
            getLongestWord(array)
        );
    }

    private static void runIntTask() {
        int[] array = getRandomArray();

        System.out.println(
            Arrays.toString(array)
        );

        array = swapMinPositiveAndMaxNegative(array);

        System.out.println(
            Arrays.toString(array)
        );
    }

    public static int[] getRandomArray() {
        int[] array = new int[20];

        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 21) - 10;
        }

        return array;
    }

    public static String getString() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(
            "String plz: "
        );

        String string;

        if (scanner.hasNext()) {
            string = scanner.next();
        } else {
            System.out.println(
                "Incorrect string...Please try again"
            );
            scanner.next();//recursion
            string = getString();
        }

        return string;
    }

    public static String getLongestWord(String[] words) {
        return Arrays.stream(words).max(
            (word1, word2) -> {
                if (word1.length() == word2.length()) {
                    return 0;
                }

                return word1.length() < word2.length() ? -1 : 1;
            }
        ).orElseThrow(
            () -> new IllegalArgumentException(
                "Array must contain values"
            )
        );
    }

    public static int getNumber() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(
            "int plz: "
        );

        int num;

        if (scanner.hasNextInt()) {
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

    public static int[] swapMinPositiveAndMaxNegative(int[] array) {
        if (array == null || array.length < 2) {
            return array;
        }

        int indexOfMinPos = 0;
        int indexOfMaxNeg = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                continue;
            }

            if (array[i] < 0) {
                if (indexOfMaxNeg == 0 || array[i] > array[indexOfMaxNeg]) {
                    indexOfMaxNeg = i;
                }
            }

            if (array[i] > 0) {
                if (indexOfMinPos == 0 || array[i] < array[indexOfMinPos]) {
                    indexOfMinPos = i;
                }
            }
        }

        int tmp;
        tmp = array[indexOfMinPos];
        array[indexOfMinPos] = array[indexOfMaxNeg];
        array[indexOfMaxNeg] = tmp;

        return array;
    }
}