package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RedB {
	@FindBy (xpath = "//input[@id='src']") private WebElement source;
	@FindBy (xpath = "//input[@id='dest']") private WebElement destination;
	@FindBy (xpath = "//main//section//div[2]//section//div//div//div//ul//li") private List<WebElement> citys;
	@FindBy (xpath = "//input[@id='onward_cal']") private WebElement date;
	@FindBy (xpath = "//td[@class='monthTitle']") private WebElement month;
	@FindBy (xpath = "//tbody//tr[1]//td[3]//button") private WebElement nextMonth;
	@FindBy (xpath = "//div//table//tbody//td") private List<WebElement> days;
	@FindBy (xpath = "//button[text()='Search Buses']") private WebElement search;
	@FindBy (xpath = "//span[@id='togglebtn']") private WebElement toggle;
	
	public RedB(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnSource() {
		source.click();
	}
	public void clickOnDestination() {
		destination.click();
	}
	public void enterSource(String name) {
		source.sendKeys(name);
	}
	public void enterDestination(String name) {
		destination.sendKeys(name);
	}
	public void selectCity(String expected) {
		for(int i=0;i<citys.size();i++) {
			WebElement ct =citys.get(i);
			String actual =ct.getText();
			if(actual.equalsIgnoreCase(expected)) {
				ct.click();
			}
		}
	}
	public void clickOnDate() {
		date.click();
	}
	public void selectDate(String mnth, String day) {
		int a=0; int b=1;
		
		while(a<b) {
		if(month.getText().contains(mnth)) {
			for(int i=0;i<days.size();i++) {
				WebElement d =days.get(i);
				String actD =d.getText();
				if(actD.equals(day)) {
					d.click();
					break;
				}
			}
			break;
		}
		else {
			nextMonth.click();
		}
		}
	}
	public void clickOnSearch() {
		search.click();
	}
	public void toggleSrcDstn() {
		toggle.click();
	}

}
