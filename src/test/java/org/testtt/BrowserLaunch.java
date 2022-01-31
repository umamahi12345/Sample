package org.testtt;
import java.io.IOException;

import org.base.Baseclass;
import org.openqa.selenium.WebElement;
public class BrowserLaunch extends Baseclass {
	
	public static void main(String[] args) throws IOException {
		browserlaunch("chrome");
		launchUrl("https://www.facebook.com/");
		maximize();
		currentUrl();
		implicitWait(20);
		
		//Loginpage l=new Loginpage();
		
		/*sendkeys(l.getTextUsername(),"uma");
		
		sendkeys(l.getTxtPassword(), "2345");
		
		driver.navigate().refresh();
		
		sendkeys(l.getTextUsername(),"mahi");
		
		sendkeys(l.getTxtPassword(),"5347");
		
		click(l.getBtnLogin());*/
		
		/*sendkeys(l.getTextUsername(),getexcel("Excel","sheet1", 2,2));
		sendkeys(l.getTxtPassword(),getexcel("Excel","sheet1",2,3));
		*/
		
	}

	 

}
