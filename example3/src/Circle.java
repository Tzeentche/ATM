public class Circle extends Shape{

    private double radius;

    @Override
    public double square() {
        return Math.PI*radius*radius;
    }

    public Circle(double radius) {
        this.radius = radius;
    }
}
