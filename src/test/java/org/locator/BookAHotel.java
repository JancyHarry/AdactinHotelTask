package org.locator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.test.AdactinMainclass;

public class BookAHotel extends AdactinMainclass {
	public BookAHotel() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "first_name")
	private WebElement txtFirstName;

	@FindBy(id = "last_name")
	private WebElement txtLastName;

	@FindBy(id = "address")
	private WebElement txtAddress;

	@FindBy(id = "cc_num")
	private WebElement txtCreditCardNo;

	@FindBy(id = "cc_type")
	private WebElement dropCreditCardType;

	@FindBy(id = "cc_exp_month")
	private WebElement dropCCMonth;

	@FindBy(id = "cc_exp_year")
	private WebElement dropCCYear;

	@FindBy(id = "cc_cvv")
	private WebElement txtCVNo;
	
	@FindBy(id = "book_now")
	private WebElement btnBookNow;

	public WebElement getTxtFirstName() {
		return txtFirstName;
	}

	public WebElement getTxtLastName() {
		return txtLastName;
	}

	public WebElement getTxtAddress() {
		return txtAddress;
	}

	public WebElement getTxtCreditCardNo() {
		return txtCreditCardNo;
	}

	public WebElement getDropCreditCardType() {
		return dropCreditCardType;
	}

	public WebElement getDropCCMonth() {
		return dropCCMonth;
	}

	public WebElement getDropCCYear() {
		return dropCCYear;
	}

	public WebElement getTxtCVNo() {
		return txtCVNo;
	}

	public WebElement getBtnBookNow() {
		return btnBookNow;
	}

}
