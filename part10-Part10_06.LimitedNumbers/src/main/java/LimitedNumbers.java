
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LimitedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();

        while(true) {

            int num = Integer.valueOf(scanner.nextInt());
            if (num < 0) {
                break;
            }

            numbers.add(num);
        }

        numbers.stream().filter(n -> n > 1 && n <= 5).forEach(x -> System.out.println(x));

    }
}
