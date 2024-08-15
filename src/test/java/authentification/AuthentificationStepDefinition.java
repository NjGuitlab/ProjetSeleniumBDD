package authentification;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utiles.CommonMethods;
import utiles.Setup;
import utiles.WaitMethods;

public class AuthentificationStepDefinition {

	// Declarer le navigateur
	public WebDriver driver;

	// Instantiation de la classe authentification PageObject
	AuthentificationPageObject authentPO = new AuthentificationPageObject();
	Setup setUp = new Setup();

	// Instantiation de la classe commonMethod
	CommonMethods commonMethods = new CommonMethods();

	// Instantiation class Wait
	WaitMethods waitMethods = new WaitMethods();

	// Constructeur de la classe
	public AuthentificationStepDefinition() {
		driver = setUp.driver;
		PageFactory.initElements(driver, AuthentificationPageObject.class);
	}

	@Given("je me connecte sur l'application")
	public void je_me_connecte_sur_l_application() throws IOException {

		commonMethods.openURLWithConfigFile("url");

	}

	@When("je saisis le username {string}")
	public void je_saisis_le_username(String name) {
		// ExplicitWait
		waitMethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver, authentPO.USERNAME_XPATH, 3);
		authentPO.saisirUsername(name);

	}

	@When("je saisis le password {string}")
	public void je_saisis_le_password(String password) {

		waitMethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver, authentPO.PASSWORD_XPATH, 3);
		authentPO.saisirPassword(password);

	}

	@When("je clique sur le bouton login")
	public void je_clique_sur_le_bouton_login() {

		waitMethods.explicitWaitUntilButtonIsClickableXpath(driver, authentPO.LOGIN_XPATH, 3);
		authentPO.cliquerBtnLogin();
	}

	@Then("je me redirige vers la page d'acceuil et {string} s'affiche")
	public void je_me_redirige_vers_la_page_d_acceuil_et_s_affiche(String resultatAttendu) {

		switch (resultatAttendu) {
		case "Dashboard":
			waitMethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver, authentPO.ACCEUIL_XPATH, 3);
			String resultatObtenu = authentPO.getTexteObtenu();
			Assert.assertEquals(resultatObtenu, resultatAttendu);
			break;

		case "Invalid credentials":

			waitMethods.explicitWaitUntilPresenceOfElementLocatedXpath(driver, authentPO.ERREUR1_XPATH, 3);
			String ObtenuErreur1 = authentPO.getTextObtenuErreur1();
			Assert.assertEquals(ObtenuErreur1, resultatAttendu);
			break;

		case "Required":

			if (commonMethods.isElementDisplayed(authentPO.erreur2) &&

					!commonMethods.isElementDisplayed(authentPO.erreur3)) {

				String ObtenuErreur2 = authentPO.getTextObtenuErreur2();
				Assert.assertEquals(ObtenuErreur2, resultatAttendu);
			}

			else if (commonMethods.isElementDisplayed(authentPO.erreur3)
					&& !commonMethods.isElementDisplayed(authentPO.erreur2)) {

				String ObtenuErreur3 = authentPO.getTextObtenuErreur3();
				Assert.assertEquals(ObtenuErreur3, resultatAttendu);
			} else if (commonMethods.isElementDisplayed(authentPO.erreur3)
					&& commonMethods.isElementDisplayed(authentPO.erreur2)) {

				String ObtenuErreur2 = authentPO.getTextObtenuErreur2();
				String ObtenuErreur3 = authentPO.getTextObtenuErreur3();
				Assert.assertEquals(ObtenuErreur2, resultatAttendu);
				Assert.assertEquals(ObtenuErreur3, resultatAttendu);
			}

			break;

		}

	}

}
