package harry.page;

import harry.config.ConfProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CustomerLoginPage {

    public WebDriver driver;

    private static final String CUSTOMER = ConfProperties.getProperty("customer");

    public CustomerLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id='userSelect']")
    private WebElement yourNameBtr;


    @FindBy(xpath = "//*[contains(text(), 'Login')]")
    private WebElement loginBtr;

    public void clickYourNameBtr() {
        yourNameBtr.click();
    }

    public void selectHarry() {
        Select select = new Select(yourNameBtr);
        select.selectByVisibleText(CUSTOMER);
    }

    public void clickLoginBtr() {
        loginBtr.click();
    }

}
