package recherche;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RechercheByStatusPageObject {

	
//---------------Declaration des variables------------------------------------------------//
	
	public static final String SELECT_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div[1]/div[1]";
	public static final String ENABLED_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div[2]/div[2]/span";
	public static final String DISABLED_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div[2]/div[3]/span";
	public static final String STATUS_OBTENU ="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[1]/div/div[5]/div";
	public static final String FIRST_XPATH= "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div[";
	public static final String SECOND_XPATH ="]/div/div[5]/div";
	public static final String LIST_CLASSNAME ="oxd-table-card";
	public static final String TAB_XPATH ="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div";
	
//---------------Declaration des selecteurs----------------------------------------------// 
	
	@FindBy(how = How.XPATH, using = SELECT_XPATH)
	public WebElement select;
	
	@FindBy(how = How.XPATH, using = ENABLED_XPATH)
	public WebElement enabled;
	
	@FindBy(how = How.XPATH, using = DISABLED_XPATH)
	public WebElement disabled;
	
	@FindBy(how = How.XPATH, using = STATUS_OBTENU)
	public WebElement statutobtenu;
	
	@FindBy(how = How.CLASS_NAME, using = LIST_CLASSNAME)
	public static List<WebElement> rowlist;
	
//----------------Declaration des methodes----------------------------------------------// 

	public void selectStatus() {
		
		this.select.click();
		
	}
	
	public void ClickEnabled() {
	
		this.enabled.click();
	}
	
	public void ClickDisabled() {
	
		this.disabled.click();
	}
	
	
	public List<String>	getStatusOBtenu(WebDriver  driver){
		
		List<String> resultatObtenu = new ArrayList<String>();
		
			
			for (int i=1; i<=rowlist.size();i++) {
			String	statusPath = FIRST_XPATH + i + SECOND_XPATH;
			WebElement statusObtenu = driver.findElement(By.xpath(statusPath));
			
			resultatObtenu.add(statusObtenu.getText());
			}
			
			return resultatObtenu;
	
				
		}
		
		
		
	}
	
	
	
