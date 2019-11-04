package testig.Captcha;

import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.lept;
import org.bytedeco.javacpp.lept.PIX;
import org.bytedeco.javacpp.tesseract.TessBaseAPI;
import org.testng.annotations.Test;

/**
 * Hello world!
 *
 */
public class App 
{
	@Test
    public void captcha()
    {
        
    	TessBaseAPI instance=new TessBaseAPI();
    	instance.Init("D:\\Automation_directory\\Captcha\\tessdata", "eng");
    	PIX image=lept.pixRead("C:\\Users\\surv2e11855\\Pictures\\cpatcha.png");
    	instance.SetImage(image);
    	BytePointer bytepiointer=instance.GetUTF8Text();
    	String output=bytepiointer.getString();
    	System.out.println(output);
    	System.out.println("Tester suresh");
    	
    	
    }
}
