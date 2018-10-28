//Name: Billy Henry
//Date: 9/18/2018
//File: Retirement_Savings.java
//Description: Calculates total amount of user's savings by retirement.

import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Retirement_Savings {

	//initialize variables to be used
	static int yearsToRetirement = 0;
	static double annualSavings = 0;
	static double interestRate = 0.05;
	static String totalSaved;
	
	public static void main(String[] args) 
	{
				
		//Create scanner input method
		Scanner userInput = new Scanner(System.in);
		
		//try for invalid type entry
		try {
		
		//try for invalid retirement year
		try {
			
		System.out.println("How many years until you retire?: ");
		yearsToRetirement = userInput.nextInt();
		retirementYearWithException(yearsToRetirement);
		} //end of try for invalid retirement year.
		
		catch(InputMismatchException e2) 
		{
			System.err.println("Error: input for years to retirement must be between 0 and 120.");
			System.err.println("Program has terminated.");
			System.exit(0);
		}
		
		//try for invalid savings amount
		try {
		
		System.out.println("How much money are you able to save per year?: ");
		annualSavings = userInput.nextDouble();
		annualSavingsWithException(annualSavings);
		} //end of try for invalid savings amount
		
		catch(InputMismatchException e3)
		{
			System.err.println("Error: input for savings amount must be greater than $1.00");
			System.err.println("Program has terminated.");
			System.exit(0);
		}
		
		} //end of try for invalid type input.
		
		catch(InputMismatchException e1) 
		{
			e1.printStackTrace();
			System.err.println("Error: input value must be a number.");
			System.err.println("Program has terminated.");
			System.exit(0);
		} //catch to throw exception if char is entered instead of string.
		
		//Call on Savings method to perform calculation
		totalSaved = Savings(annualSavings, yearsToRetirement, interestRate);
		
		System.out.println("You would have saved $" + totalSaved + " by the time you retire.");
		
		userInput.close();	
	}
	
	public static String Savings(double amount, int years, double rate)
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
		
		DecimalFormat df = new DecimalFormat("##.00");
		String roundedTotal = df.format(total);
		
		return roundedTotal;
	}
	
	public static double retirementYearWithException(double yearsToRetirment)
	{
		if(yearsToRetirement < 0 || yearsToRetirement > 120)
			throw new InputMismatchException("Must retire in greater than 0 and less than 120 years.");
			
		return(yearsToRetirement);
	}
	
	public static double annualSavingsWithException(double annualSavings)
	{
		if(annualSavings < 1.00)
			throw new InputMismatchException("Must save more than $1.00 per year.");
		
		return(annualSavings);
	}
	
}
