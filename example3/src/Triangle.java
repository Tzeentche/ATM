public class Triangle extends Shape{

    private double base;

    private double height;

    @Override
    public double square() {
        return base*height/2;
    }

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }
}
