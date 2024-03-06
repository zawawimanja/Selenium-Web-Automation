package sys;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import component.Alert;
import component.Base;
import pages.cgp.pages.cgp.main.MainPage;
import pages.cgp.pages.cgp.main.restriction.DayTimePage;
import pages.cgp.pages.cgp.main.restriction.ProductPage;
import pages.cgp.systemsettings.CVPSettingsPage;
import pages.cgp.systemsettings.SystemSettingsPage;
public class SystemSettings extends Base{
	MainPage mainPage;
	DayTimePage dayTimePage;
	ProductPage productPage;
	SystemSettingsPage systemSettingsPage;
	CVPSettingsPage cvpSettingsPage;

	Alert alert;

	public void test_CheckAcceptanceSettingsCountry() throws InterruptedException {
		systemSettingsPage = new SystemSettingsPage(driver);
		systemSettingsPage.clickCVPSettings();

		cvpSettingsPage = new CVPSettingsPage(driver);
		int rowCount = driver.findElements(By.className("datagrid")).size();

		for (int i = 1; i <= rowCount; i++) {
			String sCellValue = driver.findElement(By.xpath("//*[@id=\"tblCVPCountryIssuerList\"]/tbody/tr[" + i + "]"))
					.getText();

			if (sCellValue.equalsIgnoreCase("GFN Austria 08")) {
				driver.findElement(By.xpath("//*[@id=\"tblCVPCountryIssuerList\"]/tbody/tr[" + i + "]")).click();
			}
		}
		cvpSettingsPage.clickEditSaveCVPCountrySetting();
		// find list checkbox
		int checkboxCount = driver.findElements(By.className("issuerCountryCheckbox")).size();
	;
		for (int i = 1; i <= rowCount; i++) {
			List<WebElement> checkboxes = driver.findElements(By.className("issuerCountryCheckbox"));

			if (i == 20) {
				checkboxes.get(19).click();
				checkboxes.get(20).click();
				cvpSettingsPage.clickEditSaveCVPCountrySetting();
				// click ok
				alert = new Alert(driver);
				String message = alert.accept();
				Assert.assertEquals(message, "Issuer Country settings is updated successfully.");
			}
		}
	}
	public void test_releaseCodeIssuingCountry() throws InterruptedException {
		systemSettingsPage = new SystemSettingsPage(driver);
		systemSettingsPage.clickCVPSettings();

		cvpSettingsPage = new CVPSettingsPage(driver);
		// int rowCount =
		// driver.findElements(By.xpath("///*[@id=\"tblCVPNetworkList\"]/tbody")).size();
		// .println(driver.findElements(By.xpath("//*[@id=\"tblCVPNetworkList\"]/tbody")).size());
		for (int i = 1; i <= 100; i++) {
			String sCellValue = driver.findElement(By.xpath("//*[@id=\"tblCVPNetworkList\"]/tbody/tr[" + i + "]"))
					.getText();

			if (sCellValue.equalsIgnoreCase("NL EG Retail B.V. 0382318528")) {
				driver.findElement(By.xpath("//*[@id=\"tblCVPNetworkList\"]/tbody/tr[" + i + "]")).click();
			}
		}
		cvpSettingsPage.clickEditSaveCVPNetworkSetting();
		// find dropdown issuing country
		cvpSettingsPage.selectReleaseCodeIssuingCountry("8");
		cvpSettingsPage.clickEditSaveCVPNetworkSetting();
		;
		// click ok
		driver.switchTo().alert().accept();
	}
	public void test_AddreleaseCodeIssuingCountry() throws InterruptedException {
		systemSettingsPage = new SystemSettingsPage(driver);
		systemSettingsPage.clickCVPSettings();

		cvpSettingsPage = new CVPSettingsPage(driver);
		// int rowCount =
		// driver.findElements(By.xpath("///*[@id=\"tblCVPNetworkList\"]/tbody")).size();
		// .println(driver.findElements(By.xpath("//*[@id=\"tblCVPNetworkList\"]/tbody")).size());
		for (int i = 1; i <= 100; i++) {
			String sCellValue = driver.findElement(By.xpath("//*[@id=\"tblCVPNetworkList\"]/tbody/tr[" + i + "]"))
					.getText();

			if (sCellValue.equalsIgnoreCase("NL EG Retail B.V. 0382318528")) {
				driver.findElement(By.xpath("//*[@id=\"tblCVPNetworkList\"]/tbody/tr[" + i + "]")).click();
			}
		}
		cvpSettingsPage.clickEditSaveCVPNetworkSetting();
		cvpSettingsPage.selectReleaseCodeIssuingCountry("GFN-AT - Austria");
		cvpSettingsPage.addIssuingCountry();
		// find dropdown issuing country
		cvpSettingsPage.selectReleaseCodeIssuingCountry("1");
		cvpSettingsPage.clickEditSaveCVPNetworkSetting();

		// click ok
		driver.switchTo().alert().accept();
	}
	public void test_EditReleaseCodeIssuingCountry() throws InterruptedException {
		systemSettingsPage = new SystemSettingsPage(driver);
		systemSettingsPage.clickCVPSettings();

		cvpSettingsPage = new CVPSettingsPage(driver);
		// int rowCount =
		// driver.findElements(By.xpath("///*[@id=\"tblCVPNetworkList\"]/tbody")).size();
		// .println(driver.findElements(By.xpath("//*[@id=\"tblCVPNetworkList\"]/tbody")).size());
		for (int i = 1; i <= 100; i++) {
			String sCellValue = driver.findElement(By.xpath("//*[@id=\"tblCVPNetworkList\"]/tbody/tr[" + i + "]"))
					.getText();

			if (sCellValue.equalsIgnoreCase("NL EG Retail B.V. 0382318528")) {
				driver.findElement(By.xpath("//*[@id=\"tblCVPNetworkList\"]/tbody/tr[" + i + "]")).click();
			}
		}
		cvpSettingsPage.clickEditSaveCVPNetworkSetting();
		cvpSettingsPage.selectReleaseCodeIssuingCountry("GFN-AT - Austria");
		cvpSettingsPage.removeIssuingCountry();
		cvpSettingsPage.selectReleaseCodeIssuingCountry("GFN-BG -Bulgaria");
		cvpSettingsPage.addIssuingCountry();
		// find dropdown issuing country
		cvpSettingsPage.clickEditSaveCVPNetworkSetting();

		// click ok
		driver.switchTo().alert().accept();
	}
	public void test_RemoveReleaseCodeIssuingCountry() throws InterruptedException {
		systemSettingsPage = new SystemSettingsPage(driver);
		systemSettingsPage.clickCVPSettings();

		cvpSettingsPage = new CVPSettingsPage(driver);
		// int rowCount =
		// driver.findElements(By.xpath("///*[@id=\"tblCVPNetworkList\"]/tbody")).size();
		// .println(driver.findElements(By.xpath("//*[@id=\"tblCVPNetworkList\"]/tbody")).size());
		for (int i = 1; i <= 100; i++) {
			String sCellValue = driver.findElement(By.xpath("//*[@id=\"tblCVPNetworkList\"]/tbody/tr[" + i + "]"))
					.getText();

			if (sCellValue.equalsIgnoreCase("NL EG Retail B.V. 0382318528")) {
				driver.findElement(By.xpath("//*[@id=\"tblCVPNetworkList\"]/tbody/tr[" + i + "]")).click();
			}
		}
		cvpSettingsPage.clickEditSaveCVPNetworkSetting();
		cvpSettingsPage.selectReleaseCodeIssuingCountry("GFN-BG -Bulgaria");
		cvpSettingsPage.removeIssuingCountry();
		// find dropdown issuing country
		cvpSettingsPage.clickEditSaveCVPNetworkSetting();

		// click ok
		driver.switchTo().alert().accept();
	}
	public void test_AddnationalIssuer() throws InterruptedException {
		systemSettingsPage = new SystemSettingsPage(driver);
		systemSettingsPage.clickCVPSettings();

		cvpSettingsPage = new CVPSettingsPage(driver);
		// int rowCount =
		// driver.findElements(By.xpath("///*[@id=\"tblCVPNetworkList\"]/tbody")).size();
		// .println(driver.findElements(By.xpath("//*[@id=\"tblCVPNetworkList\"]/tbody")).size());
		for (int i = 1; i <= 100; i++) {
			String sCellValue = driver.findElement(By.xpath("//*[@id=\"tblCVPNetworkList\"]/tbody/tr[" + i + "]"))
					.getText();

			if (sCellValue.equalsIgnoreCase("NL EG Retail B.V. 0382318528")) {
				driver.findElement(By.xpath("//*[@id=\"tblCVPNetworkList\"]/tbody/tr[" + i + "]")).click();
			}
		}

		cvpSettingsPage.clickEditSaveCVPNetworkSetting();
		cvpSettingsPage.selectNationalIssuing("GFN-AT - Austria");
		cvpSettingsPage.addNationalIssuers();
		cvpSettingsPage.clickEditSaveCVPNetworkSetting();

		// click ok
		driver.switchTo().alert().accept();
	}
	public void test_EditnationalIssuer() throws InterruptedException {
		systemSettingsPage = new SystemSettingsPage(driver);
		systemSettingsPage.clickCVPSettings();

		cvpSettingsPage = new CVPSettingsPage(driver);
		// int rowCount =
		// driver.findElements(By.xpath("///*[@id=\"tblCVPNetworkList\"]/tbody")).size();
		// .println(driver.findElements(By.xpath("//*[@id=\"tblCVPNetworkList\"]/tbody")).size());
		for (int i = 1; i <= 100; i++) {
			String sCellValue = driver.findElement(By.xpath("//*[@id=\"tblCVPNetworkList\"]/tbody/tr[" + i + "]"))
					.getText();

			if (sCellValue.equalsIgnoreCase("NL EG Retail B.V. 0382318528")) {
				driver.findElement(By.xpath("//*[@id=\"tblCVPNetworkList\"]/tbody/tr[" + i + "]")).click();
			}
		}

		cvpSettingsPage.clickEditSaveCVPNetworkSetting();
		cvpSettingsPage.selectNationalIssuing("GFN-AT - Austria");
		cvpSettingsPage.removeNationalIssuers();
		cvpSettingsPage.selectNationalIssuing("GFN-BG -Bulgaria");
		cvpSettingsPage.clickEditSaveCVPNetworkSetting();

		// click ok
		driver.switchTo().alert().accept();
	}
	public void test_removeNationalIssuer() throws InterruptedException {
		systemSettingsPage = new SystemSettingsPage(driver);
		systemSettingsPage.clickCVPSettings();

		cvpSettingsPage = new CVPSettingsPage(driver);
		// int rowCount =
		// driver.findElements(By.xpath("///*[@id=\"tblCVPNetworkList\"]/tbody")).size();
		// .println(driver.findElements(By.xpath("//*[@id=\"tblCVPNetworkList\"]/tbody")).size());
		for (int i = 1; i <= 100; i++) {
			String sCellValue = driver.findElement(By.xpath("//*[@id=\"tblCVPNetworkList\"]/tbody/tr[" + i + "]"))
					.getText();

			if (sCellValue.equalsIgnoreCase("NL EG Retail B.V. 0382318528")) {
				driver.findElement(By.xpath("//*[@id=\"tblCVPNetworkList\"]/tbody/tr[" + i + "]")).click();
			}
		}

		cvpSettingsPage.clickEditSaveCVPNetworkSetting();
		cvpSettingsPage.selectNationalIssuing("GFN-BG -Bulgaria");
		cvpSettingsPage.removeNationalIssuers();
		cvpSettingsPage.clickEditSaveCVPNetworkSetting();

		// click ok
		driver.switchTo().alert().accept();
	}
	@Test
	public void test_viewNetworkGrouping() throws InterruptedException {
		systemSettingsPage = new SystemSettingsPage(driver);
		systemSettingsPage.clickCVPSettings();

		cvpSettingsPage = new CVPSettingsPage(driver);
		// int rowCount =
		// driver.findElements(By.xpath("///*[@id=\"tblCVPNetworkList\"]/tbody")).size();
		// .println(driver.findElements(By.xpath("//*[@id=\"tblCVPNetworkList\"]/tbody")).size());
		for (int i = 1; i <= 157; i++) {
			String sCellValue = driver.findElement(By.xpath("//*[@id=\"tblCVPNetworkList\"]/tbody/tr[" + i + "]/td[2]"))
					.getText();
			// print string

			// find if string first char start 9 and click it
			if (sCellValue.charAt(0) == '9') {

				driver.findElement(By.xpath("//*[@id=\"tblCVPNetworkList\"]/tbody/tr[" + i + "]")).click();
				cvpSettingsPage.clickEditSaveCVPDisplayName();
				cvpSettingsPage.setCVPDisplayName("1");
				cvpSettingsPage.clickEditSaveCVPDisplayName();
			}
		}
	}


}