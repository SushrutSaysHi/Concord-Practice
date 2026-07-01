public class SecondLargest {
    public static void main(String[] args) {
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        int[] intarray = { 12, 35, 1, 10, 34, 1 };
        for (int i = 0; i < intarray.length; i++) {
            if (first < intarray[i]) {
                first = intarray[i];
            }
            if (intarray[i] > second && intarray[i] != first) {
                second = intarray[i];
            }
        }
        System.out.println("Largest element is: " + first);
        System.out.println("Second Largest element is " + second);
    }
}
