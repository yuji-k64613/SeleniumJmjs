package com.jm;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class JmSafariTest extends JmTest {
	@Before
	public void setUp() throws Exception {
		WebDriver wd = new SafariDriver();
		
		this.setWebDriver(wd);
		wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);		
	}
}
