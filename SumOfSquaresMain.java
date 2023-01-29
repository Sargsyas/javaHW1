import java.util.Scanner;

public class SumOfSquaresMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int inputs = input.nextInt();

        int[] numbers = new int[inputs];
        int count = 0;

        while (count < inputs) {
            int num = input.nextInt();
            numbers[count] = num;
            count++;
        }
        int total = 0;

        for (int i = 0; i < count; i++) {
            int indNum = 0;
            indNum = numbers[i] * numbers[i];
            total += indNum;
        }
        System.out.println(total);

    }

}

