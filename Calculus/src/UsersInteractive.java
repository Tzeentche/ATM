
import java.util.*;

public class UsersInteractive {

    Operator operator = new Operator();

    public void letsDance() {
        String yesNo = "Y";

        while ("Y".equals(yesNo)) {
            double value1 = operator.readNumber("Enter value 1: ");
            double value2 = operator.readNumber("Enter value 2: ");

            System.out.println("Value 1 = " + value1);
            System.out.println("Value 2 = " + value2);

            System.out.println("Result " + operator.doOperation(value1, value2));

            yesNo = operator.readString("Continue? (Y\\N)?");

            if (!"Y".equals(yesNo) || !"y".equals(yesNo)) {

                System.exit(0);
            }
        }
    }
}
