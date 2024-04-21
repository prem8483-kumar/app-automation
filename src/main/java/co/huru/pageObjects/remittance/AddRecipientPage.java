package co.huru.pageObjects.remittance;

import co.huru.constants.AppConstant;
import co.huru.utils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import static org.testng.Assert.assertEquals;

public class AddRecipientPage {

	private static final Logger log = LogManager.getLogger(AddRecipientPage.class);
	private AndroidDriver driver;

	public AddRecipientPage(AndroidDriver driver)
	{
		this.driver = driver;
	}

	public AndroidActions getAndroidActions() {
		return new AndroidActions();
	}

	private final By header = AppiumBy.accessibilityId("id_screen_title");
	private final By continueButton = AppiumBy.accessibilityId("id_huru_button_text");
	private final By closeScreen = AppiumBy.accessibilityId("Close sheet");
	private final By backButton = AppiumBy.accessibilityId("huru_back_button");

	//Add Recipient
	private final By personalDetailsSection = AppiumBy.accessibilityId("id_section_header_boxRECIPIENT_PERSONAL_DETAILS");
	private final By firstNameTextBox = AppiumBy.xpath("//android.widget.EditText[1]");
	private final By lastNameTextBox = AppiumBy.xpath("//android.widget.EditText[2]");
	private final By mobileNumberTextBox = AppiumBy.xpath("//android.widget.EditText[3]");

	private final By selectRelationship = AppiumBy.xpath("//android.widget.EditText[4]");
	private final By selfAccount = AppiumBy.accessibilityId("id_item Self account");
	private final By father = AppiumBy.accessibilityId("id_item Father");
	private final By mother = AppiumBy.accessibilityId("id_item Mother");
	private final By spouse = AppiumBy.accessibilityId("id_item Spouse");
	private final By son = AppiumBy.accessibilityId("id_item Son");
	private final By daughter = AppiumBy.accessibilityId("id_item Daughter");
	private final By nickNameTextBox = AppiumBy.xpath("//android.widget.EditText[5]");

	private final By bankDetailsSection = AppiumBy.accessibilityId("id_section_header_boxRECIPIENT_BANK_DETAILS");
	private final By accountNumberTextBox = AppiumBy.xpath("//android.widget.EditText[1]");
	private final By ifscCodeTextBox = AppiumBy.xpath("//android.widget.EditText[2]");

