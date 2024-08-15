package recherche;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utiles.Setup;
import utiles.WaitMethods;

public class RechercheByStatusStepDef {

	public WebDriver driver;
	public RechercheByStatusPageObject rechercheStatus;
	WaitMethods wait = new WaitMethods();
	Setup setup = new Setup();

//---------------------------Constructeur de la classe----------------------------------------------//

	public RechercheByStatusStepDef() {

		driver = setup.driver;
		rechercheStatus = new RechercheByStatusPageObject();
		PageFactory.initElements(driver, rechercheStatus);

	}

//----------------------------------Steps----------------------------------------------------------//

	@When("je choisis un statut {string}")
	public void je_choisis_un_statut(String status) {

		wait.explicitWaitUntilPresenceOfElementLocatedXpath(driver, rechercheStatus.SELECT_XPATH, 3);
		rechercheStatus.select.click();

		if (status.equals("Enabled")) {
			wait.explicitWaitUntilPresenceOfElementLocatedXpath(driver, rechercheStatus.ENABLED_XPATH, 3);
			rechercheStatus.enabled.click();
		} else if (status.equals("Disabled")) {

			wait.explicitWaitUntilPresenceOfElementLocatedXpath(driver, rechercheStatus.DISABLED_XPATH, 3);
			rechercheStatus.disabled.click();
		}

	}

	@Then("je verifie le statut affiche dans le tableau {string}")
	public void je_verifie_le_statut_affiche_dans_le_tableau(String status) {

		//Attendre que le tableau de recherche soit visible
		wait.explicitWaitUntilPresenceOfElementLocatedXpath(driver, rechercheStatus.TAB_XPATH, 3);

		//Declaration du resultat obtenu
		List<String> resultatObtenu = rechercheStatus.getStatusOBtenu(driver);

		//On compare la liste obtenu à la liste attendu
		for (int i = 1; i < resultatObtenu.size(); i++) {

			assertEquals(status, resultatObtenu.get(i));
		}

	}

};