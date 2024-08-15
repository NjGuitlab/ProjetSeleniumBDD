package logOut;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class logOutPageObject {
	
	//declaration des selecteur
	public static final String MENU_DEROULANT_XPATH ="//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']";
	public static final String LOGOUT_XPATH ="//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/ul/li[4]/a";
	public static final String TITLE_PAGE="//h5[normalize-space()='Login']";
	
	//declaration des elements web
	
	@FindBy(how = How.XPATH, using = MENU_DEROULANT_XPATH)
	public WebElement menuDeroulant;
	
	@FindBy(how = How.XPATH, using = LOGOUT_XPATH)
	public WebElement logout;
	
	@FindBy(how = How.XPATH, using = TITLE_PAGE)
	public WebElement titlepage;
	
	
	//declaration des methodes 
	
	public void clickMenuDeroulant() {
		
		this.menuDeroulant.click();
		
	}
	
	public void clickLogOut() {
		
		this.logout.click();
	}
	
	public String getTextLogOut() {
		
		String resultatObtenu= titlepage.getText();
		return resultatObtenu;
		
	}
	
	
	
	
	
	

}
