# OOP Shapes Project

A small Java console project that demonstrates object-oriented programming concepts by modelling circles and cubes.

## Features

- Uses an abstract `Shape` class and an abstract `ThreeDShape` class.
- Uses an interface (`Drawble`) to describe how a shape can be drawn.
- Demonstrates inheritance, method overriding, encapsulation, and polymorphism.
- Reads shape data from `input.txt` and writes each shape's area and the total area to `sumAreas.txt`.
- Validates shape dimensions and reports invalid input instead of silently continuing.

## Supported input

The first line contains the number of shapes. Each following line contains a shape type (`Circle` or `Cube`) and one positive dimension (radius for a circle, side length for a cube).

Example `input.txt`:

```text
4
Circle 2
Cube 3
Circle 1.5
Cube 2
```

The program calculates circle area with `pi * radius * radius` and cube surface area with `6 * side * side`. It sums those areas and writes the results to `sumAreas.txt`.

## Run

From the project root, compile and run with a JDK:

```bash
javac -d out src/oop/project/*.java
java -cp out oop.project.OOPProject
```

Make sure `input.txt` is in the working directory when running the program.

## Limitations

- This is an academic Java OOP project, not a web backend application.
- Cube `getPerimete()` returns the combined length of its 12 edges, since a 3D cube does not have a 2D perimeter in the usual sense.
