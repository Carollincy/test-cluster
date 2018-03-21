package com.clusters.generic.utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class JavaScriptPopUpHandlers {

	public static void clickOkOnJsPopUp(WebDriver driver)
	{
		Alert alt=driver.switchTo().alert();
		alt.accept();
	}
	public static void clickCancelOnJsPopUp(WebDriver driver)
	{
		Alert alt=driver.switchTo().alert();
		alt.dismiss();
	}
	public static String getMsgOfJsPopUp(WebDriver driver)
	{
		Alert alt=driver.switchTo().alert();
		String alt_msg=alt.getText();
		return alt_msg;
	}
	public static void enterTextOnJsPopUp(WebDriver driver, String text)
	{
		Alert alt=driver.switchTo().alert();
		alt.sendKeys(text);
	}
	
}
