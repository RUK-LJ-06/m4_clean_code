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

    public abstract void display();
}
