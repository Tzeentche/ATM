package main.java;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Operator {

    static int readIntNumber(String msg) {
        System.out.println(msg);

        int reslt = 0;
        try {

            Scanner scn = new Scanner(System.in);
            reslt = scn.nextInt();

        } catch (InputMismatchException imex) {
            imex.printStackTrace();
        } catch (NoSuchElementException nsee) {
            nsee.printStackTrace();
        }

        return reslt;
    }

    static double readDoubleNumber(String msg) {
        System.out.println(msg);

        double reslt = 0.0;
        try {
            Scanner scn = new Scanner(System.in);
            reslt = scn.nextDouble();
        } catch (InputMismatchException imex) {
            imex.printStackTrace();
        } catch (NoSuchElementException nsee) {
            nsee.printStackTrace();
        }
        return reslt;
    }

    static String readString(String msg) {
        System.out.println(msg);

        String reslt = "";
        try {
            Scanner scn = new Scanner(System.in);
            reslt = scn.next();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return reslt;
    }

    static double doOperation(double v1, double v2) {
        int operation = selectOperation();
        double resultOfOperation = 0;
        switch (operation) {
            case 1: {
                Math.round(resultOfOperation = v1 + v2);
                break;
            }
            case 2: {
                Math.round(resultOfOperation = v1 - v2);
                break;
            }
            case 3: {
                Math.round(resultOfOperation = v1 * v2);
                break;
            }
            case 4: {
                Math.round(resultOfOperation = (double) v1 / v2);
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
