package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.HomePage;
import page.LoginPage;

public class CommonConditions {
    protected WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en-GB");
        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
        homePage=new HomePage(driver);
        loginPage=new LoginPage(driver);
    }

    @AfterMethod
    public void stopBrowser() {
        driver.quit();
    }

}
