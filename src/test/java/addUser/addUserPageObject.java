package addUser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class addUserPageObject {

	public static final String ADD_BUTTON_XPATH = "//i[@class='oxd-icon bi-plus oxd-button-icon']";
	public static final String SELECT_ROLE_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div/div[2]/i";
	public static final String ADMIN_ROLE_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div[2]/div[2]";
	public static final String ESS_ROLE_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div[2]/div[3]";
	public static final String EMPLOYENAME_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input";
	public static final String SELECTEMPLOYE_NAME_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div/span";
	public static final String SELECT_STATUT_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[1]";
	public static final String ENABLED_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div[2]/div[2]";
	public static final String DISABLED_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div[2]/div[3]";
	public static final String USERNAME_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input";
	public static final String PASSWORD_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input";
	public static final String CONFIRMPASSWORD_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input";
	public static final String SAVE_BUTTON_XPATH = "//button[normalize-space()='Save']";
	public static final String USER_CONNECTE_XPATH = "//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/p";
	public final static String NOTIFICATION_XPATH ="//*[@id=\"oxd-toaster_1\"]/div/div[1]/div[2]/p[2]";

	@FindBy(how = How.XPATH, using = ADD_BUTTON_XPATH)
	public static WebElement addbutton;

	@FindBy(how = How.XPATH, using = SELECT_ROLE_XPATH)
	public static WebElement selectRole;

	@FindBy(how = How.XPATH, using = ADMIN_ROLE_XPATH)
	public static WebElement adminRole;

	@FindBy(how = How.XPATH, using = ESS_ROLE_XPATH)
	public static WebElement essRole;

	@FindBy(how = How.XPATH, using = EMPLOYENAME_XPATH)
	public static WebElement employeName;

	@FindBy(how = How.XPATH, using = SELECTEMPLOYE_NAME_XPATH)
	public static WebElement nameSelected;

	@FindBy(how = How.XPATH, using = SELECT_STATUT_XPATH)
	public static WebElement selectStatus;

	@FindBy(how = How.XPATH, using = ENABLED_XPATH)
	public static WebElement enabledStatus;

	@FindBy(how = How.XPATH, using = DISABLED_XPATH)
	public static WebElement disabledStatus;

	@FindBy(how = How.XPATH, using = USERNAME_XPATH)
	public static WebElement username;

	@FindBy(how = How.XPATH, using = PASSWORD_XPATH)
	public static WebElement password;

	@FindBy(how = How.XPATH, using = CONFIRMPASSWORD_XPATH)
	public static WebElement confirmPassword;

	@FindBy(how = How.XPATH, using = SAVE_BUTTON_XPATH)
	public static WebElement saveButton;

	@FindBy(how = How.XPATH, using = USER_CONNECTE_XPATH)
	public static WebElement userconnecte;
	
	@FindBy(how = How.XPATH, using = NOTIFICATION_XPATH)
	public static WebElement notification;
	

	// declaration des methodes

	public void clickADD() {

		this.addbutton.click();
	}

	public void selectrole() {

		this.selectRole.click();

	}

	public void selectAdmin() {

		this.adminRole.click();

	}

	public void selectEss() {

		this.essRole.click();
	}

	public void saisirEmployeName(String name) {

		String nomEmploye = this.userconnecte.getText();

		this.employeName.sendKeys(nomEmploye);

	}

	public void selectEmployeName() {

		this.nameSelected.click();
		;

	}

	public void selectStatus() {

		this.selectStatus.click();

	}

	public void selectEnabled() {

		this.enabledStatus.click();
	}

	public void selectDisabled() {

		this.disabledStatus.click();
	}

	public void saisirUsername(String username) {

		this.username.sendKeys(username);

	}

	public void saisirPassword(String mdpass) {

		this.password.sendKeys(mdpass);

	}

	public void confirmPassword(String mdpass) {

		this.confirmPassword.sendKeys(mdpass);

	}

	public void enregistrerUser() {

		this.saveButton.click();

	}
	public String getTexteNotification(WebDriver driver) {
		
		String messageNotification = notification.getText();
		
		return messageNotification;
		
	}
	
}
