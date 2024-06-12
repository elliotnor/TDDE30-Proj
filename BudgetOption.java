public abstract class BudgetOption {
    protected User user;

    public BudgetOption(User user) {
        this.user = user;
    }

    public abstract void apply();
}
