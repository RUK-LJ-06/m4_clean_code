import java.util.Scanner;

public class MoneyTracker {
    private Scanner scanner;
    private MoneyRecordManager recordManager;
    private double saldoAwal;
    private double saldoSekarang;

    public MoneyTracker(double saldoAwal) {
        this.saldoAwal = saldoAwal;
        this.saldoSekarang = saldoAwal;
        scanner = new Scanner(System.in);
        recordManager = new MoneyRecordManager(this);
    }

    public void start() {
        boolean exit = false;
        while (!exit) {
            System.out.println("======================");
            System.out.println("1. Tambah Catatan");
            System.out.println("2. Lihat Catatan");
            System.out.println("3. Lihat Saldo");
            System.out.println("4. Keluar");
            System.out.print("Pilih: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline character
            System.out.println("======================");
            switch (choice) {
                case 1:
                    recordManager.addRecord();
                    break;
                case 2:
                    recordManager.showRecords();
                    break;
                case 3:
                    System.out.println("Saldo sekarang: " + saldoSekarang);
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Pilihan tidak valid");
            }
        }
        scanner.close();
    }

    public double getSaldoAwal() {
        return saldoAwal;
    }

    public void setSaldoSekarang(double saldoSekarang) {
        this.saldoSekarang = saldoSekarang;
    }

    public double getSaldoSekarang() {
        return saldoSekarang;
    }
}
