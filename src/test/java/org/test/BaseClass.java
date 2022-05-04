package org.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	public static void getDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	public static void launchURL(String url) {
		driver.get(url);
	}

	public static void enterText(WebElement element, String name) {
		element.sendKeys(name);
	}

	public void btnClick(WebElement btnclick) {
		btnclick.click();

	}

	public static void dropDown(WebElement drop, String val) {

		Select select = new Select(drop);

		// select.selectByValue(val);
		select.selectByVisibleText(val);
		// select.selectByIndex(no);

	}

	public static String excelRead(int rowNum, int cellNum) throws FileNotFoundException, IOException {
		Workbook workbook = new XSSFWorkbook(new FileInputStream(
				new File("C:\\Users\\lenovo\\eclipse-workspace\\TestNGAdactinTask\\target\\AdactinDatas.xlsx")));
		Sheet sheet = workbook.getSheet("Data");
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		CellType type = cell.getCellType();
		String ele = null;
		switch (type) {
		case STRING:
			ele = cell.getStringCellValue();
			break;

		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date date = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMMM-yy");
				ele = dateFormat.format(date);

			} else {

				double d = cell.getNumericCellValue();
				//BigDecimal b = BigDecimal.valueOf(d);
				long l=(long) d;
				ele=String.valueOf(l);
				break;
			}

		default:
			break;
		}
		return ele;

	}

}
