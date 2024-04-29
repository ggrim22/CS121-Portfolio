public class BalancedBracketsTester {
    public static void main(String[] args) {
        BalancedBrackets balanced = new BalancedBrackets();

        System.out.println("1. " + balanced.checkBalance("()"));
        System.out.println("2. " + balanced.checkBalance("(()"));
        System.out.println("3. " + balanced.checkBalance("(()())"));
        System.out.println("4. " + balanced.checkBalance("((((()(())))))"));
        System.out.println("5. " + balanced.checkBalance("())"));
        System.out.println("6. " + balanced.checkBalance(")(()))"));
    }


}
