public class Account {
    double balance;
    int accountNum;
    static int numberOfAccounts = 1000;
    String accountType;

    public Account(int da, String accountType){
        this.balance = da;
        numberOfAccounts = numberOfAccounts + 1;
        this.accountNum = numberOfAccounts;
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void deposit(double deposit){
        balance = deposit + balance;

        System.out.printf("The deposit added is: %.2f\n", deposit);
        System.out.printf("The total balance is: %.2f\n", balance);
    }

    public void withdraw(int withdraw){
        if(withdraw > balance){
            System.out.println("Insufficient Funds");
        }else{
            balance = balance - withdraw;
            System.out.printf("The amount withdrawn is: %d\n", withdraw);
            System.out.printf("The remaining balance is %d\n", balance);
        }
    }

    public int getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(int accountNum) {
        this.accountNum = accountNum;
    }

    @Override
    public String toString() {
        return String.format("Account Number: %d\nBalance: %d\n", accountNum, balance);
    }

}


