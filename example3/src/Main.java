public class Main {

    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Triangle(5, 3);
        shapes[1] = new Rectangle(5, 6);
        shapes[2] = new Circle(10);
        for (Shape shape : shapes) {
            System.out.println(shape.square());
        }

        for(Shape shape : shapes) {
            System.out.println(shape.length());
        }
    }
}
