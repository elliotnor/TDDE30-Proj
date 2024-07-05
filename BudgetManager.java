import java.util.ArrayList;
import java.util.List;

public class BudgetManager {
    private List<Transaction> transactions;
    private List<BudgetOption> budgetOptions;
    private User user;


    public BudgetManager(User user) {
        transactions = new ArrayList<>();
        budgetOptions = new ArrayList<>();
        this.user = user;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void applyTransactions() {
        for (Transaction transaction : transactions) {
            transaction.execute();
        }
    }

    public User getUser() {
        return user;
    }

    public void addBudgetOption(BudgetOption budgetOption) {
        budgetOptions.add(budgetOption);
    }

    public void applyBudgetOptions() {
        for (BudgetOption budgetOption : budgetOptions) {
            budgetOption.apply();
        }
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

}
