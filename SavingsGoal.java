public class SavingsGoal {
    private String name;
    private double goalAmount;
    private double currentAmount;
    private int targetMonths;
    private int monthsElapsed;

    public SavingsGoal(String name, double goalAmount, int targetMonths) {
        this.name = name;
        this.goalAmount = goalAmount;
        this.currentAmount = 0;
        this.targetMonths = targetMonths;
        this.monthsElapsed = 0;
    }

    public String getName() {
        return name;
    }

    public double getGoalAmount() {
        return goalAmount;
    }

    public double getCurrentAmount() {
        return currentAmount;
    }

    public int getTargetMonths() {
        return targetMonths;
    }

    public int getMonthsElapsed() {
        return monthsElapsed;
    }

    public void addSavings(double amount) {
        if (amount > 0) {
            currentAmount += amount;
        }
    }

    public void incrementMonth() {
        monthsElapsed++;
    }

    public boolean isGoalReached() {
        return currentAmount >= goalAmount;
    }

    @Override
    public String toString() {
        return "SavingsGoal{" +
                "name='" + name + '\'' +
                ", goalAmount=" + goalAmount +
                ", currentAmount=" + currentAmount +
                ", targetMonths=" + targetMonths +
                ", monthsElapsed=" + monthsElapsed +
                '}';
    }
}
