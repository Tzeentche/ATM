import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CircleTest {

    double radius;

    @Test
    public void square() {

        System.out.println(Math.PI*radius*radius);
        Circle circle = new Circle(3.00);
        Assert.assertNotNull(circle.square());
        System.out.println(circle);
    }

    @Test
    public void length() {

        System.out.println(2 * (Math.PI*radius));
        Circle circle = new Circle(32.56);

    }
}