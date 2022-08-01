import java.util.*;

public class Main {

    public static void main(String[] args) {

        int result = 0;

        Scanner in = new Scanner(System.in);

        String input = in.nextLine();

        String[] numbersStr = input.split(" ");

        int[] numbers = new int[numbersStr.length];

        for (int i = 0; i < numbersStr.length; i++)
        {
            numbers[i] = Integer.parseInt( numbersStr[i] );
        }

        for (int j = 0; j < numbers.length; j+=3)
        {
            // check if the first number is 1, 2, or 9
            if (numbers[j]== 9)
            {
                break;
            }
            else if (numbers[j] == 1)
            {
                // 1 means add
                result = numbers[j + 1] + numbers [j + 2];
            }
            else if (numbers[j] == 2)
            {
                // 2 means subtract, need to find larger
                if (numbers[j + 1] > numbers [j + 2])
                {
                    result = numbers[j + 1] - numbers [j + 2];
                }
                else
                {
                    result = numbers[j + 2] - numbers [j + 1];
                }
            }

            System.out.println(result);
        }
    }
}
