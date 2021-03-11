public class Circle extends Shape{

    private double radius;

    @Override
    public double square() {
        return Math.PI*radius*radius;
    }

    @Override
    public double length() {
        return 2 * (Math.PI*radius);
    }

    public Circle(double radius) {
        this.radius = radius;
    }
}
