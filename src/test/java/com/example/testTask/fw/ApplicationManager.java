package com.example.testTask.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.time.Duration;

public class ApplicationManager {

	String browser;
	WebDriver driver;

	MainPageHelper mainPage;
	MarketHeaderHelper marketHeader;
	MarketItemHelper marketItem;

	public ApplicationManager(String browser) {
		this.browser = browser;
	}

	public MainPageHelper getMainPage() {
		return mainPage;
	}

	public MarketHeaderHelper getMarketHeader() {
		return marketHeader;
	}

	public MarketItemHelper getMarketItem() {
		return marketItem;
	}

	public void init() {
		//		driver = new ChromeDriver();
		if (browser.equals(BrowserType.FIREFOX)) {
			driver = new FirefoxDriver();
		} else if (browser.equals(BrowserType.CHROME)) {
			driver = new ChromeDriver();
		}
		// Открыть браузер и развернуть на весь экран
		driver.manage().window().maximize();
		// delay
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// Зайти на yandex.ru
		driver.navigate().to("https://yandex.ru/");

		mainPage = new MainPageHelper(driver);
		marketHeader = new MarketHeaderHelper(driver);
		marketItem = new MarketItemHelper(driver);
	}

	public void stop() {
		driver.quit();
	}
}
