package StepMethods;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;

public class LoginSteps extends CommonConditions {
    @Before
    public void before() {
        setUp();
    }

    @After
    public void after() {
        stopBrowser();
    }

    @Given("I'm on the home page of Spotify")
    public void iMOnSpotifyHomePage() {
//        setUp();
        homePage.openPage();
    }

    @And("I go to login page")
    public void iGoToLoginPage() {
        homePage.goToLoginPage();
    }

    @And("I login using my {string} and {string} for {string} of test")
    public void iLoginUsingMyAndForOfTest(String username, String password, String type) {
        loginPage.login(type, username, password);
    }

    @Then("I get correct {string} for this {string}")
    public void iGetSuccessForThis(String result, String type) {
        String[] array=result.split("; ");
        ArrayList<String> exResult=new ArrayList<>(Arrays.asList(array));
        Assert.assertEquals(exResult, loginPage.getResult(type));
    }
}
