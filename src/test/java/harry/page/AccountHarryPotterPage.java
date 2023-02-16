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

    @FindBy(xpath = "//*[contains(text(), 'Deposit')]")
    private WebElement depositBtr;

    @FindBy(xpath = "//input[@type = 'number']")
    private WebElement inputBalance;

    @FindBy(xpath = "//*[@class='btn btn-default']")
    private WebElement transactionBtr;

    @FindBy(xpath = "//*[contains(text(), 'Withdrawl')]")
    private WebElement withDrawlBtr;

    @FindBy(xpath = "//*[text() = 'Withdraw']")
    private WebElement withdraw;

    @FindBy(xpath = "//*[text() = 'Deposit Successful']")
    private WebElement depositSuccessful;

    @FindBy(xpath = "//*[text() = 'Transaction successful']")
    private WebElement transactionSuccessful;

    @FindBy(xpath = "//*[contains(text(), 'Transactions')]")
    private WebElement transactionsBtr;

    @FindBy(xpath = "//div[@class = 'center']/strong[last()-1]")
    private WebElement balance;

    public void clickDepositBtr() {
        depositBtr.click();
    }

    public WebElement getWithDrawBtr(){
        return withdraw;
    }

    public WebElement getDepositBtr(){
        return depositBtr;
    }

    public void clickWithDrawBtr(){
        withdraw.click();
    }

    public WebElement getDepositSuccessful() {
        return depositSuccessful;
    }

    public WebElement getTransactionSuccessful() {
        return transactionSuccessful;
    }

    public void clickTransactionBtr() {
        transactionBtr.click();
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
