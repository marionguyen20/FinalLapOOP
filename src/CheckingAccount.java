public class CheckingAccount extends Account implements Comparable<CheckingAccount> {

    private double overdraftAmount;

    public CheckingAccount (String accountID, String customerID, String accountType, double balance, double overdraftAmount) {
        super(accountID, customerID, accountType, balance);
        this.overdraftAmount = overdraftAmount;
    }

    @Override
    public boolean withdraw(double amount) {
        if (balance < amount) {
            if ((amount - balance) > overdraftAmount) {
                throw new IllegalStateException("Transaction Fail");
            } else {
                balance = 0;
                overdraftAmount -= (amount - balance);
                System.out.println("Transaction Success !");
                return true;
            }
        } else {
            balance -= amount;
            System.out.println("Transaction Success !");
            return true;
        }
    }

    @Override
    public int compareTo(CheckingAccount ob) {
        if (this.overdraftAmount > ob.overdraftAmount) {
            return -1;
        } else if (this.overdraftAmount < ob.overdraftAmount) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return String.format("accID: %s; %s; CurrentBalance: %f; Overdraft Amount: %f",
                accountID, accountType, balance, overdraftAmount);
    }

    public double getOverdraftAmount () {
        return overdraftAmount;
    }
    public void setOverdraftAmount (double overdraftAmount) {
        this.overdraftAmount = overdraftAmount;
    }
}
