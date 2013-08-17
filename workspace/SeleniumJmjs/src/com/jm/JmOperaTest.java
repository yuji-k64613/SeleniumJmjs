package com.jm;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.WebDriver;

import com.opera.core.systems.OperaDriver;

public class JmOperaTest extends JmTest {
	@Before
	public void setUp() throws Exception {
		WebDriver wd = new OperaDriver();
		
		this.setWebDriver(wd);
		wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);		
	}
}
