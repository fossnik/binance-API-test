import com.binance.api.client.BinanceApiAsyncRestClient;
import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiRestClient;
import com.binance.api.client.domain.market.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Some Useful Documentation
 * 	https://github.com/binance-exchange/binance-java-api
 * 	https://github.com/binance-exchange/binance-official-api-docs
 * 	https://python-binance.readthedocs.io/en/latest/index.html
 */

public class Main {

	public static void main(String[] args) {

		final String keyFile = "/var/tmp/bnc.api.key";

		String usePrivateKey;
		String apiKey = null;
		String apiSecret = null;
		Scanner scanner = new Scanner(System.in);

		do System.out.printf("Use API key from file '%s' ? (y/n)", keyFile);
		while (!((usePrivateKey = scanner.nextLine()).matches("[yn]")));

		if (usePrivateKey.equals("y"))
			try(BufferedReader br = new BufferedReader(new FileReader(keyFile))) {
				String line;

				while ( (line = br.readLine()) != null )
					if (line.length() == 64)
						if (apiKey == null)
							apiKey = line;
						else
							if (apiSecret == null)
								apiSecret = line;

			} catch (IOException e) { e.printStackTrace(); }

		BinanceApiClientFactory factory;

		if (usePrivateKey.equals("y"))
			factory = BinanceApiClientFactory.newInstance(apiKey, apiSecret);
		else
			factory = BinanceApiClientFactory.newInstance();

		BinanceApiRestClient client = factory.newRestClient();

		int menu = -1;
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
		scanner.nextLine();


		System.exit(0);
	}

}
