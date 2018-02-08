import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class APIkey extends Main {
	private String Key;
	private String Secret;

	public APIkey(String file) {

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;

			while ((line = br.readLine()) != null)
				if (line.length() == 64)
					if (this.Key == null)
						this.Key = line;
					else if (this.Secret == null)
						this.Secret = line;

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getKey() {
		return Key;
	}

	public String getSecret() {
		return Secret;
	}
}
