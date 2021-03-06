package src.book.exercises.ch_1;

public class ex_2 {

    public void calculateAngle(int number) {
        System.out.println(String.format("%d normalized in range 0-359: %d", number,  (number % 359)));
    }

    public void calculateAngleUsingMath(int number) {
        System.out.println(String.format("%d normalized in range 0-359 using Math: %d", number, Math.floorMod(number, 359)));
    }
}
