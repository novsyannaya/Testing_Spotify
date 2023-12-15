package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginTest extends CommonConditions {
    @DataProvider(name = "loginData")
    public Object[][] loginData(){
        return new Object[][] {
                {"empty", "login", "password"
                        , new ArrayList<>(Arrays.asList("Please enter your Spotify username or email address."
                        , "Please enter your password."))},
                {"incorrect", "forEpamTest", "password"
                        , new ArrayList<>(List.of("Incorrect username or password."))},
                {"correct", "alt.r3-9oeklslp@yopmail.com", "ForTest123"
                        , new ArrayList<>(List.of("forEpamTest"))}
        };
    }

    @Test(dataProvider = "loginData")
    public void test(String test, String login, String password, ArrayList result){
        homePage.openPage();
        homePage.goToLoginPage();
        loginPage.login(test, login, password);
        Assert.assertEquals(result, loginPage.getResult(test));
    }
}
