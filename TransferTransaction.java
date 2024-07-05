public class TransferTransaction extends Transaction {
    private String sourceAccount;
    private String destinationAccount;

    public TransferTransaction(double amount, String sourceAccount, String destinationAccount) {
        super(amount);
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
    }

    @Override
    public String toString() {
        return "TransferTransaction{" +
                "amount=" + getAmount() +
                ", sourceAccount='" + sourceAccount + '\'' +
                ", destinationAccount='" + destinationAccount + '\'' +
                '}';
    }
}



