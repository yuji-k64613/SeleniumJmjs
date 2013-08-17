package com.jm;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JmFirefoxTest extends JmTest {
	@Before
	public void setUp() throws Exception {
		WebDriver wd = new FirefoxDriver();
		
		this.setWebDriver(wd);
		//System.setProperty("webdriver.chrome.driver", "/Users/yuji/prog/workspaces/Selenium/chromedriver");
		//wd = new ChromeDriver();
		wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);		
	}
}
