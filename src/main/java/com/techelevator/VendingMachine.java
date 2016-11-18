package com.techelevator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class VendingMachine {
	private double currentBalance = 0;

	private Map<String, Product> products = new LinkedHashMap<>();
	Scanner sc = new Scanner(System.in);

	public VendingMachine() {

	}

	public Map<String, Product> getProducts() {
		return products;
	}

	public void stock() throws Exception {

		File stockFile = new File("vendingmachine.csv");
		if (!stockFile.exists()) {
			System.out.println("File does not exist");
			System.exit(1);
		}

		try (FileInputStream fr = new FileInputStream(stockFile.getAbsoluteFile());
				InputStreamReader isr = new InputStreamReader(fr, "UTF-8");
				BufferedReader br = new BufferedReader(isr);) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] newStock = line.split("\\|");
				products.put(newStock[0], new Product(newStock[0], newStock[1], Double.parseDouble(newStock[2]), 5));
			}
		}
	}

	public int mainMenu() {

		System.out.println("=======================================");
		System.out.println("(1) Display Vending Machine Items");
		System.out.println("(2) Purchase");
		System.out.print("Please enter your choice:");
		int choice = sc.nextInt();
		return choice;

	}

	public int purchaseMenu() {

		System.out.println("Press 1 to feed money.");
		System.out.println("Press 2 to select product.");
		System.out.println("Press 3 to finish transaction");
		System.out.println("Enter your choice:");
		int purchaseChoice = sc.nextInt();
		return purchaseChoice;

	}

	public void displayProducts() {
		Set<String> keys = products.keySet();
		for (String k : keys) {
			Product p = products.get(k);
			System.out.println(p.getSlotID() + " " + p.getName() + " " + p.getPrice() + " " + p.getQuantity());
		}

	}

	public void start() throws IOException {

		int choice = mainMenu();
		if (choice == 1) {
			displayProducts();
		} else {
			purchase();
		}
	}

	public void feedMoney(double money) {
		currentBalance = currentBalance + money;
		System.out.println("You feeded $" + currentBalance);
	}

	public void purchase() throws IOException {
		while (true) {
			int choice = purchaseMenu();
			if (choice == 1) {
				System.out.println("Enter money you wish to feed:");
				double inputMoney = sc.nextDouble();
				feedMoney(inputMoney);

			} else if (choice == 2) {
				displayProducts();
				System.out.println("Enter item:");
				String slotID = sc.next().toUpperCase();
				purchaseProduct(slotID);
			} else {
				finishTransaction();
				break;
			}

		}
	}

	public void purchaseProduct(String slotID) throws IOException {
		if (products.containsKey(slotID)) {
			if (products.get(slotID).getQuantity() != 0) {
				if (currentBalance >= products.get(slotID).getPrice()) {

					System.out.println("Enjoy your " + products.get(slotID).getName());
					int remainingItems = products.get(slotID).getQuantity();
					remainingItems -= 1;
					products.get(slotID).setQuantity(remainingItems);
					double remainingCurrentBalance = currentBalance - products.get(slotID).getPrice();

					transactionLog(products.get(slotID).getName(), slotID, currentBalance, remainingCurrentBalance);
					currentBalance = currentBalance - products.get(slotID).getPrice();

				}

				else {
					System.out.println(products.get(slotID).getName() + " costs " + products.get(slotID).getPrice()
							+ " .You feeded $" + currentBalance);
				}
			}

			else {
				System.out.println(products.get(slotID).getName() + " is SOLD OUT");
			}
		} else {
			System.out.println("Sorry not available");
		}

	}

	public void finishTransaction() {
		if (currentBalance > 0) {
			Change change = new Change();
			System.out.println(
					"You receive $" + currentBalance + " in " + change.getChange(currentBalance) + " quarters");
		} else {
			System.out.println("Have a good day.");
		}

	}

	public void transactionLog(String name, String slotID, double amountGiven, double balance)
			throws IOException {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		File newFile = new File("TransactionLog.txt");//create file object

		try (//PrintWriter writer = new PrintWriter(newFile)
				PrintWriter writer=new PrintWriter(new FileWriter("TransactionLog.txt",true))) {
			writer.println(dateFormat.format(date) + " " + name + " " + slotID + " " + amountGiven + " " + balance);

		}

	}
}
