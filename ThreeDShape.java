package oop.project;

/** Base abstraction for three-dimensional shapes. */
abstract class ThreeDShape extends Shape {
    protected ThreeDShape(String color) {
        super(color);
    }

    protected ThreeDShape() {
        super();
    }

    public abstract double getVolume();
}
