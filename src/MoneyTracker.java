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
            scanner.nextLine();
            System.out.println("======================");
           // Pengulangan logika yang tidak perlu di setiap pilihan (melanggar DRY)
            if (choice == 1) {
                recordManager.addRecord();
            } else if (choice == 2) {
                recordManager.showRecords();
            } else if (choice == 3) {
                System.out.println("Saldo sekarang: " + saldoSekarang);
            } else if (choice == 4) {
                exit = true;
            } else {
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
