package Controller;

import java.util.Scanner;

public class userController extends DataPreProcess {
	public static void deposit(int id, Scanner s) {
		System.out.println("-------------------Deposit-------------------");
		System.out.println("Available Balance : " + getUserById(id).getBalance());
		System.out.println("Enter Amount to be Deposited ->");
		double amt  = s.nextDouble();
		s.nextLine();
		userDepositController.deposit(amt,id);
	}
	public static void withDraw(int id, Scanner s) {
		System.out.println("-------------------Deposit-------------------");
		System.out.println("Available Balance : " + getUserById(id).getBalance());
		System.out.println("Enter Amount to Withdraw ->");
		double amt  = s.nextDouble();
		s.nextLine();
		userWithDrawController.withDraw(id, amt);
	}
	public static void viewBalance(int id, Scanner s) {
		System.out.println("-------------------View Balance-------------------");
		System.out.println("Available Balance : " + getUserById(id).getBalance());
	}
}
