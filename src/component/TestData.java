package component;

import org.openqa.selenium.WebDriver;

public class TestData {
	WebDriver driver;

	public TestData(WebDriver driver) {
		this.driver = driver;
	}

	// card have card bundle
	// 05
	public String getPAN1() {
		return "7002087000922440099";
	}

	public String getPANTokenRequest() {
		return "7077087002923370079";
	}

	public String getCardExpiryTokenRequestor() {
		return "0125";
	}


	public String getCardExpiry() {
		return "0723";
	}

	// 007
	public String getPAN2() {
		return "7002087000922460014";
	}

	// 005
	public String getPAN3() {
		return "7077087002923370277";
	}

	// copy test 00000007
	// card only copy card. diff acc cannot
	// if pan delete changed to new pan and insert new value
	public String getPAN4() {
		return "7002087000922460022";
	}

	public String getCustAccNo1() {
		return "00000005";
	}

	public String getCustAccNo2() {
		return "00000007";
	}

	// if someone delete the card bundle need to add back
	public String getCardBundle() {
		return "10130";
	}

}
