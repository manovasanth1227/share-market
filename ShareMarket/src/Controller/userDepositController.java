package Controller;

import Model.User;

public class userDepositController extends DataPreProcess {
	public static void deposit(double amt, int id) {
		User usr = getUserById(id);
		if(usr!=null) {
			usr.setBalance(usr.getBalance() + amt);
			System.out.println("===================Deposit Successfull===================");
		}else {
			System.out.println("===================Deposit Unsuccessfull===================");
		}
			
	}
}
