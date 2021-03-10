import java.util.*;

public class Calculator {

    public static void main(String[] args) {

        String yesNo = "Y";

        while("Y".equals(yesNo)) {
            int value1 = readNumber("Enter value 1: ");
            int value2 = readNumber("Enter value 2: ");

            System.out.println("Value 1 = " + value1);
            System.out.println("Value 2 = " + value2);

            System.out.println("Result " + doOperation(value1, value2));

            yesNo = readString("Continue? (Y\\N)?");

            if(!"Y".equals(yesNo) || !"y".equals(yesNo)) {

                System.exit(0);
            }

        }
    }

    static int readNumber(String msg) {
        System.out.println(msg);
        Scanner scn = new Scanner(System.in);
        return scn.nextInt();
    }

    static String readString(String msg) {
        System.out.println(msg);
        Scanner scn = new Scanner(System.in);
        return scn.next();
    }

    static double doOperation(int v1, int v2) {
        int operation = selectOperation();
        double resultOfOperation = 0;
        switch (operation) {
            case 1: {
                resultOfOperation = v1 + v2;
                break;
            }
            case 2: {
                resultOfOperation = v1 - v2;
                break;
            }
            case 3: {
                resultOfOperation = v1 * v2;
                break;
            }
            case 4: {
                resultOfOperation = (double) v1 / v2;
                break;
            }
            case 5: {
                resultOfOperation = v1 % v2;
                break;
            }
            default: {
                System.out.println("Unknown operation");
            }
        }
        return resultOfOperation;
    }

    static int selectOperation() {
        System.out.println("1: +");
        System.out.println("2: -");
        System.out.println("3: *");
        System.out.println("4: /");
        System.out.println("5: %");
        return readNumber("Please, enter number of operation:");
    }
}
