package View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import Controller.DataPreProcess;
import Controller.OrderController;
import Controller.StockWatchController;
import Controller.userController;
import Controller.userLoginController;
import Controller.userRegistrationController;
import Model.OrderModel;
import Model.Stock;



public class ShareMarketDriver {
	static Scanner s = new Scanner(System.in);
	private static boolean loginValid = false;
	private static int usrId = 0;
	public static void display(String Option) {
		while(true) {
			 System.out.println("-------------------"+Option+" Options: Choose any one-------------------");
	 		 System.out.println("1.MIS-Intraday");
	 		 System.out.println("2.CNC-Swing / Long Term / Short Term");
	 		 System.out.println("3.Dashboad");
	 		 s.nextLine();
	 		 int chOfInvestment = s.nextInt();
	 		 if(chOfInvestment==3)break;
	 		 else if(chOfInvestment <=0 || chOfInvestment>=3) {
	 			 System.out.println("===================Error:Enter a Valid Option===================");
	 			 continue;
	 		 }
	 		 System.out.println("----------------"+Option+" Order Options: Choose any one----------------");
			 System.out.println("1.Market Order");
			 System.out.println("2.Limit Order");
			 System.out.println("3.Bracket Order");
			 System.out.println("4.Dashboad");
			 s.nextLine();
			 int chOrder = s.nextInt();
			 if(chOrder==4)break;
			 else if(chOfInvestment >0 && chOfInvestment<3 && chOrder>0 && chOrder<4 ) {
				 StringBuffer investmentType = new StringBuffer();
				 StringBuffer orderType = new StringBuffer();
				 switch(chOfInvestment) {
				 	case 1 :  investmentType.append("MIS-Intradey");break;
				 	case 2: investmentType.append("CNC");break;
				 }
				 switch(chOrder) {
				 	case 1 : orderType.append("Market");break;
				 	case 2 : orderType.append("Limit");break;
				 	case 3 : orderType.append("Bracket");break;
				 }
				 
				 OrderController.buyOrder(usrId, investmentType.toString(), orderType.toString(), Option, s);
				 break;
			 }else {
				 System.out.println("===================Error:Enter a Valid Option===================");
			 }
		 }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean enter = true;
		DataPreProcess.createStock();
		DataPreProcess.createUsers();
		while(enter){
				System.out.println("-------------------Welcome to ShareMarket Indices-------------------");
				System.out.println("Choose any of the options below");
				System.out.println("1.Stock Watch");
				System.out.println("2.Login");
				System.out.println("3.Buy");
				System.out.println("4.Sell");
				System.out.println("5.Deposit");
				System.out.println("6.Withdraw");
				System.out.println("7.View Balance Available");
				System.out.println("8.New Registration");
				System.out.println("9.Log Out");
				System.out.println("10.Exit");
			int ch = s.nextInt();
			switch(ch) {
				case 1 : StockWatchController.stockDisplay();
		   		   		 break;
				case 2 : if(!loginValid)loginValid = userLoginController.loginController(s);
						 else {
							 System.out.println("===================Already Signed In===================");
						 }
							break;
				case 3 : if(loginValid) display("Buying");
						 else {
							 System.out.println("===================Please Login===================");
						 }
						   break;
				case 4 :  if(loginValid)display("Selling");
						  else {
								 System.out.println("===================Please Login===================");
							 }
				           break;
				case 5 : if(loginValid)userController.deposit(usrId , s);
							  else {
									 System.out.println("===================Please Login===================");
								 }
			           		   break;
				case 6  : if(loginValid)userController.withDraw(usrId, s);
						  else {
								 System.out.println("===================Please Login===================");
							 }
							break;
				case 7: if(loginValid)userController.viewBalance(usrId, s);
						  else {
								 System.out.println("===================Please Login===================");
							 }
							break;
					
				case 8 : if(!loginValid)userRegistrationController.createUser(s);
						else {
							 System.out.println("===================Error:Already Signed In===================");
						 }
						break;
				case 9 : if(loginValid) {
								System.out.println("Are you sure? (y/n) ->");
								s.nextLine();
								 String choice = s.nextLine();
								 if(choice.charAt(0)=='y' ||choice.charAt(0)=='Y') {
									 loginValid = false;
										usrId =0;
										System.out.println("===================Signed Out Successfully===================");
								 }
								
						}else {
							 System.out.println("===================Error:Please Login===================");
						}
				           break;
				case 10 :    System.out.println("################## BYE ##################  ");
							   enter = false;
	          		           break;
				case 11 : ArrayList<OrderModel> usr = DataPreProcess.getUserById(usrId).getOrders();
						  HashMap<Stock,Integer> stock = DataPreProcess.getUserById(usrId).getStocks();
						 for(OrderModel u : usr) {
							 System.out.println(u.toString());
						 }
						 for(Stock s : stock.keySet()) {
							 System.out.println(s.toString());
							System.out.println(stock.get(s));
						 }
				           break;
				default : System.out.println("===================Error:Enter a Valid Option===================");
						   break;
			}
		}
	}
	public static void setUsrId(int id) {
		usrId = id;
	}

}