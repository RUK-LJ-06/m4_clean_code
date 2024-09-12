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
        scanner.nextLine(); // consume newline character
        System.out.print("Masukkan deskripsi: ");
        String description = scanner.nextLine();
        System.out.println("1. Pendapatan");
        System.out.println("2. Pengeluaran");
        System.out.print("Pilih jenis catatan: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline character
        System.out.println("======================");
        MoneyRecord record;
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
