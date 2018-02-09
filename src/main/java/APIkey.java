import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class APIkey {
	private String Key;
	private String Secret;
	private String filePath;

	APIkey(String file) {
		this.filePath = file;
	}

	public boolean validate() {
		try {
			BufferedReader br = new BufferedReader(new FileReader(this.filePath));
			String line;

			while ((line = br.readLine()) != null)
				if (line.length() == 64)
					if (this.Key == null)
						this.Key = line;
					else if (this.Secret == null)
						this.Secret = line;

		} catch ( Exception e ) {
			return false;
		}

		return this.getKey().length() == 64 && this.getSecret().length() == 64;
	}

	public String getKey() {
		return Key;
	}

	public String getSecret() {
		return Secret;
	}
}
