package Maven_Hiremee_captcha.cpatcha;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;


/**
 * Unit test for simple App.
 */
public class candidate_login 
{
	@FindBy(how=How.XPATH,using="(.//*[normalize-space(text()) and normalize-space(.)='About us'])[1]/following::a[2]")
	public WebElement candidate_Login_Link;

	@FindBy(how=How.ID,using="js-candi-email_address")
	public WebElement candidate_Email_Address;

	@FindBy(how=How.ID,using="js-candi-password")
	public WebElement candidate_Password;

	@FindBy(how=How.ID,using="js-candi-captcha")	
	public WebElement Captcha_Value;

	@FindBy(how=How.ID,using="js-btn_submit")
	public WebElement Candidate_Login_Submit_Button;
	WebDriver driver;
	String path;
	String path1;
	int length;
	static String imagetext;
	
	public candidate_login(WebDriver ldriver)
	{
		this.driver=ldriver;
		PageFactory.initElements(driver, this);
	}
	
	public void candidate_Logins() throws Exception
	{
		Thread.sleep(5000);
		File Src=driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div/div[2]/div/div/div[3]/div/img")).getScreenshotAs(OutputType.FILE);
		path=System.getProperty("user.dir")+"/screenshorts/candilogin.png";
		FileHandler.copy(Src,new File(path));
		System.out.println("start tesss");
		ITesseract instance = new Tesseract();
		Thread.sleep(3000);
		instance.setDatapath("tessdata"); // path to tessdata directory
		Thread.sleep(3000);
		imagetext=instance.doOCR(new File(path));
		imagetext.split("")[1].replaceAll("^[0-9]", "");
		System.out.println("Initial value is"+imagetext);
		length=imagetext.length();
		System.out.println("length is"+length);
		String[] arrOfStr = imagetext.split("[+=]"); 
		int i=Integer.parseInt(arrOfStr[0]);
		int j=Integer.parseInt(arrOfStr[1]);
		System.out.println(i);
		System.out.println(j);
		int c=i+j;
		System.out.println(c);
		String str1 = Integer.toString(c); 
		Captcha_Value.sendKeys(str1);
		 }
	}
