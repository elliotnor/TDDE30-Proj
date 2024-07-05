import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<Account> accounts;
    private double balance;
    private List<SavingsGoal> savingsGoals;

    public User(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.savingsGoals = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public List<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
    }

    public void addSavingsGoal(SavingsGoal goal) {
        savingsGoals.add(goal);
    }

    public List<SavingsGoal> getSavingsGoals() {
        return savingsGoals;
    }

    public void contributeToGoal(String goalName, double amount) {
        for (SavingsGoal goal : savingsGoals) {
            if (goal.getName().equals(goalName)) {
                if (amount <= balance) {
                    goal.addAmount(amount);
                    balance -= amount;
                }
            }
        }
    }
}
