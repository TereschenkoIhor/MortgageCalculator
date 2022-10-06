public class Main {
    public static void main(String[] args) {
        int principal = (int) Console.readNumber("Principal: ", 1000.0, 1000000.0);
        float annualInterestRate = (float) Console.readNumber("Annual Interest Rate: ", 1.0, 30.0);
        byte years = (byte) ((int) Console.readNumber("Period (Years): ", 1.0, 30.0));
        MortgageCalculator calculator = new MortgageCalculator(principal, annualInterestRate, years);
        MortgageReport report = new MortgageReport(calculator);
        report.printMortgage();
        report.printPaymentSchedule();
    }
}