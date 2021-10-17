package Shapes;

public abstract class Shape {
    private Double perimeter;
    private Double area;

    public Double getArea() {
        return area = calculateArea();
    }

    public Double getPerimeter() {
        return perimeter = calculatePerimeter();
    }

    protected abstract Double calculatePerimeter();

    protected abstract Double calculateArea();
}
