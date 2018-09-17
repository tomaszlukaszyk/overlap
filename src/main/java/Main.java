import java.util.Scanner;

public class Main {

    private Rectangle rectangle1;
    private Rectangle rectangle2;
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    private void run() {
        this.rectangle1 = getRectangle("first");
        this.rectangle2 = getRectangle("second");
        int overlapX = getOverlap("x");
        int overlapY = getOverlap("y");
        System.out.printf("Overlapping area of the two rectangles is equal to %d", overlapX * overlapY);
    }

    private Rectangle getRectangle(String rectangleNumber) {
        Rectangle rectangle = new Rectangle();
        System.out.printf("Provide coordinates for the %s rectangle:\n", rectangleNumber);
        rectangle.setBottomLeftX(getCoordinate("bottom left x"));
        rectangle.setBottomLeftY(getCoordinate("bottom left y"));
        rectangle.setTopRightX(getCoordinate("top right x"));
        rectangle.setTopRightY(getCoordinate("top right y"));
        return rectangle;
    }

    private int getCoordinate(String coordinateName) {
        Integer coordinate = null;
        while (coordinate == null) {
            System.out.printf("Enter value of %s: ", coordinateName);
            try {
                coordinate = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Not a valid number");
            }
        }
        return coordinate;
    }

    private int getOverlap(String option) {
        int firstCoordinate = Math.max(
                option.equalsIgnoreCase("x") ? this.rectangle1.getBottomLeftX() : this.rectangle1.getBottomLeftY(),
                option.equalsIgnoreCase("x") ? this.rectangle2.getBottomLeftX() : this.rectangle2.getBottomLeftY()
        );
        int secondCoordinate = Math.min(
                option.equalsIgnoreCase("x") ? this.rectangle1.getTopRightX() : this.rectangle1.getTopRightY(),
                option.equalsIgnoreCase("x") ? this.rectangle2.getTopRightX() : this.rectangle2.getTopRightY()
        );
        if (firstCoordinate > secondCoordinate)
            return 0;
        return Math.abs(firstCoordinate) + Math.abs(secondCoordinate);
    }
}
