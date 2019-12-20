package selenium;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

@RunWith(JUnit4.class)
public class RegistrationTest {
    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/opt/WebDriver/bin/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().deleteAllCookies();
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    public void validateRegistrationPageTest() {
        driver.get("http://automationpractice.com");
        driver.findElement(By.className("login")).click();
        WebElement firstCheck = wait.until(presenceOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div/div[1]/span[2]")));

        assertEquals("Authentication", firstCheck.getText().toString().replaceAll("\\s", ""));

        driver.findElement(By.id("email_create")).sendKeys("robert655@robert.pl" + Keys.ENTER);
        WebElement secondCheck = wait.until(presenceOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/form/div[1]/h3")));

        assertEquals("YOUR PERSONAL INFORMATION", secondCheck.getText().toString());

        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("customer_firstname")).sendKeys("Robert");
        driver.findElement(By.id("customer_lastname")).sendKeys("Kowalski");
        driver.findElement(By.id("passwd")).sendKeys("qwert1");
        driver.findElement(By.id("address1")).sendKeys("301 E Dave Ward Dr");
        driver.findElement(By.id("city")).sendKeys("Conway");
        Select state = new Select(driver.findElement(By.id("")));
        state.selectByVisibleText("Arkansas");
        driver.findElement(By.id("postcode")).sendKeys("72032");
        driver.findElement(By.id("phone_mobile")).sendKeys("333444555");
        driver.findElement(By.id("submitAccount")).click();

        WebElement thirdCheck = wait.until(presenceOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/h1")));

        assertEquals("MY ACCOUNT", thirdCheck.getText().toString());
    }

}
