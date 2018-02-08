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

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		final String keyFile = "/var/tmp/bnc.api.APIkey";
		APIkey key = new APIkey(keyFile);
		String usePrivateKey = "n";

		if (key.getKey().length() == 64 && key.getSecret().length() == 64)
			do System.out.printf("Use API APIkey from file '%s' ? (y/n)", keyFile);
			while(!(usePrivateKey = scanner.nextLine()).matches("[yn]"));

		BinanceApiClientFactory factory;
		if (usePrivateKey.equals("y"))
			factory = BinanceApiClientFactory.newInstance(key.getKey(), key.getSecret());
		else
			factory = BinanceApiClientFactory.newInstance();

		BinanceApiRestClient client = factory.newRestClient();

		int menu = -1;
		scanner.nextLine();
		while (menu == -1) {
			System.out.println("Which API Component Would you like to test?\n" +
					"\t1 - REST\n");

			switch (menu = scanner.nextInt()) {

				case 1:
					System.out.println(" > REST\n");
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
