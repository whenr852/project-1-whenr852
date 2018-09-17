//Name: Billy Henry
//Date: 9/18/2018
//File: Retirement_Savings.java
//Description: Calculates total amount of user's savings by retirement.

import java.util.Scanner;
import java.text.DecimalFormat;

public class Retirement_Savings {
	
	public static void main(String[] args) 
	{
				
		//Create scanner input method
		Scanner userInput = new Scanner(System.in);
		
		//initialize variables to be used
		int yearsToRetirement;
		double annualSavings;
		double interestRate = 0.05;
		double totalSaved = 0;
		
		System.out.println("How many years until you retire?: ");
		yearsToRetirement = userInput.nextInt();
		
		//Error checking
		while(yearsToRetirement <= 0 && yearsToRetirement < 100)
		{
			System.out.println("Error: please enter a number greater than 0");
			System.out.println("How many years until you retire?: ");
			yearsToRetirement = userInput.nextInt();
		} 
		
		System.out.println("How much money are you able to save per year?: ");
		annualSavings = userInput.nextDouble();
		
		//Error checking
		while(annualSavings <= 0)
		{
			System.out.println("Error: please enter a number greater than 0");
			System.out.println("How much money are you able to save per year?: ");
			annualSavings = userInput.nextDouble();
		} 
		
		//Call on Savings method to perform calculation
		totalSaved = Savings(annualSavings, yearsToRetirement, interestRate);
		
		System.out.println("You would have saved $" + totalSaved + " by the time you retire.");
		
		userInput.close();	
	}
	
	public static double Savings(double amount, int years, double rate)
	{
		//Performs calculation to find total savings with interest
		double total, interest;
		
		interest = amount*0.05;
		total = amount + interest;
		for(int i = 1; i < years; i++)
		{
			interest = (amount+total)*0.05;
			total += amount + interest;
		}
		
		total = Double.parseDouble(new DecimalFormat("##.00").format(total));
		
		return total;
	}
}
