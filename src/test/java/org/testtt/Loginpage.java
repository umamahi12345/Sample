package org.testtt;

import org.base.Baseclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class Loginpage extends Baseclass{
	/*
	//without page factory
private WebElement getUser() {
	 WebElement txtusername = driver.findElement(By.id("email"));
	return txtusername;
	 
}
*/
public Loginpage() {
	 PageFactory.initElements(driver, this);
}
@CacheLookup
 @FindBys({@FindBy(id="email"), @FindBy(xpath ="//input[@id='email']")})//AND operator
private WebElement txtusername;
              
                //ex:pa instead of pass...it take another locator
 @FindAll({@FindBy(id="pa"), @FindBy(xpath="//input[@id='pass']")}) //OR operator
private WebElement txtPassword;
 
@FindBy(name="login")                     //find single locator
private WebElement btnlogin;


public WebElement getTextUsername() {
	return txtusername;
	 }

public WebElement getTxtPassword() {
	return txtPassword;
	 
}public WebElement getBtnLogin() {
	return btnlogin;
		 
}

public void login(String userName,String password) {
	//sendkeys(getTextUsername().get(0),userName);
	
	sendkeys(getTextUsername(),userName);
	sendkeys(getTxtPassword(),password);
	
	click(getBtnLogin());
	 

}

 
}
