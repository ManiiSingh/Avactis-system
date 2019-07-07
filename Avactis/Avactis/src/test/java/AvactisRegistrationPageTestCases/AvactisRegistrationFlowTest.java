package AvactisRegistrationPageTestCases;

import org.testng.annotations.Test;
import CommonClasses.DataProviderClass;
import CommonClasses.ReadExcelDemo;
import avactisProjectPageobject.AvaticsMyaccountPageobject;
import avactisProjectPageobject.avactisRegistrationFormPageObject;
import jxl.read.biff.BiffException;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.DataProvider;
import static org.testng.Assert.assertEquals;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.AfterMethod;
import avactisProjectPageobject.*;

public class AvactisRegistrationFlowTest {

	avactisRegistrationFormPageObject registrationpage;
	AvaticsMyaccountPageobject myaccount;
	ReadExcelDemo exceldata;
	String expectedresult = "Account created successfully. You are now registered.";
	private  Logger log;

 //@Test(testName = "Verify the scuessfully User Registration Process", dataProvider = "userregistration", dataProviderClass = DataProviderClass.class, groups = "Smoke")
	public void avaticsNewUserregistrationflowtest(String email, String password, String retyepassword,
			String firstname, String lastname, String country, String state, String zip, String city, String add1,
			String add2, String contact) {
		myaccount = registrationpage.AvactisNewUserRegistrationflow(email, password, retyepassword, firstname, lastname,
				country, state, zip, city, add1, add2, contact);
		log.info("Registration Page Loaded Scussefully and User Data Entered");
		try {
			assertEquals(myaccount.AccountCreatedmessage(), expectedresult, "User Allready Registered");
			log.info("User Registered Scussfully");
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			log.warning("User Allready Registered");
		}
		

	}

	//@Test(testName = "Verify is User Allready Registered or not", dataProvider = "userregistration", dataProviderClass = DataProviderClass.class, groups = "Smoke")
	public void verifyUserRegistration(String email, String password, String retyepassword, String firstname,
			String lastname, String country, String state, String zip, String city, String add1, String add2,
			String contact) {
		registrationpage.AvactisNewUserRegistrationflow(email, password, retyepassword, firstname, lastname, country,
				state, zip, city, add1, add2, contact);
		log.info("Test Case - Verify is User Allready Registered or not : Test Case Passed");
		assertEquals(registrationpage.allreadyRegisteredUser.getText(),
				"This account name is already taken. Please choose a different account name.",
				"Test case Executed scuessfully");
		//log.info("Verify the scuessfully User Registration Process : Test Case Passed");
	}
	
	@Test(testName = "Verify the function of Sing button", groups="Smoke")
	public void SingInbuttonfunction() {
		registrationpage.SignIn();
	}

	@BeforeMethod
	public void beforeMethod() {
		registrationpage = new avactisRegistrationFormPageObject();
		registrationpage.get();
		 DOMConfigurator.configure("log4j-alternate.xml");
		 log = Logger.getLogger(AvactisRegistrationFlowTest.class.getName());
		 log.info("Test Case Started");

	}

	@AfterMethod
	public void afterMethod() {
		//registrationpage.close();
		
	}

}
