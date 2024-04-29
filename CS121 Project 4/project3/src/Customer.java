import java.util.*;

public class Customer {
    String firstName;
    String lastName;
    String pin;
    ArrayList<Account> accountList = new ArrayList<>();

    public Customer(String firstName, String lastName, String pin){
        this.firstName = firstName;
        this.lastName = lastName;
        this.pin = pin;
    }



    public void addAccount(Account account){
        accountList.add(account);
    }

    public void removeAccount(Account account){
        accountList.remove(account);
    }

    public Account getAccount(int accountNum){
        Account foundAccount = null;

        for(Account account: accountList){
            if(account.getAccountNum() == accountNum){
                foundAccount = account;
                break;
            }
        }
        return foundAccount;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public StringBuilder getAllAccounts(){
        StringBuilder accounts = new StringBuilder();
        for(Account account : accountList){
            accounts.append(account + "\n");
        }
        return accounts;
    }

    @Override
    public String toString() {
        return String.format("Account PIN: %s", pin);
    }



}
