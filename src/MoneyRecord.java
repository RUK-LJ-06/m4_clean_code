public abstract class MoneyRecord {
    protected double amount;
    protected String description;

    public MoneyRecord(double amount, String description) {
        this.amount = amount;
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    // Menambahkan metode yang tidak digunakan sama sekali (YAGNI)
    public void unusedMethod() {
        System.out.println("Ini adalah metode yang tidak terpakai.");
    }

    public abstract void display();
}
