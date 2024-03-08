package co.huru.pageObjects.remittance;

import co.huru.utils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class AddRecipientPage extends AndroidActions {

	private static final Logger log = LogManager.getLogger(AddRecipientPage.class);

	public AddRecipientPage(AndroidDriver driver)
	{
		super(driver);
	}

	private final By header = AppiumBy.xpath("//android.widget.TextView[@text=\"Add recipient details\"]");

	private final By backButton = AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
	private final By continueButton = AppiumBy.xpath("//android.widget.Button");
	private final By closeScreen = AppiumBy.accessibilityId("Close sheet");

	//Add Recipient
	private final By personalDetailsSection = AppiumBy.xpath("//android.widget.TextView[@text=\"Personal details\"]");
	private final By firstNameTextBox = AppiumBy.xpath("//android.widget.EditText[1]");
	private final By lastNameTextBox = AppiumBy.xpath("//android.widget.EditText[2]");
	private final By mobileNumberTextBox = AppiumBy.xpath("//android.widget.EditText[3]");
	private final By selectRelationship = AppiumBy.xpath("//android.widget.EditText[4]");
	private final By selfAccount = AppiumBy.xpath("//android.widget.TextView[@text=\"Self account\"]");
	private final By father = AppiumBy.xpath("//android.widget.TextView[@text=\"Father\"]");
	private final By mother = AppiumBy.xpath("//android.widget.TextView[@text=\"Mother\"]");
	private final By spouse = AppiumBy.xpath("//android.widget.TextView[@text=\"Spouse\"]");
	private final By son = AppiumBy.xpath("//android.widget.TextView[@text=\"Son\"]");
	private final By daughter = AppiumBy.xpath("//android.widget.TextView[@text=\"Daughter\"]");
	private final By nickNameTextBox = AppiumBy.xpath("//android.widget.EditText[5]");

	private final By bankDetailsSection = AppiumBy.xpath("//android.widget.TextView[@text=\"Bank details\"]");
	private final By accountNumberTextBox = AppiumBy.xpath("//android.widget.EditText[1]");
	private final By ifscCodeTextBox = AppiumBy.xpath("//android.widget.EditText[2]");

	private final By addressSection = AppiumBy.xpath("//android.widget.TextView[@text=\"Address\"]");
	private final By addressTextBox = AppiumBy.xpath("//android.widget.EditText[1]");
	private final By cityTextBox = AppiumBy.xpath("//android.widget.EditText[2]");

	//Errors
	private final By firstNameError = AppiumBy.xpath("//android.widget.TextView[@text=\"First name can only have a-z alphabets and max 30 chars\"]");
	private final By lastNameError = AppiumBy.xpath("//android.widget.TextView[@text=\"Last name can only have a-z alphabets and max 30 chars\"]");
	private final By mobileNumberError = AppiumBy.xpath("//android.widget.TextView[@text=\"Enter a valid mobile number\"]");
	private final By relationshipRequiredError = AppiumBy.xpath("//android.widget.TextView[@text=\"This field is mandatory\"]");
	private final By accountNumberError = AppiumBy.xpath("//android.widget.TextView[@text=\"Enter a valid account number\"]");
	private final By ifscCodeError = AppiumBy.xpath("//android.widget.TextView[@text=\"Enter a valid 11 digit IFSC code Eg. HDFC0000139, SBIN0015293\"]");
	private final By addressError = AppiumBy.xpath("//android.widget.TextView[@text=\"Please enter receiver's Address, <= 35 Char, no special char\"]");
	private final By cityError = AppiumBy.xpath("//android.widget.TextView[@text=\"Please enter receiver's City\"]");

	private final By personalDetailsSectionError = AppiumBy.xpath("(//android.widget.TextView[@text=\"Incomplete details\"])[1]");
	private final By bankDetailsSectionError = AppiumBy.xpath("(//android.widget.TextView[@text=\"Incomplete details\"])[2]");
	private final By addressSectionError = AppiumBy.xpath("(//android.widget.TextView[@text=\"Incomplete details\"])[3]");

	public void verifyScreenHeader()
	{
		log.info("Verify screen header");
		waitForElementToBeVisible(header);
	}

	public void navigateBack()
	{
		log.info("Navigate back");
		waitForElementToBeVisible(backButton).click();
	}

	public void clickOnContinue()
	{
		log.info("Next/Continue");
		waitForElementToBeVisible(continueButton).click();
	}

	public void closeScreen()
	{
		log.info("Close screen");
		waitForElementToBeVisible(closeScreen).click();
	}

	public void clickOnPersonalDetailsSection()
	{
		log.info("Click on personal details section");
		waitForElementToBeVisible(personalDetailsSection).click();
	}

	public void enterFirstName(String firstName)
	{
		log.info("Enter first name");
		waitForElementToBeVisible(firstNameTextBox).sendKeys(firstName);
	}

	public void enterLastName(String lastName)
	{
		log.info("Enter last name");
		waitForElementToBeVisible(lastNameTextBox).sendKeys(lastName);
	}

	public void enterNickName(String nickName)
	{
		log.info("Enter nick name");
		waitForElementToBeVisible(nickNameTextBox).sendKeys(nickName);
	}

	public void enterMobileNumber(String mobileNumber)
	{
		log.info("Enter mobile number");
		waitForElementToBeVisible(mobileNumberTextBox).sendKeys(mobileNumber);
	}

	public void clickOnSelectRelationShip()
	{
		log.info("Click on select relationship");
		waitForElementToBeVisible(selectRelationship).click();
	}

	public void selectRelationship(String relationship)
	{
		log.info("Select relationship");
		clickOnSelectRelationShip();
		switch (relationship) {
			case "Self":
				waitForElementToBeVisible(selfAccount).click();
				break;
			case "Father":
				waitForElementToBeVisible(father).click();
				break;
			case "Mother":
				waitForElementToBeVisible(mother).click();
				break;
			case "Spouse":
				waitForElementToBeVisible(spouse).click();
				break;
			case "Son":
				waitForElementToBeVisible(son).click();
				break;
			case "Daughter":
				waitForElementToBeVisible(daughter).click();
				break;
		}
	}

	public void clickOnBankDetailsSection()
	{
		log.info("Click on bank details section");
		waitForElementToBeVisible(bankDetailsSection).click();
	}

	public void enterAccountNumber(String accountNumber)
	{
		log.info("Enter account number");
		waitForElementToBeVisible(accountNumberTextBox).sendKeys(accountNumber);
	}

	public void enterIfscCode(String ifscCode)
	{
		log.info("Enter ifsc code");
		waitForElementToBeVisible(ifscCodeTextBox).sendKeys(ifscCode);
	}

	public void clickOnAddressSection()
	{
		log.info("Click on address section");
		waitForElementToBeVisible(addressSection).click();
	}

	public void enterAddress(String address)
	{
		log.info("Enter address");
		waitForElementToBeVisible(addressTextBox).sendKeys(address);
	}

	public void enterCity(String city)
	{
		log.info("Enter city");
		waitForElementToBeVisible(cityTextBox).sendKeys(city);
	}

	public void addRecipient(String firstName, String lastName, String mobileNumber, String nickName, String relationship,
							 String accountNumber, String ifscCode,
							 String address, String city)
	{
		log.info("Add recipient");
		enterFirstName(firstName);
		enterLastName(lastName);
		enterMobileNumber(mobileNumber);
		selectRelationship(relationship);
		enterNickName(nickName);

		clickOnBankDetailsSection();
		enterAccountNumber(accountNumber);
		enterIfscCode(ifscCode);

		clickOnAddressSection();
		enterAddress(address);
		enterCity(city);

		//ToDO: Issue - Double click required
		clickOnContinue();
		clickOnContinue();
	}

	public void enterPersonalDetails(String firstName, String lastName, String mobileNumber, String nickName, String relationship)
	{
		log.info("Enter personal details");
		enterFirstName(firstName);
		enterLastName(lastName);
		enterMobileNumber(mobileNumber);
		enterNickName(nickName);
		selectRelationship(relationship);
	}

	public void enterBankDetails(String accountNumber, String ifscCode)
	{
		log.info("Enter bank details");
		enterAccountNumber(accountNumber);
		enterIfscCode(ifscCode);
	}

	public void enterAddress(String address, String city)
	{
		log.info("Enter address");
		enterAddress(address);
		enterCity(city);
	}

	public void validateFirstNameError()
	{
		log.info("Validate first name error");
		waitForElementToBeVisible(firstNameError);
	}

	public void validateLastNameError()
	{
		log.info("Validate last name error");
		waitForElementToBeVisible(lastNameError);
	}


	public void validateMobileNumberError()
	{
		log.info("Validate mobile number error");
		waitForElementToBeVisible(mobileNumberError);
	}


	public void validateRelationshipRequiredError()
	{
		log.info("Validate relationship required error");
		waitForElementToBeVisible(relationshipRequiredError);
	}


	public void validateAccountNumberError()
	{
		log.info("Validate account number error");
		waitForElementToBeVisible(accountNumberError);
	}


	public void validateIfscCodeError()
	{
		log.info("Validate ifsc code error");
		waitForElementToBeVisible(ifscCodeError);
	}

	public void validateAddressError()
	{
		log.info("Validate address error");
		waitForElementToBeVisible(addressError);
	}

	public void validateCityError()
	{
		log.info("Validate city error");
		waitForElementToBeVisible(cityError);
	}

	public void validatePersonalDetailsSectionError()
	{
		log.info("Validate personal details section error");
		waitForElementToBeVisible(personalDetailsSectionError);
	}

	public void validateBankDetailsSectionError()
	{
		log.info("Validate bank details section error");
		waitForElementToBeVisible(bankDetailsSectionError);
	}

	public void validateAddressSectionError()
	{
		log.info("Validate address section error");
		waitForElementToBeVisible(addressSectionError);
	}

	public void validateIncompleteSectionsError()
	{
		log.info("Validate incomplete sections error");
		validatePersonalDetailsSectionError();
		validateBankDetailsSectionError();
		validateAddressSectionError();
	}
}
