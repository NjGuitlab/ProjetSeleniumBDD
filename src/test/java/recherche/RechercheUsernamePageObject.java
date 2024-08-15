package recherche;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RechercheUsernamePageObject {

	// declaration des selecteurs
	public final static String BTN_ADMIN_XPATH = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span";
	public final static String USERNAME_XPATH = "//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']";
	public final static String BTN_SEARCH_XPATH = "//button[@type='submit']";
	public final static String USERNAME_OBTENU_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[2]/div";
	public final static String FIRST_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[";
	public final static String SECOND_XPATH = "]/div/div[2]";
	public final static String LIST_CLASSNAME = "oxd-table-card";
	public final static String TAB_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div";
	// Declaration des elements web
	@FindBy(how = How.XPATH, using = BTN_ADMIN_XPATH)
	public static WebElement btnAdmin;

	@FindBy(how = How.XPATH, using = USERNAME_XPATH)
	public static WebElement userName;

	@FindBy(how = How.XPATH, using = BTN_SEARCH_XPATH)
	public static WebElement btnSearch;

	@FindBy(how = How.XPATH, using = USERNAME_OBTENU_XPATH)
	public static WebElement usernameObtenu;

	@FindBy(how = How.CLASS_NAME, using = LIST_CLASSNAME)
	public static List<WebElement> rowlist;

	// Declaration des methodes
	public void cliquerBtnAdmin() {

		this.btnAdmin.click();

	}

	public void saisirUserName(String name) {
		this.userName.sendKeys(name);
	}

	public void cliquerSearch() {
		this.btnSearch.click();
	}

	public List<String> getUsernameObtenu(WebDriver driver) {

		List<String> usernameList = new ArrayList<String>();

		for (int i = 1; i <= rowlist.size(); i++) {

			String usernameXpath = FIRST_XPATH + i + SECOND_XPATH;
			WebElement username = driver.findElement(By.xpath(usernameXpath));
			usernameList.add(username.getText());
		}

		return usernameList;

	}

}
