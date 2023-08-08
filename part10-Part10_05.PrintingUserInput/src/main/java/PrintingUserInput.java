
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrintingUserInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> lines = new ArrayList<>();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("")){
                break;
            }
            lines.add(input);

        }

        lines.stream().forEach(name -> System.out.println(name));

    }
}
