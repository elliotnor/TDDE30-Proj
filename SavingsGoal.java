public class SavingsGoal {
    private String name;
    private double targetAmount;
    private double currentAmount;

    public SavingsGoal(String name, double targetAmount) {
        this.name = name;
        this.targetAmount = targetAmount;
        this.currentAmount = 0;
    }

    public String getName() {
        return name;
    }

    public double getTargetAmount() {
        return targetAmount;
    }

    public double getCurrentAmount() {
        return currentAmount;
    }

    public void addAmount(double amount) {
        if (amount > 0) {
            this.currentAmount += amount;
        }
    }

    public boolean isGoalReached() {
        return this.currentAmount >= this.targetAmount;
    }
}
