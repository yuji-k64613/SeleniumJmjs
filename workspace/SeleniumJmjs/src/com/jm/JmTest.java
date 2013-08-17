package com.jm;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JmTest {
	private WebDriver wd = null;
	
	public void setWebDriver(WebDriver wd){
		this.wd = wd;
	}
	
	@Test
	public void tryANewSiteswap(){
        wd.get("http://localhost:8080/jmjs.html");
        wd.findElement(By.xpath("//li[@class='ui-block-c']/a/span")).click();
        wd.findElement(By.id("page4_text")).click();
        wd.findElement(By.id("page4_text")).clear();
        wd.findElement(By.id("page4_text")).sendKeys("12345");
        wd.findElement(By.cssSelector("#page4_select-button > span.ui-btn-inner > span.ui-btn-text")).click();
        wd.findElement(By.linkText("Mills Mess")).click();
        wd.findElement(By.cssSelector("#page4_juggle_button > span.ui-btn-inner > span.ui-btn-text")).click();		
		sleep(3000);
		
		Assert.assertEquals(true, wd.findElement(By.id("page2")).isDisplayed());
	}
	
	@Test
	public void didYouMean(){
        wd.get("http://localhost:8080/jmjs.html");
        wd.findElement(By.xpath("//li[@class='ui-block-c']/a/span")).click();
        wd.findElement(By.id("page4_text")).click();
        wd.findElement(By.id("page4_text")).clear();
        wd.findElement(By.id("page4_text")).sendKeys("12344");
        wd.findElement(By.cssSelector("#page4_juggle_button > span.ui-btn-inner")).click();
        wd.findElement(By.linkText("12345")).click();		
		sleep(3000);
		
		Assert.assertEquals(true, wd.findElement(By.id("page2")).isDisplayed());
	}

	@Test
	public void showerize(){
        wd.get("http://localhost:8080/jmjs.html");
        wd.findElement(By.xpath("//div[@id='patternList']/div[7]/h3/a/span")).click();
        wd.findElement(By.id("patternList_81")).click();
        sleep(100); // Error(Chrome)
        wd.findElement(By.xpath("//ul[@id='page2_ul']/li[3]/a/span")).click();
        wd.findElement(By.cssSelector("#page4_showerize_button > span.ui-btn-inner")).click();		
		sleep(3000);
		
		Assert.assertEquals(true, wd.findElement(By.id("page2")).isDisplayed());
	}
	
	@Test
	public void chooseTheMotion(){
        wd.get("http://localhost:8080/jmjs.html");
        wd.findElement(By.xpath("//div[@id='patternList']/div[7]/h3/a/span")).click();
        wd.findElement(By.id("patternList_81")).click();
        sleep(100); // Error(Chrome)
        wd.findElement(By.xpath("//ul[@id='page2_ul']/li[3]/a/span")).click();
        wd.findElement(By.cssSelector("#page4_motion_button > span.ui-btn-inner")).click();
        sleep(100); // Error(Chrome)
        wd.findElement(By.xpath("//ul[@id='page4_list']//a[.='Arches']")).click();		
		sleep(3000);
		
		Assert.assertEquals(true, wd.findElement(By.id("page2")).isDisplayed());
	}
	
	@Test
	public void chooseTheFormation(){
//        wd.get("http://localhost:8080/jmjs.html");
//        wd.findElement(By.xpath("//li[@class='ui-block-c']/a/span")).click();
//        wd.findElement(By.cssSelector("#page4_formation_button > span.ui-btn-inner > span.ui-btn-text")).click();
//        wd.findElement(By.linkText("10-Person 244")).click();
//		sleep(3000);
//		
//		Assert.assertEquals(true, wd.findElement(By.id("page2")).isDisplayed());
        wd.get("http://localhost:8080/jmjs.html");
        sleep(100); // Error(Chrome)
        wd.findElement(By.xpath("//li[@class='ui-block-c']/a/span")).click();
        sleep(100); // Error(Chrome)
        wd.findElement(By.cssSelector("#page4_formation_button > span.ui-btn-inner")).click();
        sleep(100); // Error(Chrome)
        wd.findElement(By.linkText("10-Person 244")).click();
        sleep(100); // Error(Chrome)
        wd.findElement(By.xpath("//ul[@id='page2_ul']/li[4]/a/span")).click();
        
		WebElement el;
		el = wd.findElement(By.cssSelector("#perno_gauge + div a"));
		Assert.assertEquals("10", el.getAttribute("title"));
        
        wd.findElement(By.id("perno_gauge")).click();
        wd.findElement(By.id("perno_gauge")).clear();
        wd.findElement(By.id("perno_gauge")).sendKeys("5");
        wd.findElement(By.xpath("//ul[@id='custIconUL']/li[2]/a/span")).click();
		sleep(3000);
		
		Assert.assertEquals(true, wd.findElement(By.id("page2")).isDisplayed());

		wd.findElement(By.xpath("//ul[@id='page2_ul']/li[4]/a/span")).click();
		el = wd.findElement(By.cssSelector("#perno_gauge + div a"));
		Assert.assertEquals("5", el.getAttribute("title"));
	}
	
	@Test
	public void selectAPetternFile(){
        wd.get("http://localhost:8080/jmjs.html");
        wd.findElement(By.xpath("//li[@class='ui-block-c']/a/span")).click();
        wd.findElement(By.cssSelector("#page4_pattern_button > span.ui-btn-inner > span.ui-btn-text")).click();
        wd.findElement(By.linkText("pattern_ja.jm")).click();
        wd.findElement(By.id("patternList_4")).click();
		sleep(3000);
		
		Assert.assertEquals(true, wd.findElement(By.id("page2")).isDisplayed());
		WebElement el = wd.findElement(By.cssSelector("#param_file"));
		Assert.assertEquals("pattern.jm", el.getAttribute("value"));		
	}

	@Test
	public void selectCheckBox(){
        wd.get("http://localhost:8080/jmjs.html");
        wd.findElement(By.xpath("//li[@class='ui-block-d']/a/span")).click();

		WebElement el;
		el = wd.findElement(By.id("mirror_box_label"));
		Assert.assertEquals("checkbox-off", el.getAttribute("data-icon"));        
		el = wd.findElement(By.id("ss_box_label"));
		Assert.assertEquals("checkbox-on", el.getAttribute("data-icon"));        
		el = wd.findElement(By.id("body_box_label"));
		Assert.assertEquals("checkbox-on", el.getAttribute("data-icon"));        
		el = wd.findElement(By.id("sound_box_label"));
		Assert.assertEquals("checkbox-off", el.getAttribute("data-icon"));        

		wd.findElement(By.xpath("//label[@id='mirror_box_label']/span/span[2]")).click();
        wd.findElement(By.xpath("//label[@id='ss_box_label']/span/span[2]")).click();
        wd.findElement(By.xpath("//label[@id='body_box_label']/span/span[2]")).click();
        wd.findElement(By.xpath("//ul[@id='custIconUL']/li[2]/a/span")).click();
		sleep(3000);
		
		Assert.assertEquals(true, wd.findElement(By.id("page2")).isDisplayed());

        wd.findElement(By.xpath("//ul[@id='page2_ul']/li[4]/a/span")).click();		
		Assert.assertEquals(true, wd.findElement(By.id("page3")).isDisplayed());

		el = wd.findElement(By.id("mirror_box_label"));
		Assert.assertEquals("checkbox-on", el.getAttribute("data-icon"));
		el = wd.findElement(By.id("ss_box_label"));
		Assert.assertEquals("checkbox-off", el.getAttribute("data-icon"));        
		el = wd.findElement(By.id("body_box_label"));
		Assert.assertEquals("checkbox-off", el.getAttribute("data-icon"));        
	}
	
	@Test
	public void changeSlider(){
        wd.get("http://localhost:8080/jmjs.html");
        wd.findElement(By.xpath("//li[@class='ui-block-d']/a/span")).click();
        wd.findElement(By.id("speed_gauge")).click();
        wd.findElement(By.id("speed_gauge")).clear();
        wd.findElement(By.id("speed_gauge")).sendKeys("0.7");
        wd.findElement(By.id("height_gauge")).click();
        wd.findElement(By.id("height_gauge")).clear();
        wd.findElement(By.id("height_gauge")).sendKeys("0.8");
        wd.findElement(By.id("dwell_gauge")).click();
        wd.findElement(By.id("dwell_gauge")).clear();
        wd.findElement(By.id("dwell_gauge")).sendKeys("0.9");
        wd.findElement(By.xpath("//ul[@id='custIconUL']/li[2]/a/span")).click();
        wd.findElement(By.xpath("//ul[@id='page2_ul']/li[4]/a/span")).click();

		WebElement el;
		el = wd.findElement(By.cssSelector("#speed_gauge + div a"));
		Assert.assertEquals("0.7", el.getAttribute("title"));
		el = wd.findElement(By.cssSelector("#height_gauge + div a"));
		Assert.assertEquals("0.8", el.getAttribute("title"));
		el = wd.findElement(By.cssSelector("#dwell_gauge + div a"));
		Assert.assertEquals("0.9", el.getAttribute("title"));
	}
	
	@After
	public void tearDown() {
		wd.close();
	}

	public static boolean isAlertPresent(FirefoxDriver wd) {
		try {
			wd.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private void getScreenShot(){
	    try {
            FileUtils.copyFile(
                    ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE),
                    new File("./file.png"));
        } catch (WebDriverException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }		
	}
	
    private static void sleep(int microtime) {
        try {
            Thread.sleep(microtime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}