package com.shopping.Main;

import java.util.Scanner;

public class MainOperations {

	static Scanner sacnner = new Scanner(System.in);

	public static void main(String[] args) {

		while (true) {
			System.out.println("Welcome to Online Shopping Application \n 1.Add User Details\n 2.Add Order Details\n 3.Add Product Details\n 4.Add Review Details\n 5.Add Category Details\n 6.Add OrderDetail-Details");

			int input = sacnner.nextInt();
			switch (input) {

			case 1:
			AllOperation.userOperations();
				System.out.println("==============================");
				break;

			case 2:
				AllOperation.orderOperations();
				System.out.println("==============================");

			case 3:
				AllOperation.productOperations();
				System.out.println("==============================");
				break;

			case 4:
				AllOperation.reviewOperations();
				System.out.println("==============================");
				break;

			case 5:
				AllOperation.categoryOperations();
				System.out.println("==============================");
				break;

			case 6:
				AllOperation.orderDetailOperations();
				System.out.println("==============================");
				break;
				
			case 7:
				System.out.println("Exiting Online Shopping Application...");
				System.exit(0);
				break;
				
				default:
					System.out.println("Invalid Option.Please Choose again"); 

			}
		}

	}

	

	

}
