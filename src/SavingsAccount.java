public class SavingsAccount extends Account implements Comparable <SavingsAccount> {

    private double interestRate;

    public SavingsAccount (String accountID, String customerID, String accountType, double balance, double interestRate) {
        super (accountID, customerID, accountType, balance);
        this.interestRate = interestRate;
    }


    @Override
    public boolean withdraw(double amount) {
        throw new UnsupportedOperationException("Cannot withdraw!!");
    }

    @Override
    public int compareTo(SavingsAccount ob) {
        if (this.interestRate > ob.interestRate) {
            return -1; //This object is rank higher
        } else if (this.interestRate < ob.interestRate) {
            return 1; //This object is rank lower
        }
        return 0;
    }

    @Override
    public String toString() {
        return String.format("accID: %s; %s; CurrentBalance: %f; Interest Rate: %f",
                accountID, accountType, balance, interestRate);
    }

    public double getInterestRate() {
        return interestRate;
    }
    public void setInterestRate (double interestRate) {
        this.interestRate = interestRate;
    }

}
