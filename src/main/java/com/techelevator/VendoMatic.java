package com.techelevator;

public class VendoMatic {
	static VendingMachine vm;

	public static void main(String[] args) throws Exception {
		vm = new VendingMachine();
		vm.stock();
		while (true) {
			vm.start();
		}

	}

}