package Maven_Hiremee_captcha.cpatcha;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class main_file 
{

	WebDriver driver;
	@BeforeClass
	public void driver()
	{
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		System.setProperty("webdriver.chrome.logfile", "./chrolog.file");
		
		//System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "./firelog.txt");
		
		driver = new ChromeDriver();
		//System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
		//driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://hiremee.co.in/candidate/login");
		driver.manage().window().maximize();
		
	}
	@Test
	public void login()
	{
		try {
			new candidate_login(driver).candidate_Logins();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
