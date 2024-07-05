import java.util.ArrayList;
import java.util.List;


public class User {
    private String name;
    private List<Account> accounts;
    private double balance;
    private List<SavingsGoal> savingsGoals;

    public User(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
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

    public double getBalance() {
        return balance;
    }

    public void addBalance(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }


    public void addSavingsGoal(SavingsGoal goal) {
        savingsGoals.add(goal);
    }

    public List<SavingsGoal> getSavingsGoals() {
        return savingsGoals;
    }

    public void transferToSavings(String goalName, double amount) {
        for (SavingsGoal goal : savingsGoals) {
            if (goal.getName().equals(goalName)) {
                if (balance >= amount) {
                    balance -= amount;
                    goal.addSavings(amount);
                }
            }
        }
    }

    public void incrementAllSavingsGoals() {
        for (SavingsGoal goal : savingsGoals) {
            goal.incrementMonth();
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                ", savingsGoals=" + savingsGoals +
                '}';
    }
}

