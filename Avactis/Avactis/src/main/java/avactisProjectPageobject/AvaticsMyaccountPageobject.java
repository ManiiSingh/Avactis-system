package avactisProjectPageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AvaticsMyaccountPageobject {
	
	
	@FindBy(xpath="//div[contains(text(),'Account')]")
	public WebElement usercreatescuss;
	WebDriver driver;
	
	public AvaticsMyaccountPageobject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public String AccountCreatedmessage() {
		String accountCreatedmessage =  usercreatescuss.getText();
		System.out.println(usercreatescuss.getText());
		return accountCreatedmessage;
	}
	
	

}
