package authentification;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Wait;

public class AuthentificationPageObject {

	// Declaration des selecteurs
	public final static String USERNAME_XPATH = "//input[@placeholder='Username']";
	public final static String PASSWORD_XPATH = "//input[@placeholder='Password']";
	public final static String LOGIN_XPATH = "//button[@type='submit']";
	public final static String ACCEUIL_XPATH = "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']";
	public final static String ERREUR1_XPATH = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text']";
	public final static String ERREUR2_XPATH = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/span";
	public final static String ERREUR3_XPATH = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/span";
	
	
	// Declaration des elements web
	@FindBy(how = How.XPATH, using = USERNAME_XPATH)
	public static WebElement username;

	@FindBy(how = How.XPATH, using = PASSWORD_XPATH)
	public static WebElement password;

	@FindBy(how = How.XPATH, using = LOGIN_XPATH)
	public static WebElement login;

	@FindBy(how = How.XPATH, using = ACCEUIL_XPATH)
	public static WebElement elementObtenu;
	
	@FindBy(how = How.XPATH, using = ERREUR1_XPATH)
	public static WebElement erreur1;
	
	@FindBy(how = How.XPATH, using = ERREUR2_XPATH)
	public static WebElement erreur2;
	
	@FindBy(how = How.XPATH, using = ERREUR3_XPATH)
	public static WebElement erreur3;

	// Création des methodes : une methode par action
	public void saisirUsername(String name) {
		this.username.sendKeys(name);
	}

	public void saisirPassword(String password) {
		this.password.sendKeys(password);
	}

	public void cliquerBtnLogin() {
		this.login.click();
	}

	public String getTexteObtenu() {
		
		return elementObtenu.getText();
	}
	public String getTextObtenuErreur1() {
		return erreur1.getText();
	}
	
	public String getTextObtenuErreur2() {
		return erreur2.getText();
	}
	
	public String getTextObtenuErreur3() {
		return erreur3.getText();
	}
	
	//test commit git 
}
