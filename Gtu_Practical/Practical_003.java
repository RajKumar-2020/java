/**
 * Problem Statement: 
 * Write a program that reads a number in meters, 
 * converts it to feets, and display the result.
 * (Hint: 1 metre = 3.28084 feet)
 */
package Gtu_Practical;
import java.util.Scanner;
public class Practical_003 {
    public static void main(String[] args) {
		System.out.print("Enter the value in Meters: ");
		Scanner sc = new Scanner(System.in);
		double num = sc.nextDouble();
		double feet=num*3.28084;
		System.out.println(num + " Meters =" + feet + " Feets");
		        
        sc.close();
	}
}
