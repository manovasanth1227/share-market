package Controller;

import Model.Stock;
public class StockWatchController {
	public static void stockDisplay() {
		Stock stocks[] = DataPreProcess.getStocks();
		for(Stock s:stocks) {
			System.out.println(s.toString());
		}
	}
}
