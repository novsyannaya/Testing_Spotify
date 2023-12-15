package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends AbstractPage {

    private WebElement buttonMenu;
    private final By buttonMenuLocator= By.xpath("//*[@data-testid='user-widget-link']");

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected AbstractPage openPage() {
        throw new RuntimeException("Please, don't open page again");
    }

    public String checkUserName() {
        buttonMenu=waitForElementLocateBy(buttonMenuLocator);
        return buttonMenu.getAccessibleName();
    }
}
