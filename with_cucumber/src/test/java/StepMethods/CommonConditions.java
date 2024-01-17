package StepMethods;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CommonConditions {
    protected WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;


    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en-GB");
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        homePage=new HomePage(driver);
        loginPage=new LoginPage(driver);
    }


    public void stopBrowser() {
        driver.quit();
    }

}
