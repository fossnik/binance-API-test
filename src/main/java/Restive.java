import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiRestClient;
import com.binance.api.client.domain.market.TickerPrice;

import java.util.List;
import java.util.Scanner;

public class Restive {

	private static boolean accessPrivate;
	private static Scanner scanner = new Scanner(System.in);

	Restive(String usePrivateKey) {
		accessPrivate = usePrivateKey.equals("y");
	}

	public static void printMenu() {
		System.out.println("\t* Restive Client Menu *\n");

		if (accessPrivate)
			System.out.println("\t=== Private Account ===\n" +
					" 10 - Account Balances\n" +
					" 11 - Open Orders\n" +
					"\n");

		System.out.println("\t=== Public API Data ===\n" +
				" 0 - Quit\n" +
				" 1 - List All Prices\n" +
				" 2 - OrderBook Queries\n");
	}

	public static int selectAction() {

		int menu = -1;
		while (menu == -1) {

			switch (menu = scanner.nextInt()) {

				case 0:
					System.out.println("\t\tGoodbye");
					System.exit(0);

				case 1:
					System.out.println("List of All Prices\n");
					return 1;

				case 2:
					throw new UnsupportedOperationException("Asynchronous API not yet Implemented");

				case 10:
					throw new UnsupportedOperationException("Asynchronous API not yet Implemented");

				case 11:
					throw new UnsupportedOperationException("Asynchronous API not yet Implemented");

				default:
					System.out.println("\tInvalid Selection\n");
					scanner.nextLine();
					menu = -1;
			}

		}

		return menu;
	}

	public static boolean execute(int action, boolean accountAccess, com.binance.api.client.BinanceApiClientFactory factory, com.binance.api.client.BinanceApiRestClient client) {
		if (accountAccess && action >= 10)
			System.out.println("Cannot Perform this Function without Private Account Access");

		switch (action) {
			case 1:
				List<TickerPrice> allPrices = client.getAllPrices();
				System.out.println(allPrices);

				return true;

			default:
				System.out.println("\tInvalid Action\n");
				return false;
		}


	}

}
