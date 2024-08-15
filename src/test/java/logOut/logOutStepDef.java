package logOut;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utiles.Setup;
import utiles.WaitMethods;

public class logOutStepDef {
	
	WebDriver driver;
	logOutPageObject logoutPO ;
	WaitMethods wait = new WaitMethods();
	Setup setup = new Setup();
	
	//Instantiation de la classe 
	
	public logOutStepDef() {
		driver = setup.driver;
		logoutPO= new logOutPageObject();
		PageFactory.initElements(driver, logoutPO);
		
	}
	
	
	@When("je clique sur le menu deroulant du profil utilisateur")
	public void je_clique_sur_le_menu_deroulant_du_profil_utilisateur() {
	  
		wait.explicitWaitUntilPresenceOfElementLocatedXpath(driver, logoutPO.MENU_DEROULANT_XPATH, 3);
		logoutPO.menuDeroulant.click();
		
	}

	@When("je clique sur le  bouton logout")
	public void je_clique_sur_le_bouton_logout() {
	    
		wait.explicitWaitUntilPresenceOfElementLocatedXpath(driver, logoutPO.LOGOUT_XPATH, 3);
		logoutPO.logout.click();
		
	}

	@Then("je me redirige vers la page de connexion et {string} s'affiche")
	public void je_me_redirige_vers_la_page_de_connexion_et_s_affiche(String resultatAttendu)  {
	    
		
		wait.explicitWaitUntilPresenceOfElementLocatedXpath(driver, logoutPO.TITLE_PAGE, 3);
		String resultatObtenu = logoutPO.getTextLogOut();
		
		assertEquals(resultatAttendu, resultatObtenu);
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
