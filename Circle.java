package oop.project;

/** A circle defined by a positive radius. */
public class Circle extends Shape {
    private double raduis;

    public Circle(String color, double raduis) {
        super(color);
        setRaduis(raduis);
    }

    public Circle(double raduis) {
        super();
        setRaduis(raduis);
    }

    public double getRaduis() {
        return raduis;
    }

    public void setRaduis(double raduis) {
        if (!Double.isFinite(raduis) || raduis <= 0) {
            throw new IllegalArgumentException("Circle radius must be a positive number.");
        }
        this.raduis = raduis;
    }

    @Override
    public double getArea() {
        return Math.PI * raduis * raduis;
    }

    @Override
    public double getPerimete() {
        return 2 * Math.PI * raduis;
    }

    @Override
    public String HowToDraw() {
        return "Use radius = " + raduis + " to draw the circle.";
    }

    @Override
    public String toString() {
        return "Circle{radius=" + raduis + "}";
    }
}
