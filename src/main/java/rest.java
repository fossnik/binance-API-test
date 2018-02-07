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
	}
}
