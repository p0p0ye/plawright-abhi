package GroupPages;

import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.codoid.products.fillo.Connection;

import util.CustomAssert;
import util.ExcelRead;
import util.GenericMethods;

public class BDBlogout extends GenericMethods {
	
private By Logout = By.xpath(" //span[@id='logoutAnchor']");
	
	WebDriverWait wait;
	WebDriver driver=null;
	public BDBlogout(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, 30);
         this.driver=driver;
}

	
	public void ClickLogout() throws Exception
	{
	
		Reporter.log("<B>Logout from Application</B>");
		switchtodefaultframe(driver);
		
		clickForLogin(Logout,"Logout Button");
		
		System.out.println("Complete");
		
  }
	
}