package com.example.testTask.tests;

import com.example.testTask.model.Item;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchItemTest extends TestBase {

	@Test
	public void itemTest() throws InterruptedException {
		// Перейти на Яндекс Маркет
		app.getMainPage().clickToMarketTab();
		// switch to the new tab
		app.getMainPage().switchToNextTab(1);
		app.getMarketHeader().selectExpressDepartment();
		// click to accept cookies
//		acceptCookies();
		// Выбрать раздел Электроника
		app.getMarketHeader().selectDepartmentType("--elektronika/23282330");
		app.getMarketItem().refresh();
//		Выбрать раздел Смартфоны
//		Зайти в расширенный поиск
//		Задать параметр поиска от 20000 до 35000 рублей.
//		Выбрать производителя “Apple”
		app.getMarketItem().filterItem(new Item().setItemType("smartfony-i-aksessuary/23282379")
				.setPriceFrom("20000").setPriceTo("35000").setBrand("Apple"));
//		Применить условия поиска
		// method 1
		app.getMarketItem().refresh();
		app.getMarketItem().pause();

		// method 2
//		Запомнить второй элемент в результатах поиска
		String itemName = app.getMarketItem().getItemNameFromListByOrder(2);
//		System.out.println(itemName); // TODO delete in ending
		app.getMarketHeader().typeInSearchInputField(itemName);

		String foundItemName = app.getMarketItem().getItemNameFromListByOrder(1);
//		System.out.println(foundItemName); // TODO delete in ending
		app.getMarketItem().pause();
//		... и проверить, что наименование товара соответствует запомненному значению.
		Assert.assertEquals(foundItemName, itemName);
	}
}

/*
Открыть браузер и развернуть на весь экран
Зайти на yandex.ru
Перейти на Яндекс Маркет
Выбрать раздел Экспресс
Выбрать раздел Электроника
Выбрать раздел Смартфоны
Зайти в расширенный поиск
Задать параметр поиска от 20000 до 35000 рублей.
Выбрать производителя “Apple”
Применить условия поиска
Запомнить второй элемент в результатах поиска
В поисковую строку ввести запомненное значение.
Найти и проверить, что наименование товара соответствует запомненному значению.
*/