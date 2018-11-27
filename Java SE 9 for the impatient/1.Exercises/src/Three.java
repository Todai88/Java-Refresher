import java.util.Arrays;
import java.util.Scanner;

public class Three {

    public Three() {
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
