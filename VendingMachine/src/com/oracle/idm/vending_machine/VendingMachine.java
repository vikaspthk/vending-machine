package com.oracle.idm.vending_machine;

import java.util.Scanner;
/* @auther dev.vikaspathak@gmail.com */

/*****************Blueprint for Vending Machine******************/
interface IVendingMachine {
	int lemonCost = 25;
	int pepsiCost = 24;
	int waterCost = 23;
	int sliceCost = 22;
	void firstPage();
	void loadMoney();
	void purchase();
	void pickItems();
	void changeMoney();
}
/************************Implementation- Vending Machine****************/
public class VendingMachine implements IVendingMachine {
	static int paid = 0, price = 0, cashback = 0;
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("WELCOME TO DRINK VENDING MACHINE: BY VIKAS \n");
		VendingMachine vm = new VendingMachine();
		vm.firstPage();
	}
/******************************UI Page***********************/
	public void firstPage() {
		VendingMachine vm1 = new VendingMachine();
		System.out.println("Press 1 for loading money");
		System.out.println("Press 2 for purchasing");
		System.out.println("Press 3 for exit");
		int choice = sc.nextInt();

		if (choice == 1) {
			vm1.loadMoney();
		}

		if (choice == 2) {
			vm1.purchase();
		}

		if (choice == 3) {
			System.out.println("Thank you");
			System.out.println("Please collect your money Back Rs. " + paid);
			System.exit(0);
		}

		if (choice > 3) {
			System.out.println("Invalid Choice......");
		}

	}

/*****************Method to insert money************************/
	public void loadMoney() {

		VendingMachine vm1 = new VendingMachine();
		try {
			System.out.println("Enter Money");

			int u = sc.nextInt();
			paid = paid + u;

			vm1.firstPage();
		} catch (NumberFormatException e1) {
			System.out.println("Please Enter Integer values");
			vm1.loadMoney();
		}
	}
/******************************Method to Purchase Item (Check out)***************/
	public void purchase() {
		VendingMachine vm1 = new VendingMachine();
		vm1.showItems();
		vm1.pickItems();
	}

	public void showItems() {
		System.out.println("1. Lemon");
		System.out.println("2. Pepsi");
		System.out.println("3. Water");
		System.out.println("4. Slice");
	}
/********************Method to choose item from list and check loaded money************************/
	public void pickItems() {
		VendingMachine vm1 = new VendingMachine();
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Price for lemon is Rs. 25 ");
			break;
		case 2:
			System.out.println("Price for Pepsi is Rs. 24 ");
			break;
		case 3:
			System.out.println("Price for water is Rs. 23 ");
			break;
		case 4:
			System.out.println("Price for slice is Rs. 22 ");
			break;
		}
		if (choice == 1) {
			price = price + lemonCost;
		}
		if (choice == 2) {
			price = price + pepsiCost;
		}
		if (choice == 3) {
			price = price + waterCost;
		}
		if (choice == 4) {
			price = price + sliceCost;
		}
		if (paid < price) {
			System.out.println("Plz insert enough money to buy this product..");


		}

		else {
			cashback = paid - price;
			System.out.println("Your change money is " + cashback);
			vm1.changeMoney();
		}

	}
/**********************Method for Change........(Greedy Approch)***************/
	public void changeMoney() {
		if (paid == price) {
			System.out.println("Your change is 0.0");
		}
		int p1 = 0, p5 = 0, p10 = 0, p20 = 0, p100 = 0;
		p100 = cashback / 100;
		cashback = cashback % 100;
		p20 = cashback / 20;
		cashback = cashback % 20;
		p10 = cashback / 10;
		cashback = cashback % 10;
		p5 = cashback / 5;
		cashback = cashback % 5;
		p1 = cashback / 1;
		cashback = cashback % 1;
		System.out.println("Return Coin Rs.1   X  " + p1);
		System.out.println("Return Coin Rs.5   X  " + p5);
		System.out.println("Return Coin Rs.10  X  " + p10);
		System.out.println("Return Coin Rs.20  X  " + p20);
		System.out.println("Return Coin Rs.100 X  " + p100);

	}

}
