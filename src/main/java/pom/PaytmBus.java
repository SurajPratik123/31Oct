package pom;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaytmBus {
	@FindBy (xpath = "//section[4]//div[1]//div[1]//div[1]//div[3]") private WebElement bus;
	@FindBy (xpath = "(//input[@id='text-box'])[1]") private WebElement source;
	@FindBy (xpath = "(//input[@id='text-box'])[2]") private WebElement destination;
	@FindBy (xpath = "//p[1]") private List<WebElement> citys;
	@FindBy (xpath = "(//input[@class='fl-input _9KqY'])[1]") private WebElement dateSelect;
	@FindBy (xpath = "//a[@class='react-datepicker__navigation react-datepicker__navigation--next']") private WebElement nextM;
	@FindBy (xpath = "//div[contains(@class,'__current-month')]") private WebElement months;
	@FindBy (xpath = "//div[@role='option']") private List<WebElement> dates;
	@FindBy (xpath = "//button[text()='Search']") private WebElement search;
	
	double x =14.14;
	double y =14.14;
	
	int a = (int) x;
	int b = (int) y;
	
	public PaytmBus(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnBusTicket() {
		bus.click();
	}
	
	public void sourceCity(String city) throws InterruptedException {
		source.sendKeys(city);
		Thread.sleep(2000);
	}
	public void destinationCity(String city) throws InterruptedException {
		destination.sendKeys(city);
		Thread.sleep(2000);
	}
	
	public void selectCity(String expected, WebDriver driver) {
		int n =citys.size();
		
		for(int i=0;i<n;i++) {
			WebElement ct =citys.get(i);
			String actual =ct.getText();
			System.out.println(actual);
			Actions act =new Actions(driver);
			if(actual.equalsIgnoreCase(expected)) {
				act.moveToElement(ct);
				act.perform();
				ct.click();
				break;
			}
		}
	}
	
	public void selectDate(String month, String date, WebDriver driver) throws InterruptedException {
		int a=0;
		int b=1;
		dateSelect.click();
		Thread.sleep(2000);
		
		while(a<b) {
			WebDriverWait wait =new WebDriverWait(driver, Duration.ofMillis(5000));
			wait.until(ExpectedConditions.visibilityOf(months));
			String mnthName =months.getText();
			Thread.sleep(b);
			if(mnthName.contains(month)) {
				for(int i=0;i<dates.size();i++) {
					WebElement dt =dates.get(i);
					String dtName =dt.getText();
					if(dtName.equalsIgnoreCase(date)) {
						dt.click();
						System.out.print(dtName + " ");
						break;
					}
				}
				System.out.println(mnthName);
				break;
			}
			else {
				Thread.sleep(2000);
				Actions act =new Actions(driver);
				act.moveByOffset(a, b);
				act.perform();
				Thread.sleep(2000);
				act.click();
				act.perform();
				Thread.sleep(2000);
			}
		}
	}
	public void searchBus() {
		search.click();
	}
	public void test(WebDriver driver) throws InterruptedException {
		dateSelect.click();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
		wait.until(ExpectedConditions.elementToBeClickable(nextM));
		((JavascriptExecutor)driver).executeScript("arguments[0].click;", nextM);
	}

}
