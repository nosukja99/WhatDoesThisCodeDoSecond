/**
 * Mortage.java
 * Calculate the monthly mortgage payment
 * The loan Amount, interest Rate and term will be input by user
 * Also calculate current mortgage balance
 */

import java.util.Scanner;

public class Mortgage {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        double loanAmount = 0;
        double interestRate = 0;
        double monthlyPayment = 0;
        double owedAmount = 0;
        int term;
        //get user inputs
        System.out.printf("Enter the loan amount: ");
        loanAmount = keyboard.nextDouble();

        System.out.printf("Enter the interest rate on the loan: ");
        interestRate = keyboard.nextDouble();

        System.out.printf("Enter the term(years) for the loan payment: ");
        term = keyboard.nextInt();

        System.out.printf("\n================================================================\n");
        keyboard.close();
        //get monthly payment by calling getMonthlyPayment method
        monthlyPayment = getMonthlyPayment(loanAmount, interestRate, term);
        //calculate current balance
        owedAmount = -(monthlyPayment * (term * 12));
        System.out.format("%-30s$%-+10.2f%n", "Amount owed to bank:", owedAmount);
        System.out.format("%-30s$%-10.2f%n", "Minimum monthly payment:", monthlyPayment);
    }

    /**
     * Calculate the monthly payment of a loan.
     *
     * @param loanAmount: Amount borrowed for Load
     * @param interestRate: Interest rate on the loan
     * @param term: Repayment term in years
     * @returns The monthly payment of a loan given the interest rate, amount and term (years)
     */
    public static double getMonthlyPayment(double loanAmount, double interestRate, double term) {
        double rate = (interestRate / 100) / 12;
        double base = (rate + 1);
        double months = term * 12;
        double result = 0;
        result = loanAmount * (rate * (Math.pow(base, months)) / ((Math.pow(base, months)) - 1));

        return result;
    }
}
