package Box;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setLength(double length) {
        if (isLowerThanZero(length)) {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.length = length;
    }

    private void setWidth(double width) {
        if (isLowerThanZero(width)) {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    private boolean isLowerThanZero(double val) {
        return val <= 0;
    }

    private void setHeight(double height) {
        if (isLowerThanZero(height)) {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
        this.height = height;
    }

    public double calculateSurfaceArea() {
        double result = (2 * (this.length * this.width)) +
                (2 * (this.length * this.height)) + (2 * (this.width * this.height));
        return result;
    }

    public double calculateLateralSurfaceArea() {
        double result = (2 * (this.length * this.height)) + (2 * (this.width * this.height));
        return result;
    }

    public double calculateVolume() {
        double result = this.length * this.width * this.height;
        return result;
    }

    @Override
    public String toString() {
        return String.format("Surface Area - %.2f%nLateral Surface Area - %.2f%nVolume - %.2f",
                this.calculateSurfaceArea(),this.calculateLateralSurfaceArea(),this.calculateVolume());
    }
}
