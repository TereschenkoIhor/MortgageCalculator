public class MortgageCalculator {
    public static final byte MONTHS_IN_YEAR = 12;
    public static final byte PERCENT = 100;
    private int principal;
    private float annualInterestRate;
    private byte years;

    public MortgageCalculator(int principal, float annualInterestRate, byte years) {
        this.principal = principal;
        this.annualInterestRate = annualInterestRate;
        this.years = years;
    }

    public double calculateMortgage() {
        float numberOfPaymentsTotal = (float)this.getNumberOfPaymentsTotal();
        float monthlyInterestRate = this.getMonthlyInterestRate();
        double mortgageMonthly = (double)this.principal * ((double)monthlyInterestRate * Math.pow((double)(1.0F + monthlyInterestRate), (double)numberOfPaymentsTotal) / (Math.pow((double)(1.0F + monthlyInterestRate), (double)numberOfPaymentsTotal) - 1.0));
        return mortgageMonthly;
    }

    public double calculateBalance(short numberOfPaymentsMade) {
        float numberOfPaymentsTotal = (float)this.getNumberOfPaymentsTotal();
        float monthlyInterestRate = this.getMonthlyInterestRate();
        double balance = (double)this.principal * Math.abs(Math.pow((double)(1.0F + monthlyInterestRate), (double)numberOfPaymentsTotal) - Math.pow((double)(1.0F + monthlyInterestRate), (double)numberOfPaymentsMade)) / Math.abs(Math.pow((double)(1.0F + monthlyInterestRate), (double)numberOfPaymentsTotal) - 1.0);
        return balance;
    }

    private int getNumberOfPaymentsTotal() {
        return this.years * 12;
    }

    private float getMonthlyInterestRate() {
        return this.annualInterestRate / 12.0F / 100.0F;
    }

    public short getYears() {
        return (short)this.years;
    }
}
