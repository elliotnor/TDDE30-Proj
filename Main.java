public class Main {
    public static void main(String[] args) {
        User user = new User("John Doe");

        Account checkingAccount = new Account("Checking", 1000);
        Account savingsAccount = new Account("Savings", 500);

        user.addAccount(checkingAccount);
        user.addAccount(savingsAccount);

        BudgetManager budgetManager = new BudgetManager();

        Transaction transfer = new TransferTransaction(checkingAccount, savingsAccount, 200);
        budgetManager.addTransaction(transfer);

        BudgetOption fixedAmountBudget = new FixedAmountBudget(user, 50);
        budgetManager.addBudgetOption(fixedAmountBudget);

        budgetManager.applyTransactions();
        budgetManager.applyBudgetOptions();

        System.out.println("Checking Balance: " + checkingAccount.getBalance());
        System.out.println("Savings Balance: " + savingsAccount.getBalance());
    }
}
