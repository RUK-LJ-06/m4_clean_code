public class Income extends MoneyRecord {
    public Income(double amount, String description) {
        super(amount, description);
    }

    @Override
    public void display() {
        System.out.println("================================================");
        System.out.println("Pendapatan: " + description + ", Jumlah: " + amount);
    }
}
