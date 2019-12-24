import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Bank {

    private String name;
    private String address;
    private List<Account> listOfAccount;
    private Set<String> setID;

    public Bank (String name, String address) {
        this.name = name;
        this.address = address;
        listOfAccount = new ArrayList<>();
        setID = new HashSet<>();
    }

    public void addAccount(Account a){
        if (!setID.contains(a.accountID)) {
            setID.add(a.accountID);
            listOfAccount.add(a);
            System.out.println("<<cusID: " + a.customerID + ">> <<accType: " + a.accountType + ">> <<accID: " + a.accountID + ">> was added successfully"
            );
        } else {
            System.out.println("Couldn't add the account <<ID: " + a.accountID + ">>");
        }

    }

    public void displayAccByCustomerID (String customerID) {
        System.out.println("CustomerID: " + customerID);
        List<Account> accounts = listOfAccount.stream()
                .filter(a -> customerID.equals(a.customerID))
                .collect(Collectors.toList());
        if(!accounts.isEmpty()) {
            for (Account a : accounts) {
                System.out.println(a);
            }
        } else  {
            System.out.println("Cannot find the Account");
        }
    }

    public void displayAccByCustomerID (String customerID, String accountType){
        System.out.println("Customer ID: " + customerID + "Account Type: " + accountType);
        List<Account> accounts = listOfAccount.stream()
                .filter(a -> customerID.equals(a.customerID) && accountType.equals(a.accountType))
                .collect(Collectors.toList());
        if (!accounts.isEmpty()) {
            for (Account a : accounts) {
                System.out.println(a);
            }
        } else {
            System.out.println("Cannot find the Account");
        }
    }

    @Override
    public String toString() {
        return String.format("NAME: %s\tADDRESS: %s", name, address);
    }

}
