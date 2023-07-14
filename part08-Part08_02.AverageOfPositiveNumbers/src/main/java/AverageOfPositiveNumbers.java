
import java.util.Scanner;

public class AverageOfPositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int counter = 0;
        while (true) {
            int value = Integer.valueOf(scanner.nextInt());

            if(value == 0) {
                break;
            } else if (value < 0) {
                continue;
            }
            else {
                sum += value;
                counter++;
            }


        }
        System.out.println(1.0 * sum/counter);

    }
}
