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
 * 	https://python-binance.readthedocs.io/en/latest/index.html
 */

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int menu = -1;
		while (menu == -1) {
			System.out.println("Which API Component Would you like to test?\n" +
					"\t1 - REST\n" +
					"\t2 - Non-blocking (Asynchronous) REST\n" +
					"\t3 - WebSocket\n");

			switch (menu = scanner.nextInt()) {

				case 1:
					System.out.println("REST");
					break;
				case 2:
					System.out.println("NonBlocking REST");
					break;
				case 3:
					System.out.println("WebSocket");
					break;

				default:
					System.out.println("\tInvalid Selection\n");
					scanner.nextLine();
					menu = -1;
			}
		}

		String apiKey;
		String apiSecret = null;
		do System.out.println("Use a private API key? (y/n)");
		while (!((apiKey = scanner.nextLine()).matches("[yn]")));

		if (apiKey.equals("y"))
			try(BufferedReader br = new BufferedReader(new FileReader("~/bnc.api.key"))) {
				String line;

				while ( (line = br.readLine()) != null )
					if (line.length() == 64)
						if (apiKey.length() != 64)
							apiKey = line;
						else
							if (apiSecret == null)
								apiSecret = line;

			} catch (IOException e) {
				e.printStackTrace();
			}

		BinanceApiClientFactory fty = BinanceApiClientFactory.newInstance();
		BinanceApiRestClient cnt = fty.newRestClient();

	}

}
