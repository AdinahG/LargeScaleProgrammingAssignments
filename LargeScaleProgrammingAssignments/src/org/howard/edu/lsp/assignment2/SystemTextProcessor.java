package org.howard.edu.lsp.assignment2;

import java.util.Scanner;



public class SystemTextProcessor {



	public static void main(String[] args) {

		/*

		 * Each digit sequence is a token detected by the scanner and can be converted into a number

		 */

		Scanner s = new Scanner(System.in);



		/*

		 * While loop, The program ends when the end-user types in “Goodbye”.

		 */

		while (true) {

			/*

			 * Take input

			 */

			System.out.println("String? ");

			String input = s.nextLine();// Store into "input" variable



			/*

			 * If user entered "Goodbye" then terminate the while loop

			 */

			if (input.equalsIgnoreCase("Goodbye")) {

				break;

			}



			/*

			 * Split user entered value based on exactly one space character after each token

			 */

			String[] splitOnSpace = input.split(" ");



			/*

			 * variables for sum & product.

			 */

			int sum = 0;

			int product = 1;



			System.out.println("Tokens:");



			/*

			 * print all the tokens entered by user 

			 * calculate sum and product of those tokens

			 */

			for (String token : splitOnSpace) {

				// Take one-one token and convert into number

				int eachToken = Integer.parseInt(token);

				// display eachToken 

				System.out.println(eachToken);



				// find sum

				sum = sum + eachToken;



				// find product 

				product = product * eachToken;

			}



			/*

			 * display sum & and product

			 */

			System.out.println("Sum: " + sum);

			System.out.println("Product: " + product);

			System.out.println();//display only new line

		}

	}



}


