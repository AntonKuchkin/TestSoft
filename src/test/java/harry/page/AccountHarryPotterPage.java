package harry.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountHarryPotterPage {

    public WebDriver driver;

    public AccountHarryPotterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@ng-class = 'btnClass2']")
    private WebElement depositBtr;

    @FindBy(xpath = "//input[@type = 'number']")
    private WebElement inputBalance;

    @FindBy(xpath = "//*[@class='btn btn-default']")
    private WebElement actionClickBtr;

    @FindBy(xpath = "//*[@ng-class = 'btnClass3']")
    private WebElement withDrawlBtr;

    @FindBy(xpath = "//*[text() = 'Deposit Successful']")
    private WebElement depositSuccessful;

    @FindBy(xpath = "//*[text() = 'Transaction successful']")
    private WebElement transactionSuccessful;

    @FindBy(xpath = "//*[@ng-class = 'btnClass1']")
    private WebElement transactionsBtr;

    @FindBy(xpath = "//div[@class = 'center']/strong[last()-1]")
    private WebElement balance;

    @FindBy(xpath = "//*[@class ='form-control ng-pristine ng-untouched ng-invalid ng-invalid-required']")
    private WebElement go;

    public WebElement goTo(){
        return go;
    }

    public void clickDepositBtr() {
        depositBtr.click();
    }

    public WebElement getDepositSuccessful() {
        return depositSuccessful;
    }

    public WebElement getTransactionSuccessful() {
        return transactionSuccessful;
    }

    public void clickActionBtr() {
        actionClickBtr.click();
    }

    public void clickWithDrawlBtr() {
        withDrawlBtr.click();
    }

    public void clickTransactionsBtr() {
        transactionsBtr.click();
    }

    public void inputBalance(Integer balance) {
        inputBalance.sendKeys(String.valueOf(balance));
    }

    public Integer getBalance() {
        return Integer.parseInt(balance.getText());
    }
}
