package deleteUser;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utiles.Setup;
import utiles.WaitMethods;

public class DeleteUserStepDef {

	public WebDriver driver;
	public DeleteUserPageObject deleteUserPO;
	public WaitMethods wait = new WaitMethods();
	public Setup setup = new Setup();

	
	public DeleteUserStepDef() {
		driver = setup.driver;
		deleteUserPO = new DeleteUserPageObject();
		PageFactory.initElements(driver, deleteUserPO);
	}
	
	
	@When("je clique sur le bouton supprimer")
	public void je_clique_sur_le_bouton_supprimer() {
	    
		wait.explicitWaitUntilPresenceOfElementLocatedXpath(driver, deleteUserPO.BTN_DELETE_XPATH, 3);
		deleteUserPO.cliquerSupprimer();

	}

	@When("je confirme la suppression")
	public void je_confirme_la_suppression() {
		wait.explicitWaitUntilPresenceOfElementLocatedXpath(driver, deleteUserPO.YES_DELETE_XPATH, 3);
		deleteUserPO.confirmerDelete();
		
	}

	@Then("je verifie que l utilisateur a bien ete supprime {string}")
	public void je_verifie_que_l_utilisateur_a_bien_ete_supprime(String messageDeleted) throws InterruptedException {
	    
		
		wait.explicitWaitUntilPresenceOfElementLocatedXpath(driver, deleteUserPO.NOTIFICATION_XPATH, 3);
		String resultatObtenu = deleteUserPO.getTexteNotification(driver);
		
		assertEquals(messageDeleted, resultatObtenu);
		Thread.sleep(3000);
		
		
	}
	
	
	@Then("l utilisateur est supprime et non trouve {string}")
	public void l_utilisateur_est_supprime_et_non_trouve(String messageNotification) {
	   
		wait.explicitWaitUntilPresenceOfElementLocatedXpath(driver, deleteUserPO.NOTIFICATION_XPATH, 3);
		String resultatObtenu = deleteUserPO.getTexteNotification(driver);
		
		assertEquals(messageNotification, resultatObtenu);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
