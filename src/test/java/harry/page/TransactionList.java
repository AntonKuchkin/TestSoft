package harry.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransactionList {

    public WebDriver driver;

    public TransactionList(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//tr[@id = 'anchor0']/td[last()]")
    private WebElement transactionTypeCredit;

    @FindBy(xpath = "//tr[@id = 'anchor1']/td[last()]")
    private WebElement transactionTypeDebit;

    @FindBy(xpath = "//tbody")
    private WebElement webElement;

    public String getTransactionTypeCredit() {
        return transactionTypeCredit.getText();
    }

    public String getTransactionTypeDebit() {
        return transactionTypeDebit.getText();
    }

    public String getWebElement() {
        return webElement.getText();
    }

}
