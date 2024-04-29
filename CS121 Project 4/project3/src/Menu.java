import java.sql.SQLOutput;
import java.util.*;

public class Menu {
    Scanner scanner = new Scanner(System.in);

    Bank b = new Bank();

    public void displayMenu() {
        while (true) {
            System.out.println("******* MENU *******");
            System.out.println("1) Access Account");
            System.out.println("2) Open a new account");
            System.out.println("3) Close All Accounts");
            System.out.println("4) Exit ");

            String input = scanner.nextLine();

            if (input.equals("1")) {
                accessAccount();
            } else if (input.equals("2")) {
                openAccount();
            } else if (input.equals("3")) {
                closeAllAcounts();
            } else if (input.equals("4")) {
                break;
            } else {
                System.out.println("Invalid Entry");
            }
        }
    }

    public void accessAccount(){
        System.out.println("Please enter a Pin");
        String pin = scanner.nextLine();

        // Retrieve the customer associated with the PIN
        Customer customer = b.getCustomerByPin(pin);

        if (customer == null) {
            System.out.println("PIN is not valid");
            return;
        }

        System.out.println(b.getAllAccounts());
        System.out.println("Enter number of account:");
        int accountNum = scanner.nextInt();

        // Retrieve the account associated with the account number
        Account account = customer.getAccount(accountNum);

        if(account == null) {
            System.out.println("Account number is invalid");
            return;
        }

        while(true){
            System.out.println("\nPlease make a selection: ");
            System.out.println("1) Make a deposit");
            System.out.println("2) Make a withdraw");
            System.out.println("3) See account balance");
            System.out.println("4) Close account");
            System.out.println("5) Exit");

            int input = scanner.nextInt();

            switch(input) {
                case 1:
                    System.out.println("Enter a deposit amount: ");
                    int depositAmount = scanner.nextInt();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.println("Enter a withdrawal amount: ");
                    int withdrawalAmount = scanner.nextInt();
                    account.withdraw(withdrawalAmount);
                    break;
                case 3:
                    System.out.println("Current Balance: " + account.getBalance());
                    break;
                case 4:
                    customer.removeAccount(account);
                    System.out.printf("Account %d removed\n", account.getAccountNum());
                    break;
                case 5:
                    return; // Exit the loop
                default:
                    System.out.println("Invalid Entry");
                    break;
            }
        }
    }

    public void openAccount(){
        System.out.println("Are you a new customer\n 1) Yes\n 2) No");
        int input = Integer.parseInt(scanner.nextLine());

        if(input == 1){
            System.out.println("Would you like to open a checking or savings account?\n 1) Checking\n 2) Savings");
            int inputTwo = Integer.parseInt(scanner.nextLine());
            if(inputTwo == 1) {
                Customer customer = createNewCustomer();
                System.out.println("Enter deposit amount for new account: ");
                int initialDeposit = scanner.nextInt();
                Account newAccount = new Account(initialDeposit, "Checking");
                customer.addAccount(newAccount);
                System.out.printf("New checking account opened: %d\n", newAccount.getAccountNum());
                scanner.nextLine();
                displayMenu();
            }else if(inputTwo == 2){
                Customer customer = createNewCustomer();
                System.out.println("Enter deposit amount for new account: ");
                int initialDeposit = scanner.nextInt();
                Savings savings = new Savings(initialDeposit, 2.5, "Savings");
                customer.addAccount(savings);
                savings.applyInterest();
                System.out.printf("New savings account opened: %d\n", savings.getAccountNum());
                scanner.nextLine();
                displayMenu();
            }
        }else if(input == 2){
            System.out.println("Input pin");
            String pin = scanner.nextLine();
            Customer existingCustomer = b.getCustomerByPin(pin);
            if(existingCustomer != null){
                System.out.println("Enter a deposit amount");
                int deposit = scanner.nextInt();
                Account a = new Account(deposit, "Checking");
                existingCustomer.addAccount(a);
                System.out.printf("New account opened: %d\n", a.getAccountNum());
                scanner.nextLine();
                displayMenu();
            }else{
                System.out.println("PIN is invalid");
                displayMenu();
            }

        }
    }

    public Customer createNewCustomer(){
        System.out.println("Enter first name");
        String firstName = scanner.nextLine();
        System.out.println("Enter last name");
        String lastName = scanner.nextLine();
        System.out.println("Enter a pin");
        String pin = scanner.nextLine();
        Customer c = new Customer(firstName, lastName, pin);
        b.addCustomer(c);

        return c;
    }

    public void closeAllAcounts(){
        System.out.println("Enter PIN: ");
        String input = scanner.nextLine();
        Customer customer = b.getCustomerByPin(input);
        if(customer == null){
            return;
        }
        b.removeCustomer(customer);
        System.out.println("Customer has been removed from bank registry");

    }
}
