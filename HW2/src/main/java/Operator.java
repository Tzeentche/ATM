
public class Operator {

    double variable;

    public double summ(double variable1, double variable2) {

        variable = (variable1 + variable2) * 100;
        return variable / 100;
    }

    public double minus(double variable1, double variable2) {

        variable = Math.round((variable1 - variable2) * 100);
        return (variable / 100);
    }

    public double multiply(double variable1, double variable2) {

        variable = Math.round((variable1 * variable2) * 100);
        return (variable / 100);
    }

    public double divide(double variable1, double variable2) {

        try {
            variable = Math.round((variable1 / variable2) * 10);
        } catch (ArithmeticException ex) {
            System.out.println("Divide by 0: " + ex);
        }
        return (variable / 10);
    }

}
