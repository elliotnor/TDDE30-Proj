public abstract class Transaction {
    protected Account fromAccount;
    protected Account toAccount;
    protected double amount;

    public Transaction(Account fromAccount, Account toAccount, double amount) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
    }

    public abstract void execute();
}
