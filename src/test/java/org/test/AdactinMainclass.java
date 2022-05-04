package org.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.locator.BookAHotel;
import org.locator.Login;
import org.locator.SearchHotelLong;
import org.locator.SelectHotel;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AdactinMainclass extends BaseClass {

	@BeforeClass
	private void beforeClass() {
		getDriver();
	}

	@Test(description = "Login")
	private void loginPage() throws IOException {
		File file = new File(
				"C:\\Users\\lenovo\\eclipse-workspace\\TestNGAdactinTask\\target\\Logincredential.properties");
		FileReader fileReader = new FileReader(file);
		Properties properties = new Properties();
		properties.load(fileReader);
		String url = properties.get("url").toString();
		launchURL(url);
		String userName = properties.get("username").toString();

		Login l = new Login();
		WebElement txtUserName = l.getTxtUserName();
		enterText(txtUserName, userName);

		String password = properties.get("password").toString();
		WebElement txtPassword = l.getTxtPassword();
		enterText(txtPassword, password);

		WebElement btnLogin = l.getBtnLogin();
		btnClick(btnLogin);
	}

	@Test(description = "SearchHotel", dataProvider = "SampleData")
	private void searchHotel(String loc, String hotel, String roomTypes, String nos, String checkIn, String checkOut,
			String adultperRoom, String childperRoom) {
		SearchHotelLong sh = new SearchHotelLong();
		WebElement selectLocation = sh.getSelectLocation();
		dropDown(selectLocation, loc);
		WebElement selectHotels = sh.getSelectHotels();
		dropDown(selectHotels, hotel);
		WebElement roomType = sh.getRoomType();
		dropDown(roomType, roomTypes);
		WebElement roomNos = sh.getRoomNos();
		dropDown(roomNos, nos);

		WebElement dataIn = sh.getDataIn();
		dataIn.clear();
		enterText(dataIn, checkIn);

		WebElement dataOut = sh.getDataOut();
		dataOut.clear();
		enterText(dataOut, checkOut);

		WebElement adultRoom = sh.getAdultRoom();
		dropDown(adultRoom, adultperRoom);

		WebElement childRoom = sh.getChildRoom();
		dropDown(childRoom, childperRoom);

		WebElement btnSubmit = sh.getBtnSubmit();
		btnClick(btnSubmit);

	}

	@DataProvider(name = "SampleData")
	private Object[][] sendData() throws FileNotFoundException, IOException {
		return new Object[][] { { excelRead(0, 0), excelRead(1, 0), excelRead(2, 0), excelRead(3, 0), excelRead(4, 0),
				excelRead(5, 0), excelRead(6, 0), excelRead(7, 0) } };

	}

	@Test(description = "Search Hotel and Book A Hotel",dataProvider = "Book Data")
	private void serchHotel(String fN,String lN,String add,String ccNo,String ccType,String ccMonth,String ccYear,String cvNo) {
		SelectHotel sh = new SelectHotel();
		WebElement selectRadiobtn = sh.getSelectRadiobtn();
		btnClick(selectRadiobtn);

		WebElement continueNxtpage = sh.getContinueNxtpage();
		btnClick(continueNxtpage);
		
		BookAHotel bh = new BookAHotel();
		WebElement txtFirstName = bh.getTxtFirstName();
		enterText(txtFirstName, fN);
		
		WebElement txtLastName = bh.getTxtLastName();
		enterText(txtLastName, lN);
		
		WebElement txtAddress = bh.getTxtAddress();
		enterText(txtAddress, add);
		
		WebElement txtCreditCardNo = bh.getTxtCreditCardNo();
		enterText(txtCreditCardNo, ccNo);
		
		WebElement dropCreditCardType = bh.getDropCreditCardType();
		dropDown(dropCreditCardType, ccType);
		
		WebElement dropCCMonth = bh.getDropCCMonth();
		dropDown(dropCCMonth, ccMonth);
		
		WebElement dropCCYear = bh.getDropCCYear();
		dropDown(dropCCYear, ccYear);
		
		WebElement txtCVNo = bh.getTxtCVNo();
	    enterText(txtCVNo, cvNo);
	    
	    WebElement btnBookNow = bh.getBtnBookNow();
	    btnClick(btnBookNow);
		
		
		
		
		
	
	}

//	@Test(description = "Book A Hotel", dataProvider = "Book Data")
//	public void bookHotel(String fN)  {
//		BookAHotel bh = new BookAHotel();
//		WebElement txtFirstName = bh.getTxtFirstName();
//		enterText(txtFirstName, fN);
//	
//	}

	@DataProvider(name = "Book Data")
	private Object[][] sendData2() throws FileNotFoundException, IOException {
		return new Object[][] { 
			{ excelRead(8, 0),excelRead(9,0),excelRead(10,0),
				excelRead(11,0),excelRead(12,0),excelRead(13,0),
				excelRead(14,0),excelRead(15,0)}
				
				
		};

	}

}
