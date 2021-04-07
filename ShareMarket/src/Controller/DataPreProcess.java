package Controller;

import java.util.ArrayList;
import Model.Stock;
import Model.User;

public class DataPreProcess {
	private static Stock stock[] = new Stock[10];
	private static ArrayList<User> user = new ArrayList<>();
	public static void createStock() {
		stock[0] = new Stock( 1,"SUNPHARMA", "Sun Pharmaceutical Industries Limited", 1020.2, "NIFTY PHARMA", "112123");
		stock[1] = new Stock( 2,"TCS","Tata Consultancy Services Limited" ,3266.2, "INFORMATION TECHNOLOGY", "323457654");
		stock[3] = new Stock(4,"NTPC", "NTPC Limited", 106.2,"NIFTY INFRASTRUCTURE", "234543");
		stock[4] = new Stock(5,"BHEL", "Bharat Heavy Electricals Limited",49.34,"NIFTY 500", "8987654");
		stock[5] = new Stock(6,"HDFCBANK","HDFC Bank Limited",	1442.5,"NIFTY BANK", "4567654");
		stock[6] = new Stock(7,"TATASTEEL", "Tata Steel Limited",876.2 , "NIFTY METAL", "6543456");
		stock[7] = new Stock(8,"BAJAJAUTO", "Bajaj Auto Limited",3565.5, "NIFTY AUTO", "32345");
		stock[8] = new Stock(9,"HINDPETRO","Hindustan Petroleum Corporation Limited",234.4 , "NIFTY ENERGY", "28645");
		stock[9]  =new Stock(10,"ASHOKLEY ","Ashok Leyland Limited",112.2 , "NIFTY AUTO", "43868");
		stock[2] = new Stock(3,"INFY","Infosys Limited",1414.0, "INFORMATION TECHNOLOGY" , "543263");
	
	}
	
	public static void  createUsers() {
		user.add(new User(1,"qwerty1Q#","ICICI","123456789012", "edfgfdhv098","Manovasanth Balasankar"));
		user.add( new User(2,"asdfgh2A#","SBI","098765432112", "kgucfxyyhv238","Balasankar"));
	
	}
	public static User getUserById(int id) {
		for(User usr : user) {
			if(usr.getUserId()==id) {
				return usr;
			}
		}
		return null;
		
	}


	public static ArrayList<User> getUsers() {
		return user;
	}
	public static void setUser( int id, String userName , String userPassword, String userBankAccount, String userAdharCard, String userPanCard) {
			user.add(new User(id,userPassword,userBankAccount,userAdharCard,userPanCard,userName));
	}
	public static Stock[] getStocks() {
		return stock;
	}
	
	public static Stock getStockById(int id) {
		for(Stock st:stock) {
			if(st.getId()==id) {
				return st;
			}
		}
		return null;
	}
	
	
}
