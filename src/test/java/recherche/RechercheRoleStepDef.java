package recherche;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utiles.Setup;
import utiles.WaitMethods;

public class RechercheRoleStepDef {

	public WebDriver driver;

	public RechercheRolePageObject rechercheRolePO;

	public WaitMethods wait = new WaitMethods();

	public Setup setup = new Setup();

	// Constructeur de la classe

	public RechercheRoleStepDef() {
		driver = setup.driver;
		rechercheRolePO = new RechercheRolePageObject();
		PageFactory.initElements(driver, rechercheRolePO);
	}

	@When("je choisi le role {string}")
	public void je_choisi_le_role(String role) {

		wait.explicitWaitUntilPresenceOfElementLocatedXpath(driver, rechercheRolePO.SELECT_XPATH, 3);
		rechercheRolePO.clickSelect();
		
		/*
		if (role.equals("Admin")) {
			wait.explicitWaitUntilButtonIsClickableXpath(driver,rechercheRolePO.ADMIN_XPATH , 5);
			rechercheRolePO.selectAdmin();
		}
		if (role.equals("ESS")) {
			wait.explicitWaitUntilButtonIsClickableXpath(driver,rechercheRolePO.ESS_XPATH , 5);
			rechercheRolePO.selectEss();
		}
		*/
		
		wait.explicitWaitUntilPresenceOfElementLocatedXpath(driver, rechercheRolePO.ADMIN_XPATH, 5);
		wait.explicitWaitUntilPresenceOfElementLocatedXpath(driver, rechercheRolePO.ESS_XPATH, 5);
		rechercheRolePO.selectRole(role);

	}

	@Then("je verifie le role {string} affiche dans le tableau")
	public void je_verifie_le_role_affiche_dans_le_tableau(String role) {

		wait.explicitWaitUntilPresenceOfElementLocatedXpath(driver, rechercheRolePO.TAB_XPATH, 3);

		List<String> resultatObtenu = rechercheRolePO.getUserRoleObtenu(driver);
		for (int i = 0; i < resultatObtenu.size(); i++) {

			Assert.assertEquals(role, resultatObtenu.get(i));

		}

	}
}
