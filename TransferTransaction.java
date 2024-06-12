public class TransferTransaction extends Transaction {

    public TransferTransaction(Account fromAccount, Account toAccount, double amount) {
        super(fromAccount, toAccount, amount);
    }

    @Override
    public void execute() {
        if (fromAccount != null && toAccount != null && fromAccount.getBalance() >= amount) {
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
        }
    }
}
