package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class HomePage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);  //or wen write Home.class insted of this main purpose of this line is //whenever the object of HomePage is created and constructor called it will initialise the all webElement
		elementUtils = new ElementUtils(driver);
		
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	@FindBy(linkText="Register")
	private WebElement registerOption;
	
	@FindBy(name="search")
	private WebElement searchBoxField;
	
	@FindBy(xpath="//button[contains(@class,'btn-default')]")
	private WebElement searchButton;
	
	public void clickOnMyAccount() {
		
		elementUtils.clickOnElement(myAccountDropMenu,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	public LoginPage selectLoginOption() {
		
		elementUtils.clickOnElement(loginOption,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new LoginPage(driver);
		
	}
	
	public RegisterPage selectRegisterOption() {
		
		elementUtils.clickOnElement(registerOption,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new RegisterPage(driver);
		
	}
	
	public void enterProductIntoSearchBox(String productText) {
		
		elementUtils.typeTextIntoElement(searchBoxField,productText,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}
	
	public SearchResultsPage clickOnSearchButton() {
		
		elementUtils.clickOnElement(searchButton,CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new SearchResultsPage(driver);
		
	}
	

}
