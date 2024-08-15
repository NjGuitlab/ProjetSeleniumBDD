package recherche;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utiles.Setup;
import utiles.WaitMethods;

public class RechercheByNameStepDef {

	public WebDriver driver;
	public RechercheByNamePageObject rechercheName;
	public WaitMethods wait = new WaitMethods();
	public Setup setup = new Setup();

	// Constructeur de la classe
	public RechercheByNameStepDef() {
		driver = setup.driver;
		rechercheName = new RechercheByNamePageObject();
		PageFactory.initElements(driver, rechercheName);
	}

	@When("je saisis le nom de l employee {string}")
	public void je_saisis_le_nom_de_l_employee(String name) {

		wait.explicitWaitUntilPresenceOfElementLocatedXpath(driver, rechercheName.EMPLOYEE_NAME_XPATH, 3);
		
		wait.explicitWaitUntilPresenceOfElementLocatedXpath(driver, rechercheName.USER_CONNECTE_XPATH, 3);
		rechercheName.saisirName();
		wait.explicitWaitUntilPresenceOfElementLocatedXpath(driver, rechercheName.SELECT_XPATH, 5);
		rechercheName.selectName();

	}

	@Then("je verifie le nom {string} affiche dans le tableau")
	public void je_verifie_le_nom_affiche_dans_le_tableau(String name) {

		wait.explicitWaitUntilPresenceOfElementLocatedXpath(driver, rechercheName.TAB_XPATH, 3);
		List<String> resultatObtenu = rechercheName.getNameObtenu(driver);
		String employeConnecte = rechercheName.userconnecte.getText();
		for (int i = 0; i < resultatObtenu.size(); i++) {

			Assert.assertEquals(employeConnecte, resultatObtenu.get(i));

		}

	}

}
