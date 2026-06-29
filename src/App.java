import java.util.Scanner;

public class App{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int n = number;
        int sum_digit=0;
        int sumPrime=0;
        while (n>0){
            int d1=n%10;
            n=n/10;
            sum_digit+=d1;
        }

        n=number;

        for (int i = 2; i < n; i++) {
            if(n%i==0){
                if(isPrime(i)){
                    sumPrime+=i;
                    System.out.println(i);
                }
            }
        }

        if (sum_digit==sumPrime){
            System.out.println("Smith number");
        }
        
    }
    public static boolean isPrime(int n){
        if(n<=1){
            return false;
        }

        if(n==2){
            return true;
        }

        if(n%2==0){
            return false;
        }

         for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false; // Found a factor, not prime
            }
        }
        return true;
    }
}