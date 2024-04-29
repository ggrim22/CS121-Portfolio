import java.util.*;
public class Bank {
    ArrayList<Customer> customerList = new ArrayList<>();

    public Bank(){

    }

    public void addCustomer(Customer customer){
        customerList.add(customer);
    }

    public void removeCustomer(Customer customer){
        customerList.remove(customer);
    }

    public Customer getCustomerByPin(String pin){
        for(Customer customer : customerList){
            if(customer.getPin().equals(pin)){
                return customer;
            }
        }
        return null;
    }

    public StringBuilder getAllAccounts(){
        StringBuilder customers = new StringBuilder();
        for(Customer customer : customerList){
            customers.append(customer + "\n");
        }
        return customers;
    }
}
