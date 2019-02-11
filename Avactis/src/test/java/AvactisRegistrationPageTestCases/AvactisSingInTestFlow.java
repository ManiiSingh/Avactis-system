package AvactisRegistrationPageTestCases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.logging.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import CommonClasses.PropertyFileRead;
import avactisProjectPageobject.AvaticsMyaccountPageobject;
import avactisProjectPageobject.SigninPage;
import avactisProjectPageobject.avactisRegistrationFormPageObject;
import net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.DiscoveryStrategy.SinglePass;

public class AvactisSingInTestFlow {
	
	PropertyFileRead prop = new PropertyFileRead();
	avactisRegistrationFormPageObject registrationpage;
	AvaticsMyaccountPageobject avaticsmyaccount;
	SigninPage signin;
	private  Logger log;	
	@Test(testName = "Validate the Scuessfull Login with Valid User",groups="Regression")
	public void UserLoginWithvalidData() throws IOException {
		registrationpage.SignIn().SignInFunction(prop.getPropertyvalue("Emailid"), prop.getPropertyvalue("password"));
		
	}
	
	@Test(testName = "Validate the Scuessfull Login with Invalid User",groups="Functional")
	public void UserLoginWithInvalidData()  {
		try {
			registrationpage.SignIn().SignInFunction(prop.getPropertyvalue("EmailIdInvalid"), prop.getPropertyvalue("passwordvalid"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Invliad User Name Password");
		}
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
