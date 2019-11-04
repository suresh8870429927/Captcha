package ocr_image;

import java.io.File;

import org.testng.annotations.Test;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

public class ocr 
{
	static String imagetext;
@Test
public void test() throws Exception
{
	File imageFile = new File("C:\\Users\\surv2e11855\\Pictures\\sikuli\\2.PNG");
	//"C:\Users\surv2e11855\Pictures\sikuli\1.PNG"
	//"C:\Users\surv2e11855\Pictures\sikuli\2.PNG"
	//File imageFile = new File("C:\\Users\\surv2e11855\\Pictures\\blur.png");
	
	//"C:\Users\surv2e11855\Pictures\testocr.png"
	//C:\\Users\\surv2e11855\\Pictures\\AccountStatement_3636724011_Jul16_123714.pdf
	//"C:\Users\surv2e11855\Pictures\captcha.png"
	
	
	
	ITesseract instance = new Tesseract();
	try {
		Thread.sleep(3000);
		instance.setDatapath("D:\\Suresh_Automation_CAP_Eclipse\\Maven_OCR_Login_Captcha\\tessdata\\");
		instance.setLanguage("eng");
		Thread.sleep(7000);
		imagetext=instance.doOCR((imageFile));
		System.out.println(imagetext);
		
	}
	catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}