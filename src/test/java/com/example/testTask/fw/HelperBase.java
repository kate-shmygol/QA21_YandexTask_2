package com.example.testTask.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class HelperBase {

	WebDriver driver;
	public HelperBase (WebDriver driver) {
		this.driver = driver;
	}

	public void pause() throws InterruptedException {
		Thread.sleep(1000);
	}

	public void refresh() {
		driver.navigate().refresh();
	}

	public void acceptCookies() {
		click(By.cssSelector("[data-id='button-all']"));
	}

	public void type(By locator, String text) {
		click(locator);
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(text);
	}

	public void click(By locator) {
		driver.findElement(locator).click(); // Предусмотреть параметризацию тестовых данных - change 'By.cssSelector("[data-id='market']")' on 'locator' - Refactor -> Introduce parameter
	}

	// method of switching to the new tab
	public void switchToNextTab(int number) {
		List<String> availableWindows = new ArrayList<>(driver.getWindowHandles());
		if (!availableWindows.isEmpty()) {
			driver.switchTo().window(availableWindows.get(number)); // Предусмотреть параметризацию тестовых данных - change '1' on 'number' - Refactor -> Introduce parameter
		}
	}
}
