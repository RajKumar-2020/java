/**
 * Write a method with following method header.
 * public static int gcd(int num1, int num2)
 * Write a program that prompts the user to enter 
 * two integers and compute the gcd of two integers.
 */
package Gtu_Practical;
import java.util.Scanner;
public class Practical_009 {
    public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("\n Enter the number 1 : ");
		int num1 = input.nextInt();
		System.out.print("\n Enter the number 2 : ");
		int num2 = input.nextInt();
		
		int result = gcd(num1,num2);
		System.out.print("GCD of " + num1 + " and " + num2 + " is : " + result);
        input.close();
	}

	public static int gcd(int num1, int num2) {
		int result=1;
		for(int i=2;i<=num1 && i<=num2;)
		{
			if(num1%i==0 && num2%i==0)
			{
				result*=i;
				num1/=i;
				num2/=i;
			}
			else if(num1%i==0)
				num1/=i;
			else if(num2%i==0)
				num2/=i;
			else
				i++;
		}
		return result;
	}
    
}
