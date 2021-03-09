public class Rectangle extends Shape{
    private double height;

    private double width;

    @Override
    public double square() {
        return height*width;
    }

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }
}
