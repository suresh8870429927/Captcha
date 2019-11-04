package barcode;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class bar 
{
	WebDriver driver;
	@Test
	public void bars() throws Exception
	{
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriverV74.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		//driver.get("www.google.com");
		
		//Liner code
		//driver.get("https://barcode.tec-it.com/en/");
		//driver.get("https://barcode.tec-it.com/en/?data=suresh%20automation%20Tester");
		//QR Code
		//driver.get("https://barcode.tec-it.com/en/QRCode?data=suresh%20Automation%20selenium");
		//driver.get("https://barcode.tec-it.com/barcode.ashx?iban=54654654654546546&bic=RLNWATWW&amount=&receiver=Automation+Testing&usage=&reference=&information=Automation+Testing&userhint=Automation+Testing&code=EPCQRCode&data=BCD%0A002%0A1%0ASCT%0ARLNWATWW%0AAutomation+Testing%0A54654654654546546%0A%0A%0A%0AAutomation+Testing%0AAutomation+Testing&multiplebarcodes=false&translate-esc=false&unit=Fit&dpi=96&imagetype=Gif&rotation=0&color=%23000000&bgcolor=%23ffffff&qunit=Mm&quiet=0&eclevel=M");
		
		
		String barcodeurl=driver.findElement(By.tagName("img")).getAttribute("src");
		System.out.println("source is"+barcodeurl);
		URL url=new URL(barcodeurl);
		BufferedImage image=ImageIO.read(url);
		LuminanceSource lumi=new BufferedImageLuminanceSource(image);
		BinaryBitmap binary=new BinaryBitmap(new HybridBinarizer(lumi));
		Result result=new MultiFormatReader().decode(binary);
		System.out.println(result.getText());
		

	}

}
