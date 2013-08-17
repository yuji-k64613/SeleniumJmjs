package com.example.jm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.android.AndroidDriver;

public class AndroidTest {
    public static void main(String[] args) {
    	try {
    		WebDriver driver = new AndroidDriver();
	        driver.get("http://www.google.co.jp");
	        WebElement element = driver.findElement(By.name("q"));
	        element.sendKeys("selenium");
	        element.submit();
	        driver.quit();
    	}
    	catch (Exception e){
    		e.printStackTrace();
    	}
    }
}
