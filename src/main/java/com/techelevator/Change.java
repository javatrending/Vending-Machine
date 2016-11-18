package com.techelevator;

public class Change {

	private int numberOfQuarters;
	private int numberOfDimes;
	private int numberOfNickels;
	
	public int getChange(double balance) {
		numberOfQuarters = (int)(balance * 100) / 25;
		return numberOfQuarters;
	}

	public int getNumberOfQuarters() {
		return numberOfQuarters;
	}

	public void setNumberOfQuarters(int numberOfQuarters) {
		this.numberOfQuarters = numberOfQuarters;
	}

	public int getNumberOfDimes() {
		return numberOfDimes;
	}

	public void setNumberOfDimes(int numberOfDimes) {
		this.numberOfDimes = numberOfDimes;
	}

	public int getNumberOfNickels() {
		return numberOfNickels;
	}

	public void setNumberOfNickels(int numberOfNickels) {
		this.numberOfNickels = numberOfNickels;
	}
	
	
}
