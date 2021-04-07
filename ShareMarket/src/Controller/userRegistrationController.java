package Controller;

import java.util.Scanner;
public class userRegistrationController {

	public static void createUser(Scanner s) {
		while(true) {
			 System.out.println("-------------------Registration-------------------");
			 System.out.println("Enter Your Name ->");
			 s.nextLine();
			 String userName = s.nextLine();
			 System.out.println("Enter Your Adhar card number ->");
			 String userAdharCard = s.nextLine();
			 if(userAdharCard.length()!=12) {
				 System.out.println("===================Error:Please Check Your Adhar card number (Should be a 12 Digit Number)===================");
				 continue;
			 }
			 System.out.println("Enter Your PAN card number ->");
			 String userPanCard = s.nextLine();
			 System.out.println("Enter Your Bank Account");
			 String userBankAccount  = s.nextLine();
			 System.out.println("Enter Password(Should contain atleast one LowerCase, UpperCase, Special Character, Number)");
			 String userPassword = s.nextLine();
			 if (userPassword.length()<8) 
               {
                   System.out.println("Password must have at least 8 characters");
                   continue;
               }
			 else {
				 	int size  = DataPreProcess.getUsers().size();
					DataPreProcess.setUser(size +1, userName, userPassword, userBankAccount , userAdharCard ,userPanCard );
					if(DataPreProcess.getUserById(size+1)!=null) {
						 System.out.println("===================Registration Successfull===================");
						 System.out.println("===================Your User ID: " +(size+1) +"===================");
						break;
					}else {
						System.out.println("===================Error:Enter Details Correctly===================");
						 System.out.println("Dashboard y/n ->");
						 String ch = s.nextLine();
						 if(ch.charAt(0)=='y' ||ch.charAt(0)=='Y') {
							 break;
						 }
					}
			 }
		 }
	}
}
