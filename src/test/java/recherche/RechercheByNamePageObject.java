package recherche;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RechercheByNamePageObject {

	public static final String EMPLOYEE_NAME_XPATH = "//input[@placeholder='Type for hints...']";
	public static final String SELECT_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div[2]/div/span";
	public static final String USER_CONNECTE_XPATH = "//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/p";
	public static final String FIRST_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[";
	public static final String SECOND_XPATH = "]/div/div[4]/div";
	public static final String RESULTAT_OBTENU_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[4]/div";
	public final static String LIST_CLASSNAME = "oxd-table-card";
	public final static String TAB_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div";

	// Declaration des selecteurs
	@FindBy(how = How.XPATH, using = EMPLOYEE_NAME_XPATH)
	public static WebElement employeName;

	@FindBy(how = How.XPATH, using = SELECT_XPATH)
	public static WebElement nameSelect;
	
	@FindBy(how = How.XPATH, using = USER_CONNECTE_XPATH)
	public static WebElement userconnecte;

	@FindBy(how = How.XPATH, using = RESULTAT_OBTENU_XPATH)
	public static WebElement elementObtenu;

	@FindBy(how = How.CLASS_NAME, using = LIST_CLASSNAME)
	public static List<WebElement> rowlist;

	// Declaration des methodes
	public void saisirName() {

		String nomEmploye = this.userconnecte.getText();
		this.employeName.sendKeys(nomEmploye);
	}
	
	public void selectName() {
		this.nameSelect.click();
	}

	public List<String> getNameObtenu(WebDriver driver) {

		List<String> nameListObtenu = new ArrayList<String>();

		for (int i = 1; i <= rowlist.size(); i++) {

			String nameXpath = FIRST_XPATH + i + SECOND_XPATH;
			WebElement name = driver.findElement(By.xpath(nameXpath));
			nameListObtenu.add(name.getText());

		}
		return nameListObtenu;

	}

}
