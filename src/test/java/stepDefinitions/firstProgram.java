package stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonMethods;

public class firstProgram {
	WebDriver driver=Hooks.getDriver();
    WebDriverWait wait=Hooks.getWait();
    CommonMethods cm=new CommonMethods();
	
	@Given("User opens the Yatra application")
	public void user_opens_the_yatra_application() {
		System.out.print("Browser opened");

		}
	
	@When("User enters {string} in the departure field")
	public void user_enters_in_the_departure_field(String string) {
		
		if(cm.popupDisplay()==true)
		{
			cm.popupHandle();
		}
		
		
		driver.findElement(By.xpath("//div[@class='MuiBox-root css-1ek1ggs' and contains(@aria-label,'Departure')]//p[2]"))
		.click();
		
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@class,'css-mnn31')]")));
		element.sendKeys(string);
		
	}
	@Then("List of searched source items display and user selects {string} from the list")
	public void list_of_searched_source_items_display_and_user_selects_agra_from_the_list(String airCode) throws InterruptedException {
		Thread.sleep(3000);
	  
		//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'text-grey-main')]")));
		List<WebElement> list=driver.findElements(By.xpath("//div[contains(@class,'text-grey-main')]"));
		//System.out.println(list.size());
		for(WebElement ele:list)
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String innerText = (String) js.executeScript(
			    "return arguments[0].innerText;", ele);
			System.out.println(innerText);
			if(ele.getText().equals(airCode))
			{
				
				ele.click();
				break;
			}
		}
	}
	@Then("Agra should be displayed in the Departure box.")
	public void agra_should_be_displayed_in_the_departure_box() {
		System.out.println("test");
		boolean b=driver.findElement(By.xpath("//p[@title='Agra']")).isDisplayed();
		Assert.assertEquals(b, true);
		 
	}
	
	@When("User enters {string} in the destination field")
	public void user_enters_in_the_destination_field(String string) {
		
		if(cm.popupDisplay()==true)
		{
			cm.popupHandle();
		}
	   
		driver.findElement(By.xpath("//p[contains(text(),'Going')]//following-sibling::p[1]")).click();
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#input-with-icon-adornment")));
		element.sendKeys(string);
	}
	@Then("List of searched destination items display and user selects {string} from the list")
	public void list_of_searched_destination_items_display_and_user_selects_from_the_list(String aircode) throws InterruptedException {
	  
		Thread.sleep(2000);
		List<WebElement> dest=driver.findElements(By.xpath("//div[contains(@class,'text-grey-main')]"));
		for(WebElement ele:dest)
		{
			JavascriptExecutor js=(JavascriptExecutor)driver;
			String innertext= (String)js.executeScript("return arguments[0].innerText;", ele);
			System.out.println(innertext);
			if(innertext.equals(aircode))
			{
				ele.click();
				break;
			}
		}
	}
	@Then("Pula should be displayed in the Departure box.")
	public void pula_should_be_displayed_in_the_departure_box() {
	    boolean b=driver.findElement(By.xpath("//p[contains(@class,'css-1rv3qys') and @title='Pula']")).isDisplayed();
	    Assert.assertEquals(b, true);
	}
	
	


}
