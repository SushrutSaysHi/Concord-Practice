public class Pattern {
    public static void main(String[] args) {
        int n = 5;
        for (int i = 1; i <= n; i++) {
            // Leading spaces
            for (int s = 1; s <= (n - i); s++) {
                System.out.print(" ");
            }
            // Ascending part
            int num = i;
            for (int j = 1; j <= i; j++) {
                System.out.print(num + "");
                num++;
            }
            // Descending part
            num -= 2;
            for (int j = 1; j < i; j++) {
                System.out.print(num + "");
                num--;
            }
            System.out.println();
        }
    }
}