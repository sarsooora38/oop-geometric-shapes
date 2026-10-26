package oop.project;

/** A cube defined by a positive side length. */
public class Cube extends ThreeDShape {
    private double side;

    public Cube(double side, String color) {
        super(color);
        setSide(side);
    }

    public Cube(double side) {
        super();
        setSide(side);
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        if (!Double.isFinite(side) || side <= 0) {
            throw new IllegalArgumentException("Cube side must be a positive number.");
        }
        this.side = side;
    }

    @Override
    public double getArea() {
        return 6 * side * side;
    }

    /** Returns the sum of the lengths of the cube's 12 edges. */
    @Override
    public double getPerimete() {
        return 12 * side;
    }

    @Override
    public double getVolume() {
        return side * side * side;
    }

    @Override
    public String HowToDraw() {
        return "Use side length = " + side + " to draw the cube.";
    }

    @Override
    public String toString() {
        return "Cube{side=" + side + "}";
    }
}
