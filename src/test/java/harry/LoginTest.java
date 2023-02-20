package harry;

import harry.config.ConfProperties;
import harry.page.AccountHarryPotterPage;
import harry.page.CustomerLoginPage;
import harry.page.LoginPage;
import harry.page.TransactionList;
import harry.service.FibonacciNumber;
import harry.service.WriteFileCsv;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.Objects;

public class LoginTest {

    private static LoginPage loginPage;
    private static WebDriver driver;
    private static CustomerLoginPage customerLoginPage;
    private static AccountHarryPotterPage accountHarryPotter;
    private static TransactionList transactionList;
    public WriteFileCsv writeFileCsv = new WriteFileCsv();
    private static final Integer fibonacci = new FibonacciNumber().getFibonacciNumberByDate();
    private static final String CREDIT = "Credit";
    private static final String DEBIT = "Debit";
    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("useAutomationExtension", false);
        driver = new ChromeDriver(chromeOptions);
        driver.get("http://localhost:4444/wd/hub");
        loginPage = new LoginPage(driver);
        customerLoginPage = new CustomerLoginPage(driver);
        accountHarryPotter = new AccountHarryPotterPage(driver);
        transactionList = new TransactionList(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(ConfProperties.getProperty("loginpage"));
    }


    @Test
    public void loginTestOne() {
        loginPage.clickCustomerLoginBtn();
    }

    @Test
    public void selectName() {
        customerLoginPage.clickYourNameBtr();
        customerLoginPage.selectHarry();
        customerLoginPage.clickLoginBtr();
    }

    @Test
    public void accountHarryPotter() throws InterruptedException {
        Integer balanceNew = accountHarryPotter.getBalance();
        accountHarryPotter.clickDepositBtr();
        accountHarryPotter.inputBalance(fibonacci);
        accountHarryPotter.clickActionBtr();
        wait.until(ExpectedConditions.visibilityOf(accountHarryPotter.getDepositSuccessful()));
        accountHarryPotter.clickWithDrawlBtr();
        wait.until(ExpectedConditions.elementToBeClickable(accountHarryPotter.goTo()));
        accountHarryPotter.inputBalance(fibonacci);
        accountHarryPotter.clickActionBtr();
        wait.until(ExpectedConditions.visibilityOf(accountHarryPotter.getTransactionSuccessful()));
    }

    @Test
    public void transaction() throws IOException {

        accountHarryPotter.clickTransactionsBtr();
        while (Objects.equals(transactionList.getWebElement(), "")) {
            driver.get(driver.getCurrentUrl());
        }
        writeFileCsv.safeFile(transactionList.getWebElement());
        Assert.assertEquals(CREDIT, transactionList.getTransactionTypeCredit());
        Assert.assertEquals(DEBIT, transactionList.getTransactionTypeDebit());
    }

    @AfterClass
    public static void end() {
        driver.close();
    }
}
