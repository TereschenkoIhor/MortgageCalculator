import java.text.NumberFormat;
import java.util.Locale;

public class MortgageReport {
    private MortgageCalculator calculator;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
    }

    public void printPaymentSchedule() {
        System.out.println("\n\nPAYMENT SCHEDULE\n----------------\n");

        for(short month = 1; month <= this.calculator.getYears() * 12; ++month) {
            double balance = this.calculator.calculateBalance(month);
            System.out.println(NumberFormat.getCurrencyInstance(Locale.US).format(balance));
        }

    }

    public void printMortgage() {
        String mortgageResult = NumberFormat.getCurrencyInstance(Locale.US).format(this.calculator.calculateMortgage());
        System.out.print("MORTGAGE :\n--------\nMonthly Payments: " + mortgageResult);
    }
}
