package deleteUser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DeleteUserPageObject {

	public final static String BTN_DELETE_XPATH = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[6]/div/button[1]/i";
	public final static String YES_DELETE_XPATH ="//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]";
	public final static String NOTIFICATION_XPATH ="//*[@id=\"oxd-toaster_1\"]/div/div[1]/div[2]/p[2]";
	
	
	@FindBy(how = How.XPATH, using = BTN_DELETE_XPATH)
	public static WebElement btnDelete;
	
	@FindBy(how = How.XPATH, using = YES_DELETE_XPATH)
	public static WebElement yesDelete;
	
	@FindBy(how = How.XPATH, using = NOTIFICATION_XPATH)
	public static WebElement notification;
	
	public void cliquerSupprimer() {
		
		this.btnDelete.click();
	}
	
	public void confirmerDelete() {
		
		this.yesDelete.click();
	}
	
	public String getTexteNotification(WebDriver driver) {
		
		String messageNotification = notification.getText();
		
		return messageNotification;
		
	}
	
	
	
	
	
}
