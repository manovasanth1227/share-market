package BussinessLogic;

import java.util.Scanner;

import Controller.DataPreProcess;
import Model.Order;
import Model.Stock;
import Model.User;

public class BuyOrder extends DataPreProcess implements Order{

	@Override
	public void marketOrder(int id , String investmentType ,String orderType, String orderOption , Scanner s ) {
		User usr  = DataPreProcess.getUserById(id);
		System.out.println("Enter the Stock ID ->");
		int stockid = s.nextInt();
		s.nextLine();
		Stock st =DataPreProcess.getStockById(stockid);
		System.out.println("Last Traded Stock Price : "+st.getLastTradedPrice());
		System.out.println("Enter the QTY ->");
		int qty = s.nextInt();
		s.nextLine();
	
		double price  = st.getLastTradedPrice();
		int size  = usr.getOrders().size()+1;
		usr.setStocks(st, qty, orderOption);
		usr.addOrder(size,  st.getSymbol(), investmentType,orderType, orderOption, price, qty);
	}

	@Override
	public void limitOrder(int id , String investmentType ,String orderType, String orderOption , Scanner s ) {
		User usr  = DataPreProcess.getUserById(id);
		s.nextLine();
		System.out.println("Enter the Stock ID ->");
		int stockid = s.nextInt();
		s.nextLine();
		Stock st =DataPreProcess.getStockById(stockid);
		System.out.println("Last Traded Stock Price : "+st.getLastTradedPrice());
		System.out.println("Enter the QTY ->");
		int qty = s.nextInt();
		s.nextLine();
	
		System.out.println("Enter the Price:");
		double price = s.nextDouble();
		s.nextLine();
		int size  = usr.getOrders().size()+1;
		usr.setStocks(st, qty, orderOption);
		usr.addOrder(size, st.getSymbol(), investmentType,orderType, orderOption, price,qty);
		
	}

	@Override
	public void bracketOrder(int id , String investmentType ,String orderType, String orderOption , Scanner s) {
		User usr  = DataPreProcess.getUserById(id);
		s.nextLine();
		System.out.println("Enter the Stock Symbol:");
		String symbol = s.nextLine();
		System.out.println("Enter the Price:");
		double price = s.nextDouble();
		s.nextLine();
		System.out.println("Enter the Target Price:");
		double targetPrice = s.nextDouble();s.nextLine();
		System.out.println("Enter the Stoploss Price:");
		double stoploss = s.nextDouble();s.nextLine();
		
	}

}
