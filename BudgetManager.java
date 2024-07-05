import java.util.ArrayList;
import java.util.List;

public class BudgetManager {
    private List<Transaction> transactions;
    private List<BudgetOption> budgetOptions;
    private List<User> users;

    public BudgetManager() {
        transactions = new ArrayList<>();
        budgetOptions = new ArrayList<>();
        this.users = new ArrayList<>();
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

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User getUser(String name) {
        for (User user : users) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    public void createSavingsGoal(String userName, String goalName, double goalAmount, int targetMonths) {
        User user = getUser(userName);
        if (user != null) {
            SavingsGoal goal = new SavingsGoal(goalName, goalAmount, targetMonths);
            user.addSavingsGoal(goal);
        }
    }

    public void transferToSavings(String userName, String goalName, double amount) {
        User user = getUser(userName);
        if (user != null) {
            user.transferToSavings(goalName, amount);
        }
    }

    public List<SavingsGoal> getUserSavingsGoals(String userName) {
        User user = getUser(userName);
        if (user != null) {
            return user.getSavingsGoals();
        }
        return new ArrayList<>();
    }

    public void incrementSavingsGoals(String userName) {
        User user = getUser(userName);
        if (user != null) {
            user.incrementAllSavingsGoals();
        }
    }
}

