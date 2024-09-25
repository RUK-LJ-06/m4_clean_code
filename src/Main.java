import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("======================");
        System.out.print("Masukkan saldo awal: ");
        double initialBalance = scanner.nextDouble();
        System.out.println("======================");
        // Pengulangan objek MoneyTracker meskipun tidak perlu (Melanggar DRY dan YAGNI)
        MoneyTracker tracker1 = new MoneyTracker(initialBalance);
        MoneyTracker tracker2 = new MoneyTracker(initialBalance); 
        tracker1.start();
        tracker2.start(); // Tidak ada gunanya menjalankan dua tracker (YAGNI)
        scanner.close();
    }
}
