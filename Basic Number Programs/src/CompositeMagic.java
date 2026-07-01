import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CompositeMagic {

    public static int isMagicCheck = 0;

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter upper limit: ");
        int n = sc.nextInt();

        System.out.println("");

        System.out.print("Enter lower limit: ");
        int m = sc.nextInt();

        System.out.println();

        if (m < n) {
            for (int i = m; i <= n; i++) {
                isMagic(i);
                if (!isPrime(i) && (isMagicCheck == 1)) {
                    numbers.add(i);
                }
            }
            System.out.println("Numbers are: " + numbers);
            System.out.println("Frequency is: " + numbers.size());
        } else {
            System.out.println("Lower limit must be lesser than upper limit");
        }
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void isMagic(int n) {
        int sumDigit = 0;
        while (n > 9) {
            while (n != 0) {
                int d = n % 10;
                n = n / 10;
                sumDigit += d;
            }
            n = sumDigit;
            System.out.println(n);
            if (sumDigit == 1) {
                isMagicCheck = 1;

            } else {
                sumDigit = 0;
                isMagicCheck = 0;
            }
        }
    }
}
