public class Triangle extends Shape{

    private double base;

    private double height;

    @Override
    public double square() {
        return base*height/2;
    }

    @Override
    public double length() {return 2 * (Math.sqrt(base * base + height * height)) + 2 * base;}

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }
}
