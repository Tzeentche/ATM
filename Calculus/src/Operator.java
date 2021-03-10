import java.util.Scanner;

public class Operator {

    static int readIntNumber(String msg) {
        System.out.println(msg);
        Scanner scn = new Scanner(System.in);
        return scn.nextInt();
    }

    static double readDoubleNumber(String msg) {
        System.out.println(msg);
        Scanner scn = new Scanner(System.in);
        return scn.nextDouble();
    }

    static String readString(String msg) {
        System.out.println(msg);
        Scanner scn = new Scanner(System.in);
        return scn.next();
    }

    static double doOperation(double v1, double v2) {
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
        return readIntNumber("Please, enter number of operation:");
    }
}
