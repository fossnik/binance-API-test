import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiRestClient;

import java.util.Scanner;

/**
 * Some Useful Documentation
 * 	https://github.com/binance-exchange/binance-java-api
 * 	https://github.com/binance-exchange/binance-official-api-docs
 * 	https://python-binance.readthedocs.io/en/latest/index.html
 */

public class Main {

	private static Scanner scanner = new Scanner(System.in);
	private static final String keyFile = "/var/tmp/bnc.api.key";

	public static void main(String[] args) {

		APIkey key = new APIkey(keyFile);
		String usePrivateKey = "n";

		if (key.validate())
			do System.out.printf("Use API key from file '%s' ? (y/n)\n", keyFile);
			while(!(usePrivateKey = scanner.nextLine()).matches("[yn]"));

		int menu = -1;
		while (menu == -1) {
			System.out.println("\nWhich API Component Would you like to test?\n" +
					"\t1 - REST\n");

			switch (menu = scanner.nextInt()) {

				case 1:
					BinanceApiClientFactory factory;

					if (usePrivateKey.equals("y"))
						factory = BinanceApiClientFactory.newInstance(key.getKey(), key.getSecret());
					else
						factory = BinanceApiClientFactory.newInstance();

					BinanceApiRestClient client = factory.newRestClient();

					Restive.printMenu();

					int action;
					boolean success;

					do {
						action = Restive.selectAction();
						success = Restive.execute(action,  usePrivateKey.equals("y"), factory, client);
					} while (!success);

					break;

				default:
					System.out.println("\tInvalid Selection\n");
					scanner.nextLine();
					menu = -1;
			}
		}

		System.exit(0);
	}

}
