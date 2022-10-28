package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.PaytmBus;
import utility.Screenshot;

public class PaytmBusTest {
	WebDriver driver;
	@BeforeMethod
	public void busTicket() {
		driver =Browser.chromeBrowser("https://paytm.com/");
		
        PaytmBus demo1 =new PaytmBus(driver);
		
		demo1.clickOnBusTicket();
	}
	
	@Test()
	public void enterSource() throws InterruptedException {
		PaytmBus demo1 =new PaytmBus(driver);
		demo1.sourceCity("la");
		demo1.selectCity("Latur", driver);
		demo1.destinationCity("mu");
		demo1.selectCity("Mumbai", driver);
//		demo1.selectDate("November", "24", driver);
//		demo1.searchBus();
		demo1.test(driver);
	}
	
	@AfterMethod
	public void takeSS() throws IOException {
		Screenshot.takeScreenshot(driver, "bus");
	}

}
