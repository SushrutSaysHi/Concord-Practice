/*  NOT A + NOT B
 * A + B
 * 
 */

public class LogicGate {
    public static boolean nand(boolean a, boolean b) {
        return (a & b) == true ? false : true;
    }

    public static void main(String[] args) {
        boolean a = true;
        boolean b = true;
        System.out.println(nand(!a, !b));
    }
}