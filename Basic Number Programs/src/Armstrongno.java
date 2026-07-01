import java.util.Scanner;

public class Armstrongno {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number");

        int number = sc.nextInt();

        if (ArmstrongNo(number) == 1) {
            System.out.println(number + " is an armstrong number");
        } else {
            System.out.println("Not armstrong number");
        }
        sc.close();
    }

    public static int ArmstrongNo(int n) {
        int sum = 0;
        int n_copy = n;
        while (n > 0) {
            int d1 = n % 10;
            n /= 10;
            sum += Math.pow(d1, 3);
            System.out.println("Sum is" + sum);
        }
        if (sum == n_copy) {
            return 1;
        } else {
            return 0;
        }
    }
}
