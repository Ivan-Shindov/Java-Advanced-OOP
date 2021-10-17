package Shapes;

public class Rectangle extends Shape{
    private final Double height;
    private final Double width;

    public Rectangle(Double height,Double width) {
        this.height = height;
        this.width = width;
    }

    public final Double getHeight() {
        return height;
    }

    public final Double getWidth() {
        return width;
    }

    @Override
    protected Double calculatePerimeter() {
        return 2 * (this.height + this.width);
    }

    @Override
    protected Double calculateArea() {
        return this.height + this.width;
    }
}
