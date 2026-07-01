import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();
        int n_copy = number;
        int reverse = 0;
        while (number > 0) {
            int d1 = number % 10;
            number /= 10;
            reverse = reverse * 10 + d1;
        }

        if (reverse == n_copy) {
            System.out.println("Palindrome Number");
        }

        sc.close();
    }
}
