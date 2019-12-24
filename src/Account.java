public abstract class Account {

    protected String accountID, customerID, accountType;
    protected double balance;

    public Account (String accountID, String customerID, String accountType, double balance) {
        this.accountID = accountID;
        this.customerID = customerID;
        this.accountType = accountType;
        this.balance = balance;
    }

    public abstract boolean withdraw (double amount);

    @Override
    public String toString() {
        return String.format("accID: %s; %s; CurrentBalance: %f", accountID, accountType, balance);
    }
}
