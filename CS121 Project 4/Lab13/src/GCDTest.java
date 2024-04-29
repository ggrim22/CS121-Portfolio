import java.util.*;
public class GCDTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        int n1 = scanner.nextInt();
        System.out.println("Enter the second number: ");
        int n2 = scanner.nextInt();
        GCD gcd = new GCD(n1, n2);

        System.out.printf("For loop GCD: %d\n", gcd.findGCDForLoop(n1, n2));
        System.out.printf("While loop GCD: %d\n", gcd.findGCDWhileLoop(n1 , n2));
        System.out.printf("Recursion GCD: %d\n", gcd.findGCDRecursively(n1 , n2));

    }
}
