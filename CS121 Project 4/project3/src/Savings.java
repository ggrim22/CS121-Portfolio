public class Savings extends Account{
    private double interestRate;

    public Savings(int da, double interestRate, String accountType) {
        super(da, accountType);
        this.interestRate = interestRate;

    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = getBalance() * interestRate / 100;
        deposit(interest);
    }
}
