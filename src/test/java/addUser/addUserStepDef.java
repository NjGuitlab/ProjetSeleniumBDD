package addUser;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utiles.Setup;
import utiles.WaitMethods;

public class addUserStepDef {

    WebDriver driver;
    addUserPageObject adduserPO;
    WaitMethods wait = new WaitMethods();
    Setup setup = new Setup();
    
    
    public addUserStepDef() {
        driver = setup.driver;
        adduserPO = new addUserPageObject();
        PageFactory.initElements(driver, adduserPO);
    }
    
    @Given("je clique sur ajouter un utilisateur")
    public void je_clique_sur_ajouter_un_utilisateur() {
        wait.explicitWaitUntilPresenceOfElementLocatedXpath(driver, adduserPO.ADD_BUTTON_XPATH, 3);
        adduserPO.clickADD();
    }

    @When("je selectionne un role {string}")
    public void je_selectionne_un_role(String role) {
        wait.explicitWaitUntilPresenceOfElementLocatedXpath(driver, adduserPO.SELECT_ROLE_XPATH, 3);
        adduserPO.selectrole();
        
        if (role.equals("Admin")) {
            wait.explicitWaitUntilPresenceOfElementLocatedXpath(driver, adduserPO.ADMIN_ROLE_XPATH, 3);
            adduserPO.selectAdmin();
        } else if (role.equals("ESS")) {
            wait.explicitWaitUntilPresenceOfElementLocatedXpath(driver, adduserPO.ESS_ROLE_XPATH, 3);
            adduserPO.selectEss();
        }
    }

    @When("je saisis l employe name {string}")
    public void je_saisis_l_employe_name(String EmployeName) {
        wait.explicitWaitUntilPresenceOfElementLocatedXpath(driver, adduserPO.EMPLOYENAME_XPATH, 5);
        adduserPO.saisirEmployeName(EmployeName);
        wait.explicitWaitUntilPresenceOfElementLocatedXpath(driver, adduserPO.SELECTEMPLOYE_NAME_XPATH, 5);
        adduserPO.selectEmployeName();
    }

    @When("je selectionne un statut {string}")
    public void je_selectionne_un_statut(String statut) {
        wait.explicitWaitUntilPresenceOfElementLocatedXpath(driver, adduserPO.SELECT_STATUT_XPATH, 5);
        adduserPO.selectStatus();
        
        if (statut.equals("Enabled")) {
            wait.explicitWaitUntilPresenceOfElementLocatedXpath(driver, adduserPO.ENABLED_XPATH, 5);
            adduserPO.selectEnabled();
        } else if (statut.equals("Disabled")) {
            wait.explicitWaitUntilPresenceOfElementLocatedXpath(driver, adduserPO.DISABLED_XPATH, 5);
            adduserPO.selectDisabled();
        }
    }

    @When("je saisis un username {string}")
    public void je_saisis_un_username(String username) {
        wait.explicitWaitUntilPresenceOfElementLocatedXpath(driver, adduserPO.USERNAME_XPATH, 5);
        adduserPO.saisirUsername(username);
    }

    @When("je saisis mon nouveau mot de passe {string}")
    public void je_saisis_mon_nouveau_mot_de_passe(String mdpass) {
        wait.explicitWaitUntilPresenceOfElementLocatedXpath(driver, adduserPO.PASSWORD_XPATH, 5);
        adduserPO.saisirPassword(mdpass);
        System.out.println("Le nouveau mot de passe est : " + mdpass);
    }

    @When("je confirme mon mot de passe {string}")
    public void je_confirme_mon_mot_de_passe(String mdpass) {
        wait.explicitWaitUntilPresenceOfElementLocatedXpath(driver, adduserPO.CONFIRMPASSWORD_XPATH, 5);
        adduserPO.confirmPassword(mdpass);
        System.out.println("Le mot de passe de confirmation est : " + mdpass);
    }

    @When("j enregistre mon ajout d utilisateur")
    public void j_enregistre_mon_ajout_d_utilisateur() {
        wait.explicitWaitUntilPresenceOfElementLocatedXpath(driver, adduserPO.SAVE_BUTTON_XPATH, 5);
        adduserPO.enregistrerUser();
        
    }
    
    @Then("je verifie que le message d enregistrement saffiche {string}")
    public void je_verifie_que_le_message_d_enregistrement_saffiche(String messageNotification) throws InterruptedException {
       
    	wait.explicitWaitUntilPresenceOfElementLocatedXpath(driver, adduserPO.NOTIFICATION_XPATH, 5);
		String resultatObtenu = adduserPO.getTexteNotification(driver);
		
		assertEquals(messageNotification, resultatObtenu);
		
		assertEquals(messageNotification, resultatObtenu);
		Thread.sleep(5000);
    	
    }
   
    
    
    
    
    
    
    
    
}
