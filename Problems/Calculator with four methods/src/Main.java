// Don't delete this import statement
import java.util.Scanner;

class SimpleCalculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long num1 = scanner.nextLong();
        String operator = scanner.next();
        long num2 = scanner.nextLong();
        calc(num1, operator, num2);
    }

    private static void calc(long num1, String operator, long num2) {
        switch (operator) {
            case "-":
                subtractTwoNumbers(num1, num2);
                break;
            case "/":
                divideTwoNumbers(num1, num2);
                break;
            case "+":
                sumTwoNumbers(num1, num2);
                break;
            default:
                multiplyTwoNumbers(num1, num2);
                break;
        }
    }

    // Implement your methods here
    public static void subtractTwoNumbers(long num1, long num2) {
        System.out.println(num1 - num2);
    }

    public static void sumTwoNumbers(long num1, long num2) {
        System.out.println(num1 + num2);
    }

    public static void divideTwoNumbers(long num1, long num2) {
        try {
            System.out.println(num1 / num2);
        } catch (ArithmeticException e) {
            System.out.println("Division by 0!");
        }
    }

    public static void multiplyTwoNumbers(long num1, long num2) {
        System.out.println(num1 * num2);
    }
}