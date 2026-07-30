import java.util.Scanner;

interface Calculator {
    int add(int n1, int n2);
    int sub(int n1, int n2);
    int mul(int n1, int n2);
    int div(int n1, int n2);
}

class Operation implements Calculator {
    public int add(int n1, int n2) {
        return n1 + n2;
    }

    public int sub(int n1, int n2) {
        return n1 - n2;
    }

    public int mul(int n1, int n2) {
        return n1 * n2;
    }

    public int div(int n1, int n2) {
        return n1 / n2;
    }
}

public class Main {
    public static void main(String[] args) {
        Operation o = new Operation();
        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.println("--- ARITHMETIC OPERATIONS ---");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");
            System.out.println("Enter your choice:");

            int ch = s.nextInt();

            if (ch == 5) {
                System.out.println("Program ended");
                break;
            }

            if (ch >= 1 && ch <= 4) {
                System.out.println("Enter a and b:");
                int a = s.nextInt();
                int b = s.nextInt();

                if (ch == 1) {
                    System.out.println("Result = " + o.add(a, b));
                } else if (ch == 2) {
                    System.out.println("Result = " + o.sub(a, b));
                } else if (ch == 3) {
                    System.out.println("Result = " + o.mul(a, b));
                } else if (ch == 4) {
                    if (b != 0) {
                        System.out.println("Result = " + o.div(a, b));
                    } else {
                        System.out.println("Cannot divide by zero");
                    }
                }
            } else {
                System.out.println("Invalid choice");
            }
        }

        s.close();
    }
}
