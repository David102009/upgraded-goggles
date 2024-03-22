package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.BaseClass;
import Utilities.CommonMethods;



public class splashDevPage {
	
	public splashDevPage() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}
	
    @FindBy(xpath="//li[@class='navitemdropdowndropdownhoverable']//span[contains(text(), 'My account')]")
	public WebElement myAccountButton;
	
	
    @FindBy(xpath="//li[@class='nav-item dropdown dropdown-hoverable']/ul[@class='mz-sub-menu-96 dropdown-menu']//span")
	public List<WebElement> LoginOrRegisterOptions;
    
    @FindBy(xpath="//*[@id=\"widget-navbar-217834\"]/ul/li[6]/ul/li[1]/a/div/span")
	public WebElement loginButton;
    
    @FindBy(xpath="//*[@id=\"widget-navbar-217834\"]/ul/li[6]/ul/li[2]/a/div/span")
	public WebElement registerButton;
    
    @FindBy(xpath="//*[@id=\"widget-navbar-217834\"]/ul/li[6]/ul/li[6]/a/div/span")
	public WebElement logoutButton;
    

	public void clickLoginLogoutOrRegister(String option) {
		
		CommonMethods.hoverOverMouse(myAccountButton);
			
		if(option.equalsIgnoreCase("Login")) {
				CommonMethods.click(loginButton);
			}else if(option.equalsIgnoreCase("Logout")) {
				CommonMethods.click(logoutButton);
			}else {
				CommonMethods.click(registerButton);
			}
	}
	
	

}