	private final By addressSection = AppiumBy.accessibilityId("id_section_header_boxRECIPIENT_ADDRESS_DETAILS");
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
		assertEquals(getAndroidActions().waitForElementToBeVisible(driver,header).getText(), AppConstant.ADD_RECIPIENT_SCREEN_HEADER);
	}

	public void navigateBack()
	{
		log.info("Navigate back");
		getAndroidActions().waitForElementToBeVisible(driver,backButton).click();
	}

	public void clickOnContinue()
	{
		log.info("Next/Continue");
		getAndroidActions().getActions(driver).click(getAndroidActions().waitForElementToBeVisible(driver,continueButton)).perform();
	}

	public void closeScreen()
	{
		log.info("Close screen");
		getAndroidActions().waitForElementToBeVisible(driver,closeScreen).click();
	}

	public void clickOnPersonalDetailsSection()
	{
		log.info("Click on personal details section");
		getAndroidActions().waitForElementToBeVisible(driver,personalDetailsSection).click();
	}

	public void enterFirstName(String firstName)
	{
		log.info("Enter first name");
		getAndroidActions().waitForElementToBeVisible(driver,firstNameTextBox).sendKeys(firstName);
	}

	public void enterLastName(String lastName)
	{
		log.info("Enter last name");
		getAndroidActions().waitForElementToBeVisible(driver,lastNameTextBox).sendKeys(lastName);
	}

	public void enterNickName(String nickName)
	{
		log.info("Enter nick name");
		getAndroidActions().waitForElementToBeVisible(driver,nickNameTextBox).sendKeys(nickName);
	}

	public void enterMobileNumber(String mobileNumber)
	{
		log.info("Enter mobile number");
		getAndroidActions().waitForElementToBeVisible(driver,mobileNumberTextBox).sendKeys(mobileNumber);
	}

	public void clickOnSelectRelationShip()
	{
		log.info("Click on select relationship");
		getAndroidActions().waitForElementToBeVisible(driver,selectRelationship).click();
	}

	public void selectRelationship(String relationship)
	{
		log.info("Select relationship");
		clickOnSelectRelationShip();
		switch (relationship) {
			case "Self":
				getAndroidActions().waitForElementToBeVisible(driver,selfAccount).click();
				break;
			case "Father":
				getAndroidActions().waitForElementToBeVisible(driver,father).click();
				break;
			case "Mother":
				getAndroidActions().waitForElementToBeVisible(driver,mother).click();
				break;
			case "Spouse":
				getAndroidActions().waitForElementToBeVisible(driver,spouse).click();
				break;
			case "Son":
				getAndroidActions().waitForElementToBeVisible(driver,son).click();
				break;
			case "Daughter":
				getAndroidActions().waitForElementToBeVisible(driver,daughter).click();
				break;
		}
	}

	public void clickOnBankDetailsSection()
	{
		log.info("Click on bank details section");
		getAndroidActions().waitForElementToBeVisible(driver,bankDetailsSection).click();
	}

	public void enterAccountNumber(String accountNumber)
	{
		log.info("Enter account number");
		getAndroidActions().waitForElementToBeVisible(driver,accountNumberTextBox).sendKeys(accountNumber);
	}

	public void enterIfscCode(String ifscCode)
	{
		log.info("Enter ifsc code");
		getAndroidActions().waitForElementToBeVisible(driver,ifscCodeTextBox).sendKeys(ifscCode);
	}

	public void clickOnAddressSection()
	{
		log.info("Click on address section");
		getAndroidActions().waitForElementToBeVisible(driver,addressSection).click();
	}

	public void enterAddress(String address)
	{
		log.info("Enter address");
		getAndroidActions().waitForElementToBeVisible(driver,addressTextBox).sendKeys(address);
	}

	public void enterCity(String city)
	{
		log.info("Enter city");
		getAndroidActions().waitForElementToBeVisible(driver,cityTextBox).sendKeys(city);
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

		//ToDo: Issue address section was not present once
		clickOnAddressSection();
		enterAddress(address);
		enterCity(city);

		//ToDO: Issue - Double click required
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
		assertEquals(getAndroidActions().waitForElementToBeVisible(driver,firstNameError).getText(), AppConstant.RECIPIENT_FIRST_NAME_ERROR_MESSAGE);
	}

	public void validateLastNameError()
	{
		log.info("Validate last name error");
		assertEquals(getAndroidActions().waitForElementToBeVisible(driver,lastNameError).getText(), AppConstant.RECIPIENT_LAST_NAME_ERROR_MESSAGE);
	}


	public void validateMobileNumberError()
	{
		log.info("Validate mobile number error");
		assertEquals(getAndroidActions().waitForElementToBeVisible(driver,mobileNumberError).getText(), AppConstant.RECIPIENT_MOBILE_NUMBER_ERROR_MESSAGE);
	}


	public void validateRelationshipRequiredError()
	{
		log.info("Validate relationship required error");
		assertEquals(getAndroidActions().waitForElementToBeVisible(driver,relationshipRequiredError).getText(), AppConstant.RECIPIENT_RELATIONSHIP_ERROR_MESSAGE);
	}


	public void validateAccountNumberError()
	{
		log.info("Validate account number error");
		assertEquals(getAndroidActions().waitForElementToBeVisible(driver,accountNumberError).getText(), AppConstant.RECIPIENT_ACCOUNT_NUMBER_ERROR_MESSAGE);
	}


	public void validateIfscCodeError()
	{
		log.info("Validate ifsc code error");
		assertEquals(getAndroidActions().waitForElementToBeVisible(driver,ifscCodeError).getText(), AppConstant.RECIPIENT_IFSC_CODE_ERROR_MESSAGE);
	}

	public void validateAddressError()
	{
		log.info("Validate address error");
		assertEquals(getAndroidActions().waitForElementToBeVisible(driver,addressError).getText(), AppConstant.RECIPIENT_ADDRESS_ERROR_MESSAGE);
	}

	public void validateCityError()
	{
		log.info("Validate city error");
		assertEquals(getAndroidActions().waitForElementToBeVisible(driver,cityError).getText(), AppConstant.RECIPIENT_CITY_ERROR_MESSAGE);
	}

	public void validatePersonalDetailsSectionError()
	{
		log.info("Validate personal details section error");
		validateFirstNameError();
		validateLastNameError();
		validateMobileNumberError();
		validateRelationshipRequiredError();

		clickOnPersonalDetailsSection();
		assertEquals(getAndroidActions().waitForElementToBeVisible(driver,personalDetailsSectionError).getText(), AppConstant.RECIPIENT_SECTIONS_ERROR_MESSAGE);
	}

	public void validateBankDetailsSectionError()
	{
		log.info("Validate bank details section error");
		clickOnBankDetailsSection();
		validateAccountNumberError();
		validateIfscCodeError();

		clickOnBankDetailsSection();
		assertEquals(getAndroidActions().waitForElementToBeVisible(driver,bankDetailsSectionError).getText(), AppConstant.RECIPIENT_SECTIONS_ERROR_MESSAGE);
	}

	public void validateAddressSectionError()
	{
		log.info("Validate address section error");
		clickOnAddressSection();
		validateAddressError();
		validateCityError();

		clickOnAddressSection();
		assertEquals(getAndroidActions().waitForElementToBeVisible(driver,addressSectionError).getText(), AppConstant.RECIPIENT_SECTIONS_ERROR_MESSAGE);
	}

	public void validateIncompleteSectionsError()
	{
		log.info("Validate incomplete sections error");
		validatePersonalDetailsSectionError();
		validateBankDetailsSectionError();
		validateAddressSectionError();
	}
}
