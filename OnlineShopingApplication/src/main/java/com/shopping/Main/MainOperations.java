package com.shopping.Main;

import java.util.Scanner;

public class MainOperations {

	static Scanner sacnner = new Scanner(System.in);

	public static void main(String[] args) {

		while (true) {
			System.out.println(
					"Welcome To Online Shopping Application \n 1.User Details\n 2.Orders Details\n 3.Product Details\n 4.Review Details\n 5.Category Details\n 6.OrderDetail-Details\n 7.Exit the Application");

			int input = sacnner.nextInt();
			switch (input) {

			case 1:
				AllOperation.userOperations();
				System.out.println("==============================");
				break;

			case 2:
				AllOperation.ordersOperations();
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
