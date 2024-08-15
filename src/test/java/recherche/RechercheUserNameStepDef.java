package recherche;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import utiles.Setup;
import utiles.WaitMethods;

public class RechercheUserNameStepDef {

	public WebDriver driver;

	public RechercheUsernamePageObject rechercheUserPO;

	public WaitMethods wait = new WaitMethods();

	public Setup setup = new Setup();

	// Constructeur de la classe

	public RechercheUserNameStepDef() {
		driver = setup.driver;
		rechercheUserPO = new RechercheUsernamePageObject();
		PageFactory.initElements(driver, rechercheUserPO);
	}

	@When("je clique sur le bouton Admin")
	public void je_clique_sur_le_bouton_admin() {
		wait.explicitWaitUntilButtonIsClickableXpath(driver, rechercheUserPO.BTN_ADMIN_XPATH, 3);
		rechercheUserPO.cliquerBtnAdmin();

	}

	@When("je rempli le username {string}")
	public void je_rempli_le_username(String name) {

		wait.explicitWaitUntilPresenceOfElementLocatedXpath(driver, rechercheUserPO.USERNAME_XPATH, 3);
		rechercheUserPO.saisirUserName(name);
	}

	@When("je clique sur le bouton search")
	public void je_clique_sur_le_bouton_search() {
		wait.explicitWaitUntilButtonIsClickableXpath(driver, rechercheUserPO.BTN_SEARCH_XPATH, 3);
		rechercheUserPO.cliquerSearch();

	}

	@Then("je verifie le username {string} affiche dans le tableau")
	public void je_verifie_le_username_affiche_dans_le_tableau(String resultatAttendu) {

		wait.explicitWaitUntilPresenceOfElementLocatedXpath(driver, rechercheUserPO.TAB_XPATH, 3);

		List<String> resultatObtenu = rechercheUserPO.getUsernameObtenu(driver);
		for (int i = 0; i < resultatObtenu.size(); i++) {

			Assert.assertEquals(resultatAttendu, resultatObtenu.get(i));

		}

	}

}
