package utils;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import stepDefinitions.Hooks;

public class CommonMethods {
	
	
	 WebDriver driver=Hooks.getDriver();
	 
	 public boolean popupDisplay()
	 
	 {
		 try {
			 return
		 (driver.findElement(By.xpath("//div[contains(@class,'style_popup__a7PrI')]")).isDisplayed());
		 }
		 
		 catch(NoSuchElementException e){
		 return false;
	 }
		 }
	 
	public void popupHandle()
	{
		driver.findElement(By.xpath("//span[@class='style_cross__q1ZoV']//img")).click();
		
	}

}
