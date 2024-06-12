public class FixedAmountBudget extends BudgetOption {
    private double amount;

    public FixedAmountBudget(User user, double amount) {
        super(user);
        this.amount = amount;
    }

    @Override
    public void apply() {
        for (Account account : user.getAccounts()) {
            account.deposit(amount);
        }
    }
}
