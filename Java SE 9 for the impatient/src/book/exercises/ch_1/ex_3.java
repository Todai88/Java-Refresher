package src.book.exercises.ch_1;

import java.util.Arrays;
import java.util.Scanner;

public class ex_3 {

    public ex_3() {
        Scanner in = new Scanner(System.in);
        this.first = in.nextInt();
        this.second = in.nextInt();
        this.third = in.nextInt();
    }

    int first, second, third;

    public void getMaxOfThree() {
        System.out.println(first > second ? first : second > third ? second : third);
    }

    public void getMaxOfThreeUsingMath() {
        System.out.println(Arrays.stream(new int[] {first, second, third}).max().getAsInt());
    }
}
