package BussinessLogic;

import Controller.DataPreProcess;
import Model.User;

public class userAuthentication extends DataPreProcess {
		public static  boolean validateCredentials(int id , String userName, String password) {
			User res = getUserById(id);
			if(res.getUserName().equalsIgnoreCase(userName) && res.getUserPassword().equalsIgnoreCase(password)) {
				return true;
			}
			return false;
		}
}
