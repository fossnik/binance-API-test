import java.util.Scanner;

public class rest {

	public static void printMenu(String accountKey) {

		switch (accountKey.charAt(0)) {

			case 'y':
				System.out.println("" +
						"import com.binance.api.client.domain.account.Account;\n" +
						"import com.binance.api.client.domain.account.DepositAddress;\n" +
						"import com.binance.api.client.domain.account.DepositHistory;\n" +
						"import com.binance.api.client.domain.account.NewOrder;\n" +
						"import com.binance.api.client.domain.account.NewOrderResponse;\n" +
						"import com.binance.api.client.domain.account.Order;\n" +
						"import com.binance.api.client.domain.account.Trade;\n" +
						"import com.binance.api.client.domain.account.WithdrawHistory;\n" +
						"import com.binance.api.client.domain.account.request.AllOrdersRequest;\n" +
						"import com.binance.api.client.domain.account.request.CancelOrderRequest;\n" +
						"import com.binance.api.client.domain.account.request.OrderRequest;\n" +
						"import com.binance.api.client.domain.account.request.OrderStatusRequest;");

			default:
				System.out.println("" +
						"import com.binance.api.client.domain.market.AggTrade;\n" +
						"import com.binance.api.client.domain.market.BookTicker;\n" +
						"import com.binance.api.client.domain.market.Candlestick;\n" +
						"import com.binance.api.client.domain.market.CandlestickInterval;\n" +
						"import com.binance.api.client.domain.market.OrderBook;\n" +
						"import com.binance.api.client.domain.market.TickerPrice;\n" +
						"import com.binance.api.client.domain.market.TickerStatistics;");
		}

		Scanner scanner = new Scanner(System.in);
		int menu = -1;
		String parameters;

		while (menu == -1) {
			System.out.println(
"Select an Operation\n" +
"\t1 - getOrderBook\n");

			switch (menu = scanner.nextInt()) {

				case 1:

						System.out.println(
" > Get Order Book\n\n" +
"\tComma-Separated Parameters:\n" +
"\t\tsymbol=< >, [limit=< >]\n\n");

						System.out.println(
"* Get compressed, aggregate trades. Trades that fill at the time, from the same order, with\n" +
" * the same price will have the quantity aggregated.\n" +
" *\n" +
" * If both <code>startTime</code> and <code>endTime</code> are sent, <code>limit</code>should not\n" +
" * be sent AND the distance between <code>startTime</code> and <code>endTime</code> must be less than 24 hours.\n" +
" *\n" +
" * @param symbol symbol to aggregate (mandatory)\n" +
" * @param fromId ID to get aggregate trades from INCLUSIVE (optional)\n" +
" * @param limit Default 500; max 500 (optional)\n" +
" * @param startTime Timestamp in ms to get aggregate trades from INCLUSIVE (optional).\n" +
" * @param endTime Timestamp in ms to get aggregate trades until INCLUSIVE (optional).\n" +
" * @return a list of aggregate trades for the given symbol");

				case 2:
					throw new UnsupportedOperationException("Not Yet Implemented");

				case 3:
					throw new UnsupportedOperationException("Not Yet Implemented");

				default:
					System.out.println("\tInvalid Selection\n");
					scanner.nextLine();
					menu = -1;
			}
		}
	}
}
