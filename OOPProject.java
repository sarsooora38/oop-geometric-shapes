package oop.project;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/** Reads shapes from input.txt and writes their areas and total to sumAreas.txt. */
public class OOPProject {
    private static final Path INPUT_FILE = Paths.get("input.txt");
    private static final Path OUTPUT_FILE = Paths.get("sumAreas.txt");

    public static void main(String[] args) {
        try {
            List<Shape> shapes = readShapes(INPUT_FILE);
            writeAreas(OUTPUT_FILE, shapes);
            System.out.println("Finished successfully. Results saved to " + OUTPUT_FILE.toAbsolutePath());
        } catch (IOException | IllegalArgumentException ex) {
            System.err.println("Could not process the input: " + ex.getMessage());
        }
    }

    private static List<Shape> readShapes(Path file) throws IOException {
        if (!Files.exists(file)) {
            throw new IOException("input.txt was not found in the project working directory.");
        }

        List<Shape> shapes = new ArrayList<>();
        try (Scanner scanner = new Scanner(Files.newBufferedReader(file, StandardCharsets.UTF_8))) {
            if (!scanner.hasNextInt()) {
                throw new IllegalArgumentException("The first line must contain the number of shapes.");
            }
            int count = scanner.nextInt();
            if (count < 0) {
                throw new IllegalArgumentException("The number of shapes cannot be negative.");
            }

            for (int i = 1; i <= count; i++) {
                if (!scanner.hasNext()) {
                    throw new IllegalArgumentException("Missing shape type for shape " + i + ".");
                }
                String type = scanner.next().toLowerCase(Locale.ROOT);
                if (!scanner.hasNextDouble()) {
                    throw new IllegalArgumentException("Missing or invalid dimension for shape " + i + ".");
                }
                double dimension = scanner.nextDouble();

                switch (type) {
                    case "circle":
                        shapes.add(new Circle(dimension));
                        break;
                    case "cube":
                        shapes.add(new Cube(dimension));
                        break;
                    default:
                        throw new IllegalArgumentException(
                                "Unsupported shape '" + type + "' on item " + i + ". Use Circle or Cube.");
                }
            }

            if (scanner.hasNext()) {
                throw new IllegalArgumentException("There are extra values after the declared shapes.");
            }
        }
        return shapes;
    }

    private static void writeAreas(Path file, List<Shape> shapes) throws IOException {
        DecimalFormat format = new DecimalFormat("0.00");
        double totalArea = 0.0;

        try (BufferedWriter writer = Files.newBufferedWriter(file, StandardCharsets.UTF_8)) {
            writer.write("Shape areas");
            writer.newLine();
            writer.write("------------");
            writer.newLine();

            for (int i = 0; i < shapes.size(); i++) {
                Shape shape = shapes.get(i);
                double area = shape.getArea();
                totalArea += area;
                writer.write((i + 1) + ". " + shape.getClass().getSimpleName()
                        + " - area = " + format.format(area));
                writer.newLine();
            }

            writer.newLine();
            writer.write("Total area = " + format.format(totalArea));
            writer.newLine();
        }
    }
}
