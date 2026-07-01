import java.util.Scanner;

public class PalindromeString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder builder = new StringBuilder();
        System.out.print("Enter a string: ");
        String input = sc.next();

        for (char c : input.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                builder.append(c);
            }
        }
        String str = builder.toString();
        String reverse = builder.reverse().toString();

        if (str.equals(reverse)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a Palindrome");
        }
        sc.close();
    }
}
