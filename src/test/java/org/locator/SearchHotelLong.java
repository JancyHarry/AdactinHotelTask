package org.locator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.test.AdactinMainclass;

public class SearchHotelLong extends AdactinMainclass{
	public SearchHotelLong() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "location")
	private WebElement selectLocation;

	@FindBy(id = "hotels")
	private WebElement selectHotels;

	@FindBy(id = "room_type")
	private WebElement roomType;

	@FindBy(xpath = "//select[@name='room_nos']")
	private WebElement roomNos;

	@FindBy(id = "datepick_in")
	private WebElement dataIn;

	@FindBy(id = "datepick_out")
	private WebElement dataOut;

	@FindBy(id = "adult_room")
	private WebElement adultRoom;

	@FindBy(id = "child_room")
	private WebElement childRoom;

	@FindBy(id = "Submit")
	private WebElement btnSubmit;

	public WebElement getSelectLocation() {
		return selectLocation;
	}

	public WebElement getSelectHotels() {
		return selectHotels;
	}

	public WebElement getRoomType() {
		return roomType;
	}

	public WebElement getRoomNos() {
		return roomNos;
	}

	public WebElement getDataIn() {
		return dataIn;
	}

	public WebElement getDataOut() {
		return dataOut;
	}

	public WebElement getAdultRoom() {
		return adultRoom;
	}

	public WebElement getChildRoom() {
		return childRoom;
	}

	public WebElement getBtnSubmit() {
		return btnSubmit;
	}

	
}
