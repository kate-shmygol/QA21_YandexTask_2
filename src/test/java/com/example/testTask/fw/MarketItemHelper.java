package com.example.testTask.fw;

import com.example.testTask.model.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class MarketItemHelper extends HelperBase {
	public MarketItemHelper(WebDriver driver) {
		super(driver);
	}

	public String getItemNameFromListByOrder(int number) {
		return driver.findElement(By.xpath("//*[@data-autotest-id='product-snippet'][" + number + "]//h3")).getText();
	}

	public void filterItem(Item item) throws InterruptedException {
		// Выбрать раздел Смартфоны
		click(By.cssSelector("[href='/catalog--" + item.getItemType() + "/list?onstock=1&how=dpop&cvredirect=3&track=srch_ddl']"));
		// Зайти в расширенный поиск
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		pause();
		// Задать параметр поиска от 20000 до 35000 рублей.
		type(By.id("glpricefrom"), item.getPriceFrom());
		type(By.id("glpriceto"), item.getPriceTo());
//		Выбрать производителя “Apple”
		// xpath: //span[text()='Apple']
		click(By.xpath("//span[text()=' " + item.getBrand() + " ']"));
//		click(By.cssSelector("span:contains(^Apple$)"));
//		click(By.cssSelector("span:contains(^" + "Apple" + "$)"));
//		click(By.cssSelector("span:contains(^" + brand + "$)"));
	}
}
