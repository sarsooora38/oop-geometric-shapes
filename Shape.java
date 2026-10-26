package oop.project;

import java.util.Date;

/** Base abstraction shared by the project's geometric shapes. */
abstract class Shape implements Drawble {
    private final Date dateCreated;
    private String color;

    protected Shape() {
        this(null);
    }

    protected Shape(String color) {
        this.color = color;
        this.dateCreated = new Date();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getDateCreated() {
        return new Date(dateCreated.getTime());
    }

    public abstract double getArea();

    public abstract double getPerimete();

    @Override
    public String toString() {
        return getClass().getSimpleName()
                + "{dateCreated=" + dateCreated
                + ", color='" + color + "'}";
    }
}
