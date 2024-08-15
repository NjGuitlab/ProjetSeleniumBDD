package recherche;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RechercheRolePageObject {

	public final static String SELECT_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div[1]/div[1]";
	public final static String ADMIN_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div[2]";
	public final static String ESS_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div[2]/div[3]";
	public final static String USER_ROLE_OBTENU_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[3]/div";
	public final static String FIRST_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[";
	public final static String SECOND_XPATH = "]/div/div[3]/div";
	public final static String LIST_CLASSNAME = "oxd-table-card";
	public final static String TAB_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div";

	// Declaration des elements web
	@FindBy(how = How.XPATH, using = SELECT_XPATH)
	public static WebElement select;

	@FindBy(how = How.XPATH, using = ADMIN_XPATH)
	public static WebElement adminRole;

	@FindBy(how = How.XPATH, using = ESS_XPATH)
	public static WebElement essRole;

	@FindBy(how = How.XPATH, using = USER_ROLE_OBTENU_XPATH)
	public static WebElement userRoleObtenu;

	@FindBy(how = How.CLASS_NAME, using = LIST_CLASSNAME)
	public static List<WebElement> rowlist;

	// Declaration des methodes

	public void clickSelect() {

		this.select.click();
	}
	
	/*public void selectAdmin() {
		
		this.adminRole.click();
	}
	
	public void selectEss() {
		
		this.essRole.click();
	}
	*/
	public void selectRole(String role) {

		if (role.equals("Admin")) {
			this.adminRole.click();
		} else if (role.equals("ESS")) {
			this.essRole.click();
		}
	}

	public List<String> getUserRoleObtenu(WebDriver driver) {

		List<String> userRoleList = new ArrayList<String>();

		for (int i = 1; i <= rowlist.size(); i++) {

			String userRoleXpath = FIRST_XPATH + i + SECOND_XPATH;
			WebElement userRole = driver.findElement(By.xpath(userRoleXpath));
			userRoleList.add(userRole.getText());
		}

		return userRoleList;

	}

}
