import java.util.ArrayList;
import java.util.List;

public class BudgetManager {
    private List<Transaction> transactions;
    private List<BudgetOption> budgetOptions;

    public BudgetManager() {
        transactions = new ArrayList<>();
        budgetOptions = new ArrayList<>();
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void applyTransactions() {
        for (Transaction transaction : transactions) {
            transaction.execute();
        }
    }

    public void addBudgetOption(BudgetOption budgetOption) {
        budgetOptions.add(budgetOption);
    }

    public void applyBudgetOptions() {
        for (BudgetOption budgetOption : budgetOptions) {
            budgetOption.apply();
        }
    }
}
