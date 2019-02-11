package avactisProjectPageobject;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;

public class avactisRegistrationFormPageObject extends LoadableComponent<avactisRegistrationFormPageObject> {

	@FindBy(name = "customer_info[Customer][Email]")
	public WebElement email;

	@FindBy(name = "customer_info[Customer][Password]")
	public WebElement password;

	@FindBy(name = "customer_info[Customer][RePassword]")
	public WebElement retypepasswpord;

	@FindBy(name = "customer_info[Customer][FirstName]")
	public WebElement firstname;

	@FindBy(name = "customer_info[Customer][LastName]")
	public WebElement lastname;

	@FindBy(id = "customer_info_Customer_Country")
	public WebElement country;

	@FindBy(id = "customer_info_Customer_State")
	public WebElement state;

	@FindBy(name = "customer_info[Customer][ZipCode]")
	public WebElement zipcode;

	@FindBy(xpath = "//a[@href='http://localhost/Avactis/sign-in.php']")
	public WebElement signinbutton;
	
	@FindBy(name = "customer_info[Customer][City]")
	public WebElement city;

	@FindBy(name = "customer_info[Customer][Streetline1]")
	public WebElement address1;

	@FindBy(name = "customer_info[Customer][Streetline2]")
	public WebElement address2;

	@FindBy(name = "customer_info[Customer][Phone]")
	public WebElement contact;

	@FindBy(xpath = "//input[@type='submit']")
	public WebElement registerbutton;
	
	@FindBy(xpath = "//div[contains(text(),\"This\")]")
	public WebElement allreadyRegisteredUser;

	public WebDriver driver;
	
	

	private String url = "http://localhost/Avactis/register.php";

	private String title = "Avactis Demo Store";

	public AvaticsMyaccountPageobject clickOnRegisterButton() {
		registerbutton.click();
		return new AvaticsMyaccountPageobject(driver);

	}

	public avactisRegistrationFormPageObject emailid(String useremail) {
		email.sendKeys(useremail);
		return this;
	}

	public avactisRegistrationFormPageObject password(String userpassword) {
		password.sendKeys(userpassword);
		return this;
	}

	public avactisRegistrationFormPageObject repassword(String userrepassword) {
		retypepasswpord.sendKeys(userrepassword);
		return this;
	}

	public avactisRegistrationFormPageObject coustomerFirstName(String firstname) {
		this.firstname.sendKeys(firstname);
		return this;
	}

	public avactisRegistrationFormPageObject coustomerLastName(String lastname) {
		this.lastname.sendKeys(lastname);
		return this;
	}

	Select dropdown;

	public avactisRegistrationFormPageObject coustomerCountry(String country) {
		dropdown = new Select(this.country);
		dropdown.selectByValue(country);
		return this;
	}

	public avactisRegistrationFormPageObject coustomerState(String state) {
		dropdown = new Select(this.state);
		dropdown.selectByValue(state);
		return this;
	}

	public avactisRegistrationFormPageObject coustomerZipCode(String zipcode) {
		this.zipcode.sendKeys(zipcode);
		return this;
	}

	public avactisRegistrationFormPageObject coustomerCity(String city) {
		this.city.sendKeys(city);
		return this;

	}

	public avactisRegistrationFormPageObject coustomerAddress1(String address1) {
		this.address1.sendKeys(address1);
		return this;
	}

	public avactisRegistrationFormPageObject coustomerAddress2(String address2) {
		this.address2.sendKeys(address2);
		return this;
	}

	public avactisRegistrationFormPageObject coustomerContactPhone(String contact) {
		this.contact.sendKeys(contact);
		return this;
	}

	public AvaticsMyaccountPageobject AvactisNewUserRegistrationflow(String email, String password, String retyepassword, String firstname,
			String lastname, String country, String state, String zip, String city, String add1, String add2,
			String contact) {
		emailid(email).password(password).repassword(retyepassword).coustomerFirstName(firstname)
				.coustomerLastName(lastname).coustomerCountry(country).coustomerState(state).coustomerZipCode(zip)
				.coustomerCity(city).coustomerAddress1(add1).coustomerAddress2(add2).coustomerContactPhone(contact).clickOnRegisterButton();
		return new AvaticsMyaccountPageobject(driver);
	}
	
	
	
	public avactisRegistrationFormPageObject() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\Selenium\\yahooEmailSend\\src\\test\\resources\\chromedriver.exe");
		// TODO Auto-generated constructor stub
		driver = new ChromeDriver();
		PageFactory.initElements(driver, this);
	}

	@Override
	protected void isLoaded() throws Error {
		// TODO Auto-generated method stub
		assertEquals(driver.getTitle(), title, "Page not Loaded Scussefully");

	}

	@Override
	protected void load() {
		// TODO Auto-generated method stub
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	
	public void close() {
		driver.close();
		
	}
	
	public SigninPage SignIn() {
		signinbutton.click();
		return new SigninPage(driver);
	}
}
