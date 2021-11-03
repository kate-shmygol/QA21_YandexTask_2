package com.example.testTask.tests;

import com.example.testTask.fw.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {

	protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));

	@BeforeMethod
	public void setUp() {
		app.init();
	}

	@AfterMethod(enabled = false)
	public void tearDown() {
		app.stop();
	}
}
