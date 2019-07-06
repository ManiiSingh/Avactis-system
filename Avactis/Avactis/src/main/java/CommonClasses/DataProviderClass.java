package CommonClasses;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;

public class DataProviderClass {
	ReadExcelDemo exceldata;
	PropertyFileRead propertiesfile;
	Properties property = new Properties();

	@DataProvider(name = "userregistration")
	public Object[][] getExcelData() throws InvalidFormatException, IOException {
		ReadExcelDemo read = new ReadExcelDemo();
		propertiesfile = new PropertyFileRead();
		return read.ReadVariant(propertiesfile.getPropertyvalue("UserDetailSheet"),
				propertiesfile.getPropertyvalue("SheetName"));
	}

}
