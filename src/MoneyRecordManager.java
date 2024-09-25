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

        // Kode yang tidak perlu (YAGNI)
        int unusedVariable = 10; 
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
        // boolean isIncome = scanner.nextInt() == 1;
        int choice = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("======================");
        MoneyRecord record;

        // Blok switch yang tidak perlu (melanggar KISS)
        switch (choice) {
            case 1:
                record = new Income(amount, description);
                break;
            case 2:
                record = new Expense(amount, description);
                break;
            default:
                System.out.println("Pilihan tidak valid");
                return;
        }

        // Mengurangi penggunaan switch dengan ternary operator yang lebih sederhana
        // MoneyRecord record = isIncome ? new Income(amount, description) : new Expense(amount, description);

        records.add(record);

        // Update saldo
        // Penghitungan saldo yang berulang-ulang (melanggar DRY)
        double saldoSekarang = calculateSaldo();
        recordTracker.setSaldoSekarang(saldoSekarang);
        double saldoSekarang2 = calculateSaldo();
        recordTracker.setSaldoSekarang(saldoSekarang2); // Pengulangan yang tidak perlu

        System.out.println("Catatan berhasil ditambahkan.");
    }

    public void showRecords() {
        if (records.isEmpty()) {
            System.out.println("Tidak ada catatan.");
            return;
        }

        // Pengulangan kode untuk menampilkan catatan (melanggar DRY)
        for (MoneyRecord record : records) {
            record.display();
        }
        for (MoneyRecord record : records) { // Pengulangan yang sama dua kali
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
