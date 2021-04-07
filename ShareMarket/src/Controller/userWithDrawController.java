package Controller;

import Model.User;

public class userWithDrawController extends DataPreProcess {
		public static void withDraw(int id ,double amt) {
			User usr = getUserById(id);
			if(usr!=null) {
				usr.setBalance(usr.getBalance() - amt);
				System.out.println("===================Withdraw Successfull===================");
			}else {
				System.out.println("===================Withdraw Unsuccessfull===================");
			}
				
		}
}
