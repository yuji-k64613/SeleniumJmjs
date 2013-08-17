package com.jm;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JmChromeTest extends JmTest {
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/Users/yuji/prog/workspaces/Selenium/driver/chromedriver");
		WebDriver wd = new ChromeDriver();
		this.setWebDriver(wd);
		wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);		
	}
}
