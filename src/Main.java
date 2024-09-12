import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("======================");
        System.out.print("Masukkan saldo awal: ");
        double initialBalance = scanner.nextDouble();
        System.out.println("======================");
        MoneyTracker tracker = new MoneyTracker(initialBalance);
        tracker.start();
        scanner.close();
    }
}
