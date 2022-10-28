package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.RedB;

public class RedBTest {
	WebDriver driver;
	@BeforeMethod
	public void launchBrowser() {
		driver =Browser.chromeBrowser("https://www.redbus.in/");
	}
	@Test
	public void bookTicketTest() {
		RedB redB =new RedB(driver);
		redB.clickOnSource();
		redB.enterSource("la");
		redB.selectCity("Latur");
		redB.enterDestination("pu");
		redB.selectCity("Pune");
		redB.selectDate("Nov", "1");
		redB.toggleSrcDstn();
		redB.clickOnSearch();
	}
}
