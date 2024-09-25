import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MoneyRecordManager {
    private List<MoneyRecord> records;
    private Scanner scanner;
    private MoneyTracker recordTracker;

    public MoneyRecordManager(MoneyTracker tracker) {
        records = new ArrayList<>();
        scanner = new Scanner(System.in);
        recordTracker = tracker;
    }

    public void addRecord() {
        System.out.println("======================");
        System.out.print("Masukkan jumlah: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Masukkan deskripsi: ");
        String description = scanner.nextLine();
        System.out.println("1. Pendapatan");
        System.out.println("2. Pengeluaran");
        System.out.print("Pilih jenis catatan: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("======================");

       // Mengganti switch dengan ternary operator (lebih sederhana dan sesuai KISS)
        MoneyRecord record = (choice == 1) 
        ? new Income(amount, description) 
        : (choice == 2) 
            ? new Expense(amount, description) 
            : null;

            if (record == null) {
                System.out.println("Pilihan tidak valid");
                return;
            }

        records.add(record);

        // Update saldo
        double saldoSekarang = calculateSaldo();
        recordTracker.setSaldoSekarang(saldoSekarang);

        System.out.println("Catatan berhasil ditambahkan.");
    }

    public void showRecords() {
        if (records.isEmpty()) {
            System.out.println("Tidak ada catatan.");
            return;
        }
        
        for (MoneyRecord record : records) { 
            record.display();
        }
    }

    private double calculateSaldo() {
        double saldo = recordTracker.getSaldoAwal();
        for (MoneyRecord record : records) {
            if (record instanceof Income) {
                saldo += record.getAmount();
            } else if (record instanceof Expense) {
                saldo -= record.getAmount();
            }
        }
        return saldo;
    }
}
