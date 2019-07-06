package avactisProjectPageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SigninPage {

	@FindBy(id="account_sign_in_form_email_id")
	public WebElement emailId;
	
	@FindBy(id="account_sign_in_form_passwd_id")
	public WebElement password;
	
	
	@FindBy(xpath="//input[@value='Sign In']")
	public WebElement singInbutton;
	
	@FindBy(xpath="//input[@value='save']")
	public WebElement remembermecheckbox;
	
	private WebDriver driver;

	public SigninPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void SignInFunction(String useremailid,String userpassword) {
		emailId.sendKeys(useremailid);
		password.sendKeys(userpassword);
		singInbutton.click();
		
	}
	
	
	

}
