public class Expense extends MoneyRecord {
    public Expense(double amount, String description) {
        super(amount, description);
    }

    @Override
    public void display() {
        System.out.println("================================================");
        System.out.println("Pengeluaran: " + description + ", Jumlah: " + amount);
    }
}
